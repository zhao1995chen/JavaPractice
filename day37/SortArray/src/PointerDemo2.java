import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PointerDemo2 {

	public static void main(String[] args) {
		List<MyValue> mv = new ArrayList<>();

		mv.add(new MyValue(5, 1));
		mv.add(new MyValue(2, 2));
		mv.add(new MyValue(3, 4));

//		for(MyValue m: mv) {
//			System.out.println(m);
//		}
//
//		mv.remove(new MyValue(2, 2)); // remove one in each time
//		System.out.println("size: " + mv.size());

		// Comparator need to return integer.
		// If the datatype of value isn't integer, need to do transformation.
		// Or do the if-else or  to make the same output
		
		// Method 1
//		Comparator<MyValue> c1 = (p1, p2) -> (int)(p1.v1 - p2.v1);
//		Collections.sort(mv, c1);
		
		// Method 2
		Collections.sort(mv, new Comparator<MyValue>() {
			public int compare(MyValue p1, MyValue p2) {
				return Math.sqrt(Math.pow(p1.v1, 2) + Math.pow(p1.v2, 2)) > Math.sqrt(Math.pow(p2.v1, 2) + Math.pow(p2.v2, 2)) ? 
						1 : Math.sqrt(Math.pow(p1.v1, 2) + Math.pow(p1.v2, 2)) < Math.sqrt(Math.pow(p2.v1, 2) + Math.pow(p2.v2, 2)) ? -1 : 0;
			}
		});
		
		for(MyValue m: mv) {
			System.out.println(m);
		}
	}
}

class MyValue {
	double v1, v2;

	public MyValue(double v1, double v2) {
		this.v1 = v1;
		this.v2 = v2;
	}

	public String toString() {
		return "v1 = " + v1 + " v2 = " + v2;
	}

	public boolean equals(Object o) { // need to override to remove the object has same x and y
		MyValue x = (MyValue) o;
		return this.v1 == x.v1 && this.v2 == x.v2;
	}
}