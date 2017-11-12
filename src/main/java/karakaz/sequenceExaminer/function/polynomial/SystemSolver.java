package karakaz.sequenceExaminer.function.polynomial;

import java.util.List;

import org.ejml.data.DenseMatrix64F;
import org.ejml.ops.CommonOps;

public class SystemSolver{

	public static double[] solveSystem(int degree, List<Double> sequence){
		DenseMatrix64F coefficients = new DenseMatrix64F(generateCoefficients(degree, sequence.size()));
		DenseMatrix64F constants = new DenseMatrix64F(convertSequenceToArray(sequence));
		DenseMatrix64F solution = new DenseMatrix64F(degree + 1, 1);

		if(CommonOps.solve(coefficients, constants, solution)){
			return solutionToSingleArray(solution);
		}
		return new double[]{};
	}

	private static double[][] generateCoefficients(int degree, int rows){
		double[][] A = new double[rows][degree + 1];
		for(int i = 0; i < A.length; i++){
			for(int j = 0; j < A[i].length; j++){
				A[i][j] = Math.pow(i + 1, degree - j);
			}
		}
		return A;
	}
	
	private static double[][] convertSequenceToArray(List<Double> sequence){
		double[][] constants = new double[sequence.size()][1];
		for(int i = 0; i < constants.length; i++){
			constants[i][0] = sequence.get(i);
		}
		return constants;
	}
	
	private static double[] solutionToSingleArray(DenseMatrix64F solution){
		double[] arr = new double[solution.getNumRows()];
		for(int i = 0; i < arr.length; i++){
			arr[i] = solution.get(arr.length - 1 - i, 0);
		}
		return arr;
	}
}
