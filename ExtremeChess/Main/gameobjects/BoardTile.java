package gameobjects;

import controllers.MoveController;
import utilities.BlockedChecker;
import utilities.Check;
import utilities.CheckBlocked;

public class BoardTile {

	public int xPos;
	public int yPos;
	public String pieceType;
	public String pieceColor;
	public String tempPieceType;
	private Piece piece;
	private Piece tempPiece;
	public boolean isOccupied;
	
	private Check chester;
	private CheckBlocked blocked;

	public BoardTile(int x,int y){
		this.isOccupied = false;
		
		this.xPos = x;
		this.yPos = y;
		this.pieceType = "-";
		this.pieceColor = "none";
		chester = new Check();
		blocked = new CheckBlocked();
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
	public boolean detLcheck(BoardTile[][] c,boolean cap,MoveController m){
		boolean check = false;
		if(this.pieceColor.equalsIgnoreCase("l")){
			for(int i = 0; i < c.length; ++i){
				for(int j = 0; j < c.length; ++j){
					if(chester.lightCheck(c, this, i, j) && !blocked.isBlocked(c,c[i][j].xPos,c[i][j].yPos,this.xPos,this.yPos)){
						System.out.println("Light in check");
						check = true;
					}
				}
			}
		}
		return check;
	}
	public boolean detDcheck(BoardTile[][] c,boolean cap,MoveController m){
		boolean check = false;

		if(this.pieceColor.equalsIgnoreCase("d")){

			for(int i = 0; i < c.length; ++i){

				for(int j = 0; j < c.length; ++j){
					

					if(chester.darkCheck(c, this, i, j) && !blocked.isBlocked(c,c[i][j].xPos,c[i][j].yPos,this.xPos,this.yPos)){
						System.out.println("Dark in check");
						check = true;
					}
				}
			}
		}
		return check;
	}
}




