package utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlayerMoveAnalyzer {
	private String[] pMoves;
	
	public PlayerMoveAnalyzer(String[] moves){
		
		this.pMoves = moves;
		moveChecker(pMoves);
	}
	public void moveChecker(String[] moves){

		for(String move : moves){
		    
			if(move != null){
				Pattern placeByPiece = Pattern.compile("([k|q|b|n|r|p])([l|d])([a-h])([1-8])");
				Matcher piecePlace= placeByPiece.matcher(move.toLowerCase());
				Pattern single = Pattern.compile("([a-h])([1-8])([a-h])([1-8])");
				Matcher singleMatch = single.matcher(move.toLowerCase());
				Pattern twoMove = Pattern.compile("([a-h])([1-8])([a-h])([1-8])([a-h])([1-8])([a-h])([1-8])");
				Matcher doubleMatch = twoMove.matcher(move.toLowerCase());
				Pattern capture = Pattern.compile("([a-h])([1-8])([a-h])([1-8])([*])");
				Matcher singleCap = capture.matcher(move.toLowerCase());

				if(piecePlace.find() && move.length() == 4){
					System.out.println("Place a " + checkColor(piecePlace.group(2)) + " " +  checkPiece(piecePlace.group(1)) + " on "  +  piecePlace.group(3) + piecePlace.group(4));

				}
				else if(doubleMatch.find() && move.length() == 8){
					System.out.println("Move the piece at location " + doubleMatch.group(1) + doubleMatch.group(2)  + " to "  + 
							doubleMatch.group(3)   + doubleMatch.group(4) + " and the piece at location " + doubleMatch.group(5) + doubleMatch.group(6)  + " to " +
							doubleMatch.group(7) + doubleMatch.group(8));
				}
				else if(singleMatch.find() && move.length() == 4){
					System.out.println("Move the piece at location " + singleMatch.group(1) + singleMatch.group(2)+ " to " + singleMatch.group(3) + singleMatch.group(4));

				}

				
				else if(singleCap.find() && move.length() == 5){
					System.out.println("Move the piece at location " + singleMatch.group(1) + singleMatch.group(2)+ " to " + singleMatch.group(3) + singleMatch.group(4) + " and captured it!");

				}
				
				
				else {
					System.out.println("Invalid Move");
				}
			}
		}
	}

	public String checkColor(String s){
		String colorChoice = new String();
		switch(s.toLowerCase()){
		case("l"):
			colorChoice = "Light";
		break;

		case("d"):
			colorChoice  ="Dark";
		break;

		default:
			break;
		}
		return colorChoice;
	}
	public String checkPiece(String p){
		String pieceChoice = new String();

		switch(p.toLowerCase()){
		case("k"):
			pieceChoice = "King";
		break;
		case("q"):
			pieceChoice  ="Queen";
		break;
		case("b"):
			pieceChoice  ="Bishop";
		break;
		case("n"):
			pieceChoice  ="Knight";
		break;
		case("r"):
			pieceChoice  ="Rook";
		break;
		case("p"):
			pieceChoice  ="Pawn";
		break;
		default:
			break;
		}
		return pieceChoice;
	}

}
