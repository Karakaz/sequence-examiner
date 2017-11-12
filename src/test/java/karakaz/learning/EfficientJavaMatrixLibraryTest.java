package karakaz.learning;

import org.ejml.data.DenseMatrix64F;
import org.ejml.ops.CommonOps;
import org.junit.Test;

public class EfficientJavaMatrixLibraryTest{

	@Test
	public void thirdDegreeSystem(){
		
		double[][] A = new double[][] { { 1, 1, 1, 1 }, { 8, 4, 2, 1 }, { 27, 9, 3, 1 }, { 64, 16, 4, 1 } };
		
		DenseMatrix64F coefficients = new DenseMatrix64F(A);
		
		DenseMatrix64F constants = new DenseMatrix64F(new double[][]{{0}, {12}, {10}, {0}});
		
		DenseMatrix64F result = new DenseMatrix64F(4, 1);
		
		CommonOps.solve(coefficients, constants, result);
		
		System.out.printf("%.2fn^3 + %.2fn^2 + %.2fn + %.2f%n", result.get(0, 0), result.get(1, 0), result.get(2, 0), result.get(3, 0));
	}

}
