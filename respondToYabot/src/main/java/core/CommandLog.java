package core;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.Ref;

public class CommandLog {

	public static void cmdLog(String cmd, MessageReceivedEvent event) {

		User objUser = event.getAuthor();
		MessageChannel objMsgCh = event.getChannel();
		Message objMsg = event.getMessage();
		Guild guild = event.getGuild();

		guild.getCategoriesByName("Development", true).get(0).getTextChannels().get(2)
				.sendMessage(objUser.getName() + ": " + "'" + Ref.PREFIX + cmd + "'" + " --> " + objMsgCh.getName())
				.queue();
	}

}
