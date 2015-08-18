package gameobjects;

public class BoardTile {
	
	int xPos;
	int yPos;
	String pieceType;
	String pieceColor;
	
	public BoardTile(int x,int y){
		
		this.xPos = x;
		this.yPos = y;
		this.pieceType = "-";
		this.pieceColor = "none";
		
	}
	
	public void printPiece(){
		System.out.println(pieceType);
	}

}
