package commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class CmdCommandList implements Command {

	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {
		return false;
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) {

	}

	@Override
	public void executed(boolean success, MessageReceivedEvent event) {
	}

	@Override
	public String help() {
		return null;
	}

}
