package commands;

import core.PermsChecker;
import core.UniError;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.EmbedTypes;
import util.Ref;

public class CmdWarn implements Command {

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
			event.getChannel()
					.sendMessage(EmbedTypes.warn()
							.setDescription("Der Benutzer **" + event.getMessage().getMentionedUsers().get(0).getName()
									+ "** wurde von **" + event.getMessage().getAuthor().getName() + "** verwarnt!")
							.addField("Grund:", reason, true)
							.setImage("https://media.giphy.com/media/tyk39lYCnSMIo/giphy.gif").build())
					.complete();

			event.getMessage().getMentionedUsers().get(0).openPrivateChannel().complete().sendMessage(EmbedTypes.warn()
					.setDescription("Du wurdest von **" + event.getMessage().getAuthor().getName() + "** verwarnt!")
					.addField("Grund:", reason, true).setImage("https://media.giphy.com/media/IT6kBZ1k5oEeI/giphy.gif")
					.build()).complete();
		} else {
			event.getChannel().sendMessage(UniError.errorInput().build()).complete();
		}
	}

	@Override
	public void executed(boolean success, MessageReceivedEvent event) {
	}

	@Override
	public String help() {
		return Ref.PREFIX + " warn [MentionedUser] [Reason]";
	}

}
