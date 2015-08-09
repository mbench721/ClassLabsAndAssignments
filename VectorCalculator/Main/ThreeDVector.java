
public class ThreeDVector {
	private final double x;


	private final double y;
	private final double z;

	public ThreeDVector(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public double getZ() {
		return z;
	}

	public ThreeDVector add(ThreeDVector addend) {
		
		return new ThreeDVector(x + addend.x, y + addend.y, z + addend.z);
	}

	// Other operations

}
