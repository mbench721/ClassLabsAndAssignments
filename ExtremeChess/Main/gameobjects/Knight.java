package gameobjects;

import controllers.PieceController;

public class Knight extends Piece {

	private PieceController control;

	public Knight(boolean available, int x, int y,String c,String t) {
		super(available, x, y,c,t);

		control = new PieceController(this);

	}

	@Override
	public boolean isValidLmove(int toX, int toY,boolean cap,boolean lCheck) {
		if(!lCheck && toX == 2 && toY <=1 && toY >= -1  && toY != 0){
			return true;
		}
		else if(!lCheck && toX == -2 && toY <=1 && toY >= -1 && toY != 0){
			return true;
		}
		else if(!lCheck && toY == 2 &&  toX <=1 && toX >= -1 && toX != 0){
			return true;
		}

		else if(!lCheck && toY == -2 && toX <=1 && toX >= -1 && toX != 0){
			return true;
		}
		return false;
	}

	@Override
	public boolean isValidDmove(int toX, int toY, boolean cap,boolean dCheck) {
		if(!dCheck && toX == 2 && toY <=1 && toY >= -1  && toY != 0){
			return true;
		}
		else if(!dCheck && toX == -2 && toY <=1 && toY >= -1 && toY != 0){
			return true;
		}
		else if(!dCheck && toY == 2 &&  toX <=1 && toX >= -1 && toX != 0){
			return true;
		}

		else if(!dCheck && toY == -2 && toX <=1 && toX >= -1 && toX != 0){
			return true;
		}
		return false;
	}

	@Override
	public boolean isValidLCastle(int toX, int toY, boolean lCheck) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isValidDCastle(int toX, int toY, boolean dCheck) {
		// TODO Auto-generated method stub
		return false;
	}


}
