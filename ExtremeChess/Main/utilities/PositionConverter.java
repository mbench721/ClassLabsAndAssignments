package utilities;

public class PositionConverter {
	private int convertedY;
	private int convertedX;

	public int convertX(String x){
		convertedX = 0;

		if(x.equalsIgnoreCase("b")){
			convertedX = 1;

		}
		else if(x.equalsIgnoreCase("c")){
			convertedX = 2;

		}
		else if(x.equalsIgnoreCase("d")){
			convertedX = 3;

		}
		else if(x.equalsIgnoreCase("e")){
			convertedX = 4;

		}
		else if(x.equalsIgnoreCase("f")){
			convertedX = 5;

		}
		else if(x.equalsIgnoreCase("g")){
			convertedX = 6;

		}
		else if(x.equalsIgnoreCase("h")){
			convertedX = 7;

		}
		


		return convertedX;

	}
	public int convertY(String y){
		convertedY = 0;
		
		if(y.equalsIgnoreCase("2")){
			convertedY = 1;

		}
		else if(y.equalsIgnoreCase("3")){
			convertedY = 2;

		}
		else if(y.equalsIgnoreCase("4")){
			convertedY = 3;

		}
		else if(y.equalsIgnoreCase("5")){
			convertedY = 4;

		}
		else if(y.equalsIgnoreCase("6")){
			convertedY = 5;

		}
		else if(y.equalsIgnoreCase("7")){
			convertedY = 6;

		}
		else if(y.equalsIgnoreCase("8")){
			convertedY = 7;

		}
	
	
		
		

		return convertedY;

	}

}
