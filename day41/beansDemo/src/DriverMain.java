
public class DriverMain {

	public static void main(String[] args) {
		Person p = new Driver("Mary", "26464", "Truck");
		System.out.println(p);
		
//		connot convert sub class to parent class 
//		Driver d = (Person) p;
//		d.drive();
	}

}
