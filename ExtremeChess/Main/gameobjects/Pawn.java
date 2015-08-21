package gameobjects;

import controllers.PieceController;

public class Pawn extends Piece{
	private PieceController control;
	private int validMovedDist = 2;
	private int firstMove = 1;



	public Pawn(boolean available, int x, int y,String c,String t) {
		super(available, x, y,c,t);


		control = new PieceController(this);
	}



	@Override
	public boolean isValidMove(int toX, int toY,boolean cap) {
		System.out.println(toX);
		System.out.println(toY);
		
		if(!cap && this.getColor().equalsIgnoreCase("d")  && toY <= 1 && toY >= 0){
			return true;
		}
		else if(!cap && this.getColor().equalsIgnoreCase("l") && toY >= -1 && toY <= 0){
			return true;
		}
		else if(cap && this.getColor().equalsIgnoreCase("d") && toY == 1 && toY >= 0 && toX != 0 ){
			
			return true;
		}
		else if(cap && this.getColor().equalsIgnoreCase("l") && toY == -1 && toY <= 0 && toX !=0){
			return true;
		}
		else{
			return false;
		}

	}

}


