public class Array2Dimention {
    public static void main(String[] args) {
        int[][] a = new int[3][4];       // 不管是幾維陣列，都看成 1 D
        int[][] b = new int[3][];
        System.out.println(a[0][0]);
        System.out.println(a.length);
        System.out.println(a[0].length); // a[0]有幾個元素
        b[0] = new int[4];
        b[1] = new int[2];
        b[2] = new int[5];
        b[0][2] = 111; b[1][1] = 345; b[2][3] = 789; // 其餘沒有設定的都是 0


        // for(int[] vv : b) {
        //     // for-each
        //     for(int v : b[0]) {
        //         System.out.print(v + "\t");
        //     }
        //     System.out.println();
        // }
        for(int[] vv : b) {
            // for-each
            for(int v : vv) {
                System.out.print(v + "\t");
            }
            System.out.println();
        }
    }
}
