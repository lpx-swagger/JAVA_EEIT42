package Generator;

import java.util.LinkedList;
import java.util.Scanner;

/*
反轉數字
Description

系統將輸入一個不固定位數之整數數字

請將數字倒轉過來輸出


Input
系統將輸入一不規則的正整數

範圍為 0 < 正整數 <= 100000000
12345

Output
請將數字反轉後以正整數輸出
54321

 */


//// String Method
//public class ReverseOneNum {
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String input = sc.nextLine();
//		byte[] strToArr = input.getBytes();
//		byte[] result = new byte[strToArr.length];
//	  
//		for(int i = 0; i < strToArr.length; i++) {
//			result[i] =  strToArr[strToArr.length - i -1];
//		}
//		
//		System.out.println(new String(result));
//	}
//
//}



// #ft9203 Integer 正負號
public class ReverseOneNum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		int rev = reverseInt(input);
		System.out.println(rev);
	}
	
	public static int reverseInt(int num){
		boolean isNegative = num < 0 ? true:false;
		
		int reverse = 0;
		int lastDigit = 0;
		
		if(isNegative) {
			num = num * -1;
		}
		
		while (num >= 1) {
			lastDigit = num % 10;
			reverse = reverse * 10 + lastDigit;
			num = num / 10;
		}
		
		return isNegative == true? reverse*-1: reverse;
	}
	
}
				



