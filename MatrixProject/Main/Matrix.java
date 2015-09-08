import java.util.ArrayList;

public class Matrix {

	private double[][] matrix;
	private int numRows;
	private int numCols;

	public Matrix(double[][] m){
		matrix = m;
		this.numRows = m.length;
		this.numCols = m[0].length;
		
		
		
	}
	public int getNumRows() {
		return numRows;
	}
	public int getNumCols() {
		return numCols;
	}
	public double[][] getMatrix() {
		return matrix;
	}

	
	public double[][] addition(double[][] A){
		double [][] B = matrix;
		int m = A.length;
        int n = A[0].length;
        double[][] C = new double[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
            	
                C[i][j] = A[i][j] + B[i][j];
            }
        }
		return C;
		
		
		
				
		
	}
	public double[][] multiplication(double[][] B){
		
		int mA = matrix.length;
        int nA = matrix[0].length;
        int mB = B.length;
        int nB = B[0].length;
        if (nA != mB) throw new RuntimeException("Illegal matrix dimensions.");
        double[][] C = new double[mA][nB];
        for (int i = 0; i < mA; i++){
            for (int j = 0; j < nB; j++){
                for (int k = 0; k < nA; k++){
                    C[i][j] += matrix[i][k] * B[k][j];
                
        System.out.println(matrix[i][k] + " " + B[k][j]);
                }
            }
        }
        return C;
		
	}

		
	
	public Matrix transpose(Matrix matrix2){

		int m = matrix2.getNumRows();
        int n = matrix2.getNumCols();
        Matrix C = new Matrix (new double[n][m]);
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
            	
                C.setValueAt(j, i, matrix2.getValueAt(i, j));
            }
        }
        return C;
	                            
	}
	public static double determinant(Matrix matrix) {
	    
	   
	    if (matrix.numCols==2 && matrix.numRows == 2) {
	        return (matrix.getValueAt(0, 0) * matrix.getValueAt(1, 1)) - ( matrix.getValueAt(0, 1) * matrix.getValueAt(1, 0));
	    }
	    double sum = 0.0;
	    for (int i=0; i<matrix.getNumCols(); i++) {
	        sum += changeSign(i) * matrix.getValueAt(0, i) * determinant(createSubMatrix(matrix, 0, i));
	    }
	    return sum;
	} 
	
	public static Matrix cofactor(Matrix matrix2) {
	    double[][] mattr = new double[matrix2.numRows][matrix2.numCols];
	    Matrix mat = new Matrix(mattr);
	    for (int i=0;i<mat.numRows;i++) {
	        for (int j=0; j<mat.numCols;j++) {
	            mat.setValueAt(i, j,changeSign(i) * changeSign(j) * determinant(createSubMatrix(matrix2, i, j)));
	            System.out.println(mat.getMatrix()[i][j]);
	        }
	    }
	    
	    return mat;
	}
	public static Matrix createSubMatrix(Matrix matrix2, int excluding_row, int excluding_col) {
	    Matrix mat = new Matrix (new double [matrix2.numRows - 1][ matrix2.numCols - 1 ]);
	    int r = -1;
	    for (int i=0;i<matrix2.numRows;i++) {
	        if (i==excluding_row)
	            continue;
	            r++;
	            int c = -1;
	        for (int j=0;j<matrix2.numCols;j++) {
	            if (j==excluding_col)
	                continue;
	            mat.setValueAt(r, ++c, matrix2.getValueAt(i, j));
	        }
	    }
	    return mat;
	} 
	
	private void setValueAt(int r, int i, double valueAt) {
	//	System.out.println(valueAt);
		this.matrix[r][i] = valueAt;
		
	}
	public double getValueAt(int i, int j){
		return this.matrix[i][j];
		
		
	}
	public static int changeSign(int i){
		if(i % 2 == 0){
			return 1;
		}
		
			return -1;
		
	}
	
	public Matrix inverse(Matrix matrix) {
	    return (transpose(cofactor(matrix)).multiplyByConstant(1.0 / determinant(matrix)));
	}
	private Matrix multiplyByConstant(double d) {
		Matrix det = this;
		for (int i = 0; i < matrix.length; i++) {
			
			   for(int j = 0; j < matrix[i].length; j++) {
				   det.getMatrix()[i][j] *= d;
			       
			
			   }
			
			}

		return det;
	}
	


}
