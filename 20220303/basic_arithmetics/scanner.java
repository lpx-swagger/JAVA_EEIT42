import java.util.Scanner;

public class scanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Resource leak 資源耗盡，記憶體
        int var1 = scanner.nextInt();
        int var2 = scanner.nextInt();
        int result = var1 + var2;
        int result_min = var1 - var2;
        int result_mul = var1 * var2;
        int result_div = var1 / var2;
        int r4 = var1 % var2;
        
        System.out.println("-> " + result); // 核心程式
        System.out.println("-> " + result_div);
        System.out.println("-> " + result_mul);
        System.out.printf("Hello%s!\n", " World");
        System.out.printf("%d / %d = %d ... %d\n", var1, var2, r4, result_div);
        System.out.printf("%d %s %d = %d ... %d\n", var1, "%%", var2, r4, result_div);
        scanner.close(); // 之後會學 try
    }
    
}

class scanner_01 { // 上層：class 
    // 中層：class attributtion
    // 底層：class method / operations
}


