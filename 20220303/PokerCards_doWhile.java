public class PokerCards_doWhile {
    public static void main(String[] args) {
        // 迴圈結構
        //int a = 1;
        int[] poker = new int[10]; 
        boolean isRepeat;
        int tmp;
        for (int i = 0; ;) {
            do {
                tmp = (int) (Math.random()*10); 
            // } while (boolean) ;  // do-while 至少做一次 再做判斷；但是 for 一開始就先判斷了
                isRepeat = false;
                for(int j =0; j<i; j++) {
                    if(tmp == poker[j]) {
                        isRepeat = true;
                        break;
                    }
                }
            } while(isRepeat);
            poker[i] = tmp;
        }
    }
}
