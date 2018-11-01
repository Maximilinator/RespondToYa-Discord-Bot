package youTubeCore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import util.Ref;

public class InternetCodeParser {

	private String parseURL() throws IOException {
		URL url = new URL(
				"https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId=UULa29CxhRwOeGTa1pOGH1Qg+&key=" + Ref.APIKEY);

		InputStream input = url.openStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(input));

		String textLine;
		String videoURL = "";
		boolean searching = true;

		while ((textLine = reader.readLine()) != null && searching) {

			if (textLine.contains("videoId")) {

				int idChar = 17;

				while ((textLine.charAt(idChar)) != '"') {
					videoURL += textLine.charAt(idChar);
					idChar++;
				}

				searching = false;
			}
		}
		
		
		
		return videoURL;
	}

	public String getVideoURL() {
		
		String url = "";
		try {
			url = "https://www.youtube.com/watch?v=" + parseURL();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("The determined URL is incorrect!");
		}
		return url;
	}
}
