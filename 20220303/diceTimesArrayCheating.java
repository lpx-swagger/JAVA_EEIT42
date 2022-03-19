
// 灌鉛 dice
public class diceTimesArrayCheating {
	public static void main(String[] args) {
		int[] p = new int[7];
		for (int i = 0; i < 100000 ; i++) {
			int point = (int)(java.lang.Math.random()*9+1);  // 1~6 點 random() 數值是 0~1, 所以印出來的值是小數點
            if(point >=1 && point <= 9) {  // (boolean)?value1:value2
                p[point > 6?point-3:point]++;
            } else {
                p[0]++;
            }
		}
        //chloe switch(point) {
        //     case 7: p[3]++;
        //     case 8: p[4]++;
        //     case 9: p[5]++;
        // }

        for (int i = 1; i < p.length; i++) {
            System.out.printf("%d appear %d times\n", i, p[i]);
        }
        if (p[0] > 0)
            System.out.printf("Error %d times\n", p[0]);

        System.out.println("--------");


        // for-each 你只在意元素值，不在意 index，方便巡防每個值
        for(int v : p) {
            System.out.println(v);
        } // 每一圈都在玩一個值
	}
}