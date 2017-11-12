package karakaz.sequenceExaminer.function.recursive;

import java.util.List;

import karakaz.sequenceExaminer.utils.FormulaBuilder;

public class RecursiveAsFormulaFormatter extends FormulaBuilder{
	
	private List<Double> seeds;
	
	public static String format(List<Double> seeds, String operationSymbol){
		return new RecursiveAsFormulaFormatter(seeds, operationSymbol).format();
	}
	
	private RecursiveAsFormulaFormatter(List<Double> seeds, String operationSymbol){
		super(operationSymbol);
		this.seeds = seeds;
	}

	private String format(){
		buildFunction();
		buildSeeds();
		return formula.toString();
	}

	private void buildFunction(){
		formula.append("F(n) = ");
		for(int i = 1; i <= seeds.size(); i++){
			formula.append("F(n-").append(i).append(")");
			if(i < seeds.size()){
				formula.append(operationDilimiter);
			}
		}
	}
	
	private void buildSeeds(){
		for(int i = 0; i < seeds.size(); i++){
			formula.append(", F(").append(i + 1).append(") = ").append(DECIMAL_FORMATTER.format(seeds.get(i)));
		}
	}
}
