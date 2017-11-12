package karakaz.sequenceExaminer.asFormula;

import static org.junit.Assert.*;

import org.junit.Test;

import karakaz.sequenceExaminer.SequenceExaminer;
import karakaz.sequenceExaminer.SequenceExaminerTestBase;

public class AsFormulaPolynomial extends SequenceExaminerTestBase{

   @Test
   public void asFormula_EMPTY() {
   	assertEquals("0", SequenceExaminer.examine().getFunction().asFormula());
   }

   @Test
   public void asFormula_One() {
   	assertEquals("1", SequenceExaminer.examine(1).getFunction().asFormula());
   }
   
   @Test
   public void asFormula_3Hundred_Hundred() {
   	assertEquals("100", SequenceExaminer.examine(100, 100, 100).getFunction().asFormula());
   }

   @Test
   public void asFormula_LinearIncreasing() {
   	assertEquals("x", SequenceExaminer.examine(1, 2, 3, 4).getFunction().asFormula());
   }
   
   @Test
   public void asFormula_LinearDecreasing() {
   	assertEquals("-x", SequenceExaminer.examine(-1, -2, -3, -4).getFunction().asFormula());
   }

   @Test
   public void asFormula_SquaredGrowth() {
   	assertEquals("x^2", SequenceExaminer.examine(1, 4, 9).getFunction().asFormula());
   }
   
   @Test
   public void asFormula_SquaredGrowthPlusConstant() {
       assertEquals("x^2 + 1", SequenceExaminer.examine(2, 5, 10, 17, 26).getFunction().asFormula());
   }
   
   @Test
   public void asFormula_SquaredGrowthPlusConstantWithStep() {
       assertEquals("5^2 + 1", SequenceExaminer.examine(2, 5, 10, 17, 26).getFunction().asFormula(5));
   }
   
}
