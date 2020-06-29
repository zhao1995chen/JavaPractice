package myprog;

public class MyCalculation {
	public static int range(int start, int end) {
		return start + (int)(Math.random()*(end - start + 1));
	}
}
