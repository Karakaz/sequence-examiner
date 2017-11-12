package karakaz.sequenceExaminer.results;

import java.util.List;

import karakaz.sequenceExaminer.SequenceExaminerException;
import karakaz.sequenceExaminer.function.Function;

public class FirstSequenceResults implements SequenceResults{

	private List<Double> sequence;
	private List<Function> functions;

	public FirstSequenceResults(List<Double> sequence, List<Function> functions){
		this.sequence = sequence;
		this.functions = functions;
	}

	@Override
	public double nextInSequence(){
		if(!functions.isEmpty()){
			return functions.get(0).getStep(sequence.size() + 1);
		} else{
			throw new SequenceExaminerException(sequence, "No function was found for sequence");
		}
	}

	@Override
	public Function getFunction(){
		return functions.get(0);
	}
}
