package CarStuff;
import java.util.List;
import greenfoot.GreenfootImage;
import intersections.Intersection;

public interface IntersectionListener {
	
	GreenfootImage blue = new GreenfootImage("Images/topCarBlue.png");
	GreenfootImage purple = new GreenfootImage("Images/topCarPurple.png");
	GreenfootImage red = new GreenfootImage("Images/topCarRed.png");
	GreenfootImage yellow = new GreenfootImage("Images/topCarYellow.png");
	public final int LEFT_LIGHT = 1, RIGHT_LIGHT = 0, DOWN_LIGHT = 3, UP_LIGHT = 2;
	public final int RIGHT_TURN = 5,LEFT_TURN = 3;
	public void approachingIntersection(Intersection i);
	public void inIntersection(Intersection i);
	public void leaveIntersection(Intersection i);
	public void reset(Intersection i);
	public void move();
	public void touched(Intersection i);
	public List<Intersection> findPath(Intersection s, Intersection f);
	public Intersection getEnd();

}
