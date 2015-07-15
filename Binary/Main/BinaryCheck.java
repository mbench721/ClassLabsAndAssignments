import java.util.ArrayList;
import java.util.Scanner;
public class BinaryCheck {

	public static void main(String[] args) {

		int counter = 3;
		Scanner scan = new Scanner(System.in);
		boolean run = true;
		ArrayList<Integer> binary = new ArrayList<Integer>();
		System.out.println("Parity Check");

		while(run){

			boolean isBinary = false;
			String capture;
			int result = 0;
			binary.clear();
			if(counter != 0){

				System.out.print("Please input bit string: ");
				capture = scan.nextLine();

				for(int i = 0; i < capture.length(); ++i){
					binary.add(Integer.valueOf(capture.substring(i,i + 1)));
				}

				result = checkParity(binary,capture,counter);

				-- counter;
			}
			if(counter == 0){
				System.out.println("please input a bit string: 0");
				capture = scan.nextLine();
				if(capture.equals("0")){
					run = false;
				}
			}
		}
		System.out.println("Program exiting, have a great day!");

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
	public static int checkParity(ArrayList<Integer> bin,String input,int count){
		int sum = 0;
		int withoutParity = 0;
		int withParity = 0;

		if(count == 3){

			for(int i = 0; i <= bin.size() - 1; ++i){
				sum += bin.get(i);

			}

			withoutParity = findMod(2,sum);
			System.out.println("The bit string with calculated parity bit is " +input+withoutParity+ " because 5 mod 2 = 1.");

		}
		else if(count < 3){

			for(int i = 0; i <= bin.size() - 2; ++i){
				sum += bin.get(i);

			}

			withParity = findMod(2,sum);

			if(withParity == bin.get(bin.size() - 1)){
				System.out.println("The bit string received is correct because 5 mod 2 = 1 and the parity bit matches!");
			}
			else{
				System.out.println("The bit string received has an error because 4 mod 2 = 0, so the parity bit is incorrect.");
			}
		}

		return sum;
	}
}
