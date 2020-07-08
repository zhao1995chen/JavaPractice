public class Driver extends Person {
	private String type;

	public Driver(String name, String phone, String type) {
		super(name, phone);
		this.type = type;
	}
	
	public void drive() {
		System.out.println(name + "drive" + type);
	}
}
