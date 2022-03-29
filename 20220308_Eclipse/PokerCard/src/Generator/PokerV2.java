package Generator;

// do-while 迴圈結構 理牌，4 players

public class PokerV2 {
 public static void main(String[] args) {
     long start = System.currentTimeMillis();
     int[] poker = new int[52]; 
     boolean isRepeat;
     int tmp;
     for (int i = 0; i < poker.length; i++) {
         do {
             tmp = (int)(Math.random()*52); 
         // } while (boolean) ;  // do-while 至少做一次 再做判斷；但是 for 一開始就先判斷了
             isRepeat = false;
             for(int j = 0; j < i; j++) {
                 if(tmp == poker[j]) {
                     isRepeat = true;
                     break;
                 }
             }
         } while(isRepeat);
         poker[i] = tmp;
     }

     System.out.println("ms : " + (System.currentTimeMillis() - start));
     
     // 檢查機制 for-each
     for(int v : poker){
         System.out.println(v);
     }

     System.out.println("------");
     
     int[][] players = new int[4][13];
     for (int i = 0; i < poker.length; i++){
         players[i%4][i/4] = poker[i];
     }

     String[] suits = {"黑桃","紅心","方塊","梅花"};
     String[] values = {"A ","2 ","3 ","4 ","5 ","6 ","7 "
     ,"8 ","9 ","10","J ","Q ","K "};

     for (int[] player : players){
         // => player 陣列 => 理牌
         java.util.Arrays.sort(player);
         for (int card : player){
             System.out.print(suits[card/13] + values[card%13] + "\t");
         }
         System.out.println();
     }

 }
}

