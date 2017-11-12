package karakaz.sequenceExaminer.function.recursive;

import java.util.List;

import karakaz.sequenceExaminer.utils.FormulaBuilder;

public class RecursiveAsFormulaWithStepFormatter extends FormulaBuilder{
	
	private int seedCount;
	private List<Double> functionResults;
	private int intStep;
	
	public static String format(int seedCount, List<Double> functionResults, String operationSymbol, double step){
		return new RecursiveAsFormulaWithStepFormatter(seedCount, functionResults, operationSymbol, step).format();
	}

	private RecursiveAsFormulaWithStepFormatter(int seedCount, List<Double> functionResults, String operationSymbol, double step){
		super(operationSymbol);
		this.seedCount = seedCount;
		this.functionResults = functionResults;
		intStep = (int)step;
	}

	private String format(){
		formula.append("F(").append(intStep).append(") = ");

		if(stepIsInUndefinedRange()){
			formula.append("Undefined");
		}
		else if(isStepASeed()){
			formula.append(DECIMAL_FORMATTER.format(functionResults.get(intStep - 1)));
		} else{
			buildVariables();
		}
		return formula.toString();
	}

	private boolean stepIsInUndefinedRange(){
		return intStep <= 0;
	}
	
	private boolean isStepASeed(){
		return intStep <= seedCount;
	}
	
	private void buildVariables(){
		for(int i = 0; i < seedCount; i++){
			formula.append(DECIMAL_FORMATTER.format(functionResults.get(functionResults.size() - seedCount + i - 1)));
			if(i < seedCount - 1){
				formula.append(operationDilimiter);
			}
		}
	}
}
