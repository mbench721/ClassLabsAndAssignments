package utilities;

import controllers.MoveController;
import gameobjects.BoardTile;

public class Check {

//	public void check(BoardTile[][] b,BoardTile t,int x ,int y, boolean cap,MoveController c){
//
//		boolean occupado = b[x][y].isOccupied();
//		String checkAgainst = b[x][y].pieceType;
//		String checkColor = b[x][y].pieceColor;
//		int toX = t.xPos - b[x][y].xPos;
//		int toY = t.yPos - b[x][y].yPos;
//		int validMovePos = 1;
//		int validMoveNeg = -1;
//		BlockedChecker chester = new BlockedChecker();
//
//
//		if(occupado && checkAgainst.equalsIgnoreCase("r") && !checkColor.equalsIgnoreCase(t.pieceColor) && toY == 0 && toX !=0 ){
//
//			if(t.pieceColor.equalsIgnoreCase("l")){
//				c.lightInCheck = true;
//				System.out.println("Light in check");
//			}
//
//			else if(t.pieceColor.equalsIgnoreCase("d")){
//				System.out.println("Dark in check");
//				c.darkInCheck = true;
//			}
//
//
//		}
//		else if(occupado && checkAgainst.equalsIgnoreCase("r") && !checkColor.equalsIgnoreCase(t.pieceColor) && toY != 0 && toX ==0 ){
//
//			if(t.pieceColor.equalsIgnoreCase("l")){
//				c.lightInCheck = true;
//				System.out.println("Light in check");
//			}
//
//			else if(t.pieceColor.equalsIgnoreCase("d")){
//				System.out.println("Dark in check");
//				c.darkInCheck = true;
//			}
//
//
//		}
//
//
//
//		else if(occupado && checkAgainst.equalsIgnoreCase("r") && !checkColor.equalsIgnoreCase(t.pieceColor) && toX != 0 && toY !=0){
//
//				//&& chester.isBlocked(b,b[x][y].yPos, b[x][y].xPos, t.yPos, t.xPos)){
//			if(t.pieceColor.equalsIgnoreCase("l") ){
//				c.lightInCheck = false;
//				System.out.println("Light out of check");
//			}
//
//			if(t.pieceColor.equalsIgnoreCase("d")){
//				c.darkInCheck = false;
//				System.out.println("Dark out of check");
//
//			}
//
//
//		}

