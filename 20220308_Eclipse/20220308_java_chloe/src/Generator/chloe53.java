package Generator;

public class chloe53 {
	public static void main(String[] args) {
		

	}

}

class Bird {
	private int leg;
	void setLegV1(int leg) {
		if (leg > 0 && leg <= 2) {
			this.leg = leg;
		}
	}
	
	void setLegV2(int leg) throws Exception{
		if(leg > 0 && leg <= 2) {
			this.leg = leg;
		} else {
			throw new Exception();
		}
	}
}
