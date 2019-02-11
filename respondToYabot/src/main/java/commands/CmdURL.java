package commands;

import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.EmbedTypes;
import util.Ref;
import youTubeCore.URLAnalyzer;

public class CmdURL implements Command {

	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {

		return false;
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) {

		MessageChannel objMsgCh = event.getChannel();

		if (args.length >= 2) {
			URLAnalyzer.commandAnalysis(args, event);
		} else {
			objMsgCh.sendMessage(EmbedTypes.warning().setTitle("EINGABEFORMAT").setDescription(
					":warning: Falsches Eingabeformat! Benutze " + Ref.PREFIX + "help [Command] für weitere Infos!")
					.build()).complete();
		}
	}

	@Override
	public void executed(boolean success, MessageReceivedEvent event) {
	}

	@Override
	public String help() {
		return Ref.PREFIX + "ytinfo " + "[Kanalname/YouTubeURL] " + "[current/total/channel]";
	}

}
