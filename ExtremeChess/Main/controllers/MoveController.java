package controllers;

import gameobjects.Board;
import gameobjects.BoardTile;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utilities.PositionConverter;

public class MoveController {

	private Board board;
	private BoardTile [][] tiles = new BoardTile[8][8];
	private PositionConverter convert;
	private boolean detCapture;

	public MoveController(Board b){

		this.convert = new PositionConverter();
		this.board = b;
		this.tiles = board.getTiles();
		detCapture = false;

	}
	public void moveControl(String move,boolean verbose){
		
		if(move != null){
			tiles = board.getTiles();
			Pattern single = Pattern.compile("([a-h])([1-8])([a-h])([1-8])");
			Matcher singleMatch = single.matcher(move.toLowerCase());
			Pattern twoMove = Pattern.compile("([a-h])([1-8])([a-h])([1-8])([a-h])([1-8])([a-h])([1-8])");
			Matcher doubleMatch = twoMove.matcher(move.toLowerCase());
			Pattern capture = Pattern.compile("([a-h])([1-8])([a-h])([1-8])([*])");
			Matcher singleCap = capture.matcher(move.toLowerCase());

			if(singleMatch.find() && move.length() == 4){
				int toX = convert.convertX(singleMatch.group(3)) - convert.convertX(singleMatch.group(1)); 
				int toY = convert.convertY(singleMatch.group(2))  - convert.convertY(singleMatch.group(4));
				detCapture = false;
				if(tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].isOccupied()){
					if(!tiles[convert.convertY(singleMatch.group(4))][convert.convertX(singleMatch.group(3))].isOccupied()&&
							tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].getPiece().isValidMove(toX, toY,detCapture)){

						tiles[convert.convertY(singleMatch.group(4))][convert.convertX(singleMatch.group(3))].setPieceOn
						(tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].getPiece());

						tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].setPieceOff();
						
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
				if(!tiles[convert.convertX(doubleMatch.group(3))][convert.convertY(doubleMatch.group(4))].isOccupied() && 
						!tiles[convert.convertX(doubleMatch.group(7))][convert.convertY(doubleMatch.group(8))].isOccupied()){

					tiles[convert.convertX(doubleMatch.group(3))][convert.convertY(doubleMatch.group(4))].setPieceOn
					(tiles[convert.convertX(doubleMatch.group(1))][convert.convertY(doubleMatch.group(2))].getPiece());

					tiles[convert.convertX(doubleMatch.group(7))][convert.convertY(doubleMatch.group(8))].setPieceOn
					(tiles[convert.convertX(doubleMatch.group(5))][convert.convertY(doubleMatch.group(6))].getPiece());

					tiles[convert.convertX(doubleMatch.group(1))][convert.convertY(doubleMatch.group(2))].setPieceOff();
					tiles[convert.convertX(doubleMatch.group(5))][convert.convertY(doubleMatch.group(6))].setPieceOff();

					if(verbose){
						board.updateBoard(tiles);
					}
					else{
						board.nonVerboseUpdate(tiles);
					}
				}

			}
			else if(singleCap.find() && move.length() == 5){
				//System.out.println(tiles[convert.convertY(singleMatch.group(4))][convert.convertX(singleMatch.group(3))].getPiece().getColor() +" " + tiles[convert.convertY(singleMatch.group(2))][convert.convertY(singleMatch.group(1))].getPiece().getColor());
				int toX = convert.convertX(singleMatch.group(3)) - convert.convertX(singleMatch.group(1)); 
				int toY = convert.convertY(singleMatch.group(2))  - convert.convertY(singleMatch.group(4));
				if(tiles[convert.convertY(singleMatch.group(4))][convert.convertX(singleMatch.group(3))].isOccupied()){
					detCapture = true;

					if(!tiles[convert.convertY(singleMatch.group(4))][convert.convertX(singleMatch.group(3))].getPiece().getColor().equalsIgnoreCase(
							tiles[convert.convertY(singleMatch.group(2))][convert.convertY(singleMatch.group(1))].getPiece().getColor())
							&& tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].getPiece().isValidMove(toX, toY,detCapture)){

						tiles[convert.convertY(singleMatch.group(4))][convert.convertX(singleMatch.group(3))].setPieceOn
						(tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].getPiece());

						tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].setPieceOff();
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
	}
	public void pieceMoveFile(ArrayList<String> moves, boolean verbose){
		for(String move : moves){
		
			if(move != null){
				tiles = board.getTiles();
				Pattern single = Pattern.compile("([a-h])([1-8])([a-h])([1-8])");
				Matcher singleMatch = single.matcher(move.toLowerCase());
				Pattern twoMove = Pattern.compile("([a-h])([1-8])([a-h])([1-8])([a-h])([1-8])([a-h])([1-8])");
				Matcher doubleMatch = twoMove.matcher(move.toLowerCase());
				Pattern capture = Pattern.compile("([a-h])([1-8])([a-h])([1-8])([*])");
				Matcher singleCap = capture.matcher(move.toLowerCase());

				if(singleMatch.find() && move.length() == 4){
					int toX = convert.convertX(singleMatch.group(3)) - convert.convertX(singleMatch.group(1)); 
					int toY = convert.convertY(singleMatch.group(2))  - convert.convertY(singleMatch.group(4));
					detCapture = false;
					if(tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].isOccupied()){
						if(!tiles[convert.convertY(singleMatch.group(4))][convert.convertX(singleMatch.group(3))].isOccupied()&&
								tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].getPiece().isValidMove(toX, toY,detCapture)){


							tiles[convert.convertY(singleMatch.group(4))][convert.convertX(singleMatch.group(3))].setPieceOn
							(tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].getPiece());

							tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].setPieceOff();


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
					if(!tiles[convert.convertX(doubleMatch.group(3))][convert.convertY(doubleMatch.group(4))].isOccupied() && 
							!tiles[convert.convertX(doubleMatch.group(7))][convert.convertY(doubleMatch.group(8))].isOccupied()){

						tiles[convert.convertX(doubleMatch.group(3))][convert.convertY(doubleMatch.group(4))].setPieceOn
						(tiles[convert.convertX(doubleMatch.group(1))][convert.convertY(doubleMatch.group(2))].getPiece());

						tiles[convert.convertX(doubleMatch.group(7))][convert.convertY(doubleMatch.group(8))].setPieceOn
						(tiles[convert.convertX(doubleMatch.group(5))][convert.convertY(doubleMatch.group(6))].getPiece());

						tiles[convert.convertX(doubleMatch.group(1))][convert.convertY(doubleMatch.group(2))].setPieceOff();
						tiles[convert.convertX(doubleMatch.group(5))][convert.convertY(doubleMatch.group(6))].setPieceOff();

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
						if(!tiles[convert.convertY(singleMatch.group(4))][convert.convertX(singleMatch.group(3))].getPiece().getColor().equalsIgnoreCase(
								tiles[convert.convertY(singleMatch.group(2))][convert.convertY(singleMatch.group(1))].getPiece().getColor())
								&& tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].getPiece().isValidMove(toX, toY,detCapture)){

							tiles[convert.convertY(singleMatch.group(4))][convert.convertX(singleMatch.group(3))].setPieceOn
							(tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(1))].getPiece());

							tiles[convert.convertY(singleMatch.group(2))][convert.convertX(singleMatch.group(3))].setPieceOff();


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
