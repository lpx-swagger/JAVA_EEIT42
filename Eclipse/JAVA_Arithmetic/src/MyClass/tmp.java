package MyClass;

import java.util.Scanner;


//public class tmp {
//	private int a, b;
//	public tmp() {
//		a = b = 0;
//	}
//	
//	public tmp(int a, int b) {
//		this.a = a; // "super" above "this"，等號後面的那個值會找最接近的
//
////	public tmp(int aa, int bb) {
////		aa = a;
//		
//	}
//	
//	
//}

class runnable implements Runnable {
    private Object obj;
    public runnable(Object obj)
    {
        this.obj = obj;
    }
    public void run() {
        try {
            Thread.sleep(3000);
           // this.obj.setText("");//right here just execute your method
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hello from a thread!"); //your code here
    }

}

public class tmp {
    public static void main(String[] args){
        Object myObject = null;
        (new Thread(new runnable(myObject))).start();
    }
}