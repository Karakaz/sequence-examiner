package karakaz.sequenceExaminer.function.recursive;

import java.util.List;

import org.apache.commons.math3.stat.StatUtils;

import com.google.common.primitives.Doubles;

public class AdditiveRecursiveFunction extends RecursiveFunction{
	
	public AdditiveRecursiveFunction(List<Double> seeds){
		super(seeds);
	}

	@Override
	protected double operation(List<Double> numbers){
		return StatUtils.sum(Doubles.toArray(numbers));
	}

	@Override
	protected String getDifferenceOperationSymbol(){
		return "+";
	}
}
