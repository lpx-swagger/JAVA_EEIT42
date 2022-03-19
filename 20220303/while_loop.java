public class while_loop {
    //進入先判斷 再做 { } 內資料
    public static void main(String[] args) {
        int N = 100;
        int START = 1, SUM = 0;
        while (START <= N) { 
            SUM = SUM + START++;
            //SUM += START++;
        }
        System.out.println(SUM);
    }
}
