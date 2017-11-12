package karakaz.sequenceExaminer;

import java.util.Arrays;
import java.util.List;

import karakaz.sequenceExaminer.function.FunctionType;

public class ExaminerProperties{
	
	private List<FunctionType> availableFunctions = Arrays.asList(FunctionType.all);
	private boolean forcedFunctionOrder;
	
	private int numberOfDecimals = 2;
	
	/**
	 * Set which types of functions {@link SequenceExaminer} will look for<br>
	 * {@code Default: Function.all}
	*/
	public void setAvailableFunctions(FunctionType... functions){
		assertThatAllIsLastElement(functions);
		availableFunctions = Arrays.asList(functions);
	}
	
	private void assertThatAllIsLastElement(FunctionType[] functions){
		for(int i = 0; i < functions.length; i++){
			if(functions[i] == FunctionType.all && i != functions.length - 1){
				throw new IllegalArgumentException("If Function.all is included, it must be the last element");
			}
		}
	}
	
	/**
	 * Whether or not to enforce the function order<br>
	 * {@code Default: false}
	*/
	public void setForceFunctionOrder(boolean forceOrder){
		forcedFunctionOrder = forceOrder;
	}

	/**
	 * Number of decimals will be used when printing the formula<br>
	 * {@code Default: 2}
	 */
	public void setNumberOfDecimalsInFormula(int decimals){
		if(decimals < 0 || decimals > 17){
			throw new IllegalArgumentException("Legal decimal range is [0, 17]");
		}
		numberOfDecimals = decimals;
	}
	
	public List<FunctionType> getAvailableFunctions(){
		return availableFunctions;
	}
	
	public boolean getForceFunctionOrder(){
		return forcedFunctionOrder;
	}
	
	public int getNumberOfDecimals(){
		return numberOfDecimals;
	}
}