		//		if(occupado && checkAgainst.equalsIgnoreCase("q") && !checkColor.equalsIgnoreCase(t.pieceColor) && toX == 0){
		//			if(t.pieceColor.equalsIgnoreCase("l")){
		//				c.lightInCheck = true;
		//				System.out.println("Light in check");
		//			}
		//			else if(t.pieceColor.equalsIgnoreCase("d")){
		//				System.out.println("Dark in check");
		//				c.darkInCheck = true;
		//			}
		//		}
		//		else if(occupado && checkAgainst.equalsIgnoreCase("q") && !checkColor.equalsIgnoreCase(t.pieceColor) && toY == 0){
		//			if(t.pieceColor.equalsIgnoreCase("l")){
		//				c.lightInCheck = true;
		//				System.out.println("Light in check");
		//			}
		//			else if(t.pieceColor.equalsIgnoreCase("d")){
		//				System.out.println("Dark in check");
		//				c.darkInCheck = true;
		//			}
		//		}
		//		else if(occupado && checkAgainst.equalsIgnoreCase("q") && !checkColor.equalsIgnoreCase(t.pieceColor)&&Math.abs(toY) == Math.abs(toX)){
		//			if(t.pieceColor.equalsIgnoreCase("l")){
		//				c.lightInCheck = true;
		//				System.out.println("Light in check");
		//			}
		//			else if(t.pieceColor.equalsIgnoreCase("d")){
		//				System.out.println("Dark in check");
		//				c.darkInCheck = true;
		//			}
		//		}
		//		if(occupado && checkAgainst.equalsIgnoreCase("b") && !checkColor.equalsIgnoreCase(t.pieceColor)&&Math.abs(toY) == Math.abs(toX) ){
		//			if(t.pieceColor.equalsIgnoreCase("l")){
		//				c.lightInCheck = true;
		//				System.out.println("Light in check");
		//			}
		//			else if(t.pieceColor.equalsIgnoreCase("d")){
		//				System.out.println("Dark in check");
		//				c.darkInCheck = true;
		//			}
		//		}
		//		if(occupado && checkAgainst.equalsIgnoreCase("n") && !checkColor.equalsIgnoreCase(t.pieceColor) && toX == 2 && toY <=1 && toY >= -1  && toY != 0  ){
		//			if(t.pieceColor.equalsIgnoreCase("l")){
		//				c.lightInCheck = true;
		//				System.out.println("Light in check");
		//			}
		//			else if(t.pieceColor.equalsIgnoreCase("d")){
		//				System.out.println("Dark in check");
		//				c.darkInCheck = true;
		//			}
		//
		//
		//		}
		//		else if(occupado && checkAgainst.equalsIgnoreCase("n") && !checkColor.equalsIgnoreCase(t.pieceColor) && toX == -2 && toY <=1 && toY >= -1 && toY != 0  ){
		//			if(t.pieceColor.equalsIgnoreCase("l")){
		//				c.lightInCheck = true;
		//				System.out.println("Light in check");
		//			}
		//			else if(t.pieceColor.equalsIgnoreCase("d")){
		//				System.out.println("Dark in check");
		//				c.darkInCheck = true;
		//			}
		//
		//		}
		//		else if(occupado && checkAgainst.equalsIgnoreCase("n") && !checkColor.equalsIgnoreCase(t.pieceColor) && toY == 2 &&  toX <=1 && toX >= -1 && toX != 0  ){
		//			if(t.pieceColor.equalsIgnoreCase("l")){
		//				c.lightInCheck = true;
		//				System.out.println("Light in check");
		//			}
		//			else if(t.pieceColor.equalsIgnoreCase("d")){
		//				System.out.println("Dark in check");
		//				c.darkInCheck = true;
		//			}
		//
		//		}
		//		else if(occupado && checkAgainst.equalsIgnoreCase("n") && !checkColor.equalsIgnoreCase(t.pieceColor) && toY == 2 &&toY == -2 && toX <=1 && toX >= -1 && toX != 0 ){
		//			if(t.pieceColor.equalsIgnoreCase("l")){
		//				c.lightInCheck = true;
		//				System.out.println("Light in check");
		//			}
		//			else if(t.pieceColor.equalsIgnoreCase("d")){
		//				System.out.println("Dark in check");
		//				c.darkInCheck = true;
		//			}
		//		}
		//
		//		else if(occupado && checkAgainst.equalsIgnoreCase("r") && !checkColor.equalsIgnoreCase(t.pieceColor)&& toX != 0 && toY !=0){
		//
		//			if(t.pieceColor.equalsIgnoreCase("l") && chester.isBlocked(b ,b[x][y].yPos, b[x][y].xPos, t.yPos, t.xPos) ){
		//				System.out.println("light out");
		//				c.lightInCheck = false;
		//
		//			}
		//			else  if(t.pieceColor.equalsIgnoreCase("d") && chester.isBlocked(b ,b[x][y].yPos, b[x][y].xPos, t.yPos, t.xPos)){
		//		    	
		//				c.darkInCheck = false;
		//
		//
		//			}
		//
		//		}
		//		if(occupado && checkAgainst.equalsIgnoreCase("r") && !checkColor.equalsIgnoreCase(t.pieceColor)&& toY != 0){
		//			
		//			if(t.pieceColor.equalsIgnoreCase("l") && chester.isBlocked(b ,b[x][y].yPos, b[x][y].xPos, t.yPos, t.xPos)){
		//				c.lightInCheck = false;
		//
		//			}
		//			if(t.pieceColor.equalsIgnoreCase("d") && chester.isBlocked(b ,b[x][y].yPos, b[x][y].xPos, t.yPos, t.xPos)){
		//				c.darkInCheck = false;
		//
		//			}
		//
		//		}
		//
		//		else if(occupado && checkAgainst.equalsIgnoreCase("q") && !checkColor.equalsIgnoreCase(t.pieceColor) &&toX != 0){
		//			if(t.pieceColor.equalsIgnoreCase("l")){
		//				c.lightInCheck = false;
		//
		//			}
		//			else if(t.pieceColor.equalsIgnoreCase("d")){
		//
		//				c.darkInCheck = false;
		//			}
		//		}
		//		else if(occupado && checkAgainst.equalsIgnoreCase("q") && !checkColor.equalsIgnoreCase(t.pieceColor)&& toY != 0){
		//			if(t.pieceColor.equalsIgnoreCase("l")){
		//				c.lightInCheck = false;
		//
		//			}
		//			else if(t.pieceColor.equalsIgnoreCase("d")){
		//
		//				c.darkInCheck = false;
		//			}
		//		}
		//		else if(occupado && checkAgainst.equalsIgnoreCase("q") && !checkColor.equalsIgnoreCase(t.pieceColor)&&Math.abs(toY) != Math.abs(toX) ){
		//			if(t.pieceColor.equalsIgnoreCase("l")){
		//				c.lightInCheck = false;
		//
		//			}
		//			else if(t.pieceColor.equalsIgnoreCase("d")){
		//
		//				c.darkInCheck = false;
		//			}
		//		}
		//		else if(occupado && checkAgainst.equalsIgnoreCase("b") && !checkColor.equalsIgnoreCase(t.pieceColor)&&Math.abs(toY) != Math.abs(toX) ){
		//			if(t.pieceColor.equalsIgnoreCase("l")){
		//				c.lightInCheck = false;
		//
		//			}
		//			else if(t.pieceColor.equalsIgnoreCase("d")){
		//
		//				c.darkInCheck = false;
		//			}
		//		}
		//		else if(occupado && checkAgainst.equalsIgnoreCase("n") && !checkColor.equalsIgnoreCase(t.pieceColor) && toX != 2 && toY > 1 && toY < -1  && toY == 0  ){
		//			if(t.pieceColor.equalsIgnoreCase("l")){
		//				c.lightInCheck = false;
		//
		//			}
		//			else if(t.pieceColor.equalsIgnoreCase("d")){
		//
		//				c.darkInCheck = false;
		//			}
		//
		//
		//		}
		//		else if(occupado && checkAgainst.equalsIgnoreCase("n") && !checkColor.equalsIgnoreCase(t.pieceColor) && toX != -2 && toY > 1 && toY < -1 && toY == 0  ){
		//			if(t.pieceColor.equalsIgnoreCase("l")){
		//				c.lightInCheck = false;
		//
		//			}
		//			else if(t.pieceColor.equalsIgnoreCase("d")){
		//
		//				c.darkInCheck = false;
		//			}
		//
		//		}
		//		else if(occupado && checkAgainst.equalsIgnoreCase("n") && !checkColor.equalsIgnoreCase(t.pieceColor) && toY != 2 &&  toX > 1 && toX < -1 && toX == 0  ){
		//			if(t.pieceColor.equalsIgnoreCase("l")){
		//				c.lightInCheck = false;
		//
		//			}
		//			else if(t.pieceColor.equalsIgnoreCase("d")){
		//
		//				c.darkInCheck = false;
		//			}
		//
		//		}
		//		else if(occupado && checkAgainst.equalsIgnoreCase("n") && !checkColor.equalsIgnoreCase(t.pieceColor) && toY != 2 &&toY != -2 && toX > 1 && toX < -1 && toX == 0   ){
		//			if(t.pieceColor.equalsIgnoreCase("l")){
		//				c.lightInCheck = false;
		//
		//			}
		//			else if(t.pieceColor.equalsIgnoreCase("d")){
		//
		//				c.darkInCheck = false;
		//			}
		//
		//		}
		//
		//		else if(occupado && checkAgainst.equalsIgnoreCase("p") && !checkColor.equalsIgnoreCase(t.pieceColor) && checkColor.equalsIgnoreCase("l") && toX == 1 && toY !=0){
		//			System.out.println("Dark in check");
		//			c.darkInCheck = true;
		//		}
		//		else if(occupado && checkAgainst.equalsIgnoreCase("p") && !checkColor.equalsIgnoreCase(t.pieceColor) && checkColor.equalsIgnoreCase("d") &&  toX == -1 && toY !=0  ){
		//			System.out.println("Light in check");
		//			c.lightInCheck = true;
		//		} 
		//		else if(occupado && checkAgainst.equalsIgnoreCase("p") && !checkColor.equalsIgnoreCase(t.pieceColor) && checkColor.equalsIgnoreCase("l") && toX != 1 && toY !=0){
		//			c.darkInCheck = false;
		//		}
		//		else if(occupado && checkAgainst.equalsIgnoreCase("p") && !checkColor.equalsIgnoreCase(t.pieceColor) && checkColor.equalsIgnoreCase("d") &&  toX != -1 && toY !=0  ){
		//			c.lightInCheck = false;
		//		} 
		//		

