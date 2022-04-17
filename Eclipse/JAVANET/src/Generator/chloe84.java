package Generator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

// http v.s. https
// 爬蟲 Crawling，抓取文字資料 ex. 衛福部口罩cvs 每 5mins 就可以自己刷新看看

public class chloe84 {
	public static void main(String[] args) {
		try {
			URL url = new URL("https://data.coa.gov.tw/Service/OpenData/ODwsv/ODwsvTravelFood.aspx");
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();  // 在Google 輸入URL之後，按下Enter => openConnection()
			
			BufferedReader reader =  // 網頁原始碼 永遠都是文字檔 => 使用 BufferedReader
				new BufferedReader(
					new InputStreamReader(conn.getInputStream()));  // openConnection()後 => 取得物件實體URLConnection => URLconnection abstract 就 abstract 方法(getInputStream() => 倒資料進來)能夠滿足我用就好了
			String line; StringBuffer sb = new StringBuffer();
			while ( (line = reader.readLine()) != null) {
				sb.append(line);
			}
			reader.close();
			
			conn.disconnect();
			
			parseJSON(sb.toString());
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	private static void parseJSON(String json) {
		try {
			JSONArray root = new JSONArray(json);
			for (int i = 0; i < root.length(); i++) {
				JSONObject row = root.getJSONObject(i);
				String country = row.getString("City");
				String town = row.getString("Town");
				String name = row.getString("Name");
				
				System.out.println(country + ":" + town +":" + name);
			}
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}

}
