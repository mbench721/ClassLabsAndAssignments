package edu.csc150;

import java.awt.Color;

import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;


public class Block extends Actor {
	public static boolean Xturn = true;
	public static boolean Oturn = false;
	public static boolean xOn = false;
	public static boolean oOn = false;
	private int width = 313;
	private int height = 230;
	protected XticTac xTic = new XticTac();
	protected OticTac oTic = new OticTac();
	private GreenfootImage block = new GreenfootImage("Images/Clear.png");
	public Block(){
		
		setImage(block);
		block.scale(width,height);
		block.setColor(Color.WHITE);
		block.fill();
		
		
	}
	public int getOffsetX(){
		return width / 2;
	}
	public int getOffsetY(){
		return height / 2;
	}
	public int getWidth(){
		return width;
	}
	public void addX(){
		if (Greenfoot.mouseClicked(this) && Xturn && oIsOn() == null)
		{
		   
		    int x = getX();
		    int y = getY();
		    getWorld().addObject( xTic = new XticTac(), x, y);
	        Xturn = false;
		    Oturn = true;
		    
		}
		else if (Greenfoot.mouseClicked(this) && Oturn && xIsOn() == null)
		{
	
		    int x = getX();
		    int y = getY();
		    getWorld().addObject(oTic = new OticTac(), x, y);
		    Oturn = false;
		    Xturn = true;
		    
		}
	
	}
	public Actor xIsOn(){
		return getOneIntersectingObject(XticTac.class);
		
	}
	public Actor oIsOn(){
		return getOneIntersectingObject(OticTac.class);
		
	}

}
