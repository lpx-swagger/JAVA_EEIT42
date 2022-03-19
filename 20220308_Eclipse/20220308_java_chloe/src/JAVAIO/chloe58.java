package JAVAIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.filechooser.FileNameExtensionFilter;

public class chloe58 {

	public static void main(String[] args) {
		//FileInputStream fin = new FileInputStream(""); // IOException => 需做try-catch
		try {
			FileInputStream fin = new FileInputStream("../io/file1");
			
			// 開檔Method2:
			int count;
			while((count = fin.read()) != -1) {
				//System.out.println(count);
				System.out.print((char)count + "");
				// 非文字檔 => binary file 沒有換line
				// text file =>
			} 
			fin.close();
		} catch(FileNotFoundException e) {
			System.out.println(e.toString());
		} catch(IOException ioe) {
			System.out.println(ioe.toString());
		}
	}

}
