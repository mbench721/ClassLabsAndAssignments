package managers;

import gameobjects.Board;


public class BoardManager {
	
	
	Board board;
	String[] moves;
	
	public BoardManager(String[] file){
		moves = file;
		
		createBoard();
		
	}
	private void createBoard(){
		board = new Board(moves);
	}

}
