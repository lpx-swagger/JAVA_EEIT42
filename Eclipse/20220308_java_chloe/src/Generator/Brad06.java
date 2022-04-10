package Generator;
public class Brad06 {
    public static void main(String[] args) {
        double var1 = 10;
        float var2 = 10.003f;
        double var3 = 10.007;
        int var4 = 3;
        int var5 = 0;
        double var6 = 0;  // int
        
        System.out.println(var1);
        System.out.println(var2);
        System.out.println(var3);
        System.out.println(var5/var4);
        System.out.println(var6/var5);
        
        int a; // [ERROR] a 要給值，需先初始化
        // System.out.println(a); // a 尚未初始化，只要有初始化，這個變數就一定有值出現

    }
}
