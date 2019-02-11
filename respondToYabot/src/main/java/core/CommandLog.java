package core;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.EmbedTypes;
import util.Ref;

public class CommandLog {

	public static void cmdLog(String cmd, MessageReceivedEvent event) {

		event.getGuild().getCategoriesByName("Development", true).get(0).getTextChannels().get(2)
				.sendMessage(EmbedTypes.log().setDescription("**" + event.getAuthor().getName() + "**: " + "'" + Ref.PREFIX + cmd
						+ "'" + " --> **#" + event.getChannel().getName()+ "**").build())
				.complete();
	}

}
