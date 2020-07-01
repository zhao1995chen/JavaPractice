package model;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class SaveProduct {

	public static void main(String[] args) throws Exception {
		OutputStream os = new FileOutputStream("C:/Users/Zhao/Documents/JavaPractice/day38/JsonObject/output/pts.bin");
		List<Product> list = new ArrayList<>();
		list.add(new Product("Apple", 50, "usa"));
		list.add(new Product("Pineapple", 150, "korea"));
		list.add(new Product("Cake", 250, "canada"));
		
		ObjectOutputStream oos = new ObjectOutputStream(os);
		oos.writeObject(list);
		oos.close();
		os.close();
		System.out.println("Product list saved.");
	}

}
