package gameobjects;


import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;



public class Rook extends Piece {

	
	private int castleValid;

	public Rook(StackPane layer, double x, double y,String c,String t,Image i) {
		super(layer, x, y,c,t,i);
		this.castleValid = 1;
	
	}

	@Override
	public boolean isValidLmove(int toX, int toY,boolean cap,boolean lCheck) {
		if(!lCheck && toX <= 7&& toX >= -7 && toY == 0){
			//--castleValid;
			return true;
		}
		else if(!lCheck && toY <= 7 && toY >= -7 && toX == 0){
			//--castleValid;
			return true;
		}
		else{
			return false;
		}

	}

	@Override
	public boolean isValidDmove(int toX, int toY, boolean cap,boolean dCheck) {
		if(!dCheck && toX <= 7 && toX >= -7 && toY == 0){
			//--castleValid;
			return true;
		}
		else if(!dCheck && toY <= 7 && toY >= -7 && toX == 0){
			//--castleValid;
			return true;
		}
		else{
			return false;
		}

	}

	@Override
	public boolean isValidLCastle(int toX, int toY, boolean lCheck) {

		if(!lCheck && this.getX() == 0 && this.getY() == 0 && castleValid == 1 && toX == 3 && toY == 0){

			return true;

		}
		else if(!lCheck && this.getX() == 0 && this.getY() == 7 && castleValid == 1 && toX == -2 && toY == 0){
			return true;
		}
		else if(!lCheck && this.getX() == 0 && this.getY() == 0 && castleValid == 1 && toX == -3 && toY == 0){

			return true;

		}
		else if(!lCheck && this.getX() == 0 && this.getY() == 7 && castleValid == 1 && toX == 2 && toY == 0){
			return true;
		}

		else{
			return false;
		}

	}

	@Override
	public boolean isValidDCastle(int toX, int toY, boolean dCheck) {

		if(!dCheck && this.getX() == 7 && this.getY() == 0 && castleValid == 1 && toX == 3 && toY == 0){
			return true;
		}
		else if(!dCheck && this.getX() == 7 && this.getY() == 7 && castleValid == 1 && toX == -2 && toY == 0){
			return true;
		}
		if(!dCheck && this.getX() == 7 && this.getY() == 0 && castleValid == 1 && toX == -3 && toY == 0){
			return true;
		}
		else if(!dCheck && this.getX() == 7 && this.getY() == 7 && castleValid == 1 && toX == 2 && toY == 0){
			return true;
		}


		return false;
	}

	


}
