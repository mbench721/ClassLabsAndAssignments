package managers;

import java.util.ArrayList;
import java.util.Scanner;

import sun.security.util.Length;
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
	ArrayList<String> moves = new ArrayList<String>();;
	BoardController boardControl;
	MoveController moveControl;
	private boolean verbose;
	public BoardManager(String[] file){

		for(String conv : file){
			moves.add(conv);
		}
		createBoard();
		createBoardControl();
		createMoveControl();
		run();

	}
	private void createBoard(){
		board = new Board();

	}
	private void createBoardControl(){

		boardControl = new BoardController(board);	
	}

	private void createMoveControl(){
		moveControl = new MoveController(board);
	}
	private void run(){

		boardControl.placePieces();

		if(moves.size() >= 1 && moves.get(0).equalsIgnoreCase("v")){

			verbose = true;	
		}
		else {

			verbose = false;
		}

		if(verbose && moves.get(0).equalsIgnoreCase("v") && moves.size() >=2){

			createMovesList();

			moveControl.pieceMoveFile(moves, verbose);
		}
		else if(verbose && moves.get(0).equalsIgnoreCase("v") && moves.size() ==1){

			Scanner stan = new Scanner(System.in);
			String input;
			input = stan.nextLine();
			moveControl.moveControl(input,verbose);

			while(!input.isEmpty()){
				input = stan.nextLine();
				moveControl.moveControl(input,verbose);

			}

		}
		else if(!verbose && moves.size() == 1 && !moves.get(0).equalsIgnoreCase("v")){

			createMovesList();
			moveControl.pieceMoveFile(moves,verbose);
			board.generateBoard();
		}
		else{

			Scanner stan = new Scanner(System.in);
			String input;

			input = stan.nextLine();
			moveControl.moveControl(input,verbose);

			while(!input.isEmpty()){
				input = stan.nextLine();
				moveControl.moveControl(input,verbose);
			}
			board.generateBoard();
		}

		System.out.println("finish");
	}
	public void createMovesList(){
		fileCreate = new FileIo(moves);
		parse = new Parser(fileCreate.getMovesFile());
		moves = parse.readFile();
	}

}

