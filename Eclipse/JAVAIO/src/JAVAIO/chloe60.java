package JAVAIO;

import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;

public class chloe60 {
	public static void main(String[] args) {
		String data = "Hi, 20220315\n2:53PM\nRohan's birthday";
		//byte[] buf = data.getBytes();// 預設值
		byte[] buf = data.getBytes(StandardCharsets.UTF_8); // 其他同學 VScode 的中文字顯示有問題
		
		
		// Method1: 原資料如果有寫資料，清掉重寫；原資料如果不在其他建立新的file，然後把新資料寫上去
		try {
			FileOutputStream fout = new FileOutputStream("../io/file2"); 
			fout.write(buf);
			fout.flush(); // 要在close之前做
			fout.close();
			
		} catch(Exception e) {
			System.out.println(e.toString());
		}

		
		/* Method2: 把剛剛寫上去的做append => 應用在「寫log記錄」不希望原檔被不破壞
		   FileOutputStream(String name, boolean append) */
		try {
			FileOutputStream fout = new FileOutputStream("../io/file2", true); 
			fout.write(buf);
			fout.flush(); // 要在close之前做
			fout.close();
			
		} catch(Exception e) {
			System.out.println(e.toString());
		}
	}
	
}
