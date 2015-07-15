
import greenfoot.GreenfootImage;
import greenfoot.World;

import java.awt.Color;
import java.util.Random;

import Planets.*;


public class SpaceGreen extends World { // name
	final static int WIDTH = 1000,  HEIGHT = 750, CELL = 1,HEIGHTD =  HEIGHT / 3,MAX_STAR = 100,STARPS = 4, MAX_P = 5;
	final static int  Q1X = 500, Q1Y = 250, Q2X = 1000, Q2Y = 250, Q3X = 500, Q3Y = 500, Q4X = 1000, Q4Y = 500, STAR_COLOR = 255;
	private Stars[] sTars = new Stars[MAX_STAR];
	public boolean topright = false, topleft = false, bottomleft = false, bottomright = false;
	public int starY,starW,starX, starH;
	public int msXpos = 50, msYpos = HEIGHT / 3, shipX;
	public int shipY;
	private Random rgen = new Random(); 
	public Color sColor; 
	Explosion explosion;
	public Mothership mothership;
	public Spaceship ship;
	public GreenfootImage sTar = getBackground();
	public Earth earth = new Earth();
	public Moon moon = new Moon();
	public Saturn saturn = new Saturn();
	public Mars mars = new Mars();
	public Brain2 brain;

	public SpaceGreen() {
		super(WIDTH, HEIGHT, CELL);
		Brain2.checkCount();
		Background();
		fillStars(sTars,MAX_STAR );
		Setstars();

		GreenfootImage earthp = new GreenfootImage("Images/HalfEarth.png");
		getBackground().drawImage(earthp, earth.getX(), earth.getY());

		GreenfootImage moonp = new GreenfootImage("Images/Moon.png");
		getBackground().drawImage(moonp, moon.getX(), moon.getY());

		GreenfootImage saturnp = new GreenfootImage("Images/Saturn.png");
		getBackground().drawImage(saturnp, saturn.getX(), saturn.getY());

		GreenfootImage marsp = new GreenfootImage("Images/RedPlanet.png");
		getBackground().drawImage(marsp, mars.getX(), mars.getY());

		ship = new Spaceship();
		mothership = new Mothership();
		explosion = new Explosion();
		addObject(mothership,mothership.getX(mothership.x),mothership.getY(mothership.y));
		addObject(ship,ship.getX(),ship.getY(ship.y));

		Checkstars();

		Checkplanets();

	}	

	public void fillStars(Stars [] array,int maxValue){

		for (int i = 0; i < array.length; i++){
			Stars star = new Stars(rgen.nextInt(WIDTH),rgen.nextInt(HEIGHT),rgen.nextInt(MAX_P), sColor,sTar);
			sTars[i] = star;	
		}
	}
	public boolean isBottomRight(int x, int y){
		return x > Q1X && y > Q1Y;
	}
	public boolean isBottomLeft(int x,int y){
		return x < Q1X && y > Q1Y;
	}
	public boolean isTopRight(int x, int y){
		return x > Q1X && y < Q2Y;
	}
	public boolean isTopLeft(int x, int y){
		return x < Q1X && y < Q1Y;
	}
	public void Checkstars(){
		if(isTopLeft (moon.getX(),moon.getY()) || isTopLeft(mars.getX(),mars.getY()) || isTopLeft(saturn.getX(),saturn.getY()) ){
			topleft = true;
		}
		if(isTopRight(moon.getX(),moon.getY()) || isTopRight(saturn.getX(),saturn.getY()) || isTopRight(mars.getX(),mars.getY())){
			topright = true;
		}
		if (isBottomLeft(moon.getX(),moon.getY()) || isBottomLeft(saturn.getX(),saturn.getY()) || isBottomLeft(mars.getX(),mars.getY()) ){
			bottomleft = true;
		}
		if (isBottomRight(moon.getX(),moon.getY()) || isBottomRight(saturn.getX(),saturn.getY()) || isBottomRight(mars.getX(),mars.getY())){
			bottomright = true;
		}

	}
	public void Checkplanets(){
		GreenfootImage star = new GreenfootImage("Images/star.png");
		starW = star.getWidth(); // = 10
		starH = star.getHeight();// = 10
		if (!topleft){// 3 random stars if planets are not in the top left
			for (int x = 0; x < 3;x ++){
				starX = rgen.nextInt(Q1X);
				starY = rgen.nextInt(Q1Y);
				getBackground().drawImage(star, starX, starY);
			}
		}
		if (!topright){
			for(int x = 0; x < 3; x++){
				starX = rgen.nextInt(Q2X - Q1X) + Q1X;       
				starY = rgen.nextInt(Q2Y);
				getBackground().drawImage(star, starX, starY);
			}
		}
		if (!bottomleft){
			for (int x = 0; x < 3; x++){
				starX = rgen.nextInt(Q1X);       
				starY = rgen.nextInt(Q2Y) + Q2Y;
				getBackground().drawImage(star, starX, starY);
			}
		}
		if(!bottomright){
			for (int x = 0; x < 3; x++){
				starX = rgen.nextInt(Q1X) + Q1X;       
				starY = rgen.nextInt(Q2Y) + Q2Y;
				getBackground().drawImage(star, starX, starY);
			}
		}
	}
	public void Setstars(){
		for( Stars set : sTars){
			set.fillOval(getBackground());	
		}
	}
	public void Background(){
		String setcolor = "BLACK";
		setcolor = setcolor.toUpperCase();
		switch (setcolor){
		case "BLUE":
			getBackground().setColor(Color.BLUE);
			getBackground().fill();
			break;
		case "CYAN":	
			getBackground().setColor(Color.CYAN);
			getBackground().fill();
			break;
		case "PINK":
			getBackground().setColor(Color.PINK);
			getBackground().fill();
			break;
		case "GRAY":
			getBackground().setColor(Color.GRAY);
			getBackground().fill();
			break;
		case "GREEN":
			getBackground().setColor(Color.GREEN);
			getBackground().fill();
			break;
		case"RED":
			getBackground().setColor(Color.RED);
			getBackground().fill();
			break;
		default:
			getBackground().setColor(Color.BLACK);
			getBackground().fill();
			break;
		}
	}
	public void act(){

		for(int i = 0; i < sTars.length; ++i){
			if(rgen.nextInt(100) + 1 <= 1){
				sTars[i].fillOval(getBackground());

			}

		}


	}

}




