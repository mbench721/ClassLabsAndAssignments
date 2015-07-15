package CarStuff;

import java.util.ArrayList;
import java.util.List;
import greenfoot.Greenfoot;
import intersections.Intersection;

public class BlueStyle extends CarsLeave {


	public BlueStyle() {
		super();
		setImage(blue);
	}
	public void act(){


		move();
		super.checkCollision();
	}

	public void setStart(Intersection[] i){
		int randInter = Greenfoot.getRandomNumber(34) + 1;
		if(i[randInter].getX() > 25 || i[randInter].getX() < 975 ){
			 randInter = Greenfoot.getRandomNumber(34) + 1;
		}
		if(i[randInter].getY() > 25 || i[randInter].getX() < 725 ){
			 randInter = Greenfoot.getRandomNumber(34) + 1;
		}
		
		if(getRotation() == UP){
			end = i[randInter];
		}
		if(getRotation() == DOWN){
			end = i[randInter];
		}
		if(getRotation() == LEFT){
			end = i[randInter];
		}
		if(getRotation() == RIGHT){
			end = i[randInter];
		}
		
	}

	public void checkPath(Intersection c, Intersection e) {
		if(getRotation() == LEFT){

			if(e.getY() > c.getY()  && getX() == c.getX() - 13 ){
				this.setRotation(DOWN);
			}
			if(e.getY() < c.getY()   && getX() == c.getX() + 13 ){
				this.setRotation(UP);
			}
		}
		if(getRotation() == RIGHT){

			if(e.getY() < e.getY()  && getX() == c.getX() - 13 ){
				this.setRotation(UP);
			}
			if(e.getY() > c.getY() && getX() == c.getX()  + 13 ){
				this.setRotation(DOWN);
			}

		}
		if(getRotation() == DOWN){

			if(e.getX() < c.getX()  && getY() == c.getY() - 13){
				this.setRotation(LEFT);
			}
			if(e.getX() > c.getX()  && getY() == c.getY() + 13){
				this.setRotation(RIGHT);
			}
		}
		if(getRotation() == UP){
			if(e.getX() < c.getX()  && getY() == c.getY() - 13  ){
				this.setRotation(LEFT);
			}
			if(e.getX() > c.getX()  && getY() == c.getY() + 13){
				this.setRotation(RIGHT);
			}
		}
		
		

		}
		@Override
		@SuppressWarnings("unchecked")
		public List<Intersection> findPath(Intersection c, Intersection f) {
			int dist = 0;
			int currentDist = 0;
			List<Intersection> path = new ArrayList<Intersection>();
			List<Intersection> xpath = new ArrayList<Intersection>();
			if(c != f){
				
				List<Intersection> closeIntersects = (ArrayList<Intersection>)this.getObjectsInRange(c.width * 2,Intersection.class);
				int best = Integer.MAX_VALUE;
				for(Intersection i : closeIntersects){
					dist = (i.getX() + i.getY()) - (f.getX() + f.getY());
					currentDist = (c.getX() + c.getY()) - (f.getX() + f.getY());
					if(dist < currentDist){
						xpath = findPath(i,f);
					} 
					if(path.size() < best){
						path = xpath;
						best = path.size();
					}
				}
			}
			
			path.add(c);
			checkPath(c,f);
			return path;
			
			
		}



	@Override
	public void move() {
		switch(carSpeed){

		case REGULAR:
			speed = REGULAR;
			move(speed);

			break;
		case SLOW:
			speed = SLOW;
			move(speed);
			break;
		case STOP:
			speed = STOP;
			move(speed);
			break;
		case TOUCHED:

			carSpeed = SPEED.REGULAR;
		default:

			break;
		}

	}
	@Override
	public void touched(Intersection i) {
		if(getRotation() == LEFT && getX() == i.getX() + 20){
			i.stats.blueCar++;
			i.stats.totalCars++;
		}
		else if(getRotation() == RIGHT && getX() == i.getX() - 20){
			i.stats.blueCar++;
			i.stats.totalCars++;
		}
		else if(getRotation() == UP && getY() == i.getY() + 20){
			i.stats.blueCar++;
			i.stats.totalCars++;
		}
		else if(getRotation() == DOWN && getY() == i.getY() - 20){
			i.stats.blueCar++;
			i.stats.totalCars++;
		}

	}


}


