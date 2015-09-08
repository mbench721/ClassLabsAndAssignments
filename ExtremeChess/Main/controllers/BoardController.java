package controllers;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utilities.PositionConverter;
import gameobjects.*;

public class BoardController {

	private int boardSize = 8;
	private Board board;
	public Board getBoard() {
		return board;
	}
	private PositionConverter convert;
	private BoardTile[][] tiles;
	private String [] whiteSetup = {"rla1","nla2","bla3","qla4","kla5","bla6","nla7","rla8","plb1","plb2","plb3","plb4","plb5","plb6","plb7","plb8"};
	private String [] blackSetup = {"rdh1","ndh2","bdh3","qdh4","kdh5","bdh6","ndh7","rdh8","pdg1","pdg2","pdg3","pdg4","pdg5","pdg6","pdg7","pdg8"};
	public BoardController(Board b){

		this.board = b;
		this.tiles = board.getTiles();
		setSquares(tiles);
		convert = new PositionConverter();

	}		

	public void piecePlaceMent(String move){

		Pattern placeByPiece = Pattern.compile("([k|q|b|n|r|p])([l|d])([a-h])([1-8])");
		Matcher piecePlace= placeByPiece.matcher(move.toLowerCase());

		if(piecePlace.find() && move.length() == 4){

			pieceToPlace(piecePlace.group(1),piecePlace.group(2),piecePlace.group(3),piecePlace.group(4));

		}
		else{
			System.out.println("invalid Move");
		}
	}

	public void piecePlaceMentCom(String[] moves){
		for(String move : moves){
			if(move != null){
				Pattern placeByPiece = Pattern.compile("([k|q|b|n|r|p])([l|d])([a-h])([1-8])");
				Matcher piecePlace= placeByPiece.matcher(move.toLowerCase());

				if(piecePlace.find() && move.length() == 4){

					pieceToPlace(piecePlace.group(1),piecePlace.group(2),piecePlace.group(3),piecePlace.group(4));

				}
				else{
					System.out.println("invalid Move");
				}
			}
		}
	}

	public void pieceToPlace(String t,String c,String x,String y){
		
		BoardTile[][] update = board.getTiles();

		if(c.equalsIgnoreCase("l")){

			if(t.equalsIgnoreCase("k")){

				King lKing = new King(true,convert.convertX(x),convert.convertY(y),c,t);

				update[convert.convertX(x)][convert.convertY(y)].setPieceOn(lKing);

			}
			else if(t.equalsIgnoreCase("q")){

				Queen lQueen = new Queen(true,convert.convertX(x),convert.convertY(y),c,t);

				update[convert.convertX(x)][convert.convertY(y)].setPieceOn(lQueen);
			}
			else if(t.equalsIgnoreCase("b")){

				Bishop lBish = new Bishop(true,convert.convertX(x),convert.convertY(y),c,t);

				update[convert.convertX(x)][convert.convertY(y)].setPieceOn(lBish);
			}
			else if(t.equalsIgnoreCase("n")){

				Knight lKnight = new Knight(true,convert.convertX(x),convert.convertY(y),c,t);

				update[convert.convertX(x)][convert.convertY(y)].setPieceOn(lKnight);
			}
			else if(t.equalsIgnoreCase("r")){

				Rook lRook = new Rook(true,convert.convertX(x),convert.convertY(y),c,t);

				update[convert.convertX(x)][convert.convertY(y)].setPieceOn(lRook);
			}
			else if(t.equalsIgnoreCase("p")){

				Pawn lPawn = new Pawn(true,convert.convertX(x),convert.convertY(y),c,t);

				update[convert.convertX(x)][convert.convertY(y)].setPieceOn(lPawn);
			}
		}
		else if(c.equalsIgnoreCase("d")){
			if(t.equalsIgnoreCase("k")){

				King dKing = new King(true,convert.convertX(x),convert.convertY(y),c,t);

				update[convert.convertX(x)][convert.convertY(y)].setPieceOn(dKing);

			}
			else if(t.equalsIgnoreCase("q")){

				Queen dQueen = new Queen(true,convert.convertX(x),convert.convertY(y),c,t);

				update[convert.convertX(x)][convert.convertY(y)].setPieceOn(dQueen);
			}
			else if(t.equalsIgnoreCase("b")){

				Bishop dBish = new Bishop(true,convert.convertX(x),convert.convertY(y),c,t);

				update[convert.convertX(x)][convert.convertY(y)].setPieceOn(dBish);
			}
			else if(t.equalsIgnoreCase("n")){

				Knight dKnight = new Knight(true,convert.convertX(x),convert.convertY(y),c,t);

				update[convert.convertX(x)][convert.convertY(y)].setPieceOn(dKnight);
			}
			else if(t.equalsIgnoreCase("r")){

				Rook dRook = new Rook(true,convert.convertX(x),convert.convertY(y),c,t);

				update[convert.convertX(x)][convert.convertY(y)].setPieceOn(dRook);
			}
			else if(t.equalsIgnoreCase("p")){

				Pawn dPawn = new Pawn(true,convert.convertX(x),convert.convertY(y),c,t);

				update[convert.convertX(x)][convert.convertY(y)].setPieceOn(dPawn);
			}

		}
	}
	public void placePieces(){
	
		
		for(String black : blackSetup){
			piecePlaceMent(black);
		}
		for(String white : whiteSetup){
			piecePlaceMent(white);
		}
		updateBoard(tiles);
	}
	public void nonVerboseUpdate(BoardTile[][] v){
		tiles = v;
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
		return test;

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
	

}


