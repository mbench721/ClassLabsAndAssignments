package gameobjects;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;



public class Pawn extends Piece{
	
	private int validMovePos = 2;
	private int validMoveNeg = -2;



	public Pawn(StackPane layer, int x, int y,String c,String t,Image i) {
		super(layer, x, y,c,t,i);

		
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


