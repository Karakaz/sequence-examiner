package karakaz.sequenceExaminer.function.finding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import karakaz.sequenceExaminer.ExaminerProperties;
import karakaz.sequenceExaminer.function.FunctionType;
import karakaz.sequenceExaminer.function.finding.differences.DifferenceFunctionFinder;
import karakaz.sequenceExaminer.function.finding.differences.RecursiveFunctionFinder;

public abstract class FunctionFinderFactory{

	private static List<FunctionFinder> functionFinders;
	private static Map<FunctionType, FunctionFinder> allFunctionFinders;
	
	public static List<FunctionFinder> createFunctionFinders(ExaminerProperties properties){
		functionFinders = new ArrayList<>();
		allFunctionFinders = getAllFunctionFinders();

		createFunctionFindersUsing(properties);
		
		return functionFinders;
	}

	private static void createFunctionFindersUsing(ExaminerProperties properties){
		List<FunctionType> availableFunctions = properties.getAvailableFunctions();
		for(FunctionType type : availableFunctions){
			switch(type){
				case polynomial:
				case recursive:
					functionFinders.add(allFunctionFinders.remove(type));
					break;
				case all:
					if(!allFunctionFinders.isEmpty()){
						functionFinders.addAll(allFunctionFinders.values());
					}
					break;
				default:
					System.out.println("Unhandled type: " + type);//TODO remove default
					break;
			}
		}
		allFunctionFinders = null;
	}

	private static Map<FunctionType, FunctionFinder> getAllFunctionFinders(){
		Map<FunctionType, FunctionFinder> functionFinders = new HashMap<>();
		functionFinders.put(FunctionType.recursive, new RecursiveFunctionFinder());
		functionFinders.put(FunctionType.polynomial, new DifferenceFunctionFinder());
		return functionFinders;
	}
}
