package commands;

import java.util.Random;

import core.CommandLog;
import core.PermsChecker;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.Ref;

public class CmdBoing implements Command {

	private String invoke = "boing";
	
	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {
		return false;
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) {

		MessageChannel objMsgCh = event.getChannel();

		if (PermsChecker.hasPerms(invoke, event)) {

			Random random = new Random();
			switch (random.nextInt(3)) {
			case 0:
				objMsgCh.sendMessage("Airbus! :airplane_small:").queue();
				break;
			case 1:
				objMsgCh.sendMessage("Antonow! :airplane:").queue();
				break;
			case 2:
				objMsgCh.sendMessage("SpaceX! :rocket:").queue();
				break;
			default:
				objMsgCh.sendMessage("Das ist nicht lustig...").queue();
			}

			CommandLog.cmdLog(invoke, event);
		} else
			objMsgCh.sendMessage(":warning: You do not have permissions to use this command!").queue();
	}

	@Override
	public void executed(boolean success, MessageReceivedEvent event) {
		System.out.println("[INFO] Der Command " + Ref.PREFIX + "boing" + " wurde erfolgreich im Channel "
				+ event.getChannel().getName() + " ausgeführt");
	}

	@Override
	public String help() {
		return null;
	}

}
