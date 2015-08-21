package gameobjects;

import controllers.PieceController;

public class Queen extends Piece {
	
	private PieceController control;

	public Queen(boolean available, int x, int y, String c,String t) {
		super(available, x, y, c,t);
		
		control = new PieceController(this);
		
	}

	@Override
	public boolean isValidMove(int toX, int toY,boolean cap) {
		
		if (Math.abs(toX) == Math.abs(toY)){
			return true;
		}
		else if ( Math.abs(toX) == Math.abs(toY)){
			return true;
		}
		else if(toX == 0 || toY == 0){
			return true;
		}
			return false;
		}
		
	}
	
	


