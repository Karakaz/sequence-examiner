package karakaz.sequenceExaminer.function.polynomial;

import karakaz.sequenceExaminer.utils.DoubleEQ;


public class PolynomialFunction implements Polynomial{

	private double[] coefficients;

	public PolynomialFunction(double[] coefficients){
		this.coefficients = coefficients;
		correctMinusZeroToZero();
	}
	
	private void correctMinusZeroToZero(){
		for(int i = 0; i < coefficients.length; i++){
			if(DoubleEQ.zero(coefficients[i])){
				coefficients[i] = 0;
			}
		}
	}

	@Override
	public int getDegree(){
		return coefficients.length - 1;
	}
	
	@Override
	public double getStep(double step){
		double result = 0;
		for(int i = 0; i < coefficients.length; i++){
			result += coefficients[i] * Math.pow(step, i);
		}
		return result;
	}

	@Override
	public String asFormula(){
		return PolynomialFormulaFormatter.format(coefficients);
	}

	@Override
	public String asFormula(double step){
		return PolynomialFormulaFormatter.format(coefficients, step);
	}

}
