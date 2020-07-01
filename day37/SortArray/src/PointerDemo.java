import java.util.Arrays;

public class PointerDemo {

	public static void main(String[ ]  args) {
    	Point[ ]  pt= {new Point(1,6),new Point(3,5),new Point(4,3),new Point(1,5),new Point(2,8)};
    	Arrays.sort(pt);
    	for(Point p : pt)
    		System.out.println(p);
    }

}

class Point implements Comparable<Point>{
    int x,y;
    public Point(int x,int y) {
    	this.x=x;
    	this.y=y;
    }
    public String toString() {
    	return "x:"+x+" y:"+y;
    }
    @Override
	public int compareTo(Point p) {
		// TODO Auto-generated method stub
		int v1=x*x+y*y;
		int v2=p.x*p.x+p.y*p.y;
		if(v1>v2)
			return 1;
		else if(v1<v2)
			return -1;
		else
			return 0;
	}
}