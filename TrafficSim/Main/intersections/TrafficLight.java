package intersections;
import greenfoot.Actor;
import greenfoot.GreenfootImage;

public class TrafficLight extends Actor {
	
	private final int UP_DOWN_YELLOW = 650, DOWN_UP_GREEN = 950, UP_DOWN_RED = 550, RIGHT_LEFT_YELLOW = 150,  LEFT_RIGHT_GREEN = 500, LEFT_RIGHT_RED = 1000;
	private GreenfootImage redLight = new GreenfootImage("Images/trafficLightRed.png");
	private GreenfootImage yellowLight = new GreenfootImage("Images/trafficLightYellow.png");
	private GreenfootImage greenLight = new GreenfootImage("Images/trafficLightGreen.png");
	public int delay;
	public  enum STATE{
		RED,GREEN,YELLOW;
	}
	public  STATE phase;
	
	public TrafficLight(){
		
		setImage(redLight);
		delay = 1000;
		phase = STATE.GREEN;
		
	}
	public void act(){
		
		changeColorGreen();
		changeColorYellow();
		changeColorRed();
		lightState();

		delay--;
		if(delay == 0){
			delay = 1000;
		}

	}
	private void lightState() {
		switch(phase){

		case RED:
			setImage(redLight);
			break;
		case YELLOW:
			setImage(yellowLight);
			break;
		case GREEN:
			setImage(greenLight);
			break;
		default:
			break;
		}
	}
	public STATE getPhase(){
		return this.phase;
	}
	public void changeColorRed(){
		
		if(delay == UP_DOWN_RED && getRotation() == 90 || delay == UP_DOWN_RED && getRotation() == 270 ){
			this.phase = STATE.RED;
		}
		else if(delay == LEFT_RIGHT_RED && getRotation() == 0 || delay == LEFT_RIGHT_RED && getRotation() == 180 ){
			this.phase = STATE.RED;
		}
		
	}
	public void changeColorYellow(){
		
		if(delay == UP_DOWN_YELLOW && getRotation() == 90 || delay == UP_DOWN_YELLOW && getRotation() == 270  ){ //down   // down up starts green
			this.phase = STATE.YELLOW;
		}
		
		else if(delay == RIGHT_LEFT_YELLOW && getRotation() == 0 || delay == RIGHT_LEFT_YELLOW && getRotation() == 180    ){ // right
			this.phase = STATE.YELLOW;
		}
			
	}
	public void changeColorGreen(){
		if(delay == DOWN_UP_GREEN&& getRotation() == 90 || delay == DOWN_UP_GREEN && getRotation() == 270 ){

			this.phase = STATE.GREEN;

		}
		
		else if(delay == LEFT_RIGHT_GREEN && getRotation() == 0 ||  delay == LEFT_RIGHT_GREEN && getRotation() == 180  ){

			this.phase = STATE.GREEN;

		}
		
	}

}


