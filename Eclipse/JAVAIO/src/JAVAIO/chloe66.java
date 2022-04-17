package JAVAIO;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import Class.StudentV2;

// 序列化 Serializable

/* Class DataOutputStream => Constructor 有 DataOutputStream(OutputStream out)的OutputStream 
	=> 不是第一根串流，跟別人連接的 */
public class chloe66 {
	public static void main(String[] args) {
		StudentV2 s1 = new StudentV2( "Chloe", 90, 40, 50);
		System.out.println(s1.toString() + ":" + s1.Avg());
		
		try {
			// 沒有輸出怎麼會有輸入？所以要先做輸出
			FileOutputStream fout = new FileOutputStream("./io/student.chloe");
			ObjectOutputStream oout = new ObjectOutputStream(fout);  /* "Object"OutputStream => 看到Object就要想到 
				=> 可以被輸出 => 腳踏車可以被串流輸出去 => Serializable : 物件記憶體的資料一個一個的轉到你要的目的地 存放在那裡，
					當需要的時候，還可以把物件還原回來，不用重新 new => ex. 遊戲 => 兩個都是主角(2個物件)，要如何知道對方的狀態？
			 			=> 交換序列化物件 */
			
			oout.writeObject(s1);  // 物件序列化 => 可以把物件寫出去，在JAVA的所以物件都是 is-a
			oout.flush();
			oout.close();  // => 因為你沒有做自動關閉，所以要close()
			System.out.println("OK");
		} catch(Exception e) {
			System.out.println(e.toString());
		}

	}

}
