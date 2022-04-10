package Generator;
public class Brad02 {
    public static void main(String[] args) {  // 為何老師 args 這邊可以改成 brad ?
        // 強型別 => 宣告先
        // 整數 byte(2^8: -128 ~ 127),
    	// 42億多，是幾位數？ 10位數 => int(2^32) 4G 多，隨身碟最多64G
        // short(2^16), int(2^32), long(2^64)
        byte var1;
        var1 = 100;
        System.out.println(var1);

        byte var2;  // [a-zA-Z$_][a-zA-Z0-9$_]* and 不可以是關鍵字
        var2 = -128;
        System.out.println(var2);
        
        byte var3 = -127;

        System.out.println(var3);
        byte $$$$; // [a-zA-Z$_][a-zA-Z0-9$_]* and 不可以是關鍵字
        $$$$ = 123; // 第一個字母盡量不要使用 $ or _
        System.out.println(($$$$));
    }
    
    public static void main1(String[] chloe) { // 如何把兩個 class 放在同一個檔案裡面執行？ => 要去修改 main => main1
        byte var1 = 10;
        byte var2 = 2;
        byte var3 = 10, var4, var5 = 3;

        // byte var4 = var1 + var2 ； 兩個 byte 相加，會變成一個 int
        int var6 = var1 / var2; // byte, short, int => int
        System.out.println(var6);
    }
}
