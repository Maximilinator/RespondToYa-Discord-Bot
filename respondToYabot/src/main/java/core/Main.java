package core;

import java.io.IOException;

import javax.security.auth.login.LoginException;

import commands.AutoChannel;
import commands.CmdBoing;
import commands.CmdCheck;
import commands.CmdShutdown;
import commands.CmdURL;
import commands.Music;
import listeners.CommandListener;
import listeners.ReadyListener;
import listeners.VoiceListener;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;
import util.Ref;
import youTubeCore.InternetCodeParser;

public class Main {

	public static void main(String[] args) throws IOException  {

		JDABuilder jdaBuilder = new JDABuilder(AccountType.BOT).setToken(Ref.TOKEN).setGame(Game.playing(getVersion()))
				.setAutoReconnect(true).setStatus(OnlineStatus.ONLINE);

		PermsChecker permsChecker = new PermsChecker();
		
		addListeners(jdaBuilder);
		addCommands();
		addPerms(permsChecker);

		try {
			JDA jda = jdaBuilder.buildBlocking();
		} catch (LoginException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static void addListeners(JDABuilder jdaBuilder) {
		jdaBuilder.addEventListener(new ReadyListener());
		jdaBuilder.addEventListener(new CommandListener());
		jdaBuilder.addEventListener(new VoiceListener());
	}

	private static void addCommands() {
		CommandHandler.commands.put("ping", new CmdCheck());
		CommandHandler.commands.put("shutdown", new CmdShutdown());
		CommandHandler.commands.put("boing", new CmdBoing());
		CommandHandler.commands.put("aboboxcamper", new CmdURL());
		CommandHandler.commands.put("autochan", new AutoChannel());
		CommandHandler.commands.put("music", new Music());
	}

	private static void addPerms(PermsChecker permsChecker) {
		// PERMS 1
		permsChecker.perms1[0] = "shutdown";

		// PERMS 2
		permsChecker.perms2[0] = "ping";

		// PERMS 3
		permsChecker.perms3[0] = "boing";
	}

	private static String getVersion() {
		return "v" + Ref.VERSION;
	}
}

// YouTube API
// https://www.googleapis.com/youtube/v3/activities?part=snippet,contentDetails&channelId=UCLa29CxhRwOeGTa1pOGH1Qg&key=AIzaSyCQL8YJgSPu3HlCmwzj0WslNEXYbFhG-AY
// https://www.googleapis.com/youtube/v3/commentThreads?part=snippet&allThreadsRelatedToChannelId=UCLa29CxhRwOeGTa1pOGH1Qg&key=AIzaSyCQL8YJgSPu3HlCmwzj0WslNEXYbFhG-AY
// https://www.googleapis.com/youtube/v3/commentThreads?part=snippet&videoId=6M6K-GzCd-o&key=AIzaSyCQL8YJgSPu3HlCmwzj0WslNEXYbFhG-AY
