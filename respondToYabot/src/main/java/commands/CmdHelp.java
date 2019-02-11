package commands;

import core.CommandHandler;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.EmbedTypes;
import util.Ref;

public class CmdHelp implements Command {

	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) {
		String command = args[0].toUpperCase();
		
		if(CommandHandler.commands.containsKey(command)) {
			event.getChannel().sendMessage(EmbedTypes.help().setDescription(CommandHandler.commands.get(command).help()).build()).complete();
		} else {
			event.getChannel().sendMessage(EmbedTypes.error().setTitle("EINGABEFEHLER").setDescription(":warning: Dein gesuchter Command existiert nicht!").build()).complete();
		}
		
	}

	@Override
	public void executed(boolean success, MessageReceivedEvent event) {
	}

	@Override
	public String help() {
		return Ref.PREFIX + "help [Command]";
	}
	
}
