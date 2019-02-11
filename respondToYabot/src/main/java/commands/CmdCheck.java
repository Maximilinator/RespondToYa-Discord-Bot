package commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.EmbedTypes;
import util.Ref;

public class CmdCheck implements Command {

	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {
		return false;
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) {

		event.getTextChannel().sendMessage(EmbedTypes.success().setTitle("PING").setDescription("pong").build()).complete();

	}

	@Override
	public void executed(boolean success, MessageReceivedEvent event) {
		System.out.println("[INFO] Der Command " + Ref.PREFIX + "ping" + " wurde erfolgreich im Channel "
				+ event.getChannel().getName() + " ausgeführt");
	}

	@Override
	public String help() {
		return Ref.PREFIX + "ping";
	}

}
