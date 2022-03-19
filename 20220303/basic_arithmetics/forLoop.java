public class forLoop {
    public static void main(java.lang.String[] args) {
        int a = 9;
        for( init(); a <= 10; drawLine()) {
            System.out.println(a++);
        }

        System.out.println("-> " + a);
    }

    public static void init() {
        System.out.println("Chloe");
    }

    public static void drawLine() {
        System.out.println("---------");
    }
}
