package commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public interface Command {

	boolean called(String[] args, MessageReceivedEvent event);

	public void action(String[] args, MessageReceivedEvent event);

	void executed(boolean success, MessageReceivedEvent event);

	public String help();

}
