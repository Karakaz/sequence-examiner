package karakaz.sequenceExaminer.function.finding.differences;

import java.util.List;

import karakaz.sequenceExaminer.utils.DoubleEQ;

public abstract class Differences {

	public static List<Double> generateByLeftSubtracting(List<Double> sequence, int seedCount) {
		return LeftSubtractionDifferences.generateDifferences(sequence, seedCount);
	}

	public static List<Double> generateByRightSubtracting(List<Double> sequence, int seedCount){
		return RightSubtractionDifferences.generateDifferences(sequence, seedCount);
	}
	
	public static List<Double> generateByLeftDividing(List<Double> sequence, int seedCount) {
		return LeftDivisionDifferences.generateDifferences(sequence, seedCount);
	}
	
	public static List<Double> generateByAdding(List<Double> sequence, int seedCount) {
		return AdditionDifferences.generateDifferences(sequence, seedCount);
	}
	
	public static List<Double> generateByMultiplying(List<Double> sequence, int seedCount) {
		return MultiplicationDifferences.generateDifferences(sequence, seedCount);
	}

	public static boolean areAllEqual(List<Double> differences) {
		return differences.stream().allMatch(i -> i.equals(differences.get(0)));
	}

	public static boolean isSequenceHomogeneousRecursive(List<Double> sequence, List<Double> differences, int seedCount){
		for(int i = 1; i < differences.size(); i++){
			if(!DoubleEQ.equals(sequence.get(i - 1), differences.get(i))){
				return false;
			}
		}
		return true;
	}
}
