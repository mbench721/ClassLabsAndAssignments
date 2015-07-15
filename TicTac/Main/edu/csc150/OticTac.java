package edu.csc150;

import greenfoot.Actor;
import greenfoot.GreenfootImage;

public class OticTac extends Actor {
	private int width = 150;
	private int height = 150;
	private GreenfootImage x = new GreenfootImage("Images/Otictac.jpg");
	public OticTac(){
		setImage(x);
		x.scale(width,height);	
	}

}