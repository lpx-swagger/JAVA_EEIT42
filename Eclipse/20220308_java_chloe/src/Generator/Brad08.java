package Generator;

public class Brad08 {
    public static void main(String[] args) {
        boolean var1 = true; // 在 JAVA Boolean 無法做數學運算，
        System.out.println(var1);
        char var2 = 'a'; // ASCII code  2^64
        System.out.println(var2);
        char var3 = 97; // ASCII code 
        System.out.println(var3); // JVM 在內部轉成 16 進位
        char var4 = '淼';
        System.out.println(var4 + 10);  // 此為arithmetic，所以這裡是 char + char = int
        /* 
         * 整數 => 正數
         * 在JAVA中處理整數的型態有：byte, short, int, long
           	 byte => 2^8 bits => Total: #256 bits => Value: -127~128
             short => 2^16 bits => Total: #65,532 bits => Value: -32,768~32,767
             int => 2^32 bits => Total: 約42億多 bits => Value: 正負20+億 => 十位數 => 電腦單位 4GB(早期直接用FAT格式化的隨身碟最多就是4G)
             long => 2^64 bits
             常用等級：int => byte(做硬體設備的交換) => short ====> long
            
         * char => 2^16 bits(和short相同) => 口徑比byte大 管線較byte粗 
           byte => 2^8 bits
        */


        // 溢位
        byte var5 = 126; // 如何不溢位？ 做 convert，使用 ++ 做 shift 的動作
        var5++; // 強型別語言
        var5++;
        System.out.println(var5); // 字元 > 128 ，所以跳到 negative
        byte var6 = 125;
        var6 += 3;
        // System.out.println(var6);
        int var7 = var6 + 3;
        System.out.println(var7);
        var7 = var7 + 1;
        System.out.printf("result: %d", var6);
    }
}

