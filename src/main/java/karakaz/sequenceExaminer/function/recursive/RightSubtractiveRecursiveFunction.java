package karakaz.sequenceExaminer.function.recursive;

import java.util.List;

public class RightSubtractiveRecursiveFunction extends RecursiveFunction{

	public RightSubtractiveRecursiveFunction(List<Double> seeds){
		super(seeds);
	}

	@Override
	protected double operation(List<Double> numbers){
		int result = 0;
		for(int i = 1; i < numbers.size(); i++){
			result += numbers.get(i - 1) - numbers.get(i);
			
		}
		return result;
	}

	@Override
	protected String getDifferenceOperationSymbol(){
		return "-";
	}

}
