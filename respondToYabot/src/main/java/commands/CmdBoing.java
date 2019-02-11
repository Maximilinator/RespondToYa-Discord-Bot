package commands;

import java.util.Random;

import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.EmbedTypes;
import util.Ref;

public class CmdBoing implements Command {

	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {
		return false;
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) {

		MessageChannel objMsgCh = event.getChannel();

		Random random = new Random();
		switch (random.nextInt(3)) {
		case 0:
			objMsgCh.sendMessage(
					EmbedTypes.success().setTitle("BOING").setDescription("Airbus! :airplane_small:").build())
					.complete();
			break;
		case 1:
			objMsgCh.sendMessage(EmbedTypes.success().setTitle("BOING").setDescription("Antonow! :airplane:").build())
					.complete();
			break;
		case 2:
			objMsgCh.sendMessage(EmbedTypes.success().setTitle("BOING").setDescription("SpaceX! :rocket:").build())
					.complete();
			break;
		default:
			objMsgCh.sendMessage(
					EmbedTypes.success().setTitle("BOING").setDescription("Das ist nicht lustig...").build())
					.complete();
		}

	}

	@Override
	public void executed(boolean success, MessageReceivedEvent event) {
	}

	@Override
	public String help() {
		return Ref.PREFIX + "boing";
	}

}
