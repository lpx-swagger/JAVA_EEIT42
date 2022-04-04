package JAVAIO;

import java.io.FileInputStream;
import java.io.FileReader;

public class chloe64 {
	public static void main(String[] args) {
		
		/* 需求：你確定要讀的檔案是「文字檔」=> ！！！編碼！！！
		 * Class Reader => public abstract class Reader 
		 	  => Abstract class for reading character文字 streams. 
		   Class FileReader => public class FileReader => 沒有方法 全部繼承InputStreamReader而來的。
		 	  => Convenience class for reading character files. => 依照你的預設編碼方式來編碼
		   Class InputStreamReader => InputStreamReader(InputStream in, Charset cs)
		 	  => 把所以資料讀進來後，再透過字元編碼(Charset)幫你處理
		 * char => 2^16 bits => 口徑比byte大 管線較byte粗 
           byte => 2^8 bits
		 */
		
		try (FileReader reader = new FileReader("../../io/file1") ) {
			int ch;
			while ((ch = reader.read()) != -1) {
				System.out.println((char)ch); // => 執行結果所看到每一行就是 一個字元
			}
		} catch(Exception e) {
			System.out.println(e.toString());
		}

	}

}