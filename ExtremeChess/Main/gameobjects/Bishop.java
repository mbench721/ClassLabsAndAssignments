package gameobjects;

import controllers.PieceController;

public class Bishop extends Piece {
	
	private PieceController control;

	public Bishop(boolean available, int x, int y) {
		super(available, x, y);
		
		control = new PieceController(this);
	}

}
