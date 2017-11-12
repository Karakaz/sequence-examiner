package karakaz.sequenceExaminer.nextInSequence;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import karakaz.sequenceExaminer.SequenceExaminer;
import karakaz.sequenceExaminer.SequenceExaminerTestBase;

public class NextInSequenceRecursive extends SequenceExaminerTestBase{

	@Test
	public void nextInSequence_RecursiveGrowthFibonacci(){
		assertEquals(5, SequenceExaminer.examine(1, 1, 2, 3).nextInSequence(), EPSILON);
	}
	
	@Test
	public void nextInSequence_RecursiveGrowthFibonacciExtended(){
		assertEquals(89, SequenceExaminer.examine(1, 1, 2, 3, 5, 8, 13, 21, 34, 55).nextInSequence(), EPSILON);
	}
	
	@Test
	public void nextInSequence_RecursiveGrowthAddingThreeSeeds(){
		assertEquals(9, SequenceExaminer.examine(1, 1, 1, 3, 5).nextInSequence(), EPSILON);
	}
	
	@Test
	public void nextInSequence_RecursiveGrowthAddingFourSeeds(){
		assertEquals(19, SequenceExaminer.examine(1, 2, 3, 4, 10).nextInSequence(), EPSILON);
	}
	
	@Test
	public void nextInSequence_RecursiveGrowthMultiplicationTwoSeeds(){
		assertEquals(8, SequenceExaminer.examine(1, 2, 2, 4).nextInSequence(), EPSILON);
	}
	
	@Test
	public void nextInSequence_RecursiveGrowthMultiplicationThreeSeeds(){
		assertEquals(139968, SequenceExaminer.examine(1, 2, 3, 6, 36, 648).nextInSequence(), EPSILON);
	}
	
	@Test
	public void nextInSequence_RecursiveGrowthMultiplicationFourSeeds(){
		assertEquals(64, SequenceExaminer.examine(1, 2, 2, 2, 8).nextInSequence(), EPSILON);
	}
	
	@Test
	public void nextInSequence_RecursiveGrowthMultiplicationFourSeeds2(){
		assertEquals(536870912, SequenceExaminer.examine(1, 1, 2, 2, 4, 16, 256, 32768).nextInSequence(), EPSILON);
	}
		
	@Test
	public void nextInSequence_RecursiveDecaySubtractionTwoSeeds(){
		assertEquals(0, SequenceExaminer.examine(1, 1, 0, -1, -1, 0, 1, 1).nextInSequence(), EPSILON);
	}
	
	@Test
	public void nextInSequence_RecursiveDecaySubtractionTwoSeeds2(){
		assertEquals(-3, SequenceExaminer.examine(5, 2, -3, -5, -2, 3, 5, 2).nextInSequence(), EPSILON);
	}
}
