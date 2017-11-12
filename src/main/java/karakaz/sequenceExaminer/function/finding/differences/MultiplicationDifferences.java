package karakaz.sequenceExaminer.function.finding.differences;

import java.util.List;

import org.apache.commons.math3.stat.StatUtils;

import com.google.common.primitives.Doubles;

public class MultiplicationDifferences extends DifferenceGenerator{
	
	public static List<Double> generateDifferences(List<Double> sequence, int seedCount){
		return new MultiplicationDifferences(sequence, seedCount).generateDifferences();
	}

	public MultiplicationDifferences(List<Double> sequence, int seedCount){
		super(sequence, seedCount);
	}

	@Override
	protected double differenceFunction(List<Double> sequenceSublist){
		return StatUtils.product(Doubles.toArray(sequenceSublist));
	}

}
