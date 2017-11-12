package karakaz.learning;

import static org.junit.Assert.*;

import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.DecompositionSolver;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import org.junit.Test;

public class ApacheMathTest{

	@Test
	public void thirdDegreeSystem(){
		
		double[][] A = new double[][] { { 1, 1, 1, 1 }, { 8, 4, 2, 1 }, { 27, 9, 3, 1 }, { 64, 16, 4, 1 } };
		
		RealMatrix coefficients = new Array2DRowRealMatrix(A);

		DecompositionSolver solver = new LUDecomposition(coefficients).getSolver();

		RealVector constants = new ArrayRealVector(new double[] { 0, 12, 10, 0 });
		RealVector solution = solver.solve(constants);

		double a = solution.getEntry(0);
		double b = solution.getEntry(1);
		double c = solution.getEntry(2);
		double d = solution.getEntry(3);

		System.out.printf("%.2fn^3 + %.2fn^2 + %.2fn + %.2f%n", a, b, c, d);
		System.out.println("=");
		System.out.printf("%.2f%n", a * Math.pow(7, 3) + b * Math.pow(7, 2) + c * 7 + d);

		//////////////////////////////////

		PolynomialFunction polynomial = new PolynomialFunction(new double[] { d, c, b, a });
		System.out.printf("%.2f%n", polynomial.value(5));
		assertEquals(-18, polynomial.value(7), 0.000001);
	}

}
