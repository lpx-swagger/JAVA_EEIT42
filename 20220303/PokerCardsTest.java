// 理牌
public class PokerCardsTest {
    public static void main(String[] args) {
        int[] poker = new int[52];
        for (int i = 0; i < poker.length; i++) {
            // poker[i] = (int)(Math.random()*52);  // 不一定要+1，因為poker card 不會用到 1-4
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

        // for-each test
        for(int v : poker) {
            System.out.println(v);
        }

    }
}
