package gameobjects;

import controllers.PieceController;

public class Pawn extends Piece{
	private PieceController control;
	


	public Pawn(boolean available, int x, int y) {
		super(available, x, y);
		
		
		control = new PieceController(this);
	}

}
