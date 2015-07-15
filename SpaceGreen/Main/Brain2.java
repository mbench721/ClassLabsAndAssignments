public class Brain2  {
	static int fuel = 150;
	static int apex;
	static int countdown = 0;
	static int motherX = 0;
	static int shipY = 0;
	static int motherW = 0;


	Brain2(){

	}
	static void checkCount(){
		if (apex < 250){
			fuel --;
			countdown ++ ;
		}
	}

}



