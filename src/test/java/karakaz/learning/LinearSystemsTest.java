package karakaz.learning;

import static org.junit.Assert.assertEquals;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import org.ejml.data.DenseMatrix64F;
import org.ejml.ops.CommonOps;
import org.junit.Test;

public class LinearSystemsTest{

	private static final double DELTA = 0.0000000001;

	private static final double[][] A = new double[][]{ { 1, 1, 1, 1 }, { 8, 4, 2, 1 }, { 27, 9, 3, 1 }, { 64, 16, 4, 1 } };
	private static final double[] b = new double[]{ 0, 12, 10, 0 };
	
	@Test
	public void ApacheMath_ThirdDegreeSystem(){
		RealMatrix coefficients = new Array2DRowRealMatrix(A);
		RealVector constants = new ArrayRealVector(b);
		RealVector solution = new LUDecomposition(coefficients).getSolver().solve(constants);
		
		assertEquals(1, solution.getEntry(0), DELTA);
		assertEquals(-13, solution.getEntry(1), DELTA);
		assertEquals(44, solution.getEntry(2), DELTA);
		assertEquals(-32, solution.getEntry(3), DELTA);
	}

	@Test
	public void EJML_ThirdDegreeSystem(){
		DenseMatrix64F coefficients = new DenseMatrix64F(A);
		DenseMatrix64F constants = new DenseMatrix64F(new double[][]{ {b[0]}, {b[1]}, {b[2]}, {b[3]} });
		DenseMatrix64F solution = new DenseMatrix64F(4, 1);
		
		CommonOps.solve(coefficients, constants, solution);
		
		assertEquals(1, solution.get(0, 0), DELTA);
		assertEquals(-13, solution.get(1, 0), DELTA);
		assertEquals(44, solution.get(2, 0), DELTA);
		assertEquals(-32, solution.get(3, 0), DELTA);
	}
	
}
