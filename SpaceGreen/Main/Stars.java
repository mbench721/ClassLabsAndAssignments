import java.awt.Color;
import java.util.Random;

import greenfoot.Actor;
import greenfoot.GreenfootImage;

public class Stars extends Actor{
	private GreenfootImage sTar;
	private int randomStarX ;
	private int randomStarY ;
	private int randomStarS;
	private Color sColor;
	private Random rgen = new Random();

	public Stars(int randomStarX, int randomStarY , int randomStarS,Color sColor,GreenfootImage sTar ) {

		this.sTar = fillOval(sTar);
		this.randomStarX = randomStarX;
		this.randomStarY = randomStarY;
		this.randomStarS = randomStarS;
		this.randomStarS = randomStarS;
		this.sColor =sColor();
	}   
	public void act(){

		if(rgen.nextInt(100) + 1 <= 1){
			this.sColor = sColor();

		}
	}

	public int getrandomStarS(){

		return this.randomStarS;
	}
	public Color sColor(){

		sColor = new Color(rgen.nextInt(255),rgen.nextInt(255),rgen.nextInt(255));
		return sColor;

	}

	public int getRandomStarX() {

		return this.randomStarX;

	}
	public int getRandomStarY(){

		return this.randomStarY;
	}
	public GreenfootImage getImage(){
		return sTar;
	}
	public GreenfootImage fillOval( GreenfootImage sTar){
		sTar.fillOval(this.randomStarX,this.randomStarY  , this.randomStarS, this.randomStarS );
		sTar.setColor(this.sColor);
		return sTar;
	}
}





