
public class TwoDvector {
	private final double x;


	private final double y;
	

	public TwoDvector(double x, double y) {
		this.x = x;
		this.y = y;
		
	}

	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	

	public TwoDvector add(TwoDvector addend) {
		
		return new TwoDvector(x + addend.x, y + addend.y);
	}
	
	public double magnitude(){
		return Math.sqrt((x * x) + (y * y));
	}

	// Other operations

}
