package listeners;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import util.Ref;
import core.*;

public class CommandListener extends ListenerAdapter {

	public void onMessageReceived(MessageReceivedEvent event) {

		if (isCommand(event.getMessage().getContentDisplay(), event.getAuthor().isBot())) {
			CommandHandler.handleCommand(CommandParser.parser(event.getMessage().getContentRaw(), event), event);
		}
	}

	private boolean isCommand(String message, boolean botOrNot) {
		char c = ' ';
		if (!message.equals("")) {
		c = message.charAt(0);
		}
		if (c == Ref.PREFIX && !botOrNot) {
			return true;
		}
		return false;
	}
}
