package karakaz.sequenceExaminer.difference;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.google.common.primitives.Doubles;

import karakaz.sequenceExaminer.SequenceExaminerTestBase;
import karakaz.sequenceExaminer.function.finding.differences.LeftDivisionDifferences;

public class DivisionDifferencesTest extends SequenceExaminerTestBase{

	@Test
	public void generateDifferencesLeft_Linear2Seeds_Twos(){
		List<Double> sequence = Arrays.asList(1.0, 2.0, 4.0);
		List<Double> differences = LeftDivisionDifferences.generateDifferences(sequence);
		assertArrayEquals(new double[]{2, 2}, Doubles.toArray(differences), EPSILON);
	}
	
	@Test
	public void generateDifferencesLeft_Linear2Seeds2(){
		List<Double> sequence = Arrays.asList(2.0, 4.0, 16.0, 128.0);
		List<Double> differences = LeftDivisionDifferences.generateDifferences(sequence);
		assertArrayEquals(new double[]{2, 4, 8}, Doubles.toArray(differences), EPSILON);
	}
	
	@Test
	public void generateDifferencesLeft_Linear3Seeds(){
		List<Double> sequence = Arrays.asList(1.0, 1.0, 2.0, 4.0, 8.0);
		List<Double> differences = LeftDivisionDifferences.generateDifferences(sequence, 3);
		assertArrayEquals(new double[]{2, 2, 1}, Doubles.toArray(differences), EPSILON);
	}
	
	@Test
	public void generateDifferencesLeft_Linear3Seeds2(){
		List<Double> sequence = Arrays.asList(2.0, 4.0, 8.0, 16.0, 32.0);
		List<Double> differences = LeftDivisionDifferences.generateDifferences(sequence, 3);
		assertArrayEquals(new double[]{1, 0.5, 0.25}, Doubles.toArray(differences), EPSILON);
	}
	
	@Test
	public void generateDifferencesLeft_Linear3Seeds3(){
		List<Double> sequence = Arrays.asList(1.0, 2.0, 3.0, 6.0, 36.0, 648.0);
		List<Double> differences = LeftDivisionDifferences.generateDifferences(sequence, 3);
		assertArrayEquals(new double[]{1.5, 1, 2, 3}, Doubles.toArray(differences), EPSILON);
	}

}
