package gameobjects;

import controllers.BoardController;

public class Board {

	private BoardController control;
	private String[] moves;
	private int boardSize = 8;
	private BoardTile[][] tiles = new BoardTile[8][8];



	public Board(String[] file){
		
		setSquares(tiles);
		moves = file;
		control = new BoardController(this);

		
	}
	public BoardTile[][] getTiles() {
		return tiles;
	}

	public BoardTile[][] setSquares(BoardTile[][] u) {

		for(int i = 0; i < tiles.length; ++i){
			
			for(int j = 0; j < tiles.length; ++j){

				tiles[i][j] = new BoardTile(i,j);

			}
		}

		return tiles;
	}

	public void generateBoard(){
		int i = 8;
		System.out.print("   A  " + " B  " + " C  " + " D  " + " E  " + " F  " + " G  " + " H");
		for (int row = 0; row < boardSize; row++)
		{
			System.out.println("");
			System.out.println(" ---------------------------------");
			System.out.print(i);
			--i;
			for (int column = 0; column < boardSize; column++)
			{
				System.out.print("| " +tiles[row][column].pieceType + " ");

			}   
			System.out.print("|");
		}
		System.out.println("");
		System.out.println(" ---------------------------------");
	} 
	public void updateBoard(BoardTile[][] u){
		tiles = u;
		int i = 8;
		System.out.print("   A  " + " B  " + " C  " + " D  " + " E  " + " F  " + " G  " + " H");
		for (int row = 0; row < boardSize; row++)
		{
			System.out.println("");
			System.out.println(" ---------------------------------");
			System.out.print(i);
			--i;
			for (int column = 0; column < boardSize; column++)
			{
				System.out.print("| " +tiles[row][column].pieceType + " ");

			}   
			System.out.print("|");
		}
		System.out.println("");
		System.out.println(" ---------------------------------");
	} 



}



