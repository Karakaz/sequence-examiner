package karakaz.sequenceExaminer.function.recursive;

import java.util.List;

public class LeftSubtractiveRecursiveFunction extends RecursiveFunction{

	public LeftSubtractiveRecursiveFunction(List<Double> seeds){
		super(seeds);
	}

	@Override
	protected double operation(List<Double> numbers){
		int result = 0;
		for(int i = 1; i < numbers.size(); i++){
			result += numbers.get(i) - numbers.get(i - 1);
			
		}
		return result;
	}

	@Override
	protected String getDifferenceOperationSymbol(){
		return "-";
	}

}
