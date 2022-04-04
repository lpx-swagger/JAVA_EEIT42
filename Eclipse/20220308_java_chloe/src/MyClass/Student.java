package MyClass;


public class Student {
	private String name;
	private int ch, eng, math;
	
	public Student(String name, int ch, int eng, int math) {
		this.name = name;	
		this.ch = ch;
		this.eng = eng;
		this.math = math;
	}
	public int Score() {
		return ch + eng + math;
	}


	public double Avg() {
		return Score() / 3.0;
	}

	@Override
	public String toString() {
		return name;
	}
}

