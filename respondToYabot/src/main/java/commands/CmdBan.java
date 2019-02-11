package commands;

import core.PermsChecker;
import core.UniError;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.EmbedTypes;
import util.Ref;

public class CmdBan implements Command {

	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {
		return false;
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) {
		String reason = "-none-";
		if (args.length >= 2) {
			reason = "";
			for (int i = 1; i < args.length; i++) {
				reason += args[i] + " ";
			}
			if (PermsChecker.canKick(event)) {
				event.getChannel().sendMessage(EmbedTypes.ban()
						.setDescription("Der Benutzer **" + event.getMessage().getMentionedUsers().get(0).getName()
								+ "** wurde von **" + event.getMessage().getAuthor().getName() + "** gebannt!")
						.addField("Grund:", reason, true)
						.setImage("https://media.giphy.com/media/uC9e2ojJn1ZXW/giphy.gif").build()).complete();

				event.getMessage().getMentionedUsers().get(0).openPrivateChannel().complete()
						.sendMessage(EmbedTypes.ban()
								.setDescription("Du wurdest von **" + event.getMessage().getAuthor().getName()
										+ "** vom Server gebannt!")
								.addField("Grund:", reason, true)
								.setImage("https://media.giphy.com/media/1zFXgNa44Z904/giphy.gif").build())
						.complete();
				event.getGuild().getController().ban(event.getMessage().getMentionedUsers().get(0), 0, reason)
						.complete();
			} else {
				event.getChannel().sendMessage(UniError.errorBotPermissions().build()).complete();
			}
		} else {
			event.getChannel()
					.sendMessage(UniError.errorInput().build())
					.complete();
		}
	}

	@Override
	public void executed(boolean success, MessageReceivedEvent event) {
	}

	@Override
	public String help() {
		return Ref.PREFIX + "ban " + "[MentionedUser]" + "[Reason]";
	}

}
