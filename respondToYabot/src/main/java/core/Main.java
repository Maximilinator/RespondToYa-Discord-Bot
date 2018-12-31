package core;

import java.io.IOException;

import javax.security.auth.login.LoginException;

import commands.AutoChannel;
import commands.CmdBoing;
import commands.CmdCheck;
import commands.CmdCommandList;
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

public class Main {

	public static void main(String[] args) throws IOException  {

		JDABuilder jdaBuilder = new JDABuilder(AccountType.BOT).setToken(Ref.TOKEN).setGame(Game.playing(getVersion()))
				.setAutoReconnect(true).setStatus(OnlineStatus.ONLINE);
		
		// Hinzufügen der Commands
		addListeners(jdaBuilder);
		addCommands();
		addPerms();

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
		CommandHandler.commands.put("commands", new CmdCommandList());
	}

	private static void addPerms() {
		// PERMS 1
		PermsChecker.perms1.add("shutdown");

		// PERMS 2
		
		// PERMS 3
	
		// PERMS 4
		PermsChecker.perms4.add("autochan");
		PermsChecker.perms4.add("music");
		PermsChecker.perms4.add("boing");
		PermsChecker.perms4.add("aboboxcamper");
		PermsChecker.perms4.add("ping");
		PermsChecker.perms4.add("commands");
	}

	private static String getVersion() {
		return "v" + Ref.VERSION;
	}
}
