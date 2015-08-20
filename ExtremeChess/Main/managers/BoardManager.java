package managers;

import java.util.Scanner;

import utilities.FileIo;
import utilities.Parser;
import controllers.BoardController;
import controllers.MoveController;
import gameobjects.Board;


public class BoardManager {

	private String [] letts = {"k","q","n","r","b","p"};
	private String [] xLetts = {"a","b","c","d","e","f","g","h"};
	private FileIo fileCreate;
	private Parser parse;
	Board board;
	String[] moves;
	private String[] movesList = new String [20];
	BoardController boardControl;
	MoveController moveControl;
	private boolean mover;
	private boolean place;
	private boolean run;

	public BoardManager(String[] file){

		moves = file;
		createBoard();
		createBoardControl();
		createMoveControl();
		run();

		

	}
	private void createBoard(){
		board = new Board(moves);
	}
	private void createBoardControl(){

		boardControl = new BoardController(board);	
	}

	private void createMoveControl(){
		moveControl = new MoveController(board);
	}
	private void run(){
		boardControl.placePieces();
		if(moves.length > 0 && moves[0].equalsIgnoreCase("v")){
			createMovesList();
			moveControl.pieceMoveFile(movesList);
		}
		else{
		Scanner stan = new Scanner(System.in);
		String input;
		run = true;
		while(run){
			
		input = stan.nextLine();
		
				moveControl.moveControl(input);
			
		}

		System.out.println("finish");
		}

	}
	public void placeOrMove(String move){

		for(int i = 0; i < letts.length; ++ i){

			if(move.substring(0, 1).equalsIgnoreCase(letts[i])){

				place = true;

			}
		}

		for(int i = 0; i < xLetts.length; ++ i){

			if(move.substring(0, 1).equalsIgnoreCase(xLetts[i])){

				mover = true;

			}
		}
	}
	public void createMovesList(){
		fileCreate = new FileIo(moves);
		parse = new Parser(fileCreate.getMovesFile());
		movesList = parse.readFile();
	}
}

