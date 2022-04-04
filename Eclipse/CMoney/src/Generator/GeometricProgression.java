package Generator;

import java.util.Scanner;

public class GeometricProgression {
	public static void main(String[] args) {
		// an/an-1 = q
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();  // 輸入n組
		int iNum = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println("OK");
	}
}