		//fix pawn!

	//}

	public boolean lightCheck(BoardTile[][] b,BoardTile t,int x ,int y){
		boolean occupado = b[x][y].isOccupied();
		String checkAgainst = b[x][y].pieceType;
		String checkColor = b[x][y].pieceColor;
		int toX = t.xPos - b[x][y].xPos;
		int toY = t.yPos - b[x][y].yPos;
		
	
		if(occupado && checkAgainst.equalsIgnoreCase("r") && checkColor.equalsIgnoreCase("d") && toY == 0 && toX != 0 ){

			System.out.println("Light in check");
			
				return true;
				
			



		}
		else if(occupado && checkAgainst.equalsIgnoreCase("r") && checkColor.equalsIgnoreCase("d") && toX ==0  && toY != 0){

			System.out.println("Light in check");
				return true;
				
		
		}



		else if(occupado && checkAgainst.equalsIgnoreCase("r") && checkColor.equalsIgnoreCase("d") && toX != 0 && toY !=0){

				//&& chester.isBlocked(b,b[x][y].yPos, b[x][y].xPos, t.yPos, t.xPos)){
			System.out.println("Light out of check");
				return false;
				
			

		}
		return false;
		
	}
	
	public boolean darkCheck(BoardTile[][] b,BoardTile t,int x ,int y){
		boolean occupado = b[x][y].isOccupied();
		String checkAgainst = b[x][y].pieceType;
		String checkColor = b[x][y].pieceColor;
		int toX = t.xPos - b[x][y].xPos;
		int toY = t.yPos - b[x][y].yPos;
		
	
		if(occupado && checkAgainst.equalsIgnoreCase("r") && checkColor.equalsIgnoreCase("l") && toY == 0 && toX != 0){

			System.out.println("Dark in check");
				return true;
				
			



		}
		else if(occupado && checkAgainst.equalsIgnoreCase("r") && checkColor.equalsIgnoreCase("l")  && toX ==0 && toY != 0){

			System.out.println("Dark in check");
				return true;
				
		
		}



		else if(occupado && checkAgainst.equalsIgnoreCase("r") && checkColor.equalsIgnoreCase("l") && toX != 0 && toY !=0){

				//&& chester.isBlocked(b,b[x][y].yPos, b[x][y].xPos, t.yPos, t.xPos)){
			System.out.println("Dark out of check");
				return false;
				
			

		}
		return false;
		
	}

}




