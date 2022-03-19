package Generator;

import java.util.Scanner;

public class MainChloe {	
	public static void main(String[] args) {
		boolean isRepeat = false;
		boolean isValid = true;
		int NUM = 6;
		int temp = 0 ;
		int[] num = new int[NUM];
	
		
		// 自選
		for (int i = 0; i < NUM; i++) {
			isValid = true;
			isRepeat = false;
			System.out.print("Enter in an integer from 1 to 49: ");
			Scanner sc = new Scanner(System.in);
			temp = sc.nextInt(); 
			
			if(temp < 1 || temp > 49) {
				System.out.println("Invalid number, the number is not in the right range!");
				i--;
				isValid = false;
			} else {
				for (int j = 0; j < i; j++) {				
					if(num[j] == temp) {
						System.out.println("Duplicate, Please try again!");
						isRepeat = true;
						i--;
						break;
					}
				}
			}
			
			if(isValid == true && isRepeat == false) {
				num[i] = temp;
			}
		}

		java.util.Arrays.sort(num);
		
		System.out.println("Your choice: ");
		for(int vv : num) {
			System.out.println(vv);
		}
		
		// 中獎號碼
		int NUMS = 6;
		int[] rand = new int[NUMS];
		int temp2;
		
		for(int i = 0; i < NUMS; i++) {
			do {
				temp2 = (int)(Math.random()*49+1);
				//rand[i] = (int)Math.random()*49+1;
				isRepeat = false;
				for (int j = 0; j < i; j++) {
					if(temp2 == rand[j]) {
						isRepeat = true;
						break;
					}
				}
			} while(isRepeat);

			rand[i] = temp2;

		}
				
		// Sequential
		//java.util.Random R = new java.util.Random();
		java.util.Arrays.sort(rand);
		
		System.out.println("\nLucky number: ");
		for(int v : rand) {
			System.out.println(v);
		}
		
		// lottery match
		int match = 0;
		for(int i: rand) {
			for(int j: num) { 
				if(i == j) {
					match++;
				}
			}
		}
		System.out.println("\nYou match #" + match + " times!");
		if(match == 6) {
			System.out.println("You win First Prize!!! You got $1,000,000,000.");
		} else if(match == 5) {
			System.out.println("Congrats! Second prize! You got $500,000,000.");
		} else if(match == 4) {
			System.out.println("Congrats! Third Prize! You got $100,000.");
		} else if(match == 3) {
			System.out.println("Congrats! Fourth Prize! You got $50,000.");
		} else if(match == 2) {
			System.out.println("Congrats! Fifth Prize! You got $2,000.");
		} else if(match == 1) {
			System.out.println("Congrats! Sixth Prize! You got $500.");
		} else {
			System.out.println("Sorry! Welcome for next try!");
		}
		
	}
	
}

