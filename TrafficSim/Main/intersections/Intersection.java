package intersections;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;
import CarStuff.Direction;
import CarStuff.IntersectionListener;
import greenfoot.Actor;
import greenfoot.GreenfootImage;

public class Intersection extends Actor  {

	public Random rgen = new Random();
	private int nearRadius, touching ;
	private GreenfootImage clear = new GreenfootImage("Images/Clear.png");
	public ArrayList<TrafficLight> lights = new ArrayList<TrafficLight>();
	ArrayList<IntersectionListener> near = new ArrayList<IntersectionListener>();
	ArrayList<IntersectionListener> in = new ArrayList<IntersectionListener>();
	Hashtable<String,Integer> carStuff = new Hashtable<String,Integer>();
	public int width = 50, height = 50;
	public int randTurn;
	public SimulationStats stats;


	public Intersection(){

		
		setImage(clear);
		clear.scale(width, height);
		clear.setColor(Color.GRAY);
		clear.fill();
		this.stats = new SimulationStats(this);
		stats. carLife = 0;
		
		
	}

	public void act(){
		
		++stats.carLife;
		randTurn =  rgen.nextInt(4) + 1;
		nearRadius = getWorld().getWidth() / 10;
		touching = getWorld().getWidth() / 22;
		carControl();

	}

	@SuppressWarnings("unchecked")
	private void carControl() {

		ArrayList<IntersectionListener> near = (ArrayList<IntersectionListener>) getObjectsInRange(nearRadius,IntersectionListener.class);
		ArrayList<IntersectionListener> in = (ArrayList<IntersectionListener>)getObjectsInRange(touching,IntersectionListener.class);


		for(IntersectionListener n : near){

			if(!near.contains(n)){
				near.add(n);
			}


			n.approachingIntersection(this);

		}

		ArrayList<IntersectionListener> cloneNear = (ArrayList<IntersectionListener>) near.clone();

		for(IntersectionListener n : in){

			if(!in.contains(n)){

				in.add(n);

			}

			if(in.contains(n)){


				cloneNear.remove(n);

			}
			
			ArrayList<Intersection> test = (ArrayList<Intersection>) n.findPath(this, n.getEnd());
			
			n.touched(this);

			n.inIntersection(this);
			n.leaveIntersection(this);
			n.reset(this);
		}	
	} 

	public TrafficLight addLight(Direction direction, int x,int y){
		TrafficLight light = new TrafficLight();
		getWorld().addObject(light, x, y);
		light.setRotation(direction.getRotation());
		return light;
	}
	public void addLights(){

		lights.add(addLight(Direction.RIGHT,this.getX() + 25, this.getY()));
		lights.add(addLight(Direction.LEFT,this.getX() - 25,this.getY()));
		lights.add(addLight(Direction.UP, this.getX(),this.getY() - 25));
		lights.add(addLight(Direction.DOWN, this.getX(), this.getY() + 25));

	}

}



