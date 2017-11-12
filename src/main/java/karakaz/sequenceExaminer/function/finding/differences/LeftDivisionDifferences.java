package karakaz.sequenceExaminer.function.finding.differences;

import java.util.List;

import com.google.common.collect.Iterables;

public class LeftDivisionDifferences extends DifferenceGenerator{
	
	public static List<Double> generateDifferences(List<Double> sequence){
		return new LeftDivisionDifferences(sequence, 2).generateDifferences();
	}
	
	public static List<Double> generateDifferences(List<Double> sequence, int seedCount){
		return new LeftDivisionDifferences(sequence, seedCount).generateDifferences();
	}
	
	private LeftDivisionDifferences(List<Double> sequence, int seedCount){
		super(sequence, seedCount);
	}

	@Override
	protected double differenceFunction(List<Double> sequenceSublist){
		double result = Iterables.getLast(sequenceSublist);
		for(int i = sequenceSublist.size() - 2; i >= 0; i--){
			result /= sequenceSublist.get(i);
		}
		return result;
	}

}
