import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PointerDemo2 {

	public static void main(String[] args) {
		List<MyValue> mv = new ArrayList<>();

		mv.add(new MyValue(1, 3));
		mv.add(new MyValue(2, 2));
		mv.add(new MyValue(3, 1));

//		for(MyValue m: mv) {
//			System.out.println(m);
//		}
//
//		mv.remove(new MyValue(2, 2)); // remove one in each time
//		System.out.println("size: " + mv.size());

		// Comparator need to return integer.
		// If the datatype of value isn't integer, need to do transformation.
		// Or do the if-else or  to make the same output
		Comparator<MyValue> c1 = (p1, p2) -> (int)(p1.v1 - p2.v1);
		Collections.sort(mv, c1);
		for(MyValue m: mv) {
			System.out.println(m);
		}
	}
}

class MyValue {
	double v1, v2;

	public MyValue(double v1, double v2) {
		super();
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