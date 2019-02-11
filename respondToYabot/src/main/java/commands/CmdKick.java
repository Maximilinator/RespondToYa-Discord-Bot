package commands;

import core.PermsChecker;
import core.UniError;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.EmbedTypes;
import util.Ref;

public class CmdKick implements Command {

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
				event.getChannel().sendMessage(EmbedTypes.kick()
						.setDescription("Der Benutzer **" + event.getMessage().getMentionedUsers().get(0).getName()
								+ "** wurde von **" + event.getMessage().getAuthor().getName() + "** gekickt!")
						.addField("Grund:", reason, true)
						.setImage("https://media.giphy.com/media/l3V0j3ytFyGHqiV7W/giphy.gif").build()).complete();

				event.getMessage().getMentionedUsers().get(0).openPrivateChannel().complete()
						.sendMessage(EmbedTypes.kick()
								.setDescription("Du wurdest von **" + event.getMessage().getAuthor().getName()
										+ "** vom Server gekickt!")
								.addField("Grund:", reason, true)
								.setImage("https://media.giphy.com/media/mxQUQbIjXMSwo/giphy.gif").build())
						.complete();
				event.getGuild().getController().kick(event.getMessage().getMentionedUsers().get(0).getName()).queue();
			} else {
				event.getChannel().sendMessage(UniError.errorBotPermissions()
						.build()).complete();
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
		return Ref.PREFIX + " kick [MentionedUser] [Reason]";
	}

}
