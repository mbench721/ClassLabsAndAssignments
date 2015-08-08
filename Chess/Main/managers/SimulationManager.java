package managers;

import utilities.MoveAnalyzer;

public class SimulationManager {
	
	MoveAnalyzer checkMoves;
	
	public SimulationManager(String[] file){
		
		checkMoves = new MoveAnalyzer(file);
			
	}

}
