package Generator;

// 正常玩，無灌鉛 Array[] Calculate DiceTimes

public class chloe17_2 {
	public static void main(String[] args) {
		int[] p = new int[7];
		for (int i = 0; i < 100000 ; i++) {
			int point = (int)(java.lang.Math.random()*6+1);  // 1~6 點 random() 數值是 0~1, 所以印出來的值是小數點
            if(point >= 1 && point <= 6 ) {  
                p[point]++;
            } else {
                p[0]++;
            }
		}

        for (int i = 0; i < p.length; i++) 
            System.out.printf("%d出現%d次\n", i, p[i]);
        
        if (p[0] > 0)
            System.out.printf("問題點出現%d次\n", p[0]);
        
        System.out.println("----");

        // for-each 你只在意元素值，不在意 index，方便巡防每個值
        for(int v : p) {
            System.out.println(v);
        } // 每一圈都在玩一個值
        
	}
}
