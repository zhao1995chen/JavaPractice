import java.util.ArrayList;
import java.util.List;

public class DistanceSortArray2 {

	public static void main(String[] args) {
    List<Pointer> pArray = new ArrayList<Pointer>();

    pArray.add(new Pointer(3, 10));
    pArray.add(new Pointer(2, 8));
    pArray.add(new Pointer(1, 7));
    pArray.add(new Pointer(3, 4));
    pArray.add(new Pointer(5, 2));

		sortPointer(pArray);

		for(Pointer element: pArray) {
			System.out.println("(" + element.getX() + ", " + element.getY() + ") -> Distance from (0, 0) " + element.getDistance());
		}
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