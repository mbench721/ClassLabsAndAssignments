package gameobjects;

import controllers.PieceController;

public class Bishop extends Piece {
	
	private PieceController control;

	public Bishop(boolean available, int x, int y,String c,String t) {
		super(available, x, y,c,t);
		
		control = new PieceController(this);
	}

	@Override
	public boolean isValidLmove(int toX, int toY,boolean cap,boolean lCheck) {
		
		if(!lCheck && Math.abs(toX )== Math.abs(toY)){
			return true;
		}
		else {
			return false;
		}
		
	}

	@Override
	public boolean isValidDmove(int toX, int toY, boolean cap,boolean dCheck) {
		if(!dCheck && Math.abs(toX )== Math.abs(toY)){
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isValidCastle() {
		
		return false;
	}
	
}
