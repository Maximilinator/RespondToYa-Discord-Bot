package youTubeCore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.EmbedTypes;
import util.Ref;

public class URLBrowser {

	public static void informationBrowse(String username, String action, boolean link, MessageReceivedEvent event)
			throws IOException {

		String playlistID = "";
		String videoID = "";
		int totalUploads = 0;
		String channelID = browseChannelID(username, link);

		if (channelID != null) {
			switch (action) {
			case "current":
				playlistID = browseLinkforString(
						"https://www.googleapis.com/youtube/v3/channels?part=contentDetails&id=" + channelID + "&key="
								+ Ref.APIKEY,
						"uploads");
				videoID = browseLinkforString(
						"https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&maxResults=50&playlistId="
								+ playlistID + "&key=" + Ref.APIKEY,
						"videoId");
				URLPoster.urlPoster("Das ist das neueste Video: ", videoID, "video", event);
				break;
			case "total":
				playlistID = browseLinkforString(
						"https://www.googleapis.com/youtube/v3/channels?part=contentDetails&id=" + channelID + "&key="
								+ Ref.APIKEY,
						"uploads");
				totalUploads = browseLinkforInt(
						"https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&maxResults=50&playlistId="
								+ playlistID + "&key=" + Ref.APIKEY,
						"totalResults");
				URLPoster.urlPoster("Insgesamt hochgeladen: ", totalUploads + "", "stat", event);
				break;
			case "channel":
				URLPoster.urlPoster("Meinst du den hier?: ", channelID, "channel", event);
				break;

			}
		} else {
			event.getChannel().sendMessage(EmbedTypes.error().setDescription(
					":warning: Der Kanal konnte nicht gefunden werden! Probiere es einmal direkt mit dem Link des Kanals!")
					.build()).complete();
		}
	}

	private static String browseLinkforString(String link, String keyword) {
		try {
			URL url = new URL(link);
			InputStream input = url.openStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));

			String textLine;
			String result = "";

			while ((textLine = reader.readLine()) != null) {
				System.out.println(textLine);
				if (textLine.contains(keyword)) {
					System.out.println(keyword + " wurde gefunden!");
					int idChar = 0;
					while ((textLine.charAt(idChar)) == ' ') {
						idChar++;
						System.out.println("VOR!!!");
					}
					System.out.println(idChar);
					idChar += keyword.length() + 5;
					while ((textLine.charAt(idChar)) != '"') {
						result += textLine.charAt(idChar);
						idChar++;
						System.out.println("Schreiben");
					}
					System.out.println(result);
					return result;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static int browseLinkforInt(String link, String keyword) {
		try {
			URL url = new URL(link);

			InputStream input = url.openStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));

			String textLine;
			String result = "";

			while ((textLine = reader.readLine()) != null) {
				System.out.println(textLine);
				if (textLine.contains(keyword)) {
					System.out.println(keyword + " wurde gefunden");
					int idChar = 0;
					while ((textLine.charAt(idChar)) == ' ') {
						idChar++;
					}
					System.out.println(idChar);
					idChar += keyword.length() + 4;
					while ((textLine.charAt(idChar)) != ',') {
						result += textLine.charAt(idChar);
						idChar++;
					}
					System.out.println(result);
					int output = 0;
					try {
						output = Integer.parseInt(result);
					} catch (NumberFormatException e) {
						e.printStackTrace();
					}
					return output;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}

	private static String browseChannelID(String username, boolean link) {
		String channelID = "";
		if (link) {
			for (int i = 32; i < 56; i++) {
				channelID += username.charAt(i);
			}
		} else {
			if (browseLinkforInt("https://www.googleapis.com/youtube/v3/channels?part=contentDetails&forUsername="
					+ username + "&key=" + Ref.APIKEY, "totalResults") != 0) {
				channelID = browseLinkforString(
						"https://www.googleapis.com/youtube/v3/channels?part=contentDetails&forUsername=" + username
								+ "&key=" + Ref.APIKEY,
						"id");
			} else {
				return null;
			}
		}
		return channelID;
	}
}
