package roads;
import java.awt.Color;

import TrafficMain.TrafficWorld;
import greenfoot.Actor;
import greenfoot.GreenfootImage;

public class RoadsNS extends Actor  {
	private int height ;
	private int width = 50;
	private GreenfootImage image = new GreenfootImage("Images/Clear.png");

	public RoadsNS(){
		height = TrafficWorld.HEIGHT;
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
	public int getWidth(){
		return width;
	}
	

}
