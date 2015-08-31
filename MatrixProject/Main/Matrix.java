import java.util.ArrayList;

public class Matrix {
	private ArrayList<String[]> matrix;
	private ArrayList<Integer> row1 = new ArrayList<Integer>();
	private ArrayList<Integer> row2 = new ArrayList<Integer>();
	private ArrayList<Integer> row3 = new ArrayList<Integer>();
	private ArrayList<Integer> row4 = new ArrayList<Integer>();
	private ArrayList<Integer> row5 = new ArrayList<Integer>();
	
	public Matrix(ArrayList<String[]> m){
		this.matrix = m;
		for (String [] convert : matrix){
			
		}
	}
	
	public void addition(ArrayList<String[]> o){
		
		
		for(int j = 0; j <matrix.size();++j){
		for(String[] add : o){
			int i = 0;
			int test = Integer.valueOf(matrix.get(j)[i]) + Integer.valueOf(add[i]);
			System.out.println(test);
		}
		}
				
		
	}
	public void multiplication(){
		
	}
	public void inverse(){
		
	}
	public void transpose(){
		
	}
	                            

}
