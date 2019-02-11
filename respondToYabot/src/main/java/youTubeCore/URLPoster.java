package youTubeCore;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.EmbedTypes;

public class URLPoster {

	public static void urlPoster(String msg, String param, String type, MessageReceivedEvent event) {

		switch (type) {
		case "video":
			if (param != null) {
				event.getChannel().sendMessage(
						EmbedTypes.success().setDescription(msg + "https://www.youtube.com/watch?v=" + param).build())
						.complete();
			} else {
				event.getChannel().sendMessage(
						EmbedTypes.error().setDescription(":warning: Das Video konnte nicht gefunden werden").build())
						.complete();
			}
			break;
		case "stat":
			if (!param.equals(0 + "")) {
				event.getChannel().sendMessage(EmbedTypes.success().setDescription(msg + param).build()).complete();
			} else {
				event.getChannel()
						.sendMessage(EmbedTypes.warning()
								.setDescription(":warning: Dein gesuchter Kanal hat noch nichts hochgeladen!").build())
						.complete();
			}
			break;
		case "channel":
			if (!param.equals(null)) {
				event.getChannel()
						.sendMessage(
								EmbedTypes.success().setDescription("https://www.youtube.com/channel/" + param).build())
						.complete();
			} else {
				event.getChannel()
						.sendMessage(EmbedTypes.error()
								.setDescription(":warning: Dein Kanal konnte nicht gefunden werden!").build())
						.complete();
			}
			break;
		}
	}
}
