package karakaz.sequenceExaminer.function.finding.differences;

import java.util.List;
import java.util.stream.Collectors;

import karakaz.sequenceExaminer.function.Function;
import karakaz.sequenceExaminer.function.finding.FunctionFinder;
import karakaz.sequenceExaminer.function.recursive.RecursiveFactory;

public class RecursiveFunctionFinder implements FunctionFinder{

	@Override
	public Function findFromSequence(List<Double> sequence){
			
		for(int seedCount = 2; seedCount < sequence.size(); seedCount++){
			
			List<Double> subtractionDifferences = Differences.generateByLeftSubtracting(sequence, seedCount);
			List<Double> divisionDifferences = Differences.generateByLeftDividing(sequence, seedCount);
			
			List<Double> inversedSubDifferences = subtractionDifferences.stream().mapToDouble(d -> d * -1).boxed().collect(Collectors.toList());
			
			if(Differences.isSequenceHomogeneousRecursive(sequence, subtractionDifferences, seedCount)) {
				return RecursiveFactory.createAddativeRecursive(sequence, seedCount);
			} 
			else if(Differences.isSequenceHomogeneousRecursive(sequence, divisionDifferences, seedCount)) {
				return RecursiveFactory.createMultiplicativeRecursive(sequence, seedCount);
			}
			else if(Differences.isSequenceHomogeneousRecursive(sequence, inversedSubDifferences, seedCount)){
				return RecursiveFactory.createRepeatingSubtractiveRecursive(sequence, seedCount);
			}
		}
			
		return null;
	}

}
