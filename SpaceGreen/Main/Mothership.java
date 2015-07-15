
import Planets.Earth;
import greenfoot.Actor;
import greenfoot.GreenfootImage;

public class Mothership extends Actor {
	
	public GreenfootImage mothershipPic = new GreenfootImage("Images/MotherShip.png");
	int x = 50;
	private int spaceHeight = 750;
	int y = spaceHeight - 548;
	int h  = mothershipPic.getHeight();;
	public Earth earth = new Earth();
	int w = mothershipPic.getWidth() / 2;
	public Mothership mothership;
	public Explosion explosion;
	private enum STATE{
		MOVE,CRASH,RESET
		}
	protected STATE phase;
	public Mothership() {
		MOVE();
		setImage("Images/MotherShip.png");
		Brain2.motherW = w;
		System.out.println(w);
	}
	public void act(){
		
		
		switch(phase){
		case MOVE:
			setImage("Images/MotherShip.png");
			
			Actor b = getOneIntersectingObject(Spaceship.class);
			if(x == 950){
				RESET();
			}
			if(b != null){
				
				
					CRASH();
			}
				move(2);
				++x;
				Brain2.motherX = this.x;
			break;
		case CRASH:
			explosion = new Explosion();
			getWorld().addObject(explosion, this.getX(), this.getY());
			getWorld().removeObject(this);
			break;
		case RESET:
			reset();
			getWorld().removeObject(this);
			break;
			default:
				break;
		}


	}

	public void reset(){
		 mothership = new Mothership();
		 x = 50;
		getWorld().addObject(mothership, getX(x), getY(y));
			
	}
	
	public int getX(int x){
		return x;
	}
	public int getY(int y){
		return y;
	}
	public int getH(int h){
		
		return h;
	}
	public void RESET(){
		this.phase = STATE.RESET;
	}
	public void CRASH(){
		this.phase = STATE.CRASH;
	}
	public void MOVE(){
		this.phase = STATE.MOVE;
	}
}
