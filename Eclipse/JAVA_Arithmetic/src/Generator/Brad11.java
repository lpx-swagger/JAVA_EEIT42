package Generator;
import java.util.Scanner;

// leap year

public class Brad11 {
    public static void main(String[] argc) {
        Scanner scanner = new Scanner(System.in); // 1752 年 9 月 1 日 -> 9 月 2 日 -> 9 月 14 日
        int year = scanner.nextInt();
        boolean leap = true;

        if (year % 4 == 0){
            if (year % 100 == 0){
                if (year % 400 == 0){
                	System.out.println("Yes, it's leap year, Feb. has 29 days!");
                }else{
                	System.out.println("No, Feb. has 28 days.");
                }
            }else{
                // 29
            }
        }else{
            // 28
        }
    
  
        
    if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
        System.out.println("Yes, it's leap year, Feb. has 29 days!");
    } 
    else {
        System.out.println("it's not leap year.");
    }

    }
}


