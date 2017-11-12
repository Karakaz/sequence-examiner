package karakaz.sequenceExaminer.function.polynomial;

import java.text.DecimalFormat;

import karakaz.sequenceExaminer.utils.DoubleEQ;
import karakaz.sequenceExaminer.utils.FormulaBuilder;

public class PolynomialFormulaFormatter extends FormulaBuilder{
	
	private static final String COEFFICIENT_DECIMAL_FORMAT = String.format(" + %1$s; - %1$s", NUMBER_FORMAT);
	private static final DecimalFormat COEFFICIENT_FORMATTER = new DecimalFormat(COEFFICIENT_DECIMAL_FORMAT);
	
	private double[] coefficients;
	
	public static String format(double[] coefficients, double step){
		return format(coefficients).replace("x", DECIMAL_FORMATTER.format(step));
	}
	
	public static String format(double[] coefficients){
		return new PolynomialFormulaFormatter(coefficients).format();
	}

	private PolynomialFormulaFormatter(double[] coefficients){
		super();
		this.coefficients = coefficients;
	}
	
	private String format(){
		if(coefficients.length == 1){
			return DECIMAL_FORMATTER.format(coefficients[0]);
		}else{
			return buildPolynomialString();
		}
	}
	private String buildPolynomialString(){
		for(int degree = 0; degree < coefficients.length; degree++){
			buildCoefficient(degree);
		}
		correctFormulaSignPrefix();
		return formula.toString();
	}

	private void buildCoefficient(int degree){
		if(!DoubleEQ.zero(coefficients[degree])){
			if(degree >= 2){
				formula.insert(0, "^" + degree);
			}
			if(degree >= 1){
				formula.insert(0, "x");
			}
			if(degree == 0){
				formula.insert(0, COEFFICIENT_FORMATTER.format(coefficients[degree]));	
			} else{
				if(DoubleEQ.one(coefficients[degree])){
					formula.insert(0, " + ");
				} else if(DoubleEQ.minusOne(coefficients[degree])){
					formula.insert(0, " - ");
				} else{
					formula.insert(0, COEFFICIENT_FORMATTER.format(coefficients[degree]));
				}
			}
		}
	}
	
	private void correctFormulaSignPrefix(){
		if(formula.length() > 3){
			if(formula.charAt(1) == '+'){
				formula.delete(0, 3);
			} else if(formula.charAt(1) == '-'){
				formula.deleteCharAt(2);
				formula.deleteCharAt(0);
			}
		}
	}
}
