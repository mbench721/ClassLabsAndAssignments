package gameobjects;

import controllers.PieceController;

public class Queen extends Piece {
	
	private PieceController control;

	public Queen(boolean available, int x, int y) {
		super(available, x, y);
		
		control = new PieceController(this);
		
	}

}
