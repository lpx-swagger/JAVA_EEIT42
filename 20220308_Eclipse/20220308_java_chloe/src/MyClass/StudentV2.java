package MyClass;

import java.io.Serializable;

public class StudentV2 implements Serializable {
	private String name;
	private int ch, math;
	private transient int eng;
	
	public StudentV2(String name, int ch, int eng, int math) {
		this.name = name;	
		this.ch = ch;
		this.eng = eng;
		this.math = math;
	}
	public int Score() {
		return ch + eng + math;
	}


	public double Agv() {
		return Score() / 3.0;
	}

	@Override
	public String toString() {
		return name;
	}
}

