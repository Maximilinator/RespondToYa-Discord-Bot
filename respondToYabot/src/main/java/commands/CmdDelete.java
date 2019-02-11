package commands;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import core.UniError;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageHistory;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.EmbedTypes;
import util.Ref;

/**
 * Created by zekro on 18.03.2017 / 01:29 DiscordBot / commands © zekro 2017
 *
 * Contributor: Skillkiller
 */

public class CmdDelete implements Command {

	private int getInt(String string) {
		try {
			return Integer.parseInt(string);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) {

		try {
			MessageHistory history = new MessageHistory(event.getTextChannel());
			List<Message> msgs;
			if (args.length == 1 && args[0].equalsIgnoreCase("all")) {
				try {
					while (true) {
						msgs = history.retrievePast(1).complete();
						msgs.get(0).delete().queue();
					}
				} catch (Exception ex) {
					// Nichts tun
				}

				Message answer = event.getTextChannel().sendMessage(EmbedTypes.success().setTitle("**DELETE**")
						.setDescription("Alle Nachrichten wurden erfolgreich gelöscht!").build()).complete();

				new Timer().schedule(new TimerTask() {
					@Override
					public void run() {
						answer.delete().queue();
					}
				}, 3000);

			} else if (args.length < 1
					|| (args.length > 0 ? getInt(args[0]) : 1) == 1 && (args.length > 0 ? getInt(args[0]) : 1) < 2) {

				event.getMessage().delete().queue();
				msgs = history.retrievePast(2).complete();
				msgs.get(0).delete().queue();

				Message answer = event.getTextChannel().sendMessage(EmbedTypes.success().setTitle("**DELETE**")
						.setDescription("Die letzte Nachricht wurde erfolgreich gelöscht!").build()).complete();

				new Timer().schedule(new TimerTask() {
					@Override
					public void run() {
						answer.delete().queue();
					}
				}, 3000);

			} else if (args.length == 2) {
				// 24/03/2013 21:54
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
				StringBuilder builder = new StringBuilder();

				for (String arg : args) {
					builder.append(" " + arg);
				}

				try {
					Date date = simpleDateFormat.parse(builder.toString());

					boolean weiter = true;
					try {
						while (weiter) {
							msgs = history.retrievePast(1).complete();
							if (date.before(Date.from(msgs.get(0).getCreationTime().toZonedDateTime().toInstant()))) {
								msgs.get(0).delete().queue();
							} else {
								weiter = false;
							}

						}

						Message answer = event.getTextChannel()
								.sendMessage(EmbedTypes.success().setTitle("**DELETE**")
										.setDescription(args[0] + " Nachrichten wurden erfolgreich gelöscht!").build())
								.complete();

						new Timer().schedule(new TimerTask() {
							@Override
							public void run() {
								answer.delete().queue();
							}
						}, 3000);
					} catch (Exception ex) {
						// Nichts tun
					}
				} catch (ParseException ex) {
					event.getTextChannel().sendMessage(EmbedTypes.error().setTitle("**ZEITFORMAT**")
							.setDescription("Falsches Zeitformat: " + simpleDateFormat.format(new Date())).build())
							.queue();
				}

			} else if (getInt(args[0]) <= 100) {

				event.getMessage().delete().queue();
				msgs = history.retrievePast(getInt(args[0])).complete();
				event.getTextChannel().deleteMessages(msgs).queue();

				Message answer = event.getTextChannel().sendMessage(EmbedTypes.success().setTitle("**DELETE**")
						.setDescription(args[0] + " Nachrichten erfolgreich gelöscht").build()).complete();

				new Timer().schedule(new TimerTask() {
					@Override
					public void run() {
						answer.delete().queue();
					}
				}, 3000);
			} else {
				event.getTextChannel()
						.sendMessage(UniError.errorInput()
								.setDescription(":warning: Du musst eine Zahl zwischen 2 und 100 nehmen!").build())
						.queue();
			}

		} catch (Exception e) {
			event.getTextChannel()
					.sendMessage(EmbedTypes.error().setTitle("**" + e.getLocalizedMessage() + "**")
							.setDescription("Folgender Fehler ist aufgetreten: " + e.getLocalizedMessage()).build())
					.queue();
		}
	}

	@Override
	public void executed(boolean success, MessageReceivedEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public String help() {
		return Ref.PREFIX + "delete " + "[2-100] || [all] || [TimeStamp]";
	}

}
