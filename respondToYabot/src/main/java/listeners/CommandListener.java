package listeners;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import util.Ref;
import core.*;

public class CommandListener extends ListenerAdapter {

	public void onMessageReceived(MessageReceivedEvent event) {

		User objUser = event.getAuthor();
		MessageChannel objMsgCh = event.getChannel();
		Message objMsg = event.getMessage();

		if (isCommand(objMsg.getContentRaw(), objUser.isBot())) {
			CommandHandler.handleCommand(CommandParser.parser(objMsg.getContentRaw(), event), event);
		}
	}

	private boolean isCommand(String message, boolean botOrNot) {
		char c = message.charAt(0);
		if (c == Ref.PREFIX && botOrNot == false) {
			return true;
		}
		return false;
	}
}
