package CarStuff;

import intersections.Intersection;

public class CarsWrap extends Car {


	public CarsWrap() {
		super();

	}
	@Override
	public void reset(Intersection i){

		if ( isAtEdge() && getRotation() == LEFT){
			

			this.setLocation(getWorld().getWidth(), getY());
		}
		else if ( isAtEdge() && getRotation() == RIGHT){
			
			this.setLocation(0, getY());
		}
		else if (isAtEdge() && getRotation() == UP){
			
			this.setLocation(getX(), getWorld().getHeight());
		}
		else if ( isAtEdge() && getRotation() == DOWN){
			
			this.setLocation(getX(), 0);
		}
	}


}
