package Planets;
import greenfoot.GreenfootImage;
import java.util.Random;

public class Saturn extends Planets {
	private Moon moon = new Moon();
	GreenfootImage saturn = new GreenfootImage("Images/Saturn.png");
	private int spacewidth = 1000;
	private int quadrant1Y = 250;
	private int quadrant1X = 500;
	private int quadrant2Y = 250;
	private int quadrant3X = 500;
	private Random rgen = new Random();
	public Saturn() {

		if (moon.getY() < quadrant1Y  && moon.getX() < quadrant1X ){          //saturn positioning
			y = rgen.nextInt(quadrant2Y) - saturn.getHeight();
			x = rgen.nextInt(quadrant1X) + quadrant1X;
		}else if (moon.getY() < quadrant1Y && moon.getX() > quadrant1X ){
			y = rgen.nextInt((quadrant2Y - quadrant1Y) + saturn.getHeight()) + quadrant1Y;
			x = rgen.nextInt(quadrant3X - saturn.getWidth());
		}else if (moon.getY() > quadrant1Y && moon.getX() < spacewidth){
			y = rgen.nextInt(quadrant1Y - saturn.getHeight());
			x = rgen.nextInt(spacewidth - saturn.getWidth());
		}
	}

}
//if (moonY < Q1Y  && moonX < Q1X ){          //saturn positioning
//	saturnY = rgen.nextInt(Q2Y - saturnH);
//	saturnX = rgen.nextInt(Q1X) + Q1X;
//}else if (moonY < Q1Y - moonH && moonX > Q1X - moonW ){
//	saturnY = rgen.nextInt((Q2Y - Q1Y) + saturnH) + Q1Y;
//	saturnX = rgen.nextInt(Q3X - saturnW);
//}else if (moonY > Q1Y && moonX < WIDTH){
//	saturnY = rgen.nextInt(Q1Y - saturnH);
//	saturnX = rgen.nextInt(WIDTH - saturnW);
//}
//getBackground().drawImage(saturn,saturnX,saturnY );