import java.util.Scanner;

public class randomMathTest {
    public static void main(String[] args) {
        
        // 輸入 data
        // Scanner scanner = new Scanner(System.in);
        // int score = scanner.nextInt();

        double temp = java.lang.Math.random();
        System.out.println(temp);
        double temp2 = temp * 101 + 0;     // 所有整數有 101 個     
        // double temp3 = temp * 49 + 1;    // +1: 位移
        // double temp2 = 100 - temp * 100; 
        int mark = (int) temp2;
        System.out.println(mark);

        // int mark = (int) temp; // 強制轉型
        // System.out.println(mark);

        // 判斷
        if (mark >= 90) { 
            System.out.println("A");
        }
            else if (mark >= 80) {  // ex. 防火牆 IP? 拒絕
                System.out.println("B");
            }
            else if (mark >= 70) {
                System.out.println("C");
            }
            else if (mark >= 60) {
                System.out.println("D");
            }
            else 
                System.out.println("E");
        
        //System.out.println("Game over");

    }
}
