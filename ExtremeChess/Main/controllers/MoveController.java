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
	public boolean lightInCheck;
	public void setLightInCheck(boolean lightInCheck) {
		this.lightInCheck = lightInCheck;
	}
	public boolean darkInCheck;
	public void setDarkInCheck(boolean darkInCheck) {
		this.darkInCheck = darkInCheck;
	}
	private String[] sMatch = {"singleMatch.group(1)","singleMatch.group(2)","singleMatch.group(3)","singleMatch.group(4)"};
	private String[] dMatch;
	private String cMatch;
	private BoardController boardControl;
	private BlockedChecker block;
	private boolean detCap;

	public MoveController(BoardController b){

		this.block = new BlockedChecker();
		this.convert = new PositionConverter();
		this.boardControl = b;
		this.board = boardControl.getBoard();
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
				detCapture = false;
				if(tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].isOccupied()){
					if(!tiles[convert.convertY(singleMatch.group(4))][convert.convertX(singleMatch.group(3))].isOccupied() &&
							!block.isBlocked(tiles, convert.convertX(singleMatch.group(3)), convert.convertY(singleMatch.group(4)), convert.convertX(singleMatch.group(1)), convert.convertY(singleMatch.group(2)))){
						if(lTurn && tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].getPiece().getColor().equalsIgnoreCase("l") ){
							if(tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].getPiece().isValidLmove(toX, toY,detCapture,lightInCheck)){
								tiles[convert.convertY(singleMatch.group(4))][convert.convertX(singleMatch.group(3))].setPieceOn
								(tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].getPiece());
								tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].setPieceOff();
								if(boardControl.checkL("l",detCapture,this)){
									tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].setPieceOn
									(tiles[convert.convertY(singleMatch.group(4))][convert.convertX(singleMatch.group(3))].getPiece());
									tiles[convert.convertY(singleMatch.group(4))][convert.convertX(singleMatch.group(3))].setPieceOff();
									System.out.println("King still in check try again.");
									lTurn = true;
								}
								else if(!boardControl.checkL("l",detCapture,this)){

									lTurn = false;
								}
							}
						}
						else if(!lTurn &&  tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].getPiece().getColor().equalsIgnoreCase("d")  ){
							if(tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].getPiece().isValidDmove(toX, toY,detCapture,darkInCheck)){
								tiles[convert.convertY(singleMatch.group(4))][convert.convertX(singleMatch.group(3))].setPieceOn
								(tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].getPiece());
								tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].setPieceOff();
								if(boardControl.checkD("d",detCapture,this)){
									tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].setPieceOn
									(tiles[convert.convertY(singleMatch.group(4))][convert.convertX(singleMatch.group(3))].getPiece());
									tiles[convert.convertY(singleMatch.group(4))][convert.convertX(singleMatch.group(3))].setPieceOff();
									System.out.println("King still in check try again.");
									lTurn = false;
									boardControl.updateBoard(tiles);
								}
								else{

									lTurn = true;
								}
							}

						}
						if(verbose){
							boardControl.updateBoard(tiles);
						}
						else{
							boardControl.nonVerboseUpdate(tiles);
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

					if(lTurn &&tiles[convert.convertY(doubleMatch.group(2))][convert.convertX(doubleMatch.group(1))].isOccupied && 
							tiles[convert.convertY(doubleMatch.group(2))][convert.convertX(doubleMatch.group(1))].getPiece().isValidLCastle(toX2,toY2,lightInCheck) &&
							lTurn && tiles[convert.convertY(doubleMatch.group(6))][convert.convertX(doubleMatch.group(5))].getPiece().isValidLCastle(toX,toY,lightInCheck)
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
					boardControl.updateBoard(tiles);
				}
				else{
					boardControl.nonVerboseUpdate(tiles);
				}
			}

			else if(singleCap.find() && move.length() == 5){

				int toX = convert.convertX(singleMatch.group(3)) - convert.convertX(singleMatch.group(1)); 
				int toY = convert.convertY(singleMatch.group(2))  - convert.convertY(singleMatch.group(4));
				if(tiles[convert.convertY(singleMatch.group(4))][convert.convertX(singleMatch.group(3))].isOccupied()){
					detCapture = true;

					if(!tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].getPiece().getColor().equalsIgnoreCase(
							tiles[convert.convertY(singleMatch.group(4))][convert.convertX(singleMatch.group(3))].getPiece().getColor())
							){

						if(lTurn && tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].getPiece().getColor().equalsIgnoreCase("l")
								&& tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].getPiece().isValidLmove(toX, toY,detCapture,lightInCheck)){


							tiles[convert.convertY(singleMatch.group(4))][convert.convertX(singleMatch.group(3))].setPieceOn
							(tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].getPiece());
							tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].setPieceOff();
							lTurn = false;

						}
						else if(!lTurn && tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].getPiece().getColor().equalsIgnoreCase("d")
								&& tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].getPiece().isValidDmove(toX, toY,detCapture,darkInCheck)){

							tiles[convert.convertY(singleMatch.group(4))][convert.convertX(singleMatch.group(3))].setPieceOn
							(tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].getPiece());
							tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].setPieceOff();
							lTurn = true;
						}
					}

					if(verbose){
						boardControl.updateBoard(tiles);
					}
					else{
						boardControl.nonVerboseUpdate(tiles);
					}

				}
			}
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

				if(singleMatch.find() && move.length() == 4){

					int toX = convert.convertX(singleMatch.group(3)) - convert.convertX(singleMatch.group(1)); 
					int toY = convert.convertY(singleMatch.group(2))  - convert.convertY(singleMatch.group(4));
					detCapture = false;

					if(tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].isOccupied()){
						if(!tiles[convert.convertY(singleMatch.group(4))][convert.convertX(singleMatch.group(3))].isOccupied() &&
								!block.isBlocked(tiles, convert.convertX(singleMatch.group(3)), convert.convertY(singleMatch.group(4)), convert.convertX(singleMatch.group(1)), convert.convertY(singleMatch.group(2)))){

							if(lTurn && tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].getPiece().getColor().equalsIgnoreCase("l") ){

								if(tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].getPiece().isValidLmove(toX, toY,detCapture,lightInCheck)){

									tiles[convert.convertY(singleMatch.group(4))][convert.convertX(singleMatch.group(3))].setPieceOn
									(tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].getPiece());
									tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].setPieceOff();
									if(boardControl.checkL("l",detCapture,this)){
										tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].setPieceOn
										(tiles[convert.convertY(singleMatch.group(4))][convert.convertX(singleMatch.group(3))].getPiece());
										tiles[convert.convertY(singleMatch.group(4))][convert.convertX(singleMatch.group(3))].setPieceOff();
										System.out.println("King still in check try again.");
										lTurn = true;
									}
									else if(!boardControl.checkL("l",detCapture,this)){
										System.out.println( "Moved " + singleMatch.group(1) + singleMatch.group(2)+ " to " + singleMatch.group(3)  + singleMatch.group(4)); 
										lTurn = false;
									}
								}
							}

							else if(!lTurn &&  tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].getPiece().getColor().equalsIgnoreCase("d")  ){

								if(tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].getPiece().isValidDmove(toX, toY,detCapture,darkInCheck)){
									tiles[convert.convertY(singleMatch.group(4))][convert.convertX(singleMatch.group(3))].setPieceOn
									(tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].getPiece());
									tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].setPieceOff();
									boardControl.updateBoard(tiles);

									if(boardControl.checkD("d",detCapture,this)){
										tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].setPieceOn
										(tiles[convert.convertY(singleMatch.group(4))][convert.convertX(singleMatch.group(3))].getPiece());
										tiles[convert.convertY(singleMatch.group(4))][convert.convertX(singleMatch.group(3))].setPieceOff();
										System.out.println("King still in check try again.");
										lTurn = false;
										boardControl.updateBoard(tiles);
									}
									else{
										System.out.println( "Moved " + singleMatch.group(1) + singleMatch.group(2)+ " to " + singleMatch.group(3) + singleMatch.group(4)); 
										lTurn = true;
									}
								}
							}

							if(verbose){
								boardControl.updateBoard(tiles); 
							}
							else{
								boardControl.nonVerboseUpdate(tiles);
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

						if(lTurn &&tiles[convert.convertY(doubleMatch.group(2))][convert.convertX(doubleMatch.group(1))].isOccupied && 
								tiles[convert.convertY(doubleMatch.group(2))][convert.convertX(doubleMatch.group(1))].getPiece().isValidLCastle(toX2,toY2,lightInCheck) &&
								lTurn && tiles[convert.convertY(doubleMatch.group(6))][convert.convertX(doubleMatch.group(5))].getPiece().isValidLCastle(toX,toY,lightInCheck)
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
						boardControl.updateBoard(tiles);
					}
					else{
						boardControl.nonVerboseUpdate(tiles);
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

							}

							else if(!lTurn && tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].getPiece().getColor().equalsIgnoreCase("d")){

								lTurn = true;
								tiles[convert.convertY(singleMatch.group(4))][convert.convertX(singleMatch.group(3))].setPieceOn
								(tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].getPiece());
								tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].setPieceOff();

							}
						}

						if(verbose){
							boardControl.updateBoard(tiles);
						}
						else{
							boardControl.nonVerboseUpdate(tiles);
						}
					}
				}
			}
			else{
				boardControl.updateBoard(tiles);
			}
		}
	}
}
