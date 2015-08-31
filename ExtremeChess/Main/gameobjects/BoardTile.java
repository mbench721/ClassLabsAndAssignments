package gameobjects;

import controllers.MoveController;
import utilities.Check;

public class BoardTile {

	public int xPos;
	public int yPos;
	public String pieceType;
	public String pieceColor;
	public String tempPieceType;
	private Piece piece;
	private Piece tempPiece;
	public boolean isOccupied;
	public boolean lightInCheck;
	public boolean darkInCheck;
	private Check chester;

	public BoardTile(int x,int y){

		this.isOccupied = false;
		this.lightInCheck = false;
		this.darkInCheck = false;
		this.xPos = x;
		this.yPos = y;
		this.pieceType = "-";
		this.pieceColor = "none";
		chester = new Check();


	}

	public void printPiece(){
		System.out.println(piece.getType());
	}
	public Piece swapPiece(Piece s){
		this.tempPiece = this.getPiece();
		setPieceOn(s);
		s= this.tempPiece;

		return s;


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
	public boolean detCheck(BoardTile[][] c,boolean cap){
		boolean check = false;
		if(this.pieceColor.equalsIgnoreCase("l")){
			for(int i = 0; i < c.length; ++i){

				for(int j = 0; j < c.length; ++j){
					check = chester.lightCheck(c, this, i, j);
					




				}
			}

		}
		else if(this.pieceColor.equalsIgnoreCase("d")){
			for(int i = 0; i < c.length; ++i){

				for(int j = 0; j < c.length; ++j){
					check =  chester.darkCheck(c, this, i, j);


				}
			}

		}
		return check;
	}
}




