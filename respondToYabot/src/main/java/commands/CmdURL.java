package commands;

import core.CommandLog;
import core.PermsChecker;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import youTubeCore.InternetCodeParser;

public class CmdURL implements Command {

	private String invoke = "aboboxcamper";
	
	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {

		return false;
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) {

		MessageChannel objMsgCh = event.getChannel();
		InternetCodeParser codeParser = new InternetCodeParser();
		
		if (PermsChecker.hasPerms(invoke, event)) {
		objMsgCh.sendMessage("Das hier ist das neueste Video von Maximilinator! " + codeParser.getVideoURL()).queue();
		
		CommandLog.cmdLog(invoke, event);
		} else
			objMsgCh.sendMessage(":warning: You do not have permissions to use this command!");
	}

	@Override
	public void executed(boolean success, MessageReceivedEvent event) {

	}

	@Override
	public String help() {

		return null;
	}

}
