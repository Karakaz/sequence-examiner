package karakaz.sequenceExaminer.function.recursive;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import com.google.common.collect.Iterables;

import karakaz.sequenceExaminer.function.Function;

public abstract class RecursiveFunction implements Function{

	private List<Double> seeds;
	
	public RecursiveFunction(List<Double> seeds){
		this.seeds = seeds;
	}
	
	@Override
	public double getStep(double step){
		if(step >= 1) {
			if(step <= 2) {
				return seeds.get((int) step);
			}else {
				return Iterables.getLast(generateStepsToLast(step));
			}
		}
		return -1;
	}
	
	private List<Double> generateStepsToLast(double lastStep){
		List<Double> result = new ArrayList<>(seeds);
		IntStream.range(seeds.size(), (int) lastStep).forEach(i -> result.add(operation(result.subList(i - seeds.size(), i))));
		return result;
	}

	protected abstract double operation(List<Double> numbers);
	
	@Override
	public String asFormula(){
		return RecursiveAsFormulaFormatter.format(seeds, getDifferenceOperationSymbol());
	}

	protected abstract String getDifferenceOperationSymbol();
	
	@Override
	public String asFormula(double step){
		return RecursiveAsFormulaWithStepFormatter.format(seeds.size(), generateStepsToLast(step), getDifferenceOperationSymbol(), step);
	}
}
