package Generator;

//TODO HW: 發給每個人牌，只會發#51次，要如何不重覆？最後兩個先交換
public class PokerSwapSort {
 public static void main(String[] args) {
     /* why 最後兩個先交換(由右至左)？easy to get the random number
      int a = 10, b = 3;
      int tmp = a;
      a = b;
      b = tmp;
      System.out.printf("a = %d ; b = %d", a, b);
      a = a+b;
      b = a-b;
      a = a-b;
      System.out.printf("a = %d , b = %d ", a, b); 
     */

     final int START = 1;
     final int NUM = 52;
     int[] poker = new int[NUM];    							// give space for #52 cards, not all same color in array

     for (int i = 1; i < NUM; i++) {
         poker[i] = i;              							// poker[0] = 0, poker[1] = 1, ... poker[51] = 51
     }

     // wash
     for (int i = (NUM - 1); i >= START; i--) {    			// 排列整齊之後，最後(右)2個先交換
         int rand = (int)(java.lang.Math.random()*(i+1));    // beginning from zero
         int tmp = poker[rand];  							// integer = integer
         poker[rand] = poker[i];
         poker[i] = tmp;
     }

     // for-each
     for(int v: poker) {
         System.out.println(v);
     }
     
     System.out.printf("total card: " + poker.length);
 }
 
}

