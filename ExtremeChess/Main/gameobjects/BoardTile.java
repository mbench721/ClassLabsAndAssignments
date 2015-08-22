package gameobjects;

public class BoardTile {

	public int xPos;
	public int yPos;
	public String pieceType;
	public String pieceColor;
	private Piece piece;
	public boolean isOccupied;

	public BoardTile(int x,int y){
		
		this.isOccupied = false;
		this.xPos = x;
		this.yPos = y;
		this.pieceType = "-";
		this.pieceColor = "none";
		

	}

	public void printPiece(){
		System.out.println(piece.getType());
	}

	public void setPieceOn(Piece p){
		if(p.getColor().equalsIgnoreCase("l")){
			pieceType = p.getType().toUpperCase();
		}
		else{
			pieceType = p.getType();
		}
		this.isOccupied = true;
		pieceColor = p.getColor();
		setPiece(p);
	}
	public void setPieceOff(){
		this.isOccupied = false;
		pieceType = "-";
		pieceColor = "none";
		piece = null;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	public boolean isOccupied() {
		return isOccupied;
	}
	public void detCheck(BoardTile[][] c){
		System.out.println("made it");
		for(int i = 0; i < c.length; ++i){

			for(int j = 0; j < c.length; ++j){
				
				if(c[i][j].isOccupied() && c[i][j].pieceType.equalsIgnoreCase("r") && c[i][j].xPos - this.xPos == 0){
					System.out.println("check");
				}
				else if(c[i][j].isOccupied() && c[i][j].pieceType.equalsIgnoreCase("r") && !c[i][j].pieceColor.equalsIgnoreCase(pieceColor)&& c[i][j].yPos - this.yPos == 0){
					System.out.println("check");
				}
				

			}
		}

		
		
	}
		
	
		


}
	



