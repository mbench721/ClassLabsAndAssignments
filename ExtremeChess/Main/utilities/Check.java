package utilities;


import gameobjects.BoardTile;

public class Check {
	public CheckBlocked chester = new CheckBlocked();

	public boolean lightCheck(BoardTile[][] t,BoardTile s,int fromX ,int fromY){
		int toX = s.xPos;
		int toY = s.yPos;
		String checkAgainst = t[fromX][fromY].pieceType;
		String checkColor = t[fromX][fromY].pieceColor;
		boolean occupado = t[fromX][fromY].isOccupied();
		int toXdiag = s.xPos - fromX;
		int toYdiag = s.yPos - fromY;

		if(toX - fromX == 0 && toY < fromY){
			for (int i = fromY; i >= toY; i--) {
				if(t[fromX][fromY].isOccupied()  && checkColor.equalsIgnoreCase("d")  && checkAgainst.equalsIgnoreCase("r") ||
						t[fromX][fromY].isOccupied()  && checkColor.equalsIgnoreCase("d")  && checkAgainst.equalsIgnoreCase("q")){
					;
					return true;
				}
				-- fromY;
			}
		}
		else if(toX - fromX == 0 && toY > fromY){
			for (int i = fromY; i <= toY; i++) {
				if(t[fromX][fromY].isOccupied() && checkColor.equalsIgnoreCase("d")  && checkAgainst.equalsIgnoreCase("r") ||
						t[fromX][fromY].isOccupied()  && checkColor.equalsIgnoreCase("d")  && checkAgainst.equalsIgnoreCase("q")){
					return true;
				}
				++ fromY;
			}
		}
		else if(toY - fromY == 0 && toX < fromX ){
			for (int i = fromX; i >= toX; i--) {
				if(t[fromX][fromY].isOccupied() && checkColor.equalsIgnoreCase("d")  && checkAgainst.equalsIgnoreCase("r") || 
						t[fromX][fromY].isOccupied()  && checkColor.equalsIgnoreCase("d")  && checkAgainst.equalsIgnoreCase("q")){
					return true;
				}
				-- fromX;
			}
		}
		else if(toY - fromY == 0 && toX > fromX){
			for (int i = fromX; i <= toX; i++) {
				if(t[fromX][fromY].isOccupied() && checkColor.equalsIgnoreCase("d") && checkAgainst.equalsIgnoreCase("r") ||
						t[fromX][fromY].isOccupied()  && checkColor.equalsIgnoreCase("d")  && checkAgainst.equalsIgnoreCase("q")){

					return true;
				}
				++ fromX;
			}
		}
		else if(toX > fromX && toY > fromY){
			for (int i = fromX; i < toX; i++) {
				if(t[fromY][i].isOccupied() && checkColor.equalsIgnoreCase("d") && checkAgainst.equalsIgnoreCase("b") ||
						t[fromY][i].isOccupied() && checkColor.equalsIgnoreCase("d") && checkAgainst.equalsIgnoreCase("q")){
					return true;
				}
				++ fromY;
			}
		}
		else if(occupado && checkAgainst.equalsIgnoreCase("q") && checkColor.equalsIgnoreCase("d")&&Math.abs(toYdiag) == Math.abs(toXdiag) ||
				occupado && checkAgainst.equalsIgnoreCase("b") && checkColor.equalsIgnoreCase("d")&&Math.abs(toYdiag) == Math.abs(toXdiag) ||
				occupado && checkAgainst.equalsIgnoreCase("b") && checkColor.equalsIgnoreCase("d")&&Math.abs(toYdiag) == Math.abs(toXdiag)){
			return true;
		}
		else if(occupado && checkAgainst.equalsIgnoreCase("p") && checkColor.equalsIgnoreCase("d")  && toXdiag == -1 && toYdiag !=0){

			return true;
		}
		if(occupado && checkAgainst.equalsIgnoreCase("n") && checkColor.equalsIgnoreCase("d") && toXdiag == 2 && toYdiag == 1 ||
				occupado && checkAgainst.equalsIgnoreCase("n") && checkColor.equalsIgnoreCase("d") && toXdiag == -2 && toYdiag == 1||
				occupado && checkAgainst.equalsIgnoreCase("n") && checkColor.equalsIgnoreCase("d") && toYdiag == 2 &&  toXdiag == 1 ||
				occupado && checkAgainst.equalsIgnoreCase("n") && checkColor.equalsIgnoreCase("d") &&toYdiag == -2 && toXdiag == 1 ||
				occupado && checkAgainst.equalsIgnoreCase("n") && checkColor.equalsIgnoreCase("d") && toXdiag == 2 && toYdiag == -1 ||
				occupado && checkAgainst.equalsIgnoreCase("n") && checkColor.equalsIgnoreCase("d") && toXdiag == -2 && toYdiag == -1||
				occupado && checkAgainst.equalsIgnoreCase("n") && checkColor.equalsIgnoreCase("d") && toYdiag == 2 &&  toXdiag == -1 ||
				occupado && checkAgainst.equalsIgnoreCase("n") && checkColor.equalsIgnoreCase("d") &&toYdiag == -2 && toXdiag == -1){
			return true;

		}
		return false;	
	}

