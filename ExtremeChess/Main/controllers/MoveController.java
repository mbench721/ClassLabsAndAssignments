package controllers;

import gameobjects.Board;
import gameobjects.BoardTile;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utilities.BlockedChecker;
import utilities.PositionConverter;

public class MoveController {

	Pattern single = Pattern.compile("([a-h])([1-8])([a-h])([1-8])");
	Pattern twoMove = Pattern.compile("([a-h])([1-8])([a-h])([1-8])([a-h])([1-8])([a-h])([1-8])");
	Pattern capture = Pattern.compile("([a-h])([1-8])([a-h])([1-8])([*])");
	Matcher singleMatch;
	Matcher doubleMatch;
	Matcher singleCap;
	private Board board;
	private BoardTile [][] tiles = new BoardTile[8][8];
	private PositionConverter convert;
	public boolean detCapture;
	private boolean lTurn;
	public boolean lightInCheck = false;
	public boolean darkInCheck = false;
	private String[] sMatch = {"singleMatch.group(1)","singleMatch.group(2)","singleMatch.group(3)","singleMatch.group(4)"};
	private String[] dMatch;
	private String cMatch;
	private BlockedChecker block;

	public MoveController(Board b){

		this.block = new BlockedChecker();
		this.convert = new PositionConverter();
		this.board = b;
		this.tiles = board.getTiles();
		detCapture = false;
		lTurn = true;

	}
	public void moveControl(String move,boolean verbose){

		if(move != null){
			tiles = board.getTiles();
			singleMatch = single.matcher(move.toLowerCase());
			doubleMatch = twoMove.matcher(move.toLowerCase());
			singleCap = capture.matcher(move.toLowerCase());
			
			
			

			if(singleMatch.find() && move.length() == 4){
				
				int toX = convert.convertX(singleMatch.group(3)) - convert.convertX(singleMatch.group(1)); 
				int toY = convert.convertY(singleMatch.group(2))  - convert.convertY(singleMatch.group(4));
				System.out.println(lightInCheck + " " + darkInCheck);
				
				
				detCapture = false;
				

				if(tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].isOccupied()){
					if(!tiles[convert.convertY(singleMatch.group(4))][convert.convertX(singleMatch.group(3))].isOccupied() &&
							!block.isBlocked(tiles, convert.convertX(singleMatch.group(3)), convert.convertY(singleMatch.group(4)), convert.convertX(singleMatch.group(1)), convert.convertY(singleMatch.group(2)))){
						
						
						if(lTurn && tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].getPiece().getColor().equalsIgnoreCase("l") ){
							board.check("d",detCapture,this);
							if(tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].getPiece().isValidLmove(toX, toY,detCapture,lightInCheck)){
								tiles[convert.convertY(singleMatch.group(4))][convert.convertX(singleMatch.group(3))].setPieceOn
								(tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].getPiece());
								tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].setPieceOff();
								
								lTurn = false;
							}

						}
						else if(!lTurn &&  tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].getPiece().getColor().equalsIgnoreCase("d")){
							board.check("l",detCapture,this);
							if(tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].getPiece().isValidDmove(toX, toY,detCapture,darkInCheck)){
								tiles[convert.convertY(singleMatch.group(4))][convert.convertX(singleMatch.group(3))].setPieceOn
								(tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].getPiece());
								tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].setPieceOff();
								
								lTurn = true;
							}

						}



						if(verbose){
							board.updateBoard(tiles);
						}
						else{
							board.nonVerboseUpdate(tiles);
						}
					}
					

				}
			
			}
			else if(doubleMatch.find() && move.length() == 8){
				int toX = convert.convertX(doubleMatch.group(3)) - convert.convertX(doubleMatch.group(1)); 
				int toY = convert.convertY(doubleMatch.group(2))  - convert.convertY(doubleMatch.group(4));
				int toX2 = convert.convertX(doubleMatch.group(5)) - convert.convertX(doubleMatch.group(7)); 
				int toY2 = convert.convertY(doubleMatch.group(6))  - convert.convertY(doubleMatch.group(8));


				if(lTurn && !tiles[convert.convertY(doubleMatch.group(4))][convert.convertX(doubleMatch.group(3))].isOccupied &&
						!tiles[convert.convertY(doubleMatch.group(8))][convert.convertX(doubleMatch.group(7))].isOccupied){
					System.out.println("made it");
					if(lTurn && tiles[convert.convertY(doubleMatch.group(2))][convert.convertX(doubleMatch.group(1))].getPiece().isValidLCastle(toX,toY,lightInCheck) &&
							lTurn && tiles[convert.convertY(doubleMatch.group(6))][convert.convertX(doubleMatch.group(5))].getPiece().isValidLCastle(toX2,toY2,lightInCheck)
							){
						

						tiles[convert.convertY(doubleMatch.group(4))][convert.convertX(doubleMatch.group(3))].setPieceOn
						(tiles[convert.convertY(doubleMatch.group(2))][convert.convertX(doubleMatch.group(1))].getPiece());
						tiles[convert.convertY(doubleMatch.group(2))][convert.convertX(doubleMatch.group(1))].setPieceOff();
						tiles[convert.convertY(doubleMatch.group(8))][convert.convertX(doubleMatch.group(7))].setPieceOn
						(tiles[convert.convertY(doubleMatch.group(6))][convert.convertX(doubleMatch.group(5))].getPiece());
						tiles[convert.convertY(doubleMatch.group(6))][convert.convertX(doubleMatch.group(5))].setPieceOff();

						lTurn = false;
					}
				}

				else if(!lTurn && !tiles[convert.convertY(doubleMatch.group(4))][convert.convertX(doubleMatch.group(3))].isOccupied &&
						!tiles[convert.convertY(doubleMatch.group(8))][convert.convertX(doubleMatch.group(7))].isOccupied){
					if(!lTurn && tiles[convert.convertY(doubleMatch.group(2))][convert.convertX(doubleMatch.group(1))].getPiece().isValidDCastle(toX,toY,darkInCheck) &&
							!lTurn && tiles[convert.convertY(doubleMatch.group(6))][convert.convertX(doubleMatch.group(5))].getPiece().isValidDCastle(toX2,toY2,darkInCheck)) { 

						System.out.println("made it");

						tiles[convert.convertY(doubleMatch.group(4))][convert.convertX(doubleMatch.group(3))].setPieceOn
						(tiles[convert.convertY(doubleMatch.group(2))][convert.convertX(doubleMatch.group(1))].getPiece());
						tiles[convert.convertY(doubleMatch.group(2))][convert.convertX(doubleMatch.group(1))].setPieceOff();
						tiles[convert.convertY(doubleMatch.group(8))][convert.convertX(doubleMatch.group(7))].setPieceOn
						(tiles[convert.convertY(doubleMatch.group(6))][convert.convertX(doubleMatch.group(5))].getPiece());
						tiles[convert.convertY(doubleMatch.group(6))][convert.convertX(doubleMatch.group(5))].setPieceOff();
						lTurn = true;
					}
				}

				if(verbose){
					board.updateBoard(tiles);
				}
				else{
					board.nonVerboseUpdate(tiles);
				}
			}




			else if(singleCap.find() && move.length() == 5){

				int toX = convert.convertX(singleMatch.group(3)) - convert.convertX(singleMatch.group(1)); 
				int toY = convert.convertY(singleMatch.group(2))  - convert.convertY(singleMatch.group(4));
				if(tiles[convert.convertY(singleMatch.group(4))][convert.convertX(singleMatch.group(3))].isOccupied()){
					detCapture = true;
//					board.check("d",detCapture,this);
//					board.check("l",detCapture,this);
					if(!tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].getPiece().getColor().equalsIgnoreCase(
							tiles[convert.convertY(singleMatch.group(4))][convert.convertX(singleMatch.group(3))].getPiece().getColor())
							){
						
						if(lTurn && tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].getPiece().getColor().equalsIgnoreCase("l")
								&& tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].getPiece().isValidLmove(toX, toY,detCapture,lightInCheck)){
							

							tiles[convert.convertY(singleMatch.group(4))][convert.convertX(singleMatch.group(3))].setPieceOn
							(tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].getPiece());
							tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].setPieceOff();
							//board.check("d",detCapture,this);
							lTurn = false;

						}
						else if(!lTurn && tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].getPiece().getColor().equalsIgnoreCase("d")
								&& tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].getPiece().isValidDmove(toX, toY,detCapture,darkInCheck)){
							
							tiles[convert.convertY(singleMatch.group(4))][convert.convertX(singleMatch.group(3))].setPieceOn
							(tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].getPiece());
							tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].setPieceOff();
							//board.check("l",detCapture,this);
							lTurn = true;
						}

					}

					if(verbose){
						board.updateBoard(tiles);
					}
					else{
						board.nonVerboseUpdate(tiles);
					}

				}
			}
			//board.check("d",detCapture,this);
			//board.check("l",detCapture,this);
		}
	}
	public void pieceMoveFile(ArrayList<String> moves, boolean verbose){

		for(String move : moves){

			if(move != null){
				tiles = board.getTiles();

				singleMatch = single.matcher(move.toLowerCase());
				doubleMatch = twoMove.matcher(move.toLowerCase());
				singleCap = capture.matcher(move.toLowerCase());
				tiles = board.getTiles();
				singleMatch = single.matcher(move.toLowerCase());
				doubleMatch = twoMove.matcher(move.toLowerCase());
				singleCap = capture.matcher(move.toLowerCase());
//				board.check("d",detCapture,this);
//				board.check("l",detCapture,this);

				if(singleMatch.find() && move.length() == 4){
					int toX = convert.convertX(singleMatch.group(3)) - convert.convertX(singleMatch.group(1)); 
					int toY = convert.convertY(singleMatch.group(2))  - convert.convertY(singleMatch.group(4));
					System.out.println(toX + toY);

					detCapture = false;

					if(tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].isOccupied()){
						if(!tiles[convert.convertY(singleMatch.group(4))][convert.convertX(singleMatch.group(3))].isOccupied() &&
								!block.isBlocked(tiles, convert.convertX(singleMatch.group(3)), convert.convertY(singleMatch.group(4)), convert.convertX(singleMatch.group(1)), convert.convertY(singleMatch.group(2)))){

							//board.check("d",detCapture,this);
							if(lTurn && tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].getPiece().getColor().equalsIgnoreCase("l") ){

								if(tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].getPiece().isValidLmove(toX, toY,detCapture,lightInCheck)){
									tiles[convert.convertY(singleMatch.group(4))][convert.convertX(singleMatch.group(3))].setPieceOn
									(tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].getPiece());

									tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].setPieceOff();
									//board.check("d",detCapture,this);
									lTurn = false;
								}

							}
							else if(!lTurn &&  tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].getPiece().getColor().equalsIgnoreCase("d")){
								//	board.check("l",detCapture,this);
								if(tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].getPiece().isValidDmove(toX, toY,detCapture,darkInCheck)){
									tiles[convert.convertY(singleMatch.group(4))][convert.convertX(singleMatch.group(3))].setPieceOn
									(tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].getPiece());

									tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].setPieceOff();
									//board.check("l",detCapture,this);
									lTurn = true;
								}

							}



							if(verbose){
								board.updateBoard(tiles);
							}
							else{
								board.nonVerboseUpdate(tiles);
							}
						}

					}
				}
				else if(doubleMatch.find() && move.length() == 8){
					int toX = convert.convertX(doubleMatch.group(3)) - convert.convertX(doubleMatch.group(1)); 
					int toY = convert.convertY(doubleMatch.group(2))  - convert.convertY(doubleMatch.group(4));
					int toX2 = convert.convertX(doubleMatch.group(5)) - convert.convertX(doubleMatch.group(7)); 
					int toY2 = convert.convertY(doubleMatch.group(6))  - convert.convertY(doubleMatch.group(8));
					if(!tiles[convert.convertX(doubleMatch.group(3))][convert.convertY(doubleMatch.group(4))].isOccupied() && 
							!tiles[convert.convertX(doubleMatch.group(7))][convert.convertY(doubleMatch.group(8))].isOccupied()){

						if(lTurn && tiles[convert.convertY(doubleMatch.group(2))][convert.convertX(doubleMatch.group(1))].getPiece().isValidLmove(toX, toY,detCapture,lightInCheck) && 
								lTurn && tiles[convert.convertY(doubleMatch.group(6))][convert.convertX(doubleMatch.group(5))].getPiece().isValidLmove(toX2, toY2,detCapture,lightInCheck) &&
								tiles[convert.convertY(doubleMatch.group(2))][convert.convertX(doubleMatch.group(1))].getPiece().getColor().equalsIgnoreCase("l") &&
								tiles[convert.convertY(doubleMatch.group(6))][convert.convertX(doubleMatch.group(5))].getPiece().getColor().equalsIgnoreCase("l")){


							tiles[convert.convertY(doubleMatch.group(4))][convert.convertX(doubleMatch.group(3))].setPieceOn
							(tiles[convert.convertY(doubleMatch.group(2))][convert.convertX(doubleMatch.group(1))].getPiece());

							tiles[convert.convertY(doubleMatch.group(8))][convert.convertX(doubleMatch.group(7))].setPieceOn
							(tiles[convert.convertY(doubleMatch.group(6))][convert.convertX(doubleMatch.group(5))].getPiece());

							tiles[convert.convertY(doubleMatch.group(2))][convert.convertX(doubleMatch.group(1))].setPieceOff();
							tiles[convert.convertY(doubleMatch.group(6))][convert.convertX(doubleMatch.group(5))].setPieceOff();


							lTurn = false;

						}
						else if(!lTurn && tiles[convert.convertY(doubleMatch.group(2))][convert.convertX(doubleMatch.group(1))].getPiece().isValidLmove(toX, toY,detCapture,lightInCheck) && 
								lTurn && tiles[convert.convertY(doubleMatch.group(6))][convert.convertX(doubleMatch.group(5))].getPiece().isValidLmove(toX2, toY2,detCapture,lightInCheck) &&
								tiles[convert.convertY(doubleMatch.group(2))][convert.convertX(doubleMatch.group(1))].getPiece().getColor().equalsIgnoreCase("d") &&
								tiles[convert.convertY(doubleMatch.group(6))][convert.convertX(doubleMatch.group(5))].getPiece().getColor().equalsIgnoreCase("d")){


							tiles[convert.convertY(doubleMatch.group(4))][convert.convertX(doubleMatch.group(3))].setPieceOn
							(tiles[convert.convertY(doubleMatch.group(2))][convert.convertX(doubleMatch.group(1))].getPiece());

							tiles[convert.convertY(doubleMatch.group(8))][convert.convertX(doubleMatch.group(7))].setPieceOn
							(tiles[convert.convertY(doubleMatch.group(6))][convert.convertX(doubleMatch.group(5))].getPiece());

							tiles[convert.convertY(doubleMatch.group(2))][convert.convertX(doubleMatch.group(1))].setPieceOff();
							tiles[convert.convertY(doubleMatch.group(6))][convert.convertX(doubleMatch.group(5))].setPieceOff();
							System.out.println("dark");
							lTurn = true;
						}


						if(verbose){
							board.updateBoard(tiles);
						}
						else{
							board.nonVerboseUpdate(tiles);
						}
					}

				}
				else if(singleCap.find() && move.length() == 5){
					int toX = convert.convertX(singleMatch.group(3)) - convert.convertX(singleMatch.group(1)); 
					int toY = convert.convertY(singleMatch.group(2))  - convert.convertY(singleMatch.group(4));
					if(tiles[convert.convertY(singleMatch.group(4))][convert.convertX(singleMatch.group(3))].isOccupied()){
						detCapture = true;

						if(!tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].getPiece().getColor().equalsIgnoreCase(
								tiles[convert.convertY(singleMatch.group(4))][convert.convertX(singleMatch.group(3))].getPiece().getColor())
								&& tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].getPiece().isValidLmove(toX, toY,detCapture,lightInCheck)){




							if(lTurn && tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].getPiece().getColor().equalsIgnoreCase("l")){
								lTurn = false;
								tiles[convert.convertY(singleMatch.group(4))][convert.convertX(singleMatch.group(3))].setPieceOn
								(tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].getPiece());
								tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].setPieceOff();
								//board.check("d",detCapture,this);

								System.out.println("lTurn");
							}
							else if(!lTurn && tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].getPiece().getColor().equalsIgnoreCase("d")){
								lTurn = true;
								tiles[convert.convertY(singleMatch.group(4))][convert.convertX(singleMatch.group(3))].setPieceOn
								(tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].getPiece());
								tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].setPieceOff();
								//board.check("l",detCapture,this);

							}

						}

						if(verbose){
							board.updateBoard(tiles);
						}
						else{
							board.nonVerboseUpdate(tiles);
						}

					}
				}
			}
			else{
				board.updateBoard(tiles);
			}
		}
	}

}
