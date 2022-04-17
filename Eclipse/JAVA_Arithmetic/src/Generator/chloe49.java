package Generator;

public class chloe49 {
	public static void main(String[] args) {
		Rectangle r1 = new Rectangle(10, 4);
		Circle c1 = new Circle(3);
		test(r1);
		test(c1);
		
//		test1(r1);
//		test1(c1);
	}
	
	static void test(Shape s) {
		System.out.printf("%s => 邊長: %f; 面積: %f\n", s.toString(), s.length(), s.area());
	}
	
//	public static void test1(Shape shape) {
//		System.out.println("邊長:" + shape.length() + "; 面積:" + shape.area());
//	}
}

interface Shape {
	double length();
	double area();
}

class Rectangle implements Shape {
	private double s1, s2;
	public Rectangle(double s1, double s2) {
		this.s1 = s1; this.s2 = s2;
	}
	public double length() {return (s1 + s2)*2;}  // 一定要 public
	public double area() {return s1*s2;}
	@Override
	public String toString() {
		return "矩形";
	}
}

class Circle implements Shape {
	private double r;
	public Circle(double r) {this.r = r;}
	public double length() {return 2*Math.PI*r;}
	public double area() {return Math.PI*r*r;}
	@Override
	public String toString() {
		return "圓形";
	}
}
