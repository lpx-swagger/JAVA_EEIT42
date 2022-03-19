package JAVAIO;

import java.io.File;

public class chloe57 {
	public static void main(String[] args) {
		File f1 = new File("./dir2");
		if (f1.exists()) {
			System.out.println("OK");
		}
	}

}