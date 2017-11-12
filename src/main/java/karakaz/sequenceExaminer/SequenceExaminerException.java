package karakaz.sequenceExaminer;

import java.util.List;

public class SequenceExaminerException extends RuntimeException{

	private static final long serialVersionUID = 2692862135021842668L;
	
	private List<Double> sequence;

	public SequenceExaminerException(List<Double> sequence){
		this.sequence = sequence;
	}
	
	public SequenceExaminerException(List<Double> sequence, String message){
		super(message);
		this.sequence = sequence;
	}
	
	public List<Double> getSequence(){
		return sequence;
	}
	
}
