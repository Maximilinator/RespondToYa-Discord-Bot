package core;

import java.util.Arrays;
import java.util.HashMap;

import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.Ref;

public class PermsChecker {

	public static HashMap<String, String[]> permLevel = new HashMap<>();
	public String[] perms1 = new String[20];
	public String[] perms2 = new String[20];
	public String[] perms3 = new String[20];

	public boolean hasPerms(String invoke, MessageReceivedEvent event) {
		switch (parsePermsLevel(event)) {
		case 1:
			if (perms1.length != 0) {
				for (int i = 0; i <= perms1.length; i++) {
					if (perms1[i].equals(invoke)) {
						return true;
					}
				}
			}
		case 2:
			for (int i = 0; i <= perms2.length; i++) {

			}
		case 3:
			for (int i = 0; i <= perms3.length; i++) {

			}
		default:
		}
		return true;
	}

	public static int parsePermsLevel(MessageReceivedEvent event) {

		for (net.dv8tion.jda.core.entities.Role r : event.getGuild().getMember(event.getAuthor()).getRoles()) {
			if (Arrays.stream(Ref.PERMS1).parallel().anyMatch(r.getName()::contains)) {
				return 1;
			} else if (Arrays.stream(Ref.PERMS2).parallel().anyMatch(r.getName()::contains)) {
				return 2;
			} else if (Arrays.stream(Ref.PERMS3).parallel().anyMatch(r.getName()::contains)) {
				return 3;
			} else if (Arrays.stream(Ref.PERMS4).parallel().anyMatch(r.getName()::contains)) {
				return 4;
			}
		}
		return 0;
	}
}
