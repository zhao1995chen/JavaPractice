import java.util.Arrays;
import java.util.Comparator;

public class ArrayDemo {

	public static void main(String[] args) {
//		Comparator<Integer> cmp = (x, y) -> x - y; // increment
		Comparator<Integer> cmp = (x, y) -> y - x; // decrement
		Integer[] a = new Integer[10];
		for(int i = 0; i < a.length; i++) {
			a[i] = (int)(Math.random() * 100 + 1);
		}
		Arrays.sort(a, cmp);
		for(int value: a) {
			System.out.println(value + " ");
		}
		System.out.println();
	}

}
