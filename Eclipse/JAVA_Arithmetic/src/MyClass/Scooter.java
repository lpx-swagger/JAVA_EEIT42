package MyClass;

public class Scooter extends Bike {  
	@Override   // annotation 
	public void upSpeed() {
		speed = speed < 1 ? 2 : speed * 1.7;
	}
}
