package karakaz.sequenceExaminer.function.finding.differences;

import java.util.List;

import karakaz.sequenceExaminer.function.Function;
import karakaz.sequenceExaminer.function.finding.FunctionFinder;
import karakaz.sequenceExaminer.function.polynomial.PolynomialFactory;

public class DifferenceFunctionFinder implements FunctionFinder{

	@Override
	public Function findFromSequence(List<Double> sequence){
		List<Double> differences = sequence;
		
		for(int degree = 0; degree < sequence.size(); degree++){
			
			if(Differences.areAllEqual(differences)){
				return PolynomialFactory.createPolynomial(degree, sequence);
			}
			differences = Differences.generateByLeftSubtracting(differences, 2);
		}
		return null;
	}
}
