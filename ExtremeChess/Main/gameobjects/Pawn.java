package gameobjects;

import controllers.PieceController;

public class Pawn extends Piece{
	private PieceController control;
	private int validMovePos = 2;
	private int validMoveNeg = -2;



	public Pawn(boolean available, int x, int y,String c,String t) {
		super(available, x, y,c,t);

		control = new PieceController(this);
	}
	@Override
	public boolean isValidLmove(int toX, int toY,boolean cap,boolean lCheck) {
		
		if(!lCheck && !cap && this.getColor().equalsIgnoreCase("l") && toY >= validMoveNeg && toY <= 0){
			validMoveNeg = -1;
			return true;
		}
		else if(!lCheck && cap && this.getColor().equalsIgnoreCase("l") && toY == validMoveNeg && toY <= 0 && toX !=0){
			validMoveNeg = -1;
			return true;
		}
		else{
			return false;
		}

	}
	@Override
	public boolean isValidDmove(int toX, int toY, boolean cap,boolean dCheck) {
		if(!dCheck && !cap && this.getColor().equalsIgnoreCase("d")  && toY <= validMovePos && toY >= 0){
			validMovePos = 1;
			return true;
		}
		
		else if(!dCheck && cap && this.getColor().equalsIgnoreCase("d") && toY == validMovePos && toY >= 0 && toX != 0 ){
			validMovePos = 1;

			return true;
		}
		
		else{
			return false;
		}
	}

	@Override
	public boolean isValidLCastle(int toX, int toY, boolean lCheck) {
		return false;
	}



	@Override
	public boolean isValidDCastle(int toX, int toY, boolean dCheck) {
		// TODO Auto-generated method stub
		return false;
	}
}


