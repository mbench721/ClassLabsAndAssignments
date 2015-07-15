package intersections;
import java.awt.Color;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

public class SimulationStats {
	public int redCar,blueCar,yellowCar,purpleCar;
	public  int totalCars;
	public ArrayList<Integer> redLife = new ArrayList<Integer>();
	public ArrayList<Integer> blueLife = new ArrayList<Integer>();
	public ArrayList<Integer> yellowLife = new ArrayList<Integer>();
	public ArrayList<Integer> purpLife = new ArrayList<Integer>();
	
	
	
	public Color carColor;
	public int carLife;
	
	
	SimulationStats(Intersection i){
	
		
		redCar = 0;
		blueCar = 0;
		yellowCar = 0;
		purpleCar = 0;
		totalCars = 0;
		
	}
	
	
	
}
