public class diceTimesArray {
	public static void main(String[] args) {
		int[] p = new int[7];
		for (int i = 0; i < 100000 ; i++) {
			int point = (int)(java.lang.Math.random()*6+1);  // 1~6 點
            if(point >= 1 && point <=6) {
                p[point]++;
            } else {
                p[0]++;
            }
		}

        for (int i = 0; i < p.length; i++) {
            System.out.printf("%d出現%d次\n", i, p[i]);
        }
        if (p[0] > 0)
            System.out.printf("Error %d times\n", p[0]);
	}
}