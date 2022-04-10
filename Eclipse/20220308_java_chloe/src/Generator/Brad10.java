package Generator;
import java.util.Scanner;

public class Brad10 {
    public static void main(String[] args) {
        // Scanner scanner = new Scanner(System.in);
        // int score = scanner.nextInt();
        // scanner.close();

        double temp = Math.random();
        System.out.println(temp);

        double temp2 = temp * 101 + 0;  // 所有整數有 101 個
        // double temp3 = temp * 49 + 1;    // +1: 位移
        // double temp2 = 100 - temp * 100;
        int score = (int)temp2;
        System.out.println(score);

        // int mark = (int) temp; // 強制轉型
        // System.out.println(mark);
        
        if (score >= 90){
            System.out.println("A");
        }else if (score >= 80){   // ex. 防火牆 IP? 拒絕
            System.out.println("B");
        }else if (score >= 70){
            System.out.println("C");
        }else if (score >= 60){
            System.out.println("D");
        }else{
            System.out.println("E");
        }
        
        System.out.println("Game Over");
    }
}
