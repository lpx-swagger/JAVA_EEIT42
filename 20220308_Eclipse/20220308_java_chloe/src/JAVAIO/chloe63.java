package JAVAIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class chloe63 {  // 看檔案有多大，一次讀一次寫，分兩段 不同步，連while-loop也不用寫

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		try {
			File source = new File("../../io/coffee.jpeg"); // File(內容不可>2G，有先天的障礙)
			FileInputStream fin = new FileInputStream(source);
			byte[] buf = new byte[(int)source.length()];
			fin.read(buf);
			fin.close();
			
			FileOutputStream fout = new FileOutputStream("../../io2/coffee3.jpeg");
			fout.write(buf);
			fout.flush();
			fout.close();
			
			System.out.println("Finish");
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		System.out.println(System.currentTimeMillis() - start);
		
	}

}