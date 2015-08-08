package controllers;

import java.awt.event.KeyEvent;
import java.util.Scanner;

import utilities.MoveAnalyzer;
import utilities.PlayerMoveAnalyzer;



public class PlayerController {
	private Scanner scam;
	private String [] moves;
	
	public PlayerController(){
		moves = new String[1];
		System.out.println("Welcome to chess! Enter your First Move or Press enter twice to exit at any time.");
		scam = new Scanner(System.in);
		String pMove = scam.nextLine();
		moves[0] = pMove;
		while(!pMove.isEmpty()){
			
			System.out.println("Next Move");
			pMove = scam.nextLine();
			if(!pMove.isEmpty()){
			moves = addToMoves(moves,pMove);
			}
			
			
		}
		
		PlayerMoveAnalyzer playerAnalyze  = new PlayerMoveAnalyzer(moves);
	
		System.out.println("Thanks for Playing");
	}
	
	public String[] addToMoves(String[] moves, String move){
		String[] temp = new String[moves.length + 1];
		for(int i = 0; i < moves.length; ++i){
			temp[i] = moves[i];
		}
		temp[temp.length - 1] = move;
		moves = temp;
		
		return moves;
		
	}
	

}
