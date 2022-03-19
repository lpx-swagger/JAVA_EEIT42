package Generator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.annotation.processing.FilerException;

public class MainChloe {
	public static void main(String[] args) {
		// 檢查機制
		try {
			File myGuessNum = new File("__myInput.txt");
			Scanner myReader = new Scanner(myGuessNum);
			String ans = myReader.nextLine();
			
			String guess;
			while(myReader.hasNext()) {
				guess = myReader.nextLine();
				if (ans == guess) {
					System.out.println();
				}
			}
		} catch (FileNotFoundException fileNotFound) {
			System.out.println("Error, cannot find file!");
		}
		
		
	}
	
	public String getHint(String secret, String guess) {
		int A = 0;
		int B = 0;
		int[] count1 = new int[10];
		int[] count2 = new int[10];

		for (int i = 0; i < secret.length(); ++i)
		  if (secret.charAt(i) == guess.charAt(i))
		    ++A;
		  else {
		    ++count1[secret.charAt(i) - '0'];
		    ++count2[guess.charAt(i) - '0'];
		  }

		for (int i = 0; i < 10; ++i)
		  B += Math.min(count1[i], count2[i]);

		return String.valueOf(A) + "A" + String.valueOf(B) + "B";
	}

//	private void checkAB() {
//		Scanner sc = new Scanner();
//		String input = new String();
//		String anws = new String();
//		
//		int countA = 0;
//		int countB = 0;
//		for (int i = 0; ; i++) {
//			for (int j = 0; j < i; j++) {
//				if() {
//					
//				} else if()
//				sc.hasNext(input.charAt(i)); 
//			}
//			
//		}
//		
//			
//	}
	
}
