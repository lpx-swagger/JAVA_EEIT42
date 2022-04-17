package JAVAIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class chloe62 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		// 假設 result: 6 => 0.006 秒鐘
		try {
			FileOutputStream fout = new FileOutputStream("../../io2/coffee1.jpeg");
			FileInputStream fin = new FileInputStream("../../io1/coffee.jpeg");
			
			byte[] buf = new byte[4*1024];  /* byte[int] => 4K 
				=> 這邊的邏輯：讀1byte寫1byte，等他寫完了再換下一個，再讀一個再寫一個 
					=> 耗磁碟 => io存取越多次，越損害磁碟 */
			
			int len;
			while ( (len = fin.read(buf)) != -1) {
				fout.write(buf, 0, len);
			}
			
			fin.close();
			fout.flush();
			fout.close();
			System.out.println("Finish");
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		System.out.println(System.currentTimeMillis() - start);
		
	}

}
