package controllers;

import gameobjects.Board;
import gameobjects.BoardTile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utilities.PositionConverter;

public class MoveController {

	private Board board;
	private BoardTile [][] tiles = new BoardTile[8][8];
	private PositionConverter convert;

	public MoveController(Board b){

		this.convert = new PositionConverter();
		this.board = b;
		this.tiles = board.getTiles();

	}
	public void moveControl(String move){

		tiles = board.getTiles();
		Pattern single = Pattern.compile("([a-h])([1-8])([a-h])([1-8])");
		Matcher singleMatch = single.matcher(move.toLowerCase());
		Pattern twoMove = Pattern.compile("([a-h])([1-8])([a-h])([1-8])([a-h])([1-8])([a-h])([1-8])");
		Matcher doubleMatch = twoMove.matcher(move.toLowerCase());
		Pattern capture = Pattern.compile("([a-h])([1-8])([a-h])([1-8])([*])");
		Matcher singleCap = capture.matcher(move.toLowerCase());

		if(singleMatch.find() && move.length() == 4){
			int moveXdiff = convert.convertX(singleMatch.group(3)) - convert.convertX(singleMatch.group(1));
			int moveYdiff = convert.convertY(singleMatch.group(4)) - convert.convertY(singleMatch.group(2));
			System.out.println(moveXdiff + " " +moveYdiff);

			if(!tiles[convert.convertX(singleMatch.group(3))][convert.convertY(singleMatch.group(4))].isOccupied() && 
					tiles[convert.convertX(singleMatch.group(1))][convert.convertY(singleMatch.group(2))].getPiece().isValidMove(moveXdiff, moveYdiff)){
				
				
				tiles[convert.convertX(singleMatch.group(3))][convert.convertY(singleMatch.group(4))].setPieceOn
				(tiles[convert.convertX(singleMatch.group(1))][convert.convertY(singleMatch.group(2))].getPiece());

				tiles[convert.convertX(singleMatch.group(1))][convert.convertY(singleMatch.group(2))].setPieceOff();

				board.updateBoard(tiles);
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

				board.updateBoard(tiles);
			}

		}
		else if(singleCap.find() && move.length() == 5){
			if(tiles[convert.convertX(singleMatch.group(3))][convert.convertY(singleMatch.group(4))].isOccupied()){
				if(!tiles[convert.convertX(singleMatch.group(3))][convert.convertY(singleMatch.group(4))].getPiece().getColor().equalsIgnoreCase(
						tiles[convert.convertX(singleMatch.group(1))][convert.convertY(singleMatch.group(2))].getPiece().getColor())){

					tiles[convert.convertX(singleMatch.group(3))][convert.convertY(singleMatch.group(4))].setPieceOn
					(tiles[convert.convertX(singleMatch.group(1))][convert.convertY(singleMatch.group(2))].getPiece());

					tiles[convert.convertX(singleMatch.group(1))][convert.convertY(singleMatch.group(2))].setPieceOff();


				}
				else{
					System.out.println("Cant capture your own color");
				}

				board.updateBoard(tiles);
			}

			else{
				System.out.println("Space is empty");
			}

		}
		else{
			System.out.println("Invalid Move");
		}

	}
	public void pieceMoveFile(String[] moves){
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

					if(!tiles[convert.convertX(singleMatch.group(3))][convert.convertY(singleMatch.group(4))].isOccupied()){
						tiles[convert.convertX(singleMatch.group(3))][convert.convertY(singleMatch.group(4))].setPieceOn
						(tiles[convert.convertX(singleMatch.group(1))][convert.convertY(singleMatch.group(2))].getPiece());

						tiles[convert.convertX(singleMatch.group(1))][convert.convertY(singleMatch.group(2))].setPieceOff();

						board.updateBoard(tiles);
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

						board.updateBoard(tiles);
					}

				}
				else if(singleCap.find() && move.length() == 5){
					if(tiles[convert.convertX(singleMatch.group(3))][convert.convertY(singleMatch.group(4))].isOccupied()){
						if(!tiles[convert.convertX(singleMatch.group(3))][convert.convertY(singleMatch.group(4))].getPiece().getColor().equalsIgnoreCase(
								tiles[convert.convertX(singleMatch.group(1))][convert.convertY(singleMatch.group(2))].getPiece().getColor())){

							tiles[convert.convertX(singleMatch.group(3))][convert.convertY(singleMatch.group(4))].setPieceOn
							(tiles[convert.convertX(singleMatch.group(1))][convert.convertY(singleMatch.group(2))].getPiece());

							tiles[convert.convertX(singleMatch.group(1))][convert.convertY(singleMatch.group(2))].setPieceOff();


						}
						else{
							System.out.println("Cant capture your own color");
						}

						board.updateBoard(tiles);
					}

					else{
						System.out.println("Space is empty");
					}

				}
				else{
					System.out.println("Invalid Move");
				}

			}
		}
	}
	public boolean validMove(int destX,int destY, BoardTile d){

		if(!d.isOccupied()){
			return false;
		}
		else{
			return true;
		}

	}

}
