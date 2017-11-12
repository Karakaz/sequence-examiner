package karakaz.sequenceExaminer.nextInSequence;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import karakaz.sequenceExaminer.SequenceExaminer;
import karakaz.sequenceExaminer.SequenceExaminerTestBase;

@Ignore("Exponenials not yet implemented")
public class NextInSequenceExponential extends SequenceExaminerTestBase{

 @Test
 public void nextInSequence_ExponentialGrowthBase2() {
     assertEquals(32, SequenceExaminer.examine(2, 4, 8, 16).nextInSequence(), EPSILON); // 2^x
 }

 @Test
 public void nextInSequence_ExponentialGrowthBase3() {
     assertEquals(243, SequenceExaminer.examine(3, 9, 27, 81).nextInSequence(), EPSILON); // 3^x
 }
 
 @Test
 public void nextInSequence_ExponentialGrowthBase3Point5TimesBy3Point5() {
 	assertEquals(150.0625, SequenceExaminer.examine(1, 3.5, 12.25, 42.875).nextInSequence(), EPSILON);
 }

 @Test
 public void nextInSequence_ExponentialGrowthBase2PlusConstant() {
     assertEquals(33, SequenceExaminer.examine(3, 5, 9, 17).nextInSequence(), EPSILON); // 2^x + 1
 }

 @Test
 public void nextInSequence_ExponentialGrowthBase2PlusConstant2() {
     assertEquals(42, SequenceExaminer.examine(12, 14, 18, 26).nextInSequence(), EPSILON); // 2^x + 10
 }

 @Test
 public void nextInSequence_ExponentialGrowthBase2MinusConstant() {
     assertEquals(31, SequenceExaminer.examine(1, 3, 7, 15).nextInSequence(), EPSILON); // 2^x - 1
 }

 @Test
 public void nextInSequence_ExponentialGrowthBase3PlusConstant() {
     assertEquals(244, SequenceExaminer.examine(4, 10, 28, 82).nextInSequence(), EPSILON); // 3^x + 1
 }

 @Test
 public void nextInSequence_ExponentialGrowthBase3PlusConstant2() {
     assertEquals(253, SequenceExaminer.examine(13, 19, 37, 91).nextInSequence(), EPSILON); // 3^x + 10
 }

 @Test
 public void nextInSequence_ExponentialGrowthBase3MinusConstant() {
     assertEquals(242, SequenceExaminer.examine(2, 8, 26, 80).nextInSequence(), EPSILON); // 3^x - 1
 }
 
}
