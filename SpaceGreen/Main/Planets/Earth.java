package Planets;
import greenfoot.GreenfootImage;
public class Earth extends Planets {	
	int WIDTH = 1000;
	int HEIGHTD = 750 / 3;
	GreenfootImage Planet = new GreenfootImage("Images/HalfEarth.png");

	public Earth() {
		x = WIDTH / 2 - Planet.getWidth() / 2; 
		y = HEIGHTD * 2;
		h = Planet.getHeight();
	}

}
