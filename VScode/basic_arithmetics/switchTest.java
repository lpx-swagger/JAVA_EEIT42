import java.util.Scanner;

public class switchTest {
    public static void main(String[] args) {

        int month = (int)(Math.random()*12 +1); // 程式是從 0 開始，若沒有+1, 就只有 1-11月，所以 +1 位移一個位置,就有12個月了
        int days = -1;        
    
        switch (month) {     // a 只能是：byte, short, char, int, String, enum
            case 1, 3, 5, 7, 8, 10, 12: // case 裡面只能是constant, 不可以是 variable
                days = 31;
                break;
            case 2:
                days = 28;
                break;
            default:
                days = 30;
                break;
       }
       System.out.printf("%d month has %d days!", month, days);
   } 
}
