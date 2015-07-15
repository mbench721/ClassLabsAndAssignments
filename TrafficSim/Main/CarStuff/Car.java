package CarStuff;

import java.util.ArrayList;
import java.util.List;
import intersections.Intersection;
import intersections.TrafficLight;
import greenfoot.Actor;



public class Car extends Actor implements IntersectionListener {

	public final int REGULAR = 2,SLOW = 1, STOP = 0,SPEEDY = 3;
	public final int UP = 270, DOWN = 90, LEFT = 180, RIGHT = 0;
	public int speed;
	
	public Intersection start;
	public Intersection end;
@Override
	public Intersection getEnd() {
		return end;
	}


	public enum SPEED{

		REGULAR, SLOW, STOP, TOUCHED;
	}
	public SPEED carSpeed;

	public Car(){
		

	}
	public void checkPath(Intersection i,int c,int f) {
	if(getRotation() == LEFT){

		if(f > c  && getX() == i.getX() - 13 ){
			this.setRotation(DOWN);
		}
		if(f < c   && getX() == i.getX() + 13 ){
			this.setRotation(UP);
		}
	}
	if(getRotation() == RIGHT){

		if(f < c  && getX() == i.getX() - 13 ){
			this.setRotation(UP);
		}
		if(f > c && getX() == i.getX()  + 13 ){
			this.setRotation(DOWN);
		}

	}
	if(getRotation() == DOWN){

		if(f < c  && getY() == i.getY() - 13){
			this.setRotation(LEFT);
		}
		if(f > c  && getY() == i.getY() + 13){
			this.setRotation(RIGHT);
		}
	}
	if(getRotation() == UP){
		if(f < c  && getY() == i.getY() - 13  ){
			this.setRotation(LEFT);
		}
		if(f > c  && getY() == i.getY() + 13){
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
			List<Intersection> closeIntersects = (ArrayList<Intersection>)this.getObjectsInRange(100,Intersection.class);
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
		checkPath(c,currentDist,dist);
		return path;
		
		
	}
	
	
	public void checkCollision(){

		Actor splode = getOneIntersectingObject(Car.class);

		Explosion explode = new Explosion();
		try{

			if(splode != null){
				throw new Error("Car collision crash!");

			}
		}
		catch (Error e){
			System.err.println(e);
			getWorld().addObject(explode, getX(), getY());
			getWorld().removeObject(splode);
			getWorld().removeObject(this);
		}
	}

	@Override
	public void approachingIntersection(Intersection i) {
		if(getRotation() == LEFT && i.lights.get(RIGHT_LIGHT).getPhase() == TrafficLight.STATE.YELLOW){

			this.carSpeed = SPEED.SLOW;
		}
		else if(getRotation() == RIGHT && i.lights.get(LEFT_LIGHT).getPhase() == TrafficLight.STATE.YELLOW){
			this.carSpeed = SPEED.SLOW;
		}
		else if(getRotation() == DOWN && i.lights.get(DOWN_LIGHT).getPhase() == TrafficLight.STATE.YELLOW){
			this.carSpeed = SPEED.SLOW;
		}
		else if(getRotation() == UP &&i.lights.get(UP_LIGHT).getPhase() == TrafficLight.STATE.YELLOW){
			this.carSpeed = SPEED.SLOW;
		}
		else 
			this.carSpeed = SPEED.REGULAR;

	}
	@Override
	public void inIntersection(Intersection i) {


		if(getRotation() == LEFT && i.lights.get(RIGHT_LIGHT).getPhase() == TrafficLight.STATE.RED){


			this.carSpeed = SPEED.STOP;

		}
		else if(getRotation() == RIGHT && i.lights.get(LEFT_LIGHT).getPhase() == TrafficLight.STATE.RED){


			this.carSpeed = SPEED.STOP;
		}
		else if(getRotation() == DOWN && i.lights.get(DOWN_LIGHT).getPhase() == TrafficLight.STATE.RED){


			this.carSpeed = SPEED.STOP;
		}
		else if(getRotation() == UP &&i.lights.get(UP_LIGHT).getPhase() == TrafficLight.STATE.RED){

			this.carSpeed = SPEED.STOP;
		}
		else
			this.carSpeed = SPEED.REGULAR;

	}
	@Override
	public void leaveIntersection(Intersection i) {

		if(getRotation() == LEFT && getX() - blue.getWidth() <= i.getX() - i.width / 2){
			this.carSpeed = SPEED.REGULAR;
		}
		else if(getRotation() == RIGHT && getX() + blue.getWidth() >= i.getX() + i.width / 2){
			this.carSpeed = SPEED.REGULAR;
		}
		else if(getRotation() == DOWN && getY() + blue.getWidth() >= i.getY() + i.width / 2){
			this.carSpeed = SPEED.REGULAR;
		}
		else if(getRotation() == UP && getY() - blue.getWidth() <= i.getY() - i.width / 2){
			this.carSpeed = SPEED.REGULAR;
		}
	}

	@Override
	public void move() {

	}
	@Override
	public void reset(Intersection i){

	}


	@Override
	public void touched(Intersection i) {


	}
	

	



}

