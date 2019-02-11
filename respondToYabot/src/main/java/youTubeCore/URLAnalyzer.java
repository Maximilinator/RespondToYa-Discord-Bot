package youTubeCore;

import java.io.IOException;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.EmbedTypes;

public class URLAnalyzer {

	// Zeigt alle unterstützen Aktionen
	private static final String[] actions = { "current", "total", "channel" };

	public static void commandAnalysis(String[] args, MessageReceivedEvent event) {

		String username = args[0];
		String action = args[1];
		boolean link = false;

		// Testet, ob es sich um einen Link oder um den Namen eines Kanals handelt
		if (username.startsWith("https://www.youtube.com/")) {
			link = true;
		}

		// Testet, ob die angebene Aktion unterstützten Aktionen übereinstimmt
		for (int i = 0; i < actions.length; i++) {
			if (actions[i].equals(action)) {
				try {
					URLBrowser.informationBrowse(username, action, link, event);
				} catch (IOException e) {
					e.printStackTrace();
				}
				return;
			}
		}
		event.getChannel().sendMessage(EmbedTypes.warning().setDescription(":warning: Deine angegebene Aktion gibt es nicht!").build()).complete();
		return;
	}

}
