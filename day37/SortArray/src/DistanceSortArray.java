import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DistanceSortArray {

	public static void main(String[] args) {
		List<Pointer> pArray = new ArrayList<Pointer>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the amount of pointer.");
		int count = sc.nextInt();
		for(int i = 0; i < count; i ++) {
			System.out.println("Please enter x and y of pointer.");
			double x = sc.nextDouble();
			double y = sc.nextDouble();

			Pointer p = new Pointer(x, y);
			pArray.add(p);
		}

		sortPointer(pArray);

		for(Pointer element: pArray) {
			System.out.println("(" + element.getX() + ", " + element.getY() + ") -> Distance from (0, 0) " + element.getDistance());
		}

		sc.close();
	}

	public static void sortPointer(List<Pointer> pArray) {
		int toArray = pArray.size();

	    while(toArray > 1) {
	    	toArray--;
			for(int i = 0; i < toArray; i++) {
				if(pArray.get(i).getDistance() > pArray.get(i+1).getDistance()) {
					Pointer temp = pArray.get(i);
					pArray.set(i, pArray.get(i + 1));
					pArray.set(i+1, temp);
				}
			}
	    }
	}
}