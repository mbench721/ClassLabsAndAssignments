package CarStuff;
import intersections.Intersection;

public class CarsLeave extends Car {
	
	public CarsLeave() {
		super();
			
	}
	@Override
	public void reset(Intersection i){

		if( isAtEdge() )
			getWorld().removeObject(this);

	}
}
