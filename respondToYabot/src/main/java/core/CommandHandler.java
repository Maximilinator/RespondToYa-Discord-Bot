package core;

import java.util.HashMap;
import commands.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.EmbedTypes;

public class CommandHandler {

	public static final CommandParser parse = new CommandParser();
	public static HashMap<String, Command> commands = new HashMap<>();

	public static void handleCommand(CommandParser.commandContainer cmd, MessageReceivedEvent event) {

		if (commands.containsKey(cmd.invoke)) {

			if (PermsChecker.hasPerms(cmd.invoke, event)) {

				CommandLog.cmdLog(cmd.invoke.toLowerCase(), event);

				boolean safe = commands.get(cmd.invoke).called(cmd.args, cmd.event);

				if (!safe) {
					commands.get(cmd.invoke).action(cmd.args, cmd.event);
					commands.get(cmd.invoke).executed(safe, cmd.event);
				} else {
					commands.get(cmd.invoke).executed(safe, cmd.event);
				}
			} else
				event.getChannel().sendMessage(EmbedTypes.warning().setTitle("PERMISSIONS").setDescription(":warning: Du hast keine Berechtigung, diesen Command zu benutzen").build()).complete();
		} else
			event.getChannel().sendMessage(EmbedTypes.error().setTitle("ERROR").setDescription(":interrobang: Oopsie Doopsie! Diesen Command gibt es leider nicht... :scream:").build()).complete();
	}

}
