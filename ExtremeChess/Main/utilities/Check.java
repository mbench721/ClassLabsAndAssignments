package utilities;

import controllers.MoveController;
import gameobjects.BoardTile;

public class Check {

	public void check(BoardTile[][] b,BoardTile t,int x ,int y, boolean cap,MoveController c){
		BlockedChecker blocked = new BlockedChecker();
		boolean occupado = b[x][y].isOccupied();
		String checkAgainst = b[x][y].pieceType;
		String checkColor = b[x][y].pieceColor;
		int toX = t.xPos - b[x][y].xPos;
		int toY = t.yPos - b[x][y].yPos;
		int validMovePos = 1;
		int validMoveNeg = -1;



		if(occupado && checkAgainst.equalsIgnoreCase("r") && !checkColor.equalsIgnoreCase(t.pieceColor) && toX == 0){

			if(t.pieceColor.equalsIgnoreCase("l")){
				c.lightInCheck = true;
				System.out.println("Light in check");
			}
			else if(t.pieceColor.equalsIgnoreCase("d")){
				System.out.println("Dark in check");
				c.darkInCheck = true;
			}

		}
		else if(occupado && checkAgainst.equalsIgnoreCase("r") && !checkColor.equalsIgnoreCase(t.pieceColor) && toY == 0){
			if(t.pieceColor.equalsIgnoreCase("l")){
				c.lightInCheck = true;
				System.out.println("Light in check");
			}
			else if(t.pieceColor.equalsIgnoreCase("d")){
				System.out.println("Dark in check");
				c.darkInCheck = true;
			}
		}

		if(occupado && checkAgainst.equalsIgnoreCase("q") && !checkColor.equalsIgnoreCase(t.pieceColor) && toX == 0){
			if(t.pieceColor.equalsIgnoreCase("l")){
				c.lightInCheck = true;
				System.out.println("Light in check");
			}
			else if(t.pieceColor.equalsIgnoreCase("d")){
				System.out.println("Dark in check");
				c.darkInCheck = true;
			}
		}
		else if(occupado && checkAgainst.equalsIgnoreCase("q") && !checkColor.equalsIgnoreCase(t.pieceColor) && toY == 0){
			if(t.pieceColor.equalsIgnoreCase("l")){
				c.lightInCheck = true;
				System.out.println("Light in check");
			}
			else if(t.pieceColor.equalsIgnoreCase("d")){
				System.out.println("Dark in check");
				c.darkInCheck = true;
			}
		}
		else if(occupado && checkAgainst.equalsIgnoreCase("q") && !checkColor.equalsIgnoreCase(t.pieceColor)&&Math.abs(toY) == Math.abs(toX)){
			if(t.pieceColor.equalsIgnoreCase("l")){
				c.lightInCheck = true;
				System.out.println("Light in check");
			}
			else if(t.pieceColor.equalsIgnoreCase("d")){
				System.out.println("Dark in check");
				c.darkInCheck = true;
			}
		}
		if(occupado && checkAgainst.equalsIgnoreCase("b") && !checkColor.equalsIgnoreCase(t.pieceColor)&&Math.abs(toY) == Math.abs(toX) ){
			if(t.pieceColor.equalsIgnoreCase("l")){
				c.lightInCheck = true;
				System.out.println("Light in check");
			}
			else if(t.pieceColor.equalsIgnoreCase("d")){
				System.out.println("Dark in check");
				c.darkInCheck = true;
			}
		}
		if(occupado && checkAgainst.equalsIgnoreCase("n") && !checkColor.equalsIgnoreCase(t.pieceColor) && toX == 2 && toY <=1 && toY >= -1  && toY != 0  ){
			if(t.pieceColor.equalsIgnoreCase("l")){
				c.lightInCheck = true;
				System.out.println("Light in check");
			}
			else if(t.pieceColor.equalsIgnoreCase("d")){
				System.out.println("Dark in check");
				c.darkInCheck = true;
			}


		}
		else if(occupado && checkAgainst.equalsIgnoreCase("n") && !checkColor.equalsIgnoreCase(t.pieceColor) && toX == -2 && toY <=1 && toY >= -1 && toY != 0  ){
			if(t.pieceColor.equalsIgnoreCase("l")){
				c.lightInCheck = true;
				System.out.println("Light in check");
			}
			else if(t.pieceColor.equalsIgnoreCase("d")){
				System.out.println("Dark in check");
				c.darkInCheck = true;
			}

		}
		else if(occupado && checkAgainst.equalsIgnoreCase("n") && !checkColor.equalsIgnoreCase(t.pieceColor) && toY == 2 &&  toX <=1 && toX >= -1 && toX != 0  ){
			if(t.pieceColor.equalsIgnoreCase("l")){
				c.lightInCheck = true;
				System.out.println("Light in check");
			}
			else if(t.pieceColor.equalsIgnoreCase("d")){
				System.out.println("Dark in check");
				c.darkInCheck = true;
			}

		}
		else if(occupado && checkAgainst.equalsIgnoreCase("n") && !checkColor.equalsIgnoreCase(t.pieceColor) && toY == 2 &&toY == -2 && toX <=1 && toX >= -1 && toX != 0 ){
			if(t.pieceColor.equalsIgnoreCase("l")){
				c.lightInCheck = true;
				System.out.println("Light in check");
			}
			else if(t.pieceColor.equalsIgnoreCase("d")){
				System.out.println("Dark in check");
				c.darkInCheck = true;
			}
		}

		if(occupado && checkAgainst.equalsIgnoreCase("r") && !checkColor.equalsIgnoreCase(t.pieceColor)&& toX != 0){

			if(t.pieceColor.equalsIgnoreCase("l")){
				c.lightInCheck = false;

			}
			else if(t.pieceColor.equalsIgnoreCase("d")){
				c.darkInCheck = false;


			}

		}
		else if(occupado && checkAgainst.equalsIgnoreCase("r") && !checkColor.equalsIgnoreCase(t.pieceColor)&& toY != 0){
			if(t.pieceColor.equalsIgnoreCase("l")){
				c.lightInCheck = false;

			}
			else if(t.pieceColor.equalsIgnoreCase("d")){
				c.darkInCheck = false;

			}
		}

		if(occupado && checkAgainst.equalsIgnoreCase("q") && !checkColor.equalsIgnoreCase(t.pieceColor) &&toX != 0){
			if(t.pieceColor.equalsIgnoreCase("l")){
				c.lightInCheck = false;

			}
			else if(t.pieceColor.equalsIgnoreCase("d")){

				c.darkInCheck = false;
			}
		}
		else if(occupado && checkAgainst.equalsIgnoreCase("q") && !checkColor.equalsIgnoreCase(t.pieceColor)&& toY != 0){
			if(t.pieceColor.equalsIgnoreCase("l")){
				c.lightInCheck = false;

			}
			else if(t.pieceColor.equalsIgnoreCase("d")){

				c.darkInCheck = false;
			}
		}
		else if(occupado && checkAgainst.equalsIgnoreCase("q") && !checkColor.equalsIgnoreCase(t.pieceColor)&&Math.abs(toY) != Math.abs(toX) ){
			if(t.pieceColor.equalsIgnoreCase("l")){
				c.lightInCheck = false;

			}
			else if(t.pieceColor.equalsIgnoreCase("d")){

				c.darkInCheck = false;
			}
		}
		else if(occupado && checkAgainst.equalsIgnoreCase("b") && !checkColor.equalsIgnoreCase(t.pieceColor)&&Math.abs(toY) != Math.abs(toX) ){
			if(t.pieceColor.equalsIgnoreCase("l")){
				c.lightInCheck = false;

			}
			else if(t.pieceColor.equalsIgnoreCase("d")){

				c.darkInCheck = false;
			}
		}
		else if(occupado && checkAgainst.equalsIgnoreCase("n") && !checkColor.equalsIgnoreCase(t.pieceColor) && toX != 2 && toY > 1 && toY < -1  && toY == 0  ){
			if(t.pieceColor.equalsIgnoreCase("l")){
				c.lightInCheck = false;

			}
			else if(t.pieceColor.equalsIgnoreCase("d")){

				c.darkInCheck = false;
			}


		}
		else if(occupado && checkAgainst.equalsIgnoreCase("n") && !checkColor.equalsIgnoreCase(t.pieceColor) && toX != -2 && toY > 1 && toY < -1 && toY == 0  ){
			if(t.pieceColor.equalsIgnoreCase("l")){
				c.lightInCheck = false;

			}
			else if(t.pieceColor.equalsIgnoreCase("d")){

				c.darkInCheck = false;
			}

		}
		else if(occupado && checkAgainst.equalsIgnoreCase("n") && !checkColor.equalsIgnoreCase(t.pieceColor) && toY != 2 &&  toX > 1 && toX < -1 && toX == 0  ){
			if(t.pieceColor.equalsIgnoreCase("l")){
				c.lightInCheck = false;

			}
			else if(t.pieceColor.equalsIgnoreCase("d")){

				c.darkInCheck = false;
			}

		}
		else if(occupado && checkAgainst.equalsIgnoreCase("n") && !checkColor.equalsIgnoreCase(t.pieceColor) && toY != 2 &&toY != -2 && toX > 1 && toX < -1 && toX == 0   ){
			if(t.pieceColor.equalsIgnoreCase("l")){
				c.lightInCheck = false;

			}
			else if(t.pieceColor.equalsIgnoreCase("d")){

				c.darkInCheck = false;
			}

		}

		//		else if(b[x][y].isOccupied() && b[x][y].pieceType.equalsIgnoreCase("p") && !b[x][y].pieceColor.equalsIgnoreCase(t.pieceColor) && b[x][y].pieceColor.equalsIgnoreCase("d") && toY == 1 && toX != 0){
		//			System.out.println("Check");
		//		}
		//		else if(b[x][y].isOccupied() && b[x][y].pieceType.equalsIgnoreCase("p") && !b[x][y].pieceColor.equalsIgnoreCase(t.pieceColor) && b[x][y].pieceColor.equalsIgnoreCase("l") &&  toY == -1 && toX !=0  ){
		//			System.out.println("Check");
		//		} 
		//fix pawn!





	}

}


