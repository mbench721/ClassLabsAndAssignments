package utilities;

import managers.SimulationManager;
import managers.UserGameManager;

public class Switch {

	private UserGameManager noSim;
	private SimulationManager simGame;
	private String[] test = new String[1];

	public Switch(String[] file){

		

		if (file.length == 0) {
			//System.out.println("no arguments were given.");
			noSim = new UserGameManager();
		}
		else {
			simGame = new SimulationManager(file);

//			for (String a : test) {
//
//				System.out.println(a);
//			}
		}
	}

}
