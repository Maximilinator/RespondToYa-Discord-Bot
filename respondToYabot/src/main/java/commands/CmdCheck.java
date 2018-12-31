package commands;

import core.CommandLog;
import core.PermsChecker;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.Ref;

public class CmdCheck implements Command {

	private String invoke = "ping";

	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {
		return false;
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) {

		MessageChannel objMsgCh = event.getChannel();

		if (PermsChecker.hasPerms(invoke, event)) {
			objMsgCh.sendMessage("Pong").queue();

			CommandLog.cmdLog(invoke, event);
		} else
			objMsgCh.sendMessage(":warning: You do not have permissions to use this command!");

	}

	@Override
	public void executed(boolean success, MessageReceivedEvent event) {
		System.out.println("[INFO] Der Command " + Ref.PREFIX + "ping" + " wurde erfolgreich im Channel "
				+ event.getChannel().getName() + " ausgeführt");
	}

	@Override
	public String help() {
		return null;
	}

}
