package CarStuff;

public enum Direction {

	LEFT(180), RIGHT(0), UP(270), DOWN(90);
	private int rotation;

	private Direction(int rotation){
		this.rotation = rotation;
	}
	public int getRotation(){
		return rotation;
	}

}
