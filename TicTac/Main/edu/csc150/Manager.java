package edu.csc150;

import javax.swing.JOptionPane;

import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.World;

public class Manager extends Actor {
	
	protected Block topLeft = new Block();
	protected Block topMid = new Block();
	protected Block topRight = new Block();
	protected Block midRight = new Block();
	protected Block midLeft = new Block();
	protected Block mid = new Block();
	protected Block bottomMid = new Block();
	protected Block bottomLeft = new Block();
	protected Block bottomRight = new Block();
	private int borderWidth = 10;
	private State phase;
	
	public Manager(World world){
		
		world.addObject(topMid, topMid.getOffsetX() + borderWidth + world.getWidth() / 3, topMid.getOffsetY() + borderWidth);
		world.addObject(topLeft, topLeft.getOffsetX() + borderWidth, topLeft.getOffsetY() + borderWidth);
		world.addObject(topRight, topRight.getOffsetX() + borderWidth + world.getWidth() / 3 * 2, topRight.getOffsetY() + borderWidth);
		
		world.addObject(mid, mid.getOffsetX() + borderWidth + world.getWidth() / 3, mid.getOffsetY()+ borderWidth + world.getHeight() / 3  );
		world.addObject(midLeft, midLeft.getOffsetX() + borderWidth, midLeft.getOffsetY() + borderWidth + world.getHeight() / 3 );
		world.addObject(midRight, midRight.getOffsetX() + borderWidth + world.getWidth() / 3 * 2, midRight.getOffsetY() + borderWidth + world.getHeight() / 3 );
		
		world.addObject(bottomMid, topMid.getOffsetX() + borderWidth + world.getWidth() / 3, topMid.getOffsetY() + borderWidth + world.getHeight() / 3 * 2 );
		world.addObject(bottomLeft, topMid.getOffsetX() + borderWidth, topMid.getOffsetY() + borderWidth + world.getHeight() / 3 * 2 );
		world.addObject(bottomRight, topMid.getOffsetX() + borderWidth  + world.getWidth() / 3 * 2, topMid.getOffsetY() + borderWidth + world.getHeight() / 3 * 2 );
		
		this.phase = State.PLAY;
	}
	public void act(){
		
		
		switch(phase){
		case PLAY:
			topLeft.addX();
			topMid.addX();
			topRight.addX();
			midRight.addX();
			midLeft.addX();
			mid.addX();
			bottomMid.addX();
			bottomLeft.addX();
			bottomRight.addX();
			checkXtoe();
			checkOtoe();
			break;
			
		case XWIN:
			JOptionPane.showMessageDialog(null, " X wins! Tic Tac Toe Three in a Row!");
			Greenfoot.stop();
			break;
		
		 case OWIN:
			 JOptionPane.showMessageDialog(null, " O wins! Tic Tac Toe Three in a Row!");
				Greenfoot.stop();
			 break;
		 default:
				break;
		}
		
	}
	public void checkXtoe(){
		if (topLeft.xIsOn() != null && topMid.xIsOn() != null && topRight.xIsOn() != null){
			phase = State.XWIN;
		}
		else if (midLeft.xIsOn() != null && mid.xIsOn() != null && midRight.xIsOn() != null){
			phase = State.XWIN;
			
		}
		else if (bottomLeft.xIsOn() != null && bottomMid.xIsOn() != null && bottomRight.xIsOn() != null){

			phase = State.XWIN;
		}
		else if (topLeft.xIsOn() != null && midLeft.xIsOn() != null && bottomLeft.xIsOn() != null){

			phase = State.XWIN;
		}
		else if (topMid.xIsOn() != null && mid.xIsOn() != null && bottomMid.xIsOn() != null){

			phase = State.XWIN;
		}
		else if (topRight.xIsOn() != null && midRight.xIsOn() != null && bottomRight.xIsOn() != null){

			phase = State.XWIN;
		}
		else if (topLeft.xIsOn() != null && mid.xIsOn() != null && bottomRight.xIsOn() != null){

			phase = State.XWIN;
		}
		else if (bottomLeft.xIsOn() != null && mid.xIsOn() != null && topRight.xIsOn() != null){

			phase = State.XWIN;
		}

	}
	public void checkOtoe(){
		if (topLeft.oIsOn() != null && topMid.oIsOn() != null && topRight.oIsOn() != null){

			phase = State.OWIN;
		}
		else if (midLeft.oIsOn() != null && mid.oIsOn() != null && midRight.oIsOn() != null){

			phase = State.OWIN;
		}
		else if (bottomLeft.oIsOn() != null && bottomMid.oIsOn() != null && bottomRight.oIsOn() != null){

			phase = State.OWIN;
		}
		else if (topLeft.oIsOn() != null && midLeft.oIsOn() != null && bottomLeft.oIsOn() != null){

			phase = State.OWIN;
		}
		else if (topMid.oIsOn() != null && mid.oIsOn() != null && bottomMid.oIsOn() != null){

			phase = State.OWIN;
		}
		else if (topRight.oIsOn() != null && midRight.oIsOn() != null && bottomRight.oIsOn() != null){

			phase = State.OWIN;
		}
		else if (topLeft.oIsOn() != null && mid.oIsOn() != null && bottomRight.oIsOn() != null){

			phase = State.OWIN;
		}
		else if (bottomLeft.oIsOn() != null && mid.oIsOn() != null && topRight.oIsOn() != null){

			phase = State.OWIN;
		}


	}

}

	
	


