package Generator;

//理牌
public class PokerRunTime {
 public static void main(String[] args) {
     long start = System.currentTimeMillis();
     int[] poker = new int[52];
     for (int i = 0; i < poker.length; i++) { // 列出所有poker cards 有幾張
         // poker[i] = (int)(Math.random()*52);  // 不一定要+1，因為poker card 不會用到
         int tmp = (int) (Math.random()*52);
         
         // 檢查機制
         boolean isRepeat = false;
         for (int j = 0; j < i; j++) {
             if(tmp == poker[j]) {
                 isRepeat = true;
                 break;
             }
         }

         // isRepeat => false/true
         if(!isRepeat) {
             poker[i] = tmp;
         } else {
             i--;
         }

         //poker[i] = tmp;
         //System.out.println(poker[i]); // 有機率讓 值 重複
     }

     System.out.println("ms: " + (System.currentTimeMillis() - start));
     // for-each test
     for(int v : poker) {
         System.out.println(v);
     }

 }
}

