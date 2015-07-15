package Planets;
import java.util.Random;
import greenfoot.GreenfootImage;

public class Mars extends Planets {
	private Random rgen = new Random();
	GreenfootImage mars = new GreenfootImage("Images/RedPlanet.png");
	Earth earth = new Earth();
	Saturn saturn = new Saturn();
	Moon moon = new Moon();
	private int spaceWidth = 1000;
	public Mars() {
		if (moon.getY() < saturn.getY()){			
			y = rgen.nextInt(moon.getY()) + moon.getY();
			x = rgen.nextInt(spaceWidth - mars.getWidth());
		} 
		else if (moon.getX() < saturn.getX() && moon.getY() > saturn.getY()){
			x = rgen.nextInt(spaceWidth) + moon.getX();
			y = rgen.nextInt(earth.getY() - mars.getHeight());
		}else
		{
			x = rgen.nextInt(spaceWidth - mars.getWidth());
			y = rgen.nextInt(earth.getY());
		}
	}
}
//if (moonY < saturnY){			
//	rplanetY = rgen.nextInt(moonY + moonH) + moonY;
//	rplanetX = rgen.nextInt(WIDTH - rplanetW);
//} 
//else if (moonX < saturnX && moonY > saturnY + moonH){
//	rplanetX = rgen.nextInt(WIDTH - rplanetX) + moonX;
//	rplanetY = rgen.nextInt(hearthH - rplanetH);
//}else
//{
//	rplanetX = rgen.nextInt(WIDTH - rplanetW);
//	rplanetY = rgen.nextInt(hearthY);
//}
