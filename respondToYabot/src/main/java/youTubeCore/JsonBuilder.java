package youTubeCore;

import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONObject;

public class JsonBuilder {

	public static void test() {
		try {
			FileWriter file = new FileWriter("test.json");
			file.write("{\r\n" + 
					" \"kind\": \"youtube#playlistItemListResponse\",\r\n" + 
					" \"etag\": \"\\\"XpPGQXPnxQJhLgs6enD_n8JR4Qk/OLKnn0-FAnM6pb6rtOqHAh2Pht8\\\"\",\r\n" + 
					" \"nextPageToken\": \"CAEQAA\",\r\n" + 
					" \"pageInfo\": {\r\n" + 
					"  \"totalResults\": 4822,\r\n" + 
					"  \"resultsPerPage\": 1\r\n" + 
					" },\r\n" + 
					" \"items\": [\r\n" + 
					"  {\r\n" + 
					"   \"kind\": \"youtube#playlistItem\",\r\n" + 
					"   \"etag\": \"\\\"XpPGQXPnxQJhLgs6enD_n8JR4Qk/eyh6rbybZB3PCSgFgFumEbOmT-o\\\"\",\r\n" + 
					"   \"id\": \"VVVPenFoekFJdzRKVEpJTWtEVGZMbmtnLmpVMHJlYzJza2Rr\",\r\n" + 
					"   \"snippet\": {\r\n" + 
					"    \"publishedAt\": \"2019-02-09T15:54:12.000Z\",\r\n" + 
					"    \"channelId\": \"UCOzqhzAIw4JTJIMkDTfLnkg\",\r\n" + 
					"    \"title\": \"Mein eigenes COMPUTER-SPIEL ist FERTIG!\",\r\n" + 
					"    \"description\": \"Hier geht es zum Spiel: https://dennotogo.itch.io/palle-wird-pralle\\nZu Dennos Twitter: https://twitter.com/DennoToGo\\nDer Paluten Shop: http://paluten.shop\\nMein erstes Buch: http://amzn.to/2Ewudnn *\\n_\\n\\n►Twitter http://goo.gl/FvikcE\\n►Instagram http://goo.gl/J0M0Oc \\n\\nDie mit * gekennzeichneten Links sind Affiliate Links. Wenn du dieses Produkt kaufen solltest, werde ich am Umsatz beteiligt. Für dich entstehen dabei keine Mehrkosten.\",\r\n" + 
					"    \"thumbnails\": {\r\n" + 
					"     \"default\": {\r\n" + 
					"      \"url\": \"https://i.ytimg.com/vi/jU0rec2skdk/default.jpg\",\r\n" + 
					"      \"width\": 120,\r\n" + 
					"      \"height\": 90\r\n" + 
					"     },\r\n" + 
					"     \"medium\": {\r\n" + 
					"      \"url\": \"https://i.ytimg.com/vi/jU0rec2skdk/mqdefault.jpg\",\r\n" + 
					"      \"width\": 320,\r\n" + 
					"      \"height\": 180\r\n" + 
					"     },\r\n" + 
					"     \"high\": {\r\n" + 
					"      \"url\": \"https://i.ytimg.com/vi/jU0rec2skdk/hqdefault.jpg\",\r\n" + 
					"      \"width\": 480,\r\n" + 
					"      \"height\": 360\r\n" + 
					"     },\r\n" + 
					"     \"standard\": {\r\n" + 
					"      \"url\": \"https://i.ytimg.com/vi/jU0rec2skdk/sddefault.jpg\",\r\n" + 
					"      \"width\": 640,\r\n" + 
					"      \"height\": 480\r\n" + 
					"     },\r\n" + 
					"     \"maxres\": {\r\n" + 
					"      \"url\": \"https://i.ytimg.com/vi/jU0rec2skdk/maxresdefault.jpg\",\r\n" + 
					"      \"width\": 1280,\r\n" + 
					"      \"height\": 720\r\n" + 
					"     }\r\n" + 
					"    },\r\n" + 
					"    \"channelTitle\": \"Paluten\",\r\n" + 
					"    \"playlistId\": \"UUOzqhzAIw4JTJIMkDTfLnkg\",\r\n" + 
					"    \"position\": 0,\r\n" + 
					"    \"resourceId\": {\r\n" + 
					"     \"kind\": \"youtube#video\",\r\n" + 
					"     \"videoId\": \"jU0rec2skdk\"\r\n" + 
					"    }\r\n" + 
					"   }\r\n" + 
					"  }\r\n" + 
					" ]\r\n" + 
					"}");
			file.close();
			JSONObject json = new JSONObject("test.json");
			String id = json.get("id").toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	}
	
}
