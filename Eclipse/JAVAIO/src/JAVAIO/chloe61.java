package JAVAIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class chloe61 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		// 假設 result: 6000 => 6 秒鐘
		try (FileOutputStream fout = new FileOutputStream("../../io2/coffee.jpeg");
				FileInputStream fin = new FileInputStream("../../io/coffee.jpeg")){ /* try 刮號內的區域變數，在括號內做完會自動關閉，裡面可以多道敘述句，
					但是只能在 JAVA api 看到 All Implemented Interfaces 有AutoCloseable的。
					針對 AutoCloseable 只能是在 try() {     } 內才有可自動關閉 */
			
			int d;
			while ( (d = fin.read()) != -1) {
				fout.write(d);
			}
			fout.flush();
			// fout.close(); // => 已經有 AutoCloseable 就不用再 .close() 了 
			System.out.println("Finish");
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		System.out.println(System.currentTimeMillis() - start);
		
	}

}