	public boolean darkCheck(BoardTile[][] t,BoardTile s,int fromX ,int fromY){
		int toX = s.xPos;
		int toY = s.yPos;
		int toXdiag = s.xPos - t[fromX][fromY].xPos;
		int toYdiag = s.yPos - t[fromX][fromY].yPos;
		String checkAgainst = t[fromX][fromY].pieceType;
		String checkColor = t[fromX][fromY].pieceColor;
		boolean occupado = t[fromX][fromY].isOccupied();
	
		if(toX - fromX == 0 && toY < fromY){
			for (int i = fromY; i >= toY; i--) {
				if(t[fromX][fromY].isOccupied()  && checkColor.equalsIgnoreCase("l")  && checkAgainst.equalsIgnoreCase("r") ||
						t[fromX][fromY].isOccupied()  && checkColor.equalsIgnoreCase("l")  && checkAgainst.equalsIgnoreCase("q") ){

					return true;
				}
				-- fromY;
			}
		}
		else if(toX - fromX == 0 && toY > fromY){
			for (int i = fromY; i <= toY; i++) {
				if(t[fromX][fromY].isOccupied() && checkColor.equalsIgnoreCase("l")  && checkAgainst.equalsIgnoreCase("r") ||
						t[fromX][fromY].isOccupied()  && checkColor.equalsIgnoreCase("l")  && checkAgainst.equalsIgnoreCase("q") ){
					return true;
				}
				++ fromY;
			}
		}
		else if(toY - fromY == 0 && toX < fromX){
			for (int i = fromX; i >= toX; i--) {
				if(t[fromX][fromY - 1].isOccupied() && checkColor.equalsIgnoreCase("l")  && checkAgainst.equalsIgnoreCase("r") ||
						t[fromX][fromY].isOccupied()  && checkColor.equalsIgnoreCase("l")  && checkAgainst.equalsIgnoreCase("q")){
					return true;
				}
				-- fromX;
			}
		}
		else if(toY - fromY == 0 && toX > fromX){
			for (int i = fromX; i <= toX; i++) {
				if(t[fromX][fromY].isOccupied() && checkColor.equalsIgnoreCase("l") && checkAgainst.equalsIgnoreCase("r") || 
						t[fromX][fromY].isOccupied()  && checkColor.equalsIgnoreCase("l")  && checkAgainst.equalsIgnoreCase("q")){
					return true;
				}
				++ fromX;
			}
		}
		else if(occupado && checkAgainst.equalsIgnoreCase("q") && checkColor.equalsIgnoreCase("l")&&Math.abs(toYdiag) == Math.abs(toXdiag) ||
				occupado && checkAgainst.equalsIgnoreCase("b") && checkColor.equalsIgnoreCase("l")&&Math.abs(toYdiag) == Math.abs(toXdiag) ||
				occupado && checkAgainst.equalsIgnoreCase("b") && checkColor.equalsIgnoreCase("l")&&Math.abs(toYdiag) == Math.abs(toXdiag) ){
			return true;
		}
		else if(occupado && checkAgainst.equalsIgnoreCase("p")  && checkColor.equalsIgnoreCase("l") &&  toXdiag == 1 && toYdiag !=0 ){
			return true;
		} 
		else if(occupado && checkAgainst.equalsIgnoreCase("n") && checkColor.equalsIgnoreCase("l") && toXdiag == 2 && toYdiag == 1 ||
				occupado && checkAgainst.equalsIgnoreCase("n") && checkColor.equalsIgnoreCase("l") && toXdiag == -2 && toYdiag == 1||
				occupado && checkAgainst.equalsIgnoreCase("n") && checkColor.equalsIgnoreCase("l") && toYdiag == 2 &&  toXdiag == 1 ||
				occupado && checkAgainst.equalsIgnoreCase("n") && checkColor.equalsIgnoreCase("l") &&toYdiag == -2 && toXdiag == 1 ||
				occupado && checkAgainst.equalsIgnoreCase("n") && checkColor.equalsIgnoreCase("l") && toXdiag == 2 && toYdiag == -1 ||
				occupado && checkAgainst.equalsIgnoreCase("n") && checkColor.equalsIgnoreCase("l") && toXdiag == -2 && toYdiag == -1||
				occupado && checkAgainst.equalsIgnoreCase("n") && checkColor.equalsIgnoreCase("l") && toYdiag == 2 &&  toXdiag == -1 ||
				occupado && checkAgainst.equalsIgnoreCase("n") && checkColor.equalsIgnoreCase("l") &&toYdiag == -2 && toXdiag == -1){
			return true;
		}
		return false;	
	}
}




