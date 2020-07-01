public class Pointer {
	private double x;
	private double y;
	private double distance;

	Pointer(double x, double y) {
		this.x = x;
		this.y = y;
		this.calculateDistance();
	}

	void calculateDistance() {
		this.distance = Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
	}

	double getX() {
		return this.x;
	}

	double getY() {
		return this.y;
	}

	double getDistance() {
		return this.distance;
	}
}