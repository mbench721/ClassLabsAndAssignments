import greenfoot.Actor;
import java.util.Random;
import Planets.*;


public class Brain extends Actor {
	
	static int dock;
	static int fuel = 50;
	int apex = 0;
	private Spaceship ship;
	private Mothership mothership;
	private Earth earth;
	private int g = 750 / 3 * 2;
	
	public  Brain(Spaceship ship,Mothership mothershp) {
this.ship = new Spaceship();
		
		this.mothership = new Mothership();
		
		
		
	}
	public void act(){

		
		
		
	}
	
	public  int getApex(int a){
		apex = a;
		
	return apex;
	}
	public int getY(int y){
		return y;
	}
	public int getX(int x){
		
		return x;
	}
	public int setFuel(){
		ship.fuel = fuel;
		return ship.fuel;
	}
	
	
	
	
}
	
	



//SpaceWorld world = new SpaceWorld();
//greenfoot.setWorld(world);
//grennfoot.start();