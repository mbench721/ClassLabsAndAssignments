package utilities;

import java.util.ArrayList;

import gameobjects.BoardTile;

public class BlockedChecker {

	public boolean isBlocked(BoardTile[][] t,int toX,int toY,int fromX,int fromY){


		if(!t[fromY][fromX].pieceType.equalsIgnoreCase("n") && !t[fromY][fromX].pieceType.equalsIgnoreCase("k")){
			//diagnal right down left up
			if(toX > fromX && toY > fromY){
				for (int i = fromX + 1; i < toX + 1; i++) {

					if(t[fromY + 1][i].isOccupied()){
						System.out.println(t[fromY + 1][i].pieceType);
						return true;
					}
					//System.out.println(fromY + 1 + " " + i);
					++ fromY;
				}


			}
			//diagnal left 
			else if(toX < fromX && toY < fromY){

				for (int i = fromX - 1; i > toX - 1; i--) {
					
					//System.out.println(fromY - 1 + " " + i);
					if(t[fromY - 1][i].isOccupied()){
						System.out.println(t[fromY + 1][i].pieceType);
						return true;
					}

					-- fromY;
				}
			}
			else if(toX > fromX && toY < fromY){
				for (int i = fromX + 1; i < toX + 1; i++) {

					if(t[fromY - 1][i].isOccupied()){
						return true;
					}
					//System.out.println(fromY + 1 + " " + i);
					-- fromY;
				}


			}
			//diagnal left 
			else if(toX < fromX && toY > fromY){
				System.out.println(fromX + " " + fromY+ " " +toX + " " + toY);
				for (int i = fromX - 1; i > toX  ; i--) {
				
					if(t[fromY + 1][i].isOccupied()){
						
						return true;
						
					}
				
						++ fromY;
				
					
				}
			}




			//vertical bottom up
			else if(toX - fromX == 0 && toY < fromY){
				for (int i = fromY - 1; i > toY; i--) {
					if(t[fromY - 1][fromX].isOccupied()){
						return true;
					}
					-- fromY;
				}

			}
			// vertical top down
			else if(toX - fromX == 0 && toY > fromY){
				for (int i = fromY + 1; i < toY; i++) {
					if(t[fromY + 1][fromX].isOccupied()){
						return true;
					}

					++ fromY;
				}

			}
			else if(toY - fromY == 0 && toX < fromX){
				for (int i = fromX - 1; i > toX; i--) {
					if(t[fromY][fromX - 1].isOccupied()){
						return true;
					}
					-- fromX;
				}

			}
			else if(toY - fromY == 0 && toX > fromX){
				for (int i = fromX + 1; i < toX; i++) {
					if(t[fromY][fromX + 1].isOccupied()){
						return true;
					}
					++ fromX;
				}

			}
		}
		
			return false;
	
		



	}

}
