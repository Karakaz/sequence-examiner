package karakaz.sequenceExaminer.function.finding.differences;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public abstract class DifferenceGenerator{
	
	protected List<Double> sequence;
	private int seedCount;

	public DifferenceGenerator(List<Double> sequence, int seedCount){
		this.sequence = sequence;
		this.seedCount = seedCount;
	}

	protected List<Double> generateDifferences(){
		DoubleStream differencesStream = IntStream.range(0, sequence.size() - seedCount + 1).mapToDouble(this::generateDifference);
		return differencesStream.boxed().collect(Collectors.toList());
	}
	
	protected double generateDifference(int index){
		return differenceFunction(sequence.subList(index, index + seedCount));
	}
	
	protected abstract double differenceFunction(List<Double> sequenceSublist);
}
