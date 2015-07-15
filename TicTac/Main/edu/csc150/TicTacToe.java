package edu.csc150;

import java.awt.Color;
import greenfoot.World;

public class TicTacToe extends World {
	public static int WIDTH = 1000, HEIGHT = 750, CELL = 1;
	Manager manager;

	public TicTacToe(){
		super (WIDTH,HEIGHT,CELL);
		getBackground().setColor(Color.BLACK);
		getBackground().fill();
		manager = new Manager(this);

	}	
	public void act(){

		manager.act();
		
	}

}
