package JAVAIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;

// 序列化 + 解序列化 => 物件序列化，祖宗代都要叫進來
public class chloe68 {
	public static void main(String[] args) {
		chloe683 obj1 = new chloe683();
		
		// serialize
		try {
			ObjectOutputStream oos = new ObjectOutputStream(
					new FileOutputStream("../../io/c683.chloe"));
			oos.writeObject(obj1);  // 序列化
			oos.flush();
			oos.close();
			System.out.println("OK");
			
		}catch (Exception e){
			System.out.println(e.toString());
		}
		
		System.out.println("*** de-serialize ***");
		
		// de-serialize
		try {
			ObjectInputStream ois = new ObjectInputStream(
					new FileInputStream("../../io/c683.chloe"));
			chloe683 obj2 = (chloe683)ois.readObject();  // 解序列化
			ois.close();
			System.out.println("OK1");
		}catch(Exception e) {
			System.out.println(e.toString());
		}	

	}

}



class chloe681 {
	chloe681() {
		System.out.println("chloe681()");
	}
}


class chloe682 extends chloe681 implements Serializable{  // 發現阿公沒有序列化，趕快自己做初始化，才會得到 obj2
	chloe682() {
		System.out.println("chloe682()");
	}
}


class chloe683 extends chloe682 {
	private chloe684 c684;  // chloe683的成員(chloe684) 也要宣告實作可序列化
	chloe683() {
		c684 = new chloe684(); // 初始化
		System.out.println("chloe683()");
		
	}
}


class chloe684 {
	
}
