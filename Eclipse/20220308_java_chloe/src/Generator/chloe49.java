package Generator;

public class chloe49 {

	public static void main(String[] args) {
		Rectangle r1 = new Rectangle(10, 4);
		

	}

}

interface Shape {   // 沒有物件 => static 的關係？？？
	double length();
	double area();
}

class Rectangle implements Shape {
	private double s1, s2;
	public Rectangle(int s1, int s2) {
	}
	public double length() {return 1;}
	public double area() {return 2;}
	
}

class Circle implements Shape {
	private double r;
	public Circle {
		this.r = r;
	}
	public double length() {return 2*Math.PI*r;}
	public double area() {return Math.PI*r*r;}
 }
