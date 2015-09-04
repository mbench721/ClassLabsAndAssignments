package gameobjects;

import controllers.BoardController;
import controllers.MoveController;

public class Board {

	private BoardController control;
	private String[] moves;
	private int boardSize = 8;
	private BoardTile[][] tiles = new BoardTile[8][8];

	public Board(){

		setSquares(tiles);
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
		int i = 1;
		
		System.out.print("   A  " + " B  " + " C  " + " D  " + " E  " + " F  " + " G  " + " H");
		for (int row = 0; row < boardSize; row++)
		{
			System.out.println("");
			System.out.println(" ---------------------------------");
			System.out.print(i);
			++i;
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
		int i = 1;
		System.out.print("   A  " + " B  " + " C  " + " D  " + " E  " + " F  " + " G  " + " H");
		for (int row = 0; row < boardSize; row++)
		{
			System.out.println("");
			System.out.println(" ---------------------------------");
			System.out.print(i);
			++i;
			for (int column = 0; column < boardSize; column++)
			{
				System.out.print("| " +tiles[row][column].pieceType + " ");

			}   
			System.out.print("|");
		}
		System.out.println("");
		System.out.println(" ---------------------------------");
	} 


	public void nonVerboseUpdate(BoardTile[][] v){
		tiles = v;
	}

	public boolean checkL(String c,boolean cap,MoveController co){
		boolean test = false;
		for(int i = 0; i < tiles.length; ++i){

			for(int j = 0; j < tiles.length; ++j){
				if(tiles[i][j].isOccupied()){

					if(tiles[i][j].pieceType.equalsIgnoreCase("k") && tiles[i][j].getPiece().getColor().equalsIgnoreCase("l")){
						test = tiles[i][j].detLcheck(tiles,cap,co);
						
					}




				}
			}
		}
		System.out.println(test);
		return test;

	}
	public boolean checkD(String c,boolean cap,MoveController co){
		boolean test = false;
		for(int i = 0; i < tiles.length; ++i){

			for(int j = 0; j < tiles.length; ++j){
				if(tiles[i][j].isOccupied()){


					if(tiles[i][j].pieceType.equalsIgnoreCase("k") && tiles[i][j].getPiece().getColor().equalsIgnoreCase("d")){
						test = tiles[i][j].detDcheck(tiles,cap,co);
						
					}



				}
			}
		}
		System.out.println(test);
		return test;

	}




}



