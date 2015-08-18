package managers;

public class GameManager {
	
	
	private BoardManager boardMan;
	private String[] moves;
	
	public GameManager(String[] file){
		
		moves = file;
		createBoardManager();
			
	}
	
	private void createBoardManager(){
		boardMan = new BoardManager(moves);
	}

}
