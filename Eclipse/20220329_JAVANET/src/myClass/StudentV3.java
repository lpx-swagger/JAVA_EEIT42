package myClass;

// 只要你是學生就配一台腳踏車，不用 new

import java.io.Serializable;

public class StudentV3 implements Serializable{
	private int ch, math;
	//private transient int eng;
	private int eng;
	private String name;
	private BikeV2 bike;
	
	public StudentV3(String name, int ch, int eng, int math) {
		this.name = name;
		this.ch = ch;
		this.eng = eng;
		this.math = math;
		bike = new BikeV2();
	}
	
	public BikeV2 getBike() {
		return bike;
	}
	
	public int score() {
		return ch + eng + math;
	}
	
	public double avg() {
		return score() / 3.0;
	}
	
	@Override
	public String toString() {
		return name;
	}
}