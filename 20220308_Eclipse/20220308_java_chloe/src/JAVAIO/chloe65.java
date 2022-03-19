package JAVAIO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class chloe65 {
	public static void main(String[] args) {
		try {
			/* 泡一杯好茶，每一個容器都有他的功用，源頭是一樣的。
			 * Class BufferedReader 的建構式 沒有直接灌到File或String來做處理，而是Reader 
			 	=> 不是直接連到目的地的東西，而是被串接的東西 => 為何要連？因為Method的readLine()是 一次讀一列，byte陣列
			*/
			
//			// 2組串接
//			FileReader fr = new FileReader("../../io/maskdata.csv");  // String, File
//			BufferedReader br = new BufferedReader(fr);
			
			
//			// 3組串接
//			FileInputStream fis = new FileInputStream("../../io/maskdata.csv");
//			InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
//			BufferedReader br = new BufferedReader(isr);
			
			
			// 常用Method: 3組串接 同上作法
			BufferedReader br = 
					new BufferedReader(
							new InputStreamReader(
									new FileInputStream("../../io/maskdata.csv")));
			
			
			String line;
			while((line = br.readLine()) != null) {
				String[] splitData = line.split(",");
				//System.out.println(" >> " + line);
				System.out.println(splitData[1] + ":" + splitData[4] + ":" + splitData[5]);
			}
			
			br.close();
			
		} catch (Exception e){
			System.out.println(e.toString());
		}

	}

}

