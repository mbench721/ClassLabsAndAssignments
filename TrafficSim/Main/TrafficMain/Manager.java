
package TrafficMain;
import intersections.Intersection;
import intersections.IntersectionPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import roads.RoadLine;
import roads.RoadsEW;
import roads.RoadsNS;
import CarStuff.*;
import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.World;

public class Manager extends Actor  {

	public BeginStats begin;
	private World world;
	int time;
	private final static int NUM_OF_INTERSECTIONS = 35;
	private final static int NUM_NS_ROADS = 7;
	private final static int NUM_EW_ROADS = 5;
	private final int NUM_OF_LINES = 17;
	public RoadsEW[] ewRoadsRay = new RoadsEW[NUM_EW_ROADS];
	public RoadsNS[] nsRoadsRay = new RoadsNS[NUM_NS_ROADS];
	private RoadsEW ewRoads;
	private RoadsNS nsRoads;
	private Random rgen = new Random();
	public Intersection[] intersections =  new Intersection[NUM_OF_INTERSECTIONS];
	public int[][] endStats;
	public int addRandCar;
	public int randUpPos,randDownPos,randLeftPos,randRightPos;
	public int randLeftRightPos;
	public int carRate;
	private JInternalFrame[] frames;
	public boolean redTrue = false,blueTrue = false;


