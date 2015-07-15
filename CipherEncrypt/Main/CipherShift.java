import java.util.ArrayList;
import java.util.Scanner;


public class CipherShift {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int cipher = 0;
		int cipherShift = 0;
		String alphaBet = "abcdefghijklmnopqrstuvwxyz ";
		String input;
		String encryOrDecry;
		ArrayList<String> forward = new ArrayList<String>();
		ArrayList<String> backward = new ArrayList<String>();
		fillAlpha(forward,backward);
		System.out.println("Enter cipher, shift,either encrypt or decrypt, and your message inside Quotations");
//		cipher = scan.nextInt();
//		cipherShift = scan.nextInt();
		input = scan.nextLine();
		encryOrDecry = input.substring(input.indexOf("e"), input.indexOf("t") + 1);
		encryOrDecry = input.substring(input.indexOf("d"), input.indexOf("t") + 1);
		System.out.println(encryOrDecry);
//		System.out.println(cipher);
//		System.out.println(cipherShift);
		
		
		

	}
	public static void fillAlpha(ArrayList<String> f,ArrayList<String> b){
		String alphaBet = "abcdefghijklmnopqrstuvwxyz ";
		for(int i = 0; i < alphaBet.length(); ++i){
			f.add(alphaBet.substring(i,i + 1));
			
			
		}
		for(int i = alphaBet.length() - 1; i >= 0;--i){
			b.add(alphaBet.substring(i,i + 1));
			
		}
		
	}
	public static String encrypt(){
		return null;
		
	}
	public static String decrypt(){
		return null;
		
	}

}
