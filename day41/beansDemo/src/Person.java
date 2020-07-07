public class Person {
	protected String name;
	protected String phone;
	
	public Person(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", phone=" + phone + "]";
	}
}
