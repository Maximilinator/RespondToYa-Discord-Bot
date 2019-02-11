package commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.EmbedTypes;
import util.Ref;

public class CmdShutdown implements Command {

	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {
		return false;
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) {

		event.getTextChannel().sendMessage(
				EmbedTypes.success().setTitle("SHUTDOWN").setDescription("Der Bot ist ab jetzt offline!").build())
				.complete();

		System.exit(0);
	}

	@Override
	public void executed(boolean success, MessageReceivedEvent event) {
	}

	@Override
	public String help() {
		return Ref.PREFIX + "shutdown";
	}

}
