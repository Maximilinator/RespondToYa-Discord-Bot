package core;

import java.io.IOException;
import javax.security.auth.login.LoginException;
import commands.AutoChannel;
import commands.CmdBan;
import commands.CmdBoing;
import commands.CmdCheck;
import commands.CmdCommandList;
import commands.CmdDelete;
import commands.CmdHelp;
import commands.CmdKick;
import commands.CmdPoll;
import commands.CmdShutdown;
import commands.CmdURL;
import commands.CmdWarn;
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

	public static void main(String[] args) throws IOException {

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
		CommandHandler.commands.put("PING", new CmdCheck());
		CommandHandler.commands.put("SHUTDOWN", new CmdShutdown());
		CommandHandler.commands.put("BOING", new CmdBoing());
		CommandHandler.commands.put("YTINFO", new CmdURL());
		CommandHandler.commands.put("AUTOCHAN", new AutoChannel());
		CommandHandler.commands.put("MUSIC", new Music());
		CommandHandler.commands.put("COMMANDS", new CmdCommandList());
		CommandHandler.commands.put("DELETE", new CmdDelete());
		CommandHandler.commands.put("HELP", new CmdHelp());
		CommandHandler.commands.put("BAN", new CmdBan());
		CommandHandler.commands.put("KICK", new CmdKick());
		CommandHandler.commands.put("WARN", new CmdWarn());
		CommandHandler.commands.put("POLL", new CmdPoll());
	}

	private static void addPerms() {
		// PERMS 1
		PermsChecker.perms1.add("SHUTDOWN");

		// PERMS 2
		PermsChecker.perms2.add("DELETE");
		PermsChecker.perms2.add("BAN");
		PermsChecker.perms2.add("KICK");
		PermsChecker.perms2.add("WARN");
		PermsChecker.perms2.add("POLL");

		// PERMS 3

		// PERMS 4
		PermsChecker.perms4.add("AUTOCHAN");
		PermsChecker.perms4.add("MUSIC");
		PermsChecker.perms4.add("BOING");
		PermsChecker.perms4.add("YTINFO");
		PermsChecker.perms4.add("PING");
		PermsChecker.perms4.add("COMMANDS");
		PermsChecker.perms4.add("HELP");
	}

	private static String getVersion() {
		return "v" + Ref.VERSION;
	}
}
