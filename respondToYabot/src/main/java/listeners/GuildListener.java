package listeners;

import core.UniError;
import net.dv8tion.jda.core.events.guild.GuildJoinEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class GuildListener extends ListenerAdapter {

	public void onGuildJoin(GuildJoinEvent event) {
		event.getGuild().getSystemChannel().sendMessage(
				UniError.memberJoined().setDescription("Hallo " + event.getGuild().getSelfMember().getAsMention()
						+ "!\nWillkommen auf " + event.getGuild().getName()).build() + "!")
				.complete();
	}

}
