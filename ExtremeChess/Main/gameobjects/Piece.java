package gameobjects;



public abstract class Piece {
	private boolean available;
    private int x;
    private int y;
    private String color;
    private String type;

   

	public Piece(boolean available, int x, int y,String c,String t) {
        super();
        
        this.available = available;
        this.x = x;
        this.y = y;
        this.color = c;
        this.type = t;
    }


    public String getColor() {
		return color;
	}

    public String getType() {
		return type;
	}

	public boolean isAvailable() {
        return available;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setLocation(int x,int y){
    	this.x = x;
    	this.y = y;
    }

    public abstract boolean isValidLmove(int toX,int toY,boolean cap,boolean lCheck);
    public abstract boolean isValidDmove(int toX,int toY,boolean cap,boolean dCheck);
    public abstract boolean isValidCastle();
    	
   
	   
   
}
