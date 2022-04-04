package Generator;

import java.util.LinkedList;

// shuffle card 洗牌

public class PokerV3 {
 public static void main(String[] args) {
     final int ACCOUNT = 52;
     LinkedList<Integer> list = new LinkedList<>();        // 泛型<>
     for (int i = 0 ; i < ACCOUNT; i++) list.add(i);       // 52 張牌 排列順序整齊的card，就像文具店裡買回來的那種
     java.util.Collections.shuffle(list);                  // 各大語言都有這 method，list 可以跟 array 互換

     // for-each
     for(Integer v: list) {
         System.out.println(v);
     }
 }
}