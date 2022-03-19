package JAVAIO;

import java.io.File;
import java.io.FileInputStream;

public class chloe59 {
	public static void main(String[] args) {
		try {
//			FileInputStream fin = new FileInputStream("../io/file1");
//			byte[] b = new byte[3]; // 一次讀 3 byte，適合UTF-8 => 亂碼1/3
//			//byte[] b = new byte[2]; // 適合Big-5 => 亂碼1/2 => #10-11這樣寫彈性不高
//			
//			int len;
//			while((len = fin.read(b)) != -1)  {
//				System.out.print(new String(b, 0, len));  // 這裡不用 println，為了日後除錯
//			}
//			fin.close();
			
			
			File f1 = new File("../io/file1");
			FileInputStream fin = new FileInputStream(f1);
			
			/* 開檔Method3: 若已經知道檔案大小是多少，陣列[] 裡面是int => 不能讀超過2G的檔案 
			一次讀全部 不會有亂碼，但是在讀的過程中 無法區分出 一個字一個字(byte?)，利用範例理解 
			ex. 資a策b會cdef */
			byte[] buf = new byte[(int)f1.length()]; // 需先有 File f1 才知道這個檔有多大
			fin.read(buf);
			System.out.print(new String(buf));
			System.out.println("OK");
			fin.close();
			
		} catch(Exception e) {
			System.out.println(e.toString());
		}

	}

}