package managers;

public class GameManager {
	private PlayerManager pieces;
	private BoardManager boardMan;
	public GameManager(String[] file){
		createPieceManager();
		createBoardManager();
		
		
	}
	private void createPieceManager(){
		pieces = new PlayerManager();
	}
	private void createBoardManager(){
		boardMan = new BoardManager();
	}

}
