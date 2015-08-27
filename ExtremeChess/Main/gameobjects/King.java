package gameobjects;

import controllers.PieceController;



public class King extends Piece {
	
	private PieceController control;
	private int castleValid;

	public King(boolean available, int x, int y,String c,String t) {
		super(available, x, y,c,t);
		
		control = new PieceController(this);
		castleValid = 1;
		
	}
	
	@Override
	public boolean isValidLmove(int toX,int toY,boolean cap,boolean lCheck){
		if(toX <= 1 && toY <= 1 && toX >= 0 && toY >= 0) {
			--castleValid;
			return true;	
		}
		else if(toX >= -1 && toY >= -1 && toX <=  0 && toY <= 0){
			--castleValid;
			return true;
		}
		else if( Math.abs(toX) == Math.abs(toY) && toX <= 1 && toY <=1 && toX >= -1 && toY >= -1){
			--castleValid;
			return true;
					
		}
		
		else{
			return false;
		}
		
	}

	@Override
	public boolean isValidDmove(int toX, int toY, boolean cap,boolean dCheck) {
		if(toX <= 1 && toY <= 1 && toX >= 0 && toY >= 0) {
			--castleValid;
			return true;	
		}
		else if(toX >= -1 && toY >= -1 && toX <=  0 && toY <= 0){
			--castleValid;
			return true;
		}
		else if(Math.abs(toX) == Math.abs(toY) && toX <= 1 && toY <=1 && toX >= -1 && toY >= -1){
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
		if(!lCheck && this.getX() == 4 && this.getY() == 0 && castleValid == 1 ){
			return true;
			
		}
		else if(!lCheck && this.getX() == 3 && this.getY() == 7 && castleValid == 1 ){
			return true;
			
		}
		else{
			return false;
		}
		
		
	}

	@Override
	public boolean isValidDCastle(int toX, int toY, boolean dCheck) {
		System.out.println(this.getX() + " " + this.getY());
		if(!dCheck && this.getX() == 4 && this.getY() == 0 && castleValid == 1 ){
			return true;
			
		}
		else if(!dCheck && this.getX() == 3 && this.getY() == 7 && castleValid == 1 ){
			return true;
			
		}
		return false;
		
	}   	
}
