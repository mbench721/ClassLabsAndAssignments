package gameobjects;

import controllers.PieceController;

public class Knight extends Piece {
	
	private PieceController control;
	
	public Knight(boolean available, int x, int y,String c,String t) {
		super(available, x, y,c,t);
		
		control = new PieceController(this);

	}
	@Override
	  public boolean isValidMove(int toX, int toY){
	        if(toX == 0 && toY == 0){
	            return false; 
	        }//cannot move nothing
	        else if( toX > 1   &&  toY> 1 ){
	            return false;
	        }
	        else{
	        	 return true;	
	        }
	}

}
