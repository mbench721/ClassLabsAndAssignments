package utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import gameobjects.BoardTile;
import gameobjects.Piece;

public class PositionConverter {
	private int convertedY;
	private int convertedX;
	private Piece selected;
	
	Pattern single = Pattern.compile("([a-h])([1-8])([a-h])([1-8])");
	Pattern twoMove = Pattern.compile("([a-h])([1-8])([a-h])([1-8])([a-h])([1-8])([a-h])([1-8])");
	Pattern capture = Pattern.compile("([a-h])([1-8])([a-h])([1-8])([*])");
	
	
	
	public boolean matchPattern(String move){
		
		Matcher singleMatch = single.matcher(move.toLowerCase());
		Matcher doubleMatch = twoMove.matcher(move.toLowerCase());
		Matcher singleCap = capture.matcher(move.toLowerCase());
		
		if(singleMatch.find()){
			return true;
		}
		else if(doubleMatch.find()){
			return true;
		}
		else if(singleCap.find()){
			return true;
		}
		else{
			return false;	
		}
	
		
	}
	
	public Piece getTilePiece(BoardTile[][] t,String x, String y){
		selected = t[convertY(y)][convertX(x)].getPiece();
		return selected;
	}

	public int convertX(String x){
		convertedX = 0;

		if(x.equalsIgnoreCase("b")){
			convertedX = 1;

		}
		else if(x.equalsIgnoreCase("c")){
			convertedX = 2;

		}
		else if(x.equalsIgnoreCase("d")){
			convertedX = 3;

		}
		else if(x.equalsIgnoreCase("e")){
			convertedX = 4;

		}
		else if(x.equalsIgnoreCase("f")){
			convertedX = 5;

		}
		else if(x.equalsIgnoreCase("g")){
			convertedX = 6;

		}
		else if(x.equalsIgnoreCase("h")){
			convertedX = 7;

		}
		


		return convertedX;

	}
	public int convertY(String y){
		convertedY = 0;
		
		if(y.equalsIgnoreCase("2")){
			convertedY = 1;

		}
		else if(y.equalsIgnoreCase("3")){
			convertedY = 2;

		}
		else if(y.equalsIgnoreCase("4")){
			convertedY = 3;

		}
		else if(y.equalsIgnoreCase("5")){
			convertedY = 4;

		}
		else if(y.equalsIgnoreCase("6")){
			convertedY = 5;

		}
		else if(y.equalsIgnoreCase("7")){
			convertedY = 6;

		}
		else if(y.equalsIgnoreCase("8")){
			convertedY = 7;

		}
	
	
		
		

		return convertedY;

	}

}
