package model;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ReadProduct {

	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("C:/Users/Zhao/Documents/JavaPractice/day38/JsonObject/output/pts.bin");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Product[] pts = (Product[]) ois.readObject();
		for(Product p: pts) {
			System.out.println(p);
		}
		ois.close();
		fis.close();
	}
}
