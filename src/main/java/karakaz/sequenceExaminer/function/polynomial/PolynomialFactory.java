package karakaz.sequenceExaminer.function.polynomial;

import java.util.List;

public class PolynomialFactory{

	private static final double DEFAULT_CONSTANT_VALUE = 0;
	
	public static Polynomial createPolynomial(int degree, List<Double> sequence){
		double[] coefficients = SystemSolver.solveSystem(degree, sequence);
		return new PolynomialFunction(coefficients);
	}

	public static Polynomial createDefault(){
		return new PolynomialFunction(new double[]{DEFAULT_CONSTANT_VALUE});
	}

	public static Polynomial createConstant(double constant){
		return new PolynomialFunction(new double[]{constant});
	}
}
