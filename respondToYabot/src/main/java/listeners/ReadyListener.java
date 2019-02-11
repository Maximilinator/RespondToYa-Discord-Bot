package listeners;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import util.EmbedTypes;

public class ReadyListener extends ListenerAdapter {

	public void onReady(ReadyEvent event) {

		for (Guild guild : event.getJDA().getGuilds()) {
			guild.getCategoriesByName("Development", true).get(0).getTextChannels().get(0)
					.sendMessage(EmbedTypes.success().setTitle("PYROCYNICAL").setDescription("So guys, we did it! Yikes!").build()).complete();
		}

	}
}
