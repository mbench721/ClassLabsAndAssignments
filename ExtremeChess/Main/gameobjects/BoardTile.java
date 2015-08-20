package gameobjects;

public class BoardTile {

	public int xPos;
	public int yPos;
	public String pieceType;
	public String pieceColor;
	private Piece piece;
	private boolean isOccupied;

	public BoardTile(int x,int y){
		
		this.isOccupied = false;
		this.xPos = x;
		this.yPos = y;
		this.pieceType = "-";
		this.pieceColor = "none";
		this.piece = new Blank(true, x,y,"none", "-");

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
		piece = new Blank(true,xPos,yPos,"none","-");
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

}
