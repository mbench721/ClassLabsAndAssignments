package gameobjects;

import controllers.PieceController;

public class Rook extends Piece {
	
	private PieceController control;
	private int castleValid;

	public Rook(boolean available, int x, int y,String c,String t) {
		super(available, x, y,c,t);
		this.castleValid = 1;
		control = new PieceController(this);
	}

	@Override
	public boolean isValidLmove(int toX, int toY,boolean cap,boolean lCheck) {
		if(!lCheck && toX <= 7&& toX >= -7 && toY == 0){
			--castleValid;
			return true;
		}
		else if(!lCheck && toY <= 7 && toY >= -7 && toX == 0){
			--castleValid;
			return true;
		}
		else{
			return false;
		}
		
	}

	@Override
	public boolean isValidDmove(int toX, int toY, boolean cap,boolean dCheck) {
		if(!dCheck && toX <= 7&& toX >= -7 && toY == 0){
			--castleValid;
			return true;
		}
		else if(!dCheck && toY <= 7 && toY >= -7 && toX == 0){
			--castleValid;
			return true;
		}
		else{
			return false;
		}
		
	}



	@Override
	public boolean isValidLCastle(int toX, int toY, boolean lCheck) {
		System.out.println(this.getX() + " " + this.getY());
		System.out.println(castleValid);
		if(!lCheck && this.getX() == 0 && this.getY() == 0 && castleValid == 1 || this.getX() == 7 && this.getY() == 0 && castleValid == 1){
			return true;
			
		}
		else if(!lCheck && this.getX() == 0 && this.getY() == 7 && castleValid == 1 || this.getX() == 7 && this.getY() == 7 && castleValid == 1 ){
			return true;
		}
		else{
			return false;
		}
		
	}

	@Override
	public boolean isValidDCastle(int toX, int toY, boolean dCheck) {
		if(!dCheck && this.getX() == 0 && this.getY() == 0 && castleValid == 1 || this.getX() == 7 && this.getY() == 0 && castleValid == 1){
			return true;
			
		}
		else if(!dCheck && this.getX() == 0 && this.getY() == 7 && castleValid == 1 || this.getX() == 7 && this.getY() == 7 && castleValid == 1 ){
			return true;
		}
		return false;
	}
	

}
