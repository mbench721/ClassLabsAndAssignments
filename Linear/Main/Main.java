import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		int[] start = new int[4];
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your Multiplier");
		start[0] = scan.nextInt() ;
		System.out.println("Enter your Increment");
		start[1] = scan.nextInt();
		System.out.println("Enter your Modulus");
		start[2] = scan.nextInt();
		System.out.println("enter your Seed");
		start[3] = scan.nextInt();
		int numTimes = 0;
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(start[3]);

		int check  = start[3];
		do{

			int loop = lcmRand(check,start[1],start[0],start[2]);
			check = loop;
			result.add(check);

			++ numTimes;
			if(numTimes == 20){
				check = start[3];
				System.out.println("This doesnt repeat after 20 times!");
			}

		}while(check != start[3]);
		System.out.print("LCMrandom ");
		for(int s : start){
			System.out.print(" " + s);
		}
		System.out.println(" ");
		System.out.print("Random Numbers Generated: ");
		for(int p : result){
			System.out.print(" " + p);
		}
		System.out.println(" ");
		System.out.println("Sequence repeats after " + numTimes + " times");

	}
	public static int findMod(int mod, int user){
		int userBase = user;
		int div = mod;
		int divided = user;

		while(divided >= div){
			divided = divided / div;
			divided = divided  * div;
			divided = userBase - divided;

		}

		return divided;
	}
	public static int lcmRand(int s,int i, int mult,int mod){

		int previous;
		int next = s;
		int increment = i;
		int multiplier = mult;
		int modulus = mod;

		next = multiplier * next + increment;
		previous = findMod(modulus,next);

		return previous;
	}
}
