package roads;
import java.awt.Color;
import greenfoot.Actor;
import greenfoot.GreenfootImage;

public class RoadLine extends Actor {
	private GreenfootImage line = new GreenfootImage("Images/Clear.png");
	public RoadLine(){
		setImage(line);
		line.scale(10, 3);
		line.setColor(Color.YELLOW);
		line.fill();
	}
	public int getOffSetX(){
		return line.getWidth() / 2;

	}
}
