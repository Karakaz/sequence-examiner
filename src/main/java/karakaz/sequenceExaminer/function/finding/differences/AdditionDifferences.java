package karakaz.sequenceExaminer.function.finding.differences;

import java.util.List;

import org.apache.commons.math3.stat.StatUtils;

import com.google.common.primitives.Doubles;

public class AdditionDifferences extends DifferenceGenerator{
	
	public static List<Double> generateDifferences(List<Double> sequence, int seedCount){
		return new AdditionDifferences(sequence, seedCount).generateDifferences();
	}

	private AdditionDifferences(List<Double> sequence, int seedCount){
		super(sequence, seedCount);
	}

	@Override
	protected double differenceFunction(List<Double> sequenceSublist){
		return StatUtils.sum(Doubles.toArray(sequenceSublist));
	}

}
