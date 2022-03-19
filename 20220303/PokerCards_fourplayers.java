import java.util.Arrays;
//Day3-2, Day4-1
// 理牌
public class PokerCards_fourplayers {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[] poker = new int[52];
        for (int i = 0; i < poker.length; i++) { // 列出所有poker cards 有幾張
            // poker[i] = (int)(Math.random()*52);  // 不一定要+1，因為 poker card 不會用到取得的數字
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

        System.out.println("----");
        int[][] players = new int[4][13]; // 4玩家，每人13張牌
        for(int i = 0; i < poker.length; i++ ) {
            // players[第幾家][第幾張] = poker card 剛剛洗好的那張牌
            // i % 4 餘數
            // i / 4 => 7 / 4 => 1餘3 => 第3家第一張
            players[i%4][i/4] = poker[i];
        }

        // 檢查機制
        for(int[] player: players) {  // 4家攤牌
            for (int card: player) {
                System.out.print(card + "  ");
            }
            System.out.println();
        }
        
        // for (int card: players[0]) {
        //     System.out.print(card + "  ");
        // }
        // System.out.println();

        // for (int card: players[1]) {
        //     System.out.print(card + "  ");
        // }
        // System.out.println();

        // for (int card: players[2]) {
        //     System.out.print(card + "  ");
        // }
        // System.out.println();

        // for (int card: players[3]) {
        //     System.out.print(card + "  ");
        // }
        // System.out.println();

        

        // i/13 商決定花色， i%13 決定 value
        //String[] color = {"spade", "heart", "dimand", "club"};
        String[] color = {"桃", "心", "稜", "梅"};
        String[] values = {"A ", "2 ", "3 ", "4 ", "5 ", "6 ", "7 ", 
        "8 ", "9 ", "10 ", "J ", "Q ", "K "};

        for (int[] vvv : players) {
            // => player 1D array => 理牌，排序
            Arrays.sort(vvv);
            for (int card : vvv) {
                //System.out.print( card + "\t");
                System.out.printf(color[card/13] + values[card%13] + "\t");
                //System.out.printf(color[card/13] + values[card%13] + "(" + card + ")"); 
            }
            System.out.println();
        }
    }
}
