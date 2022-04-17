package Generator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONObject;

// 增！
//stmt.executeUpdate() => int
//parseJSON 的方式來寫

public class chloe88 {
	public static PreparedStatement pstmt;
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		
		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3307/iii", prop);
			
			// 3. SQL statement => 使用 PreparedStatement 和 ? 預存的方式來防止隱碼攻擊(SQL Injection)
			pstmt = conn.prepareStatement(
					"INSERT INTO foods (name,addr,tel) " +
					"VALUES (?,?,?)");
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		
		// 1. 抓 JSON 回來
		fetchJSON();
		// 2. parse json
		// 3. insert into
		System.out.println("OK");
	}
	
	private static void fetchJSON() {
		try {
			URL url = new URL("https://data.coa.gov.tw/Service/OpenData/ODwsv/ODwsvTravelFood.aspx");
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			
			BufferedReader reader = 
				new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
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
			for (int i=0; i<root.length(); i++) {
				JSONObject row = root.getJSONObject(i);
				String name = row.getString("Name");
				String addr = row.getString("Address");
				String tel = row.getString("Tel");
				
				// 撈到一筆，就入一筆到資料庫
				insertData(name, addr, tel);
				
			}
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
	
	private static void insertData(String name, String addr, String tel) {
		try {
			pstmt.setString(1, name);
			pstmt.setString(2, addr);
			pstmt.setString(3, tel);
			
			// 4. execute SQL statement
			pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}

}
