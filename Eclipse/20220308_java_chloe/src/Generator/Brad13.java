package Generator;

public class Brad13 {
    public static void main(String[] args) {
        int month = (int)(Math.random()*12+1); // 程式是從 0 開始，若沒有+1, 就只有 1-11月，所以 +1 位移一個位置,就有12個月了
        int days = -1;
        switch (month){  // a 只能是：byte, short, char, int, String, enum
            case 1: case 3: case 5: case 7:  // case 裡面只能是constant, 不可以是 variable
            case 8: case 10: case 12:
                days = 31;
                break;
            case 4: case 6: case 9: case 11:
                days = 30;
                break;
            case 2:
                days = 28;
                break;
        }
        System.out.printf("%d月有%d天", month, days);
    }
}
