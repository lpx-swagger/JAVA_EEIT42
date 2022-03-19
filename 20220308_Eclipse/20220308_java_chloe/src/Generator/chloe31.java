package Generator;

import MyClass.Bike;

public class chloe31 {
	public static void main(String[] args) {
		Bike myBike = new Bike();
		//Bike uBike = new Bike();

		do {
			myBike.upSpeed();
		} while (myBike.speed() > 10);

		System.out.println(myBike.getSpeed());
		//System.out.println(uBike.speed);
	}

}
