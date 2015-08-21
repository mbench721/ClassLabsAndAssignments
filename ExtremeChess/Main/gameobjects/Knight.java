package gameobjects;

import controllers.PieceController;

public class Knight extends Piece {

	private PieceController control;

	public Knight(boolean available, int x, int y,String c,String t) {
		super(available, x, y,c,t);

		control = new PieceController(this);

	}

	@Override
	public boolean isValidMove(int toX, int toY,boolean cap) {
		if(toX == 2 && toY <=1 && toY >= -1  && toY != 0){
			return true;
		}
		else if(toX == -2 && toY <=1 && toY >= -1 && toY != 0){
			return true;
		}
		else if(toY == 2 &&  toX <=1 && toX >= -1 && toX != 0){
			return true;
		}

		else if(toY == -2 && toX <=1 && toX >= -1 && toX != 0){
			return true;
		}
		return false;
	}


}