	public Manager(World world){

		begin = new BeginStats();
		this.world = world;
		drawRoads();
		drawLines();
		
		intersections =  addIntersections();
		this.frames = new JInternalFrame[35];
		
		
		
	}
	public void act(){
		
		setBegin();
		--time;
		endStats();
		addRandCar = rgen.nextInt(carRate) + 1;
		addCars();


	}
	private void endStats() {
		if(time == 0){
			endStats = new int[intersections.length][4];

			for(int i = 0; i < endStats.length;++ i){
				endStats[i][0] = intersections[i].stats.blueCar;
				endStats[i][1] =  intersections[i].stats.purpleCar;
				endStats[i][2] =  intersections[i].stats.yellowCar;
				endStats[i][3] =  intersections[i].stats.redCar;

			}

			writeFileAfter();
			statsSheet();
			Greenfoot.stop();
		}
	}
	private void setBegin() {
		if(carRate == 0){
			FileReader freader= null;
			try {
				
				freader=new FileReader("Setup.txt");
				BufferedReader inputFile=new BufferedReader(freader);
				carRate = Integer.valueOf(inputFile.readLine());
				time = Integer.valueOf(inputFile.readLine());

			} catch (IOException e) {

				e.printStackTrace();
			}
			finally{
				if(freader != null){
					try {

						freader.close();
					} catch (IOException e) {

						e.printStackTrace();
					}
				}
			}
		}
	}
	public  void writeFileAfter(){
		FileWriter outputStream = null;
		try {
			outputStream = new FileWriter("Stats.txt");
			for(int i = 0; i < intersections.length;++i)
				outputStream.write("Intersection " + (i + 1) +":" +" " + "Blue: " + endStats[i][0]  + " Purple: " + " " + endStats[i][1] + " Yellow: " + " " + endStats[i][2] +" Red: " + " " + endStats[i][3] + "\015");     


		} catch (IOException e) {

			e.printStackTrace();
		}

		finally{
			if(outputStream != null){
				try {
					outputStream.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		}
	}
	public void statsSheet(){

		JFrame stats = new JFrame("Traffic Stats");
		stats.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		intersections.StatsPanel statBox =  new intersections.StatsPanel();
		stats.getContentPane().add(statBox);
		Dimension d = new Dimension(1125,950);
		stats.setPreferredSize(d);
		stats.pack();
		stats.setLocation(500, 10);
		stats.setVisible(true);

		Dimension dimension = new Dimension(150,160);
		for (int j =0; j < intersections.length;++j){
			JInternalFrame frame = new IntersectionPanel();
			JButton redStats = new JButton("Red Cars: " + intersections[j].stats.redCar);
			JButton blueStats = new JButton("Blue Cars: " + intersections[j].stats.blueCar);
			JButton yellowStats = new JButton("Yellow Cars: " + intersections[j].stats.yellowCar);
			JButton purpleStats = new JButton("Purple Cars: " + intersections[j].stats.purpleCar);
			frame = new JInternalFrame("Inter: " + (j + 1), true,true,true,true);
			frame.add(redStats);
			frame.add(blueStats);
			frame.add(purpleStats);
			frame.add(yellowStats);
			frames[j] = frame;

		}
		for(JInternalFrame f : frames){
			statBox.add(f);

			f.setLayout(new FlowLayout());
			f.setBackground(Color.GREEN);
			f.setPreferredSize(dimension);
			f.pack();
			f.setVisible(true);

		}

	}
	public Car createCar(Direction direction, int x, int y,Intersection i){
		PurpleStyle purple = new PurpleStyle();
		BlueStyle blue = new BlueStyle();
		RedStyle red = new RedStyle();
		YellowStyle yellow = new YellowStyle();
		Car car = new Car();
		int colorChance = 4;

		if(rgen.nextInt(colorChance) + 1 == 1 && begin.panel.purpleTrue){
			car = purple;
			world.addObject(car, x, y);
			car.setRotation(direction.getRotation());
			purple.setStart(intersections);
			


		}
		else if(rgen.nextInt(colorChance) + 1 == 2 && begin.panel.blueTrue){
			car = blue;
			world.addObject(car, x, y);
			car.setRotation(direction.getRotation());

			blue.setStart(intersections);
			
		}
		else if(rgen.nextInt(colorChance) + 1 == 3 && begin.panel.redTrue){
			car = red;
			world.addObject(car, x, y);
			car.setRotation(direction.getRotation());

			red.setStart(intersections);
			
			
		}
		else if(rgen.nextInt(colorChance) + 1 == 4 && begin.panel.yellowTrue){
			car = yellow;
			world.addObject(yellow, x, y);
			yellow.setRotation(direction.getRotation());

			yellow.setStart(intersections);
			
		}
		
		
		return car;

	}
	public void drawRoadLine(Direction direction, int x, int y){

		RoadLine line = new RoadLine();
		world.addObject(line, x, y);
		line.setRotation(direction.getRotation());

	}
	public void drawRoads(){
		int offSetNumber = 0;
		for(int i = 0; i < NUM_NS_ROADS;++i){

			nsRoads = new RoadsNS();
			world.addObject(nsRoads,  offSetNumber + nsRoads.getOffsetX(), nsRoads.getoffsetY());
			nsRoadsRay[i] = nsRoads;
			offSetNumber += ((world.getWidth() - nsRoads.getWidth()) / (NUM_NS_ROADS - 1));

		}
		offSetNumber = 0;
		for(int i = 0; i < NUM_EW_ROADS;++i){

			ewRoads = new RoadsEW();
			world.addObject(ewRoads, ewRoads.getOffsetX(), offSetNumber + ewRoads.getoffsetY());
			ewRoadsRay[i] = ewRoads;
			offSetNumber += ((world.getHeight() - ewRoads.getHeight()) / (NUM_EW_ROADS - 1));

		}
	}
	public void drawLines(){
		for(int k = 0; k < NUM_NS_ROADS;++k){

			int lineY = 50;
			for(int e = 0; e < NUM_OF_LINES; ++e){

				drawRoadLine(Direction.DOWN,nsRoadsRay[k].getX(),lineY);
				lineY += ((world.getHeight() - ewRoads.getHeight()) / (NUM_OF_LINES - 1));

			}	
		}
		for(int j = 0; j < NUM_EW_ROADS;++j){

			int lineX =10;
			for(int e = 0; e < (NUM_OF_LINES+7); ++e){

				drawRoadLine(Direction.LEFT, lineX,ewRoadsRay[j].getY());
				lineX += ((world.getWidth() - ewRoads.getHeight()) / (NUM_OF_LINES + 7 - 1 ));
			}
		}
	}
	public void addCars(){
		randUpPos = rgen.nextInt(7);
		randDownPos = rgen.nextInt(7) + 27;
		randRightPos = rgen.nextInt(7) ;
		if(randRightPos == 0){
			randRightPos = 0;
		}
		else{
			randRightPos += 7;
		}
		randLeftPos = rgen.nextInt(5)+ 1;
		if(randLeftPos == 6){
			randLeftPos = 6;
		}
		else if(randLeftPos != 6){
			randLeftPos = (randLeftPos * 7) - 1;
		}
		if(addRandCar == 10){
			createCar(Direction.DOWN,intersections[randUpPos].getX() - 15, 50,intersections[randUpPos]);

		}
		else if(addRandCar == 15){
			createCar(Direction.UP,intersections[randDownPos].getX() + 15,world.getHeight() - 50,intersections[randDownPos]);

		}
		else if(addRandCar == 20){
			createCar(Direction.RIGHT,50,intersections[randRightPos].getY() + 15,intersections[randRightPos]);

		}
		else if(addRandCar == 25){
			createCar(Direction.LEFT,world.getWidth() - 50, intersections[randLeftPos].getY() - 15,intersections[randLeftPos]);

		}

	}

	public Intersection[] addIntersections(){

		Intersection[] intersections = new Intersection[NUM_OF_INTERSECTIONS];

		int x = 0;
		for (int i = 0; i < NUM_EW_ROADS; ++i){

			int  interX = ewRoads.getHeight() / 2;
			for (int e = 0;e < NUM_NS_ROADS;++e){


				Intersection intersection = new Intersection();
				world.addObject(intersection,interX,ewRoadsRay[i].getY());
				intersections[x] = intersection;
				intersections[x].addLights();
				interX += ((world.getWidth() - nsRoads.getWidth()) / (NUM_NS_ROADS - 1));
				
				++ x;
				
			}
		}

		return intersections;
	}
}
