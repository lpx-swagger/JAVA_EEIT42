package Generator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

import org.json.JSONStringer;
import org.json.JSONWriter;

// 資料分頁 LIMIT
// 編出 JSON
// JTable => 視窗表現出資料 => 新分頁開啟；分開的技術你有了，想像要如何combine
	// 不要用[][] => 資料固定
	// Listen for data change
		// table data   TO   table model(getRowCount, getColumnCount)   TO   table Object

public class chloe97 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Page: ");
		int page = sc.nextInt();
		int rpp = 10;  // Row Per Page
		int start = (page - 1) * rpp;
		
		// 如果輸入值不合理，就不要往下做，#139筆 最多14頁，輸入0或 >14就不對
		
		// connect to sql
		Properties prop = new Properties();
		prop.put("user", "root"); prop.put("password", "root");
		
//		// 從第%d開始取10筆
//		String presql = "SELECT * FROM foods ORDER BY id LIMIT %d, 10";
		String presql = "SELECT * FROM foods ORDER BY id LIMIT %d, %d";
		String sql = String.format(presql, start, rpp);
		
		try(Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3307/iii", prop)) {
			PreparedStatement ps = conn.prepareStatement(
				sql,
				ResultSet.TYPE_SCROLL_INSENSITIVE,
//				ResultSet.CONCUR_UPDATABLE  // pointer 看到money 直接值的改變，不要再下Update 的句法了
				ResultSet.CONCUR_READ_ONLY);  // 同步
			
		// [ ] 空的也會被輸出
		JSONStringer js = new JSONStringer();  // 先創一個文字化
		JSONWriter jw = js.array();
		
		// 撈資料 => 巡防
		ResultSet rs = ps.executeQuery();
		
		// 若資料想呈現來來回回，就要加上 ResultSet.TYPE*** & CUNCUR_READ*** 的敘述句，because 我有加 ResultSet.TYPE*** & CUNCUR_READ*** 的敘述句，才可以回頭看，否則只能往前衝
		// 直衝最後一筆，就知道你總共有幾筆資料
		rs.last();
		int rowCount = rs.getRow(); 
		System.out.println(rowCount);
		
		rs.beforeFirst();
		while (rs.next()) {
			String id = rs.getString("id");
			String name = rs.getString("name");
			String addr = rs.getString("addr");
			String tel = rs.getString("tel");
			System.out.println(id + " : " + name);
			
//			jw.array();  // 陣列裡的陣列
//			jw.endArray();
			jw.object();
			jw.key("id"); jw.value(id);
			jw.key("name"); jw.value(name);
			jw.key("addr"); jw.value(addr);
			jw.key("tel"); jw.value(tel);
			jw.endObject();
			// TODO 沒有String 可以寫，但是有Object, 整數寫下去，他會autoboxing
		}
		
		jw.endArray();
		System.out.println(jw.toString());
		
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}
}
