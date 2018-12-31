package commands;

import core.CommandLog;
import core.PermsChecker;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class CmdCommandList implements Command {

	private String invoke = "commands";

	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {
		return false;
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) {

		MessageChannel objMsgCh = event.getChannel();

		if (PermsChecker.hasPerms(invoke, event)) {

			String commandList = "";
			
			switch (PermsChecker.parsePermsLevel(event)) {
			case 1:
				for (int i = 0; i < PermsChecker.perms1.size(); i++) {
					commandList = commandList + PermsChecker.perms1.get(i) + "\n";
				}
			case 2:
				for (int i = 0; i < PermsChecker.perms2.size(); i++) {
					commandList = commandList + PermsChecker.perms2.get(i) + "\n";
				}
			case 3:
				for (int i = 0; i < PermsChecker.perms3.size(); i++) {
					commandList = commandList + PermsChecker.perms3.get(i) + "\n";
				}
			case 4:
				for (int i = 0; i < PermsChecker.perms4.size(); i++) {
					commandList = commandList + PermsChecker.perms4.get(i) + "\n";
				}
			default:
			}
			
			objMsgCh.sendMessage(event.getAuthor().getAsMention() + " Du darfst folgende Commands benutzen:\n" + commandList).queue();

			CommandLog.cmdLog(invoke, event);
		} else
			objMsgCh.sendMessage(":warning: You do not have permissions to use this command!").queue();
	}

	@Override
	public void executed(boolean success, MessageReceivedEvent event) {
	}

	@Override
	public String help() {
		return null;
	}

}
