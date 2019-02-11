package core;

import net.dv8tion.jda.core.EmbedBuilder;
import util.EmbedTypes;

public class UniError {

	public static EmbedBuilder errorBotPermissions() {
		return EmbedTypes.error().setTitle("**BOTBERECHTIGUNG**").setDescription(":warning: Der erwähnte User hat mindestens einen zu hohen Rang, um die Aktion durchführen zu können. Entferne diesen zuerst!");
	}
	
	public static EmbedBuilder errorInput() {
		return EmbedTypes.error().setTitle("**EINGABE**").setDescription(":warning: Deine getätigte Eingabe ist falsch!");
	}
	
	public static EmbedBuilder errorInputFormat() {
		return EmbedTypes.error().setTitle("**EINGABEFORMAT**").setDescription(":warning: Deine getätigte Eingabe besitzt das falsche Format. Benutze !help [Command] für weitere Infos!");
	}
	
	public static EmbedBuilder warningPermissions() {
		return EmbedTypes.warning().setTitle("**BERECHTIGUNG**").setDescription(":warning: Du hast keine Berechtigungen, um diesen Command zu benutzen!");
	}
	
	public static EmbedBuilder memberJoined() {
		return EmbedTypes.success().setTitle("**BEGRÜßUNG**");
	}
	
}
