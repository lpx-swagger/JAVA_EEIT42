package Generator;
public class Brad03 {
    public static void main(String[] brad) {  // 如何把兩個 class 放在同一個檔案裡面執行？ package? 是屬於 api 的那一塊？
        byte var1 = 10;
        byte var2 = 3;
        byte var3 = 10, var4, var5 = 3;

     // byte var4 = var1 + var2 ； 兩個 byte 相加，會變成一個 int
        int var6 = var1 % var2; // byte, short, int => int
        System.out.println(var6);
    }
}
