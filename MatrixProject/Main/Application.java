import java.util.ArrayList;
import java.util.Scanner;

public class Application {

	private ArrayList<String[]> matrix = new ArrayList<String[]>();


	public Application(){
		printMenu();
		captureMatrix();

	}
	public void printMenu(){
		System.out.println("                       Matrix Multiplication : 1");
		System.out.println("                       Matrix Addition : 2");
		System.out.println("                       Matrix Inverse : 3");
		System.out.println("                       Matrix Multiplication : 1");
	}

	public void captureMatrix(){
		Scanner stan = new Scanner(System.in);
		System.out.println("Enter the matrix you would like to use, Press enter once when you are done entering rows");
		System.out.println("and press enter twice to finalize the matrix.");
		String startCapture = stan.nextLine();

		String[] temp = startCapture.split(",");
		for(String line : temp){
			System.out.println(line);
		}
		matrix.add(temp);
		while(!startCapture.isEmpty()){
			startCapture = stan.nextLine();
			temp = startCapture.split(",");
			for(String line : temp){
				System.out.println(line);
			}
			matrix.add(temp);
		}

	}

}
