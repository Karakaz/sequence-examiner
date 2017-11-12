package karakaz.sequenceExaminer.function.finding.differences;

import java.util.List;

public class RightSubtractionDifferences extends DifferenceGenerator{

	public static List<Double> generateDifferences(List<Double> sequence){
		return new RightSubtractionDifferences(sequence, 2).generateDifferences();
	}
	
	public static List<Double> generateDifferences(List<Double> sequence, int seedCount){
		return new RightSubtractionDifferences(sequence, seedCount).generateDifferences();
	}
	
	private RightSubtractionDifferences(List<Double> sequence, int seedCount){
		super(sequence, seedCount);
	}
	
	@Override
	protected double differenceFunction(List<Double> sequenceSublist){
		double result = sequenceSublist.get(0);
		for(int i = 1; i < sequenceSublist.size(); i++){
			result -= sequenceSublist.get(i);
		}
		return result;
	}

}
