package gameobjects;

import controllers.PieceController;



public class King extends Piece {
	
	private PieceController control;

	public King(boolean available, int x, int y) {
		super(available, x, y);
		
		control = new PieceController(this);
		
	}

	
}
