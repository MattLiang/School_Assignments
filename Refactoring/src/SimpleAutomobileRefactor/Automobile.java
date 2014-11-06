package SimpleAutomobileRefactor;

public class Automobile extends CarRefactor.Vehicle {
	private String make;
	public String model;
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
}
