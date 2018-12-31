package core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.Ref;

public class PermsChecker {

	public static HashMap<String, String[]> permLevel = new HashMap<>();
	public static ArrayList<String> perms1 = new ArrayList<>();
	public static ArrayList<String> perms2 = new ArrayList<>();
	public static ArrayList<String> perms3 = new ArrayList<>();
	public static ArrayList<String> perms4 = new ArrayList<>();

	public static boolean hasPerms(String invoke, MessageReceivedEvent event) {
		switch (parsePermsLevel(event)) {
		case 1:
			if (perms1.size() != 0) {
				for (int i = 0; i < perms1.size(); i++) {
					if (perms1.get(i).equals(invoke)) {
						return true;
					}
				}
			}
		case 2:
			if (perms2.size() != 0) {
				for (int i = 0; i < perms2.size(); i++) {
					if (perms2.get(i).equals(invoke)) {
						return true;
					}
				}
			}
		case 3:
			if (perms3.size() != 0) {
				for (int i = 0; i < perms3.size(); i++) {
					if (perms3.get(i).equals(invoke)) {
						return true;
					}
				}
			}
		case 4:
			if (perms4.size() != 0) {
				for (int i = 0; i < perms4.size(); i++) {
					if (perms4.get(i).equals(invoke)) {
						return true;
					}
				}
			}
		default:
		}
		return false;
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
