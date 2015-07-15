package Planets;
import java.util.Random;
import greenfoot.GreenfootImage;

public class Moon extends Planets {
	private Earth earth = new Earth();
	private Random rgen = new Random();
	private int width = 1000;
	GreenfootImage moon = new GreenfootImage("Images/Moon.png");

	public Moon() {
		x = rgen.nextInt(width) - moon.getWidth();
		y = rgen.nextInt(earth.getY() - moon.getHeight());
	}

}
