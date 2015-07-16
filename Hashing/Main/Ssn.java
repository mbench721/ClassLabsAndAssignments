
import java.util.Scanner;
public class Ssn {

	public static void main(String[] args) {
		int mod = 0;
		int ssn = 1;
		int result = 0;

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your Hash Function.");
		mod = scan.nextInt();
		
		while(ssn != 0){

			System.out.println("Enter your Social Security Number");
			String ssnLine = scan.nextLine();
			

			if(ssnLine.equals("0")){
				ssn = 0;
			}

			if(ssnLine.length() != 0 && ssn != 0){
				ssn = Integer.valueOf(ssnLine);
				result = findMod(mod,ssn);
				while(ssnLine.length() != 9 && ssn != 0){
					System.out.println("Invalid Length please try again");
					ssnLine = scan.nextLine();
					

					ssn = Integer.valueOf(ssnLine);
					

				}
				System.out.println("Hash value for " + ssn + " Mod " +mod + " = " + result);
			}
		}
		System.out.println("Exiting Program Have a Nice Day!");
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
}
