package Class;

import java.io.Serializable;

public class StudentV2 implements Serializable {
	private int ch, math;
	private transient int eng;
	private String name;
	
	public StudentV2(String name, int ch, int eng, int math) {
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

