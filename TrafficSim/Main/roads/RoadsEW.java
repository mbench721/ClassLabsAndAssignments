package roads;
import java.awt.Color;

import TrafficMain.TrafficWorld;
import greenfoot.Actor;
import greenfoot.GreenfootImage;

public class RoadsEW extends Actor {

	private int height = 50;
	private int width;
	private GreenfootImage image = new GreenfootImage("Images/Clear.png");
	public RoadsEW(){
		width = TrafficWorld.WIDTH;
		setImage(image);
		image.scale(width, height);
		image.setColor(Color.GRAY);
		image.fill();		
	}

	public int getOffsetX(){
		return width / 2;
	}
	public int getoffsetY(){
		return height / 2;
	}
	public int getHeight(){
		return height;
	}
}
