package karakaz.sequenceExaminer.function.recursive;

import java.util.List;

import karakaz.sequenceExaminer.function.Function;

public class RecursiveFactory{

	public static Function createAddativeRecursive(List<Double> sequence, int seedCount){
		List<Double> seeds = sequence.subList(0, seedCount);
		return new AdditiveRecursiveFunction(seeds);
	}

	public static Function createMultiplicativeRecursive(List<Double> sequence, int seedCount){
		List<Double> seeds = sequence.subList(0, seedCount);
		return new MultiplicativeRecursiveFunction(seeds);
	}

	public static Function createRepeatingSubtractiveRecursive(List<Double> sequence, int seedCount){
		List<Double> seeds = sequence.subList(0, seedCount);
		return new LeftSubtractiveRecursiveFunction(seeds);
	}
}
