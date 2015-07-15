
import greenfoot.Actor;
import greenfoot.Greenfoot;
import Planets.Earth;

public class Spaceship extends Actor {

	int counTdown;
	int fuel;
	int fuelweight;
	int collision = 235;
	public int gravity;//9.8
	private Earth earth = new Earth();
	int apex;
	int velocity;
	private int spaceWidth = 1000;
	Integer x = new Integer(spaceWidth / 2);
	Integer y = earth.getY() +5;
	int h;
	public STATE phase;
	private Explosion explosion;
	public static Actor dock;
	public  Actor collide;
	public Mothership mothership = new Mothership();;
	public enum STATE {
		WAIT,BURN,COAST,FALL,CRASH;
	}
	public Spaceship() {

		System.out.println(Brain2.countdown);
		System.out.println(mothership.y + mothership.h);
		fuel = Brain2.fuel;
		//counTdown = 274;
		counTdown = Brain2.countdown;

		gravity = 51;
		velocity = 2;
		WAIT();
		setImage("Images/SpaceShipNoThrust.png");
		setRotation(270);	
	}

	public void act() {

		this.explosion = new Explosion();

		switch(phase){
		case WAIT:

			setImage("Images/SpaceShipNoThrust.png");
			setRotation(270);
			if(counTdown == 0){
				BURN();
			}else{
				--counTdown;
			}
			break;
		case BURN:
			setImage("Images/SpaceShip.png");
			if (fuel > 0){
				--fuel;
				move(velocity);
				collide = getOneIntersectingObject(Mothership.class);
				if(collide != null){


					explosion = new Explosion();
					getWorld().addObject(explosion, this.getX(), this.getY());
					getWorld().removeObject(this);

				} 
			}else{

				COAST();	
			}

			break;

		case COAST:

			setImage(("Images/SpaceShipNoThrust.png"));
			velocity = 1;
			if (gravity == 0){

				Brain2.apex = this.getY();
				System.out.println(Brain2.apex);

				if (this.getY() >= collision   ){
					Brain2.fuel ++ ;

				}
				else if(this.getY() <= collision  ){
					Brain2.fuel --;
				}

				FALL();
			}else{
				move(velocity);
				-- gravity;	
			}
			break;

		case FALL:
			checkDock();
			setImage("Images/SpaceShipDown.png");
			if (getY() != earth.getY()){
				move(-1);
			}

			else{
				this.intersects(Earth.class);
				CRASH();
			}
			break;
		case CRASH:
			System.out.println(Brain2.countdown);
			explosion = new Explosion();
			getWorld().addObject(explosion, this.getX(), earth.getY());
			getWorld().removeObject(this);


			break;
		default :

			break;
		}

	}

	public int getX(){
		return x;
	}
	public int getY(int y){

		return y;
	}
	public void WAIT(){
		this.phase = STATE.WAIT;
	}
	public void BURN(){
		this.phase = STATE.BURN;
	}
	public void COAST(){
		this.phase = STATE.COAST;
	}
	public void FALL(){

		this.phase = STATE.FALL;
	} 
	public void CRASH(){
		this.phase = STATE.CRASH;
	}

	public void intersects(Class<Earth> class1){

		if(y == earth.getY() - (earth.getH() / 4)){

			CRASH();

		}

	}

	public void checkDock(){
		dock = this.getOneIntersectingObject(Mothership.class);
		if (getY() == 236 && dock != null  ){
			System.out.println("dock");
			Greenfoot.stop();	
		}
	}
}
// do while 1 or more times
// while 0 or more times
// if you make a constant static 
// for each the reference is read only
// two reasons to avoid name collisions
//for



