package gameobjects;

import controllers.BoardController;

public class Board {
	
	private BoardController control;
	private String[] moves;
	private int boardSize = 8;
	
	public Board(String[] file){
		
		moves = file;
		control = new BoardController(this);
		
		generateBoard();
		
	}
	
	public void generateBoard(){
		for (int row = 0; row < boardSize; row++)
	      {
	          System.out.println("");
	          System.out.println("---------------------------------");

	          for (int column = 0; column < boardSize; column++)
	          {
	              System.out.print("| " + " " + " ");
	              
	          }   
	          System.out.print("|");
	    }
	    System.out.println("");
	    System.out.println("---------------------------------");
	   } 
	}


