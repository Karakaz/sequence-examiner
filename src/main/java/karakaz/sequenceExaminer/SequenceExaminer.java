package karakaz.sequenceExaminer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import karakaz.sequenceExaminer.function.Function;
import karakaz.sequenceExaminer.function.finding.FunctionFinder;
import karakaz.sequenceExaminer.function.finding.FunctionFinderFactory;
import karakaz.sequenceExaminer.function.polynomial.PolynomialFactory;
import karakaz.sequenceExaminer.results.FirstSequenceResults;
import karakaz.sequenceExaminer.results.SequenceResults;

public class SequenceExaminer{

	private ExaminerProperties staticProperties;
	
	private ExaminerProperties properties;
	
	private List<Double> sequence;
	private List<FunctionFinder> functionFinders;
	
	private List<Function> functions;

   public static SequenceResults examine(double... sequence){
       return examine(Arrays.asList(ArrayUtils.toObject(sequence)));
   }

   public static SequenceResults examine(List<Double> sequence){
       return new SequenceExaminer().examineSequence(sequence);
   }

	public SequenceExaminer(){
		this(new ExaminerProperties());
   }
	
	public SequenceExaminer(ExaminerProperties properties){
		this.properties = properties;
      functionFinders = FunctionFinderFactory.createFunctionFinders(properties);
      functions = new ArrayList<>();
	}
	
	public SequenceResults examineSequence(List<Double> sequence){
		this.sequence = sequence;
		if(sequence.size() < 2){
			createPolynomialFunction();
		} else{
			findFromSequence();
		}
		return new FirstSequenceResults(sequence, functions);
	}

	private void createPolynomialFunction(){
		if(sequence.isEmpty()){
			functions.add(PolynomialFactory.createDefault());
		} else if(sequence.size() == 1){
			functions.add(PolynomialFactory.createConstant(sequence.get(0)));
		}
	}

	private void findFromSequence(){
		for(FunctionFinder functionFinder : functionFinders){
			Function function = functionFinder.findFromSequence(sequence);
			if(function != null){
				functions.add(function);
			}
		}
	}
}
