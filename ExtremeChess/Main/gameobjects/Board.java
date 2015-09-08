package gameobjects;

import controllers.BoardController;
import controllers.MoveController;

public class Board {

	private BoardController control;
	private String[] moves;
	private BoardTile[][] tiles = new BoardTile[8][8];


	public Board(){

		
		control = new BoardController(this);

	}
	public BoardTile[][] getTiles() {
		return tiles;
	}

	
	
	

	
}



