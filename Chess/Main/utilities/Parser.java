package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Parser {
	
	File needsParse;
	String[] move =  new String[25];

	public Parser(File f){
		
		this.needsParse = f;
	}

	public String[] readFile(){
		FileReader freader= null;

		try {

			freader=new FileReader(needsParse);
			BufferedReader inputFile=new BufferedReader(freader);

			String line;
			int i = 0;
			while((line = inputFile.readLine()) != null){
				move[i] = line;
				i++;
			}

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
		return move;
	}
}
