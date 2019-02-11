package commands;

import core.PermsChecker;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.EmbedTypes;
import util.Ref;

public class CmdCommandList implements Command {

	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {
		return false;
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) {

		String commandList = "";

		switch (PermsChecker.parsePermsLevel(event)) {
		case 1:
			for (int i = 0; i < PermsChecker.perms1.size(); i++) {
				commandList = commandList + Ref.PREFIX + PermsChecker.perms1.get(i).toLowerCase() + "\n";
			}
		case 2:
			for (int i = 0; i < PermsChecker.perms2.size(); i++) {
				commandList = commandList + Ref.PREFIX + PermsChecker.perms2.get(i).toLowerCase() + "\n";
			}
		case 3:
			for (int i = 0; i < PermsChecker.perms3.size(); i++) {
				commandList = commandList + Ref.PREFIX + PermsChecker.perms3.get(i).toLowerCase() + "\n";
			}
		case 4:
			for (int i = 0; i < PermsChecker.perms4.size(); i++) {
				commandList = commandList + Ref.PREFIX + PermsChecker.perms4.get(i).toLowerCase() + "\n";
			}
		default:
		}

		event.getTextChannel().sendMessage(EmbedTypes.help().setDescription(event.getAuthor().getAsMention() + " Du darfst folgende Commands benutzen:\n" + commandList).build()
				).complete();

	}

	@Override
	public void executed(boolean success, MessageReceivedEvent event) {
	}

	@Override
	public String help() {
		return Ref.PREFIX + "commands";
	}

}
