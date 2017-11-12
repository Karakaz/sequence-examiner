package karakaz.sequenceExaminer.utils;

public abstract class FormulaBuilder extends BaseDecimalFormatter{

	protected StringBuilder formula;
	protected String operationDilimiter;
	
	protected FormulaBuilder(){
		formula = new StringBuilder(100);
	}
	
	protected FormulaBuilder(String operationSymbol){
		this();
		operationDilimiter = ' ' + operationSymbol + ' ';
	}
}
