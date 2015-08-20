package utilities;

import java.io.File;

public class FileIo {
	
	private File movesFile;
	private String[] fileNames;

	public FileIo(String[] fileNames){
		
		this.fileNames = fileNames;
		movesFile = new File(fileNames[1]);
			
	}
	
	public String[] getFileNames() {
		return fileNames;
	}
	
	public File getMovesFile() {
		return movesFile;
	}

	

}
