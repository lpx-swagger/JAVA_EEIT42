package Generator;
public class Brad12 {
    public static void main(String[] args) {
        int a = 10, b = 3;
        
        // if ( a-- >= 10 || b++ <= 3) {       // || 前面成立了，就不會跑後面的運算
        //     System.out.printf("OK: a = %d; b = %d\n", a, b);
        // } else {
        //     System.out.printf("Not OK: a = %d; b = %d\n", a, b);
        // }


        // if ( --a >= 10 || ++b <= 3) {       // ++ 在前就要先做了
        //     System.out.printf("OK: a = %d; b = %d\n", a, b);
        // } else {
        //     System.out.printf("Not OK: a = %d; b = %d\n", a, b);
        // }


        // if (--a >= 10 && ++b <= 3) {        // --a 就已經錯了(前面已經決定就不會去後面)，就會直接跑到 else loop
        //     System.out.printf("OK: a = %d; b = %d\n", a, b);
        // } else {
        //     System.out.printf("Not OK: a = %d; b = %d\n", a, b);
        // }
        // result: a = 9; b = 3

        // if (--a >= 10 & ++b <= 3) {
        //     System.out.printf("OK: a = %d; b = %d\n", a, b);
        // } else {
        //     System.out.printf("Not OK: a = %d; b = %d\n", a, b);
        // }
        // result: a = 9; b = 4
        
        if ( --a >= 10 & ++b <= 3){
            System.out.printf("OK: a = %d; b = %d\n", a, b);
        }else{
            System.out.printf("XX: a = %d; b = %d\n", a, b);
        }

        System.out.println(3 ^ 2);
        System.out.println(1 | 2);

    }
}
