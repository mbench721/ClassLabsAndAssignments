import java.util.ArrayList;
import java.util.Scanner;

public class Application {


	private double[][] userMatrix;
	private boolean calc;
	private ArrayList<Matrix> sums = new ArrayList<Matrix>();
	private ArrayList<Matrix> products = new ArrayList<Matrix>();
	private ArrayList<Matrix> transposed = new ArrayList<Matrix>();

	public Application(){
		calc = true;
		while(calc){
			run();
		}

		System.out.println("                      Thanks for using my calculator!");

	}
	public void printMenu(){
		System.out.println("                 Welcometo the Matrix!......Calculator.");
		System.out.println("                       =====================    ");
		System.out.println("                       Matrix Addition       : 1");
		System.out.println("                       Matrix Multiplication : 2");
		System.out.println("                       Matrix Inverse        : 3");
		System.out.println("                       Matrix Transpose      : 4");
		System.out.println("                       Results               : 5");
		System.out.println("                       Exit                  : 6");
	}

	public void run(){
		printMenu();
		Scanner stan = new Scanner(System.in);
		System.out.println(" ");
		System.out.println("                       Choose an operation");
		String choice = stan.nextLine();
		if(choice.equalsIgnoreCase("1")){
			addChose();
		}
		else if(choice.equalsIgnoreCase("2")){
			multChose();
		}
		else if(choice.equalsIgnoreCase("3")){

		}
		else if(choice.equalsIgnoreCase("4")){
			transChose();
		}
		else if(choice.equalsIgnoreCase("5")){
			results();

		}
		else if(choice.equalsIgnoreCase("6")){
			calc = false;
		}
	}
	public void addChose(){
		Scanner stan = new Scanner(System.in);
		System.out.println("Alright, How big of matrixes will we be adding? Keep in mind you can only add equal matrixes. enter in format rowsXcolumns");
		String startCapture = stan.nextLine();
		userMatrix = new double[Integer.valueOf(startCapture.substring(0, startCapture.indexOf("x")))][Integer.valueOf(startCapture.substring(startCapture.indexOf("x") + 1))];

		System.out.println("Enter the matrix you would like to use, Press enter once when you are done entering rows");
		System.out.println("and press enter twice to finalize the matrix.");
		startCapture = stan.nextLine();

		String[] tempS = startCapture.split(",");
		int size = tempS.length;
		int start = 0;

		for(int i = 0;i < size;++i){
			userMatrix[start][i] = Double.parseDouble(tempS[i]);

		}
		++start;
		
		while(!startCapture.isEmpty()){
			startCapture = stan.nextLine();
			if(!startCapture.isEmpty()){
				tempS = startCapture.split(",");
				for(int i = 0;i < size ;++i){
					userMatrix[start][i] = Double.parseDouble(tempS[i]);
					

				}
				++start;
			}


		}
		Matrix first = new Matrix(userMatrix);



		System.out.println("Enter the matrix you would like to add to it, Press enter once when you are done entering rows");
		System.out.println("and press enter twice to finalize the matrix.");
		startCapture = stan.nextLine();

		tempS = startCapture.split(",");
		size = tempS.length;
		start = 0;

		for(int i = 0;i < size;++i){
			userMatrix[start][i] = Double.parseDouble(tempS[i]);

		}
		++start;


		while(!startCapture.isEmpty()){
			startCapture = stan.nextLine();
			if(!startCapture.isEmpty()){
				tempS = startCapture.split(",");
				for(int i = 0;i < size;++i){
					userMatrix[start][i] = Double.parseDouble(tempS[i]);
					

				}
				++start;
			}


		}
		Matrix second = new Matrix(userMatrix);
		Matrix sum = new Matrix(first.addition(second.getMatrix()));
		sums.add(sum);
		System.out.println("your result was :");
		for(int i = 0; i < sum.getMatrix().length; ++ i){
			for(int j = 0; j < sum.getMatrix().length; ++ j){
				System.out.print(sum.getMatrix()[i][j] + " ");
			}
			System.out.println("");
		}
	}
	public void multChose(){
		Scanner stan = new Scanner(System.in);
		System.out.println("Alright, How big of matrix will we be Multiplying? enter in format rowsXcolumns");
		String startCapture = stan.nextLine();
		userMatrix = new double[Integer.valueOf(startCapture.substring(0, startCapture.indexOf("x")))][Integer.valueOf(startCapture.substring(startCapture.indexOf("x") + 1))];

		System.out.println("Enter the matrix you would like to use, Press enter once when you are done entering rows");
		System.out.println("and press enter twice to finalize the matrix.");
		startCapture = stan.nextLine();

		String[] tempS = startCapture.split(",");
		int size = tempS.length;
		int start = 0;

		for(int i = 0;i < size;++i){
			userMatrix[start][i] = Double.parseDouble(tempS[i]);
			System.out.println(userMatrix[start][i]);

		}
		++start;
		
		while(!startCapture.isEmpty()){
			startCapture = stan.nextLine();
			if(!startCapture.isEmpty()){
				tempS = startCapture.split(",");
				for(int i = 0;i < size ;++i){
					userMatrix[start][i] = Double.parseDouble(tempS[i]);
					
				}
				++start;
			}


		}
		Matrix first = new Matrix(userMatrix);
		System.out.println("Alright, How big of matrix will we be Multiplying? enter in format rowsXcolumns");
		startCapture = stan.nextLine();
		userMatrix = new double[Integer.valueOf(startCapture.substring(0, startCapture.indexOf("x")))][Integer.valueOf(startCapture.substring(startCapture.indexOf("x") + 1))];


		System.out.println("Enter the matrix you would like to use, Press enter once when you are done entering rows");
		System.out.println("and press enter twice to finalize the matrix.");
		startCapture = stan.nextLine();

		tempS = startCapture.split(",");
		size = tempS.length;
		start = 0;

		for(int i = 0;i < size;++i){
			userMatrix[start][i] = Double.parseDouble(tempS[i]);
			

		}
		++start;


		while(!startCapture.isEmpty()){
			startCapture = stan.nextLine();
			if(!startCapture.isEmpty()){
				tempS = startCapture.split(",");
				for(int i = 0;i < size;++i){
					userMatrix[start][i] = Double.parseDouble(tempS[i]);
					

				}
				++start;
			}


		}
		Matrix second = new Matrix(userMatrix);
		Matrix prod = new Matrix(first.multiplication(second.getMatrix()));
		products.add(prod);
		for(int i = 0; i < prod.getMatrix().length; ++ i){
			for(int j = 0; j < prod.getMatrix().length; ++ j){
				System.out.print(prod.getMatrix()[i][j] + " ");
				
			}
		}
	}
	public void transChose(){
		Scanner stan = new Scanner(System.in);
		System.out.println("Alright, How big of a matrix will we be transposing? enter in format rowsXcolumns");
		String startCapture = stan.nextLine();
		userMatrix = new double[Integer.valueOf(startCapture.substring(0, startCapture.indexOf("x")))][Integer.valueOf(startCapture.substring(startCapture.indexOf("x") + 1))];

		System.out.println("Enter the matrix you would like to use, Press enter once when you are done entering rows");
		System.out.println("and press enter twice to finalize the matrix.");
		startCapture = stan.nextLine();

		String[] tempS = startCapture.split(",");
		int size = tempS.length;
		int start = 0;

		for(int i = 0;i < size;++i){
			userMatrix[start][i] = Double.parseDouble(tempS[i]);
			System.out.println(userMatrix[start][i]);

		}
		++start;
		
		while(!startCapture.isEmpty()){
			startCapture = stan.nextLine();
			if(!startCapture.isEmpty()){
				tempS = startCapture.split(",");
				for(int i = 0;i < size ;++i){
					userMatrix[start][i] = Double.parseDouble(tempS[i]);
					System.out.println(userMatrix[start][i]);

				}
				++start;
			}

		}
		Matrix toTrans = new Matrix(userMatrix);
		Matrix trans = new Matrix(toTrans.transpose(toTrans.getMatrix()));
		transposed.add(trans);
		for(int i = 0; i < trans.getMatrix().length; ++ i){
			for(int j = 0; j < trans.getMatrix().length; ++ j){
				System.out.print(trans.getMatrix()[i][j]);
			}
		}
	}
	public void results(){
		System.out.println("Addition results : ");
		for(Matrix s : sums){
			for(int i = 0; i < s.getMatrix().length; ++ i){
				for(int j = 0; j < s.getMatrix().length; ++ j){
					System.out.print(s.getMatrix()[i][j] + " ");
				}
				System.out.println("");
			}
			
		}
		System.out.println(" ");
		System.out.println("Multiplication results : ");
		for(Matrix p : products){
			for(int i = 0; i < p.getMatrix().length; ++ i){
				for(int j = 0; j < p.getMatrix().length; ++ j){
					System.out.print(p.getMatrix()[i][j] + " ");
				}
				System.out.println("");
			}
			
		}
		System.out.println(" ");
		System.out.println("Transpose results : ");
		for(Matrix t : transposed){
			for(int i = 0; i < t.getMatrix().length; ++ i){
				for(int j = 0; j < t.getMatrix().length; ++ j){
					System.out.print(t.getMatrix()[i][j] + " ");
				}
				System.out.println("");
			}
			
		}
	}
}




