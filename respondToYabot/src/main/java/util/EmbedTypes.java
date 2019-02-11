package util;

import java.awt.Color;

import net.dv8tion.jda.core.EmbedBuilder;

public class EmbedTypes {

	public static EmbedBuilder success() {
		return new EmbedBuilder().setColor(Color.GREEN);
	}

	public static EmbedBuilder error() {
		return new EmbedBuilder().setColor(Color.RED);
	}

	public static EmbedBuilder warning() {
		return new EmbedBuilder().setColor(Color.YELLOW);
	}

	public static EmbedBuilder help() {
		return new EmbedBuilder().setColor(Color.CYAN);
	}

	public static EmbedBuilder warn() {
		return new EmbedBuilder().setColor(Color.YELLOW).setTitle("**WARN**");
	}

	public static EmbedBuilder ban() {
		return new EmbedBuilder().setColor(Color.RED).setTitle("**BAN**");
	}

	public static EmbedBuilder kick() {
		return new EmbedBuilder().setColor(Color.WHITE).setTitle("**KICK**");
	}
	
	public static EmbedBuilder poll() {
		return new EmbedBuilder().setColor(Color.MAGENTA).setTitle("**POLL/UMFRAGE**");
	}
	
	public static EmbedBuilder log() {
		return new EmbedBuilder().setColor(Color.LIGHT_GRAY);
	}

}
