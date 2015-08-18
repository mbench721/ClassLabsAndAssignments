package gameobjects;

import controllers.PieceController;

public class Rook extends Piece {
	
	private PieceController control;

	public Rook(boolean available, int x, int y) {
		super(available, x, y);
		
		control = new PieceController(this);
	}

}
