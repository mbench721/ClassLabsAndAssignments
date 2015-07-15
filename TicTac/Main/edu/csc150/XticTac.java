package edu.csc150;

import greenfoot.Actor;
import greenfoot.GreenfootImage;

public class XticTac extends Actor {
	private int width = 150;
	private int height = 150;
	private GreenfootImage xTic = new GreenfootImage("Images/Xtictac.png");
	public XticTac(){

		setImage(xTic);
		xTic.scale(width,height);

	}	
}



