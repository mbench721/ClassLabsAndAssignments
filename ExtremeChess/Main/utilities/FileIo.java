package utilities;

import java.io.File;
import java.util.ArrayList;

public class FileIo {
	
	private File movesFile;
	private ArrayList<String> fileNames;
	private ArrayList<File> files = new ArrayList();

	public FileIo(ArrayList<String> fileNames){
		
		this.fileNames = fileNames;
		for (String name : fileNames){
			
		}
		
		if(fileNames.size() >= 2){
			movesFile = new File(fileNames.get(fileNames.size() - 1));
		}if(fileNames.size() == 1 && !fileNames.get(0).equalsIgnoreCase("v")){
			movesFile = new File(fileNames.get(fileNames.size() -1 ));
		}
		
	
			
	}
	
	public ArrayList<String> getFileNames() {
		return fileNames;
	}
	
	public File getMovesFile() {
		return movesFile;
	}

	

}
