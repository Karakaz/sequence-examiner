package karakaz.sequenceExaminer.difference;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.google.common.primitives.Doubles;

import karakaz.sequenceExaminer.SequenceExaminerTestBase;
import karakaz.sequenceExaminer.function.finding.differences.LeftSubtractionDifferences;
import karakaz.sequenceExaminer.function.finding.differences.RightSubtractionDifferences;

public class SubtractionDiffrencesTest extends SequenceExaminerTestBase{
	
	@Test
	public void generateDifferencesLeft_Linear2Seeds_Ones(){
		List<Double> sequence = Arrays.asList(1.0, 2.0, 3.0);
		List<Double> differences = LeftSubtractionDifferences.generateDifferences(sequence);
		assertArrayEquals(new double[]{1, 1}, Doubles.toArray(differences), EPSILON);
	}
	
	@Test
	public void generateDifferencesLeft_Linear2Seeds_Twos(){
		List<Double> sequence = Arrays.asList(2.0, 4.0, 6.0, 8.0);
		List<Double> differences = LeftSubtractionDifferences.generateDifferences(sequence);
		assertArrayEquals(new double[]{2, 2, 2}, Doubles.toArray(differences), EPSILON);
	}
	
	@Test
	public void generateDifferencesLeft_Linear3Seeds_Linear(){
		List<Double> sequence = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
		List<Double> differences = LeftSubtractionDifferences.generateDifferences(sequence, 3);
		assertArrayEquals(new double[]{0, -1, -2}, Doubles.toArray(differences), EPSILON);
	}
	
	@Test
	public void generateDifferencesLeft_Linear3Seeds2_Linear(){
		List<Double> sequence = Arrays.asList(2.0, 4.0, 6.0, 8.0, 10.0, 12.0);
		List<Double> differences = LeftSubtractionDifferences.generateDifferences(sequence, 3);
		assertArrayEquals(new double[]{0, -2, -4, -6}, Doubles.toArray(differences), EPSILON);
	}
	
	@Test
	public void generateDifferencesLeft_SquaredGrowth_Linear(){
		List<Double> sequence = Arrays.asList(1.0, 4.0, 9.0, 16.0);
		List<Double> differences = LeftSubtractionDifferences.generateDifferences(sequence);
		assertArrayEquals(new double[]{3, 5, 7}, Doubles.toArray(differences), EPSILON);
	}
	
	@Test
	public void generateDifferencesRight_Linear_Ones(){
		List<Double> sequence = Arrays.asList(1.0, 2.0, 3.0);
		List<Double> differences = RightSubtractionDifferences.generateDifferences(sequence);
		assertArrayEquals(new double[]{-1, -1}, Doubles.toArray(differences), EPSILON);
	}
	
	@Test
	public void generateDifferencesRight_Linear_Twos(){
		List<Double> sequence = Arrays.asList(2.0, 4.0, 6.0, 8.0);
		List<Double> differences = RightSubtractionDifferences.generateDifferences(sequence);
		assertArrayEquals(new double[]{-2, -2, -2}, Doubles.toArray(differences), EPSILON);
	}
	
	@Test
	public void generateDifferencesRight_SquaredGrowth_Linear(){
		List<Double> sequence = Arrays.asList(1.0, 4.0, 9.0, 16.0);
		List<Double> differences = RightSubtractionDifferences.generateDifferences(sequence);
		assertArrayEquals(new double[]{-3, -5, -7}, Doubles.toArray(differences), EPSILON);
	}
}
