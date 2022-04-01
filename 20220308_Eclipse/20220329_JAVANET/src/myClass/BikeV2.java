package myClass;

import java.io.Serializable;

//public class Bike {
public class BikeV2 implements Serializable{
	public double speed;
	//private double speed;
	//protected double speed;  // 保護級/限制級 電影
	public void upSpeed() {
		speed = speed < 1 ? 1 : speed*1.2;
	}
	
	public void downSpeed() {
		speed = speed < 1 ? 0 : speed*0.7;
	}
	
//	public void getSpeed() {      // why "double" instead of "void" here?
	public double getSpeed() {    // void 沒有 return 值
		return speed;
	}
	
	public String toString() {
		return "Speed = " + speed;
	}
	
}

//class downSpeed {  // 通常是由public class 來取這段資料？
//	double speed;
//	speed = speed < 1 ? 0: speed*0.7;
//}
