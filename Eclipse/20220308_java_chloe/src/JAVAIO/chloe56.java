package JAVAIO;

import java.io.File;

public class chloe56 { // members includes: field, object

	public static void main(String[] args) {
		System.out.println(File.pathSeparator);
		System.out.println(File.separator);
		
		File f1 = new File("test3");
		if(f1.exists()) {
			System.out.println("OK");
		}
		else {
//			try {
//				f1.createNewFile();
//			} catch (Exception e) {
//				System.out.println(e.toString());
//			}
			f1.mkdir();
			System.out.println("XX");
			
		}
	}

}
