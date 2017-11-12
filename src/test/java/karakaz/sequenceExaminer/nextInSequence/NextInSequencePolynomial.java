package karakaz.sequenceExaminer.nextInSequence;

import static org.junit.Assert.*;
import karakaz.sequenceExaminer.SequenceExaminer;
import karakaz.sequenceExaminer.SequenceExaminerTestBase;

import org.junit.Test;

public class NextInSequencePolynomial extends SequenceExaminerTestBase{

   @Test
   public void nextInSequence_EMPTY() {
       assertEquals(0, SequenceExaminer.examine().nextInSequence(), EPSILON);
   }

   @Test
   public void nextInSequence_Zero() {
       assertEquals(0, SequenceExaminer.examine(0).nextInSequence(), EPSILON);
   }

   @Test
   public void nextInSequence_One() {
       assertEquals(1, SequenceExaminer.examine(1).nextInSequence(), EPSILON);
   }
   
   @Test
   public void nextInSequence_Two() {
   	assertEquals(2, SequenceExaminer.examine(2).nextInSequence(), EPSILON);
   }

   @Test
   public void nextInSequence_MinusOne() {
       assertEquals(-1, SequenceExaminer.examine(-1).nextInSequence(), EPSILON);
   }

   @Test
   public void nextInSequence_2Ones_One() {
       assertEquals(1, SequenceExaminer.examine(1, 1).nextInSequence(), EPSILON);
   }
   
   @Test
   public void nextInSequence_2Tens_Ten() {
   	assertEquals(10, SequenceExaminer.examine(10, 10).nextInSequence(), EPSILON);
   }
   
   @Test
   public void nextInSequence_3Hundred_Hundred() {
   	assertEquals(100, SequenceExaminer.examine(100, 100, 100).nextInSequence(), EPSILON);
   }

   @Test
   public void nextInSequence_LinearIncreasing() {
       assertEquals(5, SequenceExaminer.examine(1, 2, 3, 4).nextInSequence(), EPSILON); // x+
   }

   @Test
   public void nextInSequence_LinearIncreasing2() {
       assertEquals(2500, SequenceExaminer.examine(500, 1000, 1500, 2000).nextInSequence(), EPSILON); //x+
   }

   @Test
   public void nextInSequence_LinearDecreasing() {
       assertEquals(3, SequenceExaminer.examine(7, 6, 5, 4).nextInSequence(), EPSILON); // x-
   }

   @Test
   public void nextInSequence_SquaredGrowth() {
       assertEquals(16, SequenceExaminer.examine(1, 4, 9).nextInSequence(), EPSILON); // x^2
   }
   
   @Test
   public void nextInSequence_SquaredGrowthExtraNumber() {
   	assertEquals(25, SequenceExaminer.examine(1, 4, 9, 16).nextInSequence(), EPSILON); // x^2
   }

   
   @Test
   public void nextInSequence_SquaredGrowthPlusConstant() {
   	assertEquals(37, SequenceExaminer.examine(2, 5, 10, 17, 26).nextInSequence(), EPSILON); // x^2 + 1
   }
   
   @Test
   public void nextInSequence_SquaredGrowthMinusConstant() {
       assertEquals(33, SequenceExaminer.examine(1, 6, 13, 22).nextInSequence(), EPSILON); // x^2 - 3
   }

   @Test
   public void nextInSequence_SquaredDecay() {
       assertEquals(4, SequenceExaminer.examine(36, 25, 16, 9).nextInSequence(), EPSILON); // x^2
   }

   @Test
   public void nextInSequence_CubicGrowth() {
       assertEquals(343, SequenceExaminer.examine(8, 27, 64, 125, 216).nextInSequence(), EPSILON); // x^3
   }

   @Test
   public void nextInSequence_QuarticGrowth() {
       assertEquals(4096, SequenceExaminer.examine(16, 81, 256, 625, 1296, 2401).nextInSequence(), EPSILON); // x^4
   }

}
