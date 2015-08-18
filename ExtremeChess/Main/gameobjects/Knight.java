package gameobjects;

import controllers.PieceController;

public class Knight extends Piece {
	
	private PieceController control;
	
	public Knight(boolean available, int x, int y) {
		super(available, x, y);
		
		control = new PieceController(this);

	}

}
