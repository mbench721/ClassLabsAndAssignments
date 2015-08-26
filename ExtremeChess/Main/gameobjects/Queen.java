package gameobjects;

import controllers.PieceController;

public class Queen extends Piece {

	private PieceController control;

	public Queen(boolean available, int x, int y, String c,String t) {
		
		super(available, x, y, c,t);

		control = new PieceController(this);

	}

	@Override
	public boolean isValidLmove(int toX, int toY,boolean cap,boolean lCheck) {

		if (!lCheck && Math.abs(toX) == Math.abs(toY)){
			return true;
		}
		else if ( !lCheck && Math.abs(toX) == Math.abs(toY)){
			return true;
		}
		else if(!lCheck && toX == 0 || !lCheck && toY == 0){
			return true;
		}
		return false;
	}

	@Override
	public boolean isValidDmove(int toX, int toY, boolean cap,boolean dCheck) {
		if (!dCheck && Math.abs(toX) == Math.abs(toY)){
			return true;
		}
		else if (!dCheck && Math.abs(toX) == Math.abs(toY)){
			return true;
		}
		else if(!dCheck && toX == 0 || !dCheck &&  toY == 0){
			return true;
		}
		return false;

	}

	@Override
	public boolean isValidCastle() {
		// TODO Auto-generated method stub
		return false;
	}

}




