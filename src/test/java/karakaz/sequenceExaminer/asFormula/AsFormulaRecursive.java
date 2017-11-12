package karakaz.sequenceExaminer.asFormula;

import static org.junit.Assert.*;

import org.junit.Test;

import karakaz.sequenceExaminer.SequenceExaminer;
import karakaz.sequenceExaminer.SequenceExaminerTestBase;

public class AsFormulaRecursive extends SequenceExaminerTestBase{

	@Test
	public void asFormula_RecursiveGrowthFibonacci(){
//		System.out.println("Expected:\tF(n) = F(n-1) + F(n-2), F(1) = 1, F(2) = 1");
//		System.out.println("Actual:  \t" + SequenceExaminer.examine(1, 1, 2, 3).getFunction().asFormula());
		assertEquals("F(n) = F(n-1) + F(n-2), F(1) = 1, F(2) = 1", SequenceExaminer.examine(1, 1, 2, 3).getFunction().asFormula()); 
	}
	
	@Test
	public void asFormula_RecursiveGrowthFibonacciExtended(){
		assertEquals("F(n) = F(n-1) + F(n-2), F(1) = 1, F(2) = 1", SequenceExaminer.examine(1, 1, 2, 3, 5, 8, 13, 21, 34, 55).getFunction().asFormula()); 
	}
	
	@Test
	public void asFormula_RecursiveGrowthAdditiveThreeSeeds(){
		assertEquals("F(n) = F(n-1) + F(n-2) + F(n-3), F(1) = 1, F(2) = 1, F(3) = 1", SequenceExaminer.examine(1, 1, 1, 3, 5).getFunction().asFormula()); 
	}
	
	@Test
	public void asFormula_RecursiveGrowthAdditiveFourSeeds(){
		assertEquals("F(n) = F(n-1) + F(n-2) + F(n-3) + F(n-4), F(1) = 1, F(2) = 2, F(3) = 3, F(4) = 4", SequenceExaminer.examine(1, 2, 3, 4, 10).getFunction().asFormula()); 
	}
   
	@Test
	public void asFormula_RecursiveGrowthMultiplicativeTwoSeeds(){
		assertEquals("F(n) = F(n-1) * F(n-2), F(1) = 1, F(2) = 2", SequenceExaminer.examine(1, 2, 2, 4).getFunction().asFormula()); 
	}
   
	@Test
	public void asFormula_RecursiveFibonacciStep0_Undefined(){
		assertEquals("F(0) = Undefined", SequenceExaminer.examine(1, 1, 2, 3).getFunction().asFormula(0)); 
	}
	
	@Test
	public void asFormula_RecursiveFibonacciStepMinus1_Undefined(){
		assertEquals("F(-1) = Undefined", SequenceExaminer.examine(1, 1, 2, 3).getFunction().asFormula(-1)); 
	}
	
	@Test
	public void asFormula_RecursiveFibonacciStepPoint5_Undefined(){
		assertEquals("F(0) = Undefined", SequenceExaminer.examine(1, 1, 2, 3).getFunction().asFormula(0.5)); 
	}
	
	@Test
	public void asFormula_RecursiveFibonacciStep1Point5(){
		assertEquals("F(1) = 1", SequenceExaminer.examine(1, 1, 2, 3).getFunction().asFormula(1.5)); 
	}
	
	@Test
	public void asFormula_RecursiveGrowthFibonacciStep1(){
		assertEquals("F(1) = 1", SequenceExaminer.examine(1, 1, 2, 3).getFunction().asFormula(1)); 
	}
	
	@Test
	public void asFormula_RecursiveGrowthFibonacciStep2(){
		assertEquals("F(2) = 1", SequenceExaminer.examine(1, 1, 2, 3).getFunction().asFormula(2)); 
	}
	
	@Test
	public void asFormula_RecursiveGrowthFibonacciStep3(){
		assertEquals("F(3) = 1 + 1", SequenceExaminer.examine(1, 1, 2, 3).getFunction().asFormula(3)); 
	}
	
	@Test
	public void asFormula_RecursiveGrowthFibonacciStep4(){
		assertEquals("F(4) = 1 + 2", SequenceExaminer.examine(1, 1, 2, 3).getFunction().asFormula(4)); 
	}
	
	@Test
	public void asFormula_RecursiveGrowthFibonacciStep5(){
		assertEquals("F(5) = 2 + 3", SequenceExaminer.examine(1, 1, 2, 3).getFunction().asFormula(5)); 
	}
	
	@Test
	public void asFormula_RecursiveGrowthFibonacciStep6(){
		assertEquals("F(6) = 3 + 5", SequenceExaminer.examine(1, 1, 2, 3).getFunction().asFormula(6)); 
	}
	
	@Test
	public void asFormula_RecursiveGrowthFibonacciStep7(){
		assertEquals("F(7) = 5 + 8", SequenceExaminer.examine(1, 1, 2, 3).getFunction().asFormula(7)); 
	}
	
	@Test
	public void asFormula_RecursiveGrowthAdditiveThreeSeedsStep3(){
		assertEquals("F(3) = 1", SequenceExaminer.examine(1, 1, 1, 3).getFunction().asFormula(3)); 
	}
	
	@Test
	public void asFormula_RecursiveGrowthAdditiveThreeSeedsStep4(){
		assertEquals("F(4) = 1 + 1 + 1", SequenceExaminer.examine(1, 1, 1, 3).getFunction().asFormula(4)); 
	}
	
	@Test
	public void asFormula_RecursiveGrowthAdditiveThreeSeedsStep5(){
		assertEquals("F(5) = 1 + 1 + 3", SequenceExaminer.examine(1, 1, 1, 3).getFunction().asFormula(5)); 
	}
	
	@Test
	public void asFormula_RecursiveGrowthAdditiveThreeSeedsStep6(){
		assertEquals("F(6) = 1 + 3 + 5", SequenceExaminer.examine(1, 1, 1, 3).getFunction().asFormula(6)); 
	}

}
