package gameobjects;

import controllers.PieceController;



public class King extends Piece {
	
	private PieceController control;

	public King(boolean available, int x, int y,String c,String t) {
		super(available, x, y,c,t);
		
		control = new PieceController(this);
		
	}
	
	@Override
	public boolean isValidMove(int toX,int toY,boolean cap){
		if(toX <= 1 && toY <= 1 && toX >= 0 && toY >= 0) {
			return true;	
		}
		else if(toX >= -1 && toY >= -1 && toX <=  0 && toY <= 0){
			return true;
		}
		else if(Math.abs(toX) == Math.abs(toY) && toX <= 1 && toY <=1 && toX >= -1 && toY >= -1){
			return true;
					
		}
		
		else{
			return false;
		}
		
	}
	       
	    

	
}
