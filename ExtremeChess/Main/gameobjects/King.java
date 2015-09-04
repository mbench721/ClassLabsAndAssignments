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
		if(!lCheck && toX <= 1 && toY <= 1 && toX >= 0 && toY >= 0) {
			//--castleValid;
			return true;	
		}
		else if(!lCheck && toX >= -1 && toY >= -1 && toX <=  0 && toY <= 0){
			//--castleValid;
			return true;
		}
		else if(!lCheck && Math.abs(toX) == Math.abs(toY) && toX <= 1 && toY <=1 && toX >= -1 && toY >= -1){
			//--castleValid;
			return true;
					
		}
		
		else{
			return false;
		}
		
	}

	@Override
	public boolean isValidDmove(int toX, int toY, boolean cap,boolean dCheck) {
		if(!dCheck && toX <= 1 && toY <= 1 && toX >= 0 && toY >= 0) {
			//--castleValid;
			return true;	
		}
		else if( !dCheck && toX >= -1 && toY >= -1 && toX <=  0 && toY <= 0){
			//--castleValid;
			return true;
		}
		else if(!dCheck && Math.abs(toX) == Math.abs(toY) && toX <= 1 && toY <=1 && toX >= -1 && toY >= -1){
			//--castleValid;
			return true;
					
		}
		
		else{
			return false;
		}
	}


	

	@Override
	public boolean isValidLCastle(int toX, int toY, boolean lCheck) {
		//System.out.println(this.getX() + " " + this.getY());
		
		if(!lCheck && this.getX() == 0 && this.getY() == 4 && castleValid == 1 && toX == 2 && toY == 0 ){
			System.out.println("King");
			return true;
			
		}
		else if(!lCheck && this.getX() == 0 && this.getY() == 4 && castleValid == 1 && toX == -2 && toY == 0 ){
			System.out.println("King");
			return true;
			
		}
		else{
			return false;
		}
		
		
	}

	@Override
	public boolean isValidDCastle(int toX, int toY, boolean dCheck) {
		System.out.println(this.getX() + " " + this.getY());
		if(!dCheck && this.getX() == 7 && this.getY() == 4 && castleValid == 1 && toX == 2 && toY == 0 ){
			System.out.println("King");
			return true;
			
		}
		else if(!dCheck && this.getX() == 7 && this.getY() == 4 && castleValid == 1 && toX == -2 && toY == 0 ){
			return true;
			
		}
		return false;
		
	}   	
}
