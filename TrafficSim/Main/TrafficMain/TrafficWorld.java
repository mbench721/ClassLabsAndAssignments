package TrafficMain;
import java.awt.Color;

import greenfoot.Greenfoot;
import greenfoot.World;

public class TrafficWorld extends World {
	

	public final static int WIDTH = 1000;
	public static final int HEIGHT = 750;
	static final int CELLSIZE = 1;
	Manager manage;

	public TrafficWorld(){

		super (WIDTH,HEIGHT,CELLSIZE);
		getBackground().setColor(Color.GREEN);
		getBackground().fill();
		
		
		
		manage = new Manager(this);
	

	}
	public void act(){
		manage.act();
	}
}

