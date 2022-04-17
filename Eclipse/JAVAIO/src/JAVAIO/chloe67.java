package JAVAIO;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import Class.StudentV2;

// 解序列化 de-Serializable
// 請問此類別有沒有 實作可序列化？=> 表示這個類別有沒有跟Student一樣

public class chloe67 {
	public static void main(String[] args) {
		try {
			ObjectInputStream oin = 
					new ObjectInputStream(
							new FileInputStream("./io/student.chloe"));
			
			Object obj1 = oin.readObject();
			oin.close();  // 關閉串流 Stream
			
//			if(obj1 instanceof Student) {
//				System.out.println("OK");
//			} else {
//				System.out.println("XX");
//			}
			
			StudentV2 s1 = (StudentV2)obj1; // 解序列化
			System.out.println(s1.Score());
			System.out.println(s1.toString());
			System.out.println(s1.Avg());
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}

