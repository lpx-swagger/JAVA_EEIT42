package Generator;

public class chloeMulti99 {
    public static void main(String[] args) {
        final int ROWS = 3;
        final int COLS = 5;
        final int START = 2;
        for(int k = 0; k < ROWS; k++) {
            for (int j = 1; j < 10; j++) {  
                for (int i = START; i <= (START + COLS -1); i++) {
//                for (int i = START; i < (START + COLS); i++) {
                    int newi = i + k * COLS;   // 5 columes, 依序是：2+5, 3+5, 4+5, 5+5, 6+5
                    int result = newi * j;
                    System.out.printf("%d x %d = %d\t", newi, j, result);
                }
                System.out.println();
            }
            System.out.println("------------");
        }
    }
}

