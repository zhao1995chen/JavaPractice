package Model;

public class Product {
	private String name;
	private int price;
	private String place;
	
	public Product(String name, int price, String place) {
		super();
		this.name = name;
		this.price = price;
		this.place = place;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}
}