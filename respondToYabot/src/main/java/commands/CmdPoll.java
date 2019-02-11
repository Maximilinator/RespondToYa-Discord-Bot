package commands;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import core.UniError;
import net.dv8tion.jda.client.managers.EmoteManager;
import net.dv8tion.jda.client.managers.EmoteManagerUpdatable;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Emote;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.MessageHistory;
import net.dv8tion.jda.core.entities.MessageReaction;
import net.dv8tion.jda.core.entities.MessageReaction.ReactionEmote;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.requests.restaction.AuditableRestAction;
import util.EmbedTypes;
import util.Ref;

public class CmdPoll implements Command {

	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {
		return false;
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) {
		String question = "";
		for (int i = 0; i < args.length - 1; i++) {
			question += " " + args[i];
		}
		MessageChannel channel = event.getGuild().getTextChannelById(event.getMessage().getMentionedChannels().get(0).getId());
		channel.sendMessage(EmbedTypes.poll().setDescription(question).addField("  Ja", ":thumbsup:", true)
				.addField("Nein", ":thumbsdown:", true).setAuthor(event.getAuthor().getName(), null, event.getAuthor().getAvatarUrl()).build()).complete().addReaction("👍").complete();

		MessageHistory history = channel.getHistoryAfter(event.getChannel().getLatestMessageId(), 1)
				.complete();
		history.getRetrievedHistory().get(0).addReaction("👎").complete();
		channel.sendMessage("@here").queue();
	}

	@Override
	public void executed(boolean success, MessageReceivedEvent event) {
	}

	@Override
	public String help() {
		return Ref.PREFIX + "poll [Question] [MentionedChannel]";
	}

}
