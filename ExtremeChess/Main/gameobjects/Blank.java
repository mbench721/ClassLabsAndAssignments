package gameobjects;

import controllers.PieceController;

public class Blank extends Piece {

	private PieceController control;

	public Blank(boolean available, int x, int y, String c, String t) {
		super(available, x, y, c, t);
		
		control = new PieceController(this);
	}
	@Override
	  public boolean isValidMove(int toX, int toY){

	        	 return true;	
	        
	}

}
