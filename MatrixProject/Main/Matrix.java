import java.util.ArrayList;

public class Matrix {

	private double[][] matrix;
	
	
	
	public Matrix(double[][] m){
		this.matrix = m;
		
		
		
		
	}
	public double[][] getMatrix() {
		return matrix;
	}

	
	public double[][] addition(double[][] A){
		double [][] B = this.getMatrix();
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
		
		int mA = this.matrix.length;
        int nA = this.matrix[0].length;
        int mB = B.length;
        int nB = B[0].length;
        if (nA != mB) throw new RuntimeException("Illegal matrix dimensions.");
        double[][] C = new double[mA][nB];
        for (int i = 0; i < mA; i++){
            for (int j = 0; j < nB; j++){
                for (int k = 0; k < nA; k++){
                    C[i][j] += this.matrix[i][k] * B[k][j];
                
        System.out.println(this.matrix[i][k] + " " + B[k][j]);
                }
            }
        }
        return C;
		
	}
//	public double[][] inverse(double[][] a) throws Exception {
//		// Formula used to Calculate Inverse:
//		// inv(A) = 1/det(A) * adj(A)
//		
//		int tms = a.length;
//
//		double m[][] = new double[tms][tms];
//		double mm[][] = Adjoint(a);
//
//		double det = Determinant(a);
//		double dd = 0;
//
//		
//			dd = 1 / det;
//		
//
//		for (int i = 0; i < tms; i++)
//			for (int j = 0; j < tms; j++) {
//				m[i][j] = dd * mm[i][j];
//			}
//
//		return m;
//	}
		
	
	public double[][] transpose(double[][] A){

		int m = A.length;
        int n = A[0].length;
        double[][] C = new double[n][m];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                C[j][i] = A[i][j];
        return C;
	                            
	}
//	public double Determinant(double[][] matrix) {
//		
//		int tms = matrix.length;
//
//		double det = 1;
//
//		matrix = UpperTriangle(matrix);
//
//		for (int i = 0; i < tms; i++) {
//			det = det * matrix[i][i];
//		} // multiply down diagonal
//
//		det = det * iDF; // adjust w/ determinant factor
//
//		
//		return det;
//	}
//	public double[][] UpperTriangle(double[][] m) {
//		
//		double f1 = 0;
//		double temp = 0;
//		int tms = m.length; // get This Matrix Size (could be smaller than
//							// global)
//		int v = 1;
//
//		iDF = 1;
//
//		for (int col = 0; col < tms - 1; col++) {
//			for (int row = col + 1; row < tms; row++) {
//				v = 1;
//
//				outahere: while (m[col][col] == 0) // check if 0 in diagonal
//				{ // if so switch until not
//					if (col + v >= tms) // check if switched all rows
//					{
//						iDF = 0;
//						break outahere;
//					} else {
//						for (int c = 0; c < tms; c++) {
//							temp = m[col][c];
//							m[col][c] = m[col + v][c]; // switch rows
//							m[col + v][c] = temp;
//						}
//						v++; // count row switchs
//						iDF = iDF * -1; // each switch changes determinant
//										// factor
//					}
//				}
//
//				if (m[col][col] != 0) {
//					
//
//					try {
//						f1 = (-1) * m[row][col] / m[col][col];
//						for (int i = col; i < tms; i++) {
//							m[row][i] = f1 * m[col][i] + m[row][i];
//						}
//					} catch (Exception e) {
//						System.out.println("Still Here!!!");
//					}
//
//				}
//
//			}
//		}
//
//		return m;
//	}
//	public double[][] Adjoint(double[][] a) throws Exception {
//		
//		int tms = a.length;
//
//		double m[][] = new double[tms][tms];
//
//		int ii, jj, ia, ja;
//		double det;
//
//		for (int i = 0; i < tms; i++)
//			for (int j = 0; j < tms; j++) {
//				ia = ja = 0;
//
//				double ap[][] = new double[tms - 1][tms - 1];
//
//				for (ii = 0; ii < tms; ii++) {
//					for (jj = 0; jj < tms; jj++) {
//
//						if ((ii != i) && (jj != j)) {
//							ap[ia][ja] = a[ii][jj];
//							ja++;
//						}
//
//					}
//					if ((ii != i) && (jj != j)) {
//						ia++;
//					}
//					ja = 0;
//				}
//
//				det = Determinant(ap);
//				m[i][j] = (double) Math.pow(-1, i + j) * det;
//			}
//
//		m = transpose(m);
//
//		return m;
//	}


}
