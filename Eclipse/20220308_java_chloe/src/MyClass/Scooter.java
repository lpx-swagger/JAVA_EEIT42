package MyClass;

public class Scooter extends Bike {  // 可否 tree dump 看結構一下？
	@Override   // annotation 
	public void upSpeed() {
		speed = speed < 1 ? 2 : speed * 1.7;
	}
}
