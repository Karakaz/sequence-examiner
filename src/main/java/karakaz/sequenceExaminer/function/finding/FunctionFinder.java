package karakaz.sequenceExaminer.function.finding;

import java.util.List;

import karakaz.sequenceExaminer.function.Function;

public interface FunctionFinder{
	
	public Function findFromSequence(List<Double> sequence);
	
}
