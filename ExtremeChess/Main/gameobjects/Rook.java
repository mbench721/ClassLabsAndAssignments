package gameobjects;

import controllers.PieceController;

public class Rook extends Piece {
	
	private PieceController control;

	public Rook(boolean available, int x, int y,String c,String t) {
		super(available, x, y,c,t);
		
		control = new PieceController(this);
	}

	@Override
	public boolean isValidLmove(int toX, int toY,boolean cap) {
		if(toX <= 7&& toX >= -7 && toY == 0){
			return true;
		}
		else if(toY <= 7 && toY >= -7 && toX == 0){
			return true;
		}
		else{
			return false;
		}
		
	}

	@Override
	public boolean isValidDmove(int toX, int toY, boolean cap) {
		if(toX <= 7&& toX >= -7 && toY == 0){
			return true;
		}
		else if(toY <= 7 && toY >= -7 && toX == 0){
			return true;
		}
		else{
			return false;
		}
		
	}
	

}
