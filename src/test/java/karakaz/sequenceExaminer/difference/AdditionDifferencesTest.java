package karakaz.sequenceExaminer.difference;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.google.common.primitives.Doubles;

import karakaz.sequenceExaminer.SequenceExaminerTestBase;
import karakaz.sequenceExaminer.function.finding.differences.AdditionDifferences;

public class AdditionDifferencesTest extends SequenceExaminerTestBase{

	@Test
	public void generateDifferences_Linear2Seeds_Linear(){
		List<Double> sequence = Arrays.asList(1.0, 2.0, 3.0, 4.0);
		List<Double> differences = AdditionDifferences.generateDifferences(sequence, 2);
		assertArrayEquals(new double[]{3, 5, 7}, Doubles.toArray(differences), EPSILON);
	}
	
	@Test
	public void generateDifferences_Linear2Seeds2_Linear(){
		List<Double> sequence = Arrays.asList(0.0, 5.0, 10.0);
		List<Double> differences = AdditionDifferences.generateDifferences(sequence, 2);
		assertArrayEquals(new double[]{5, 15}, Doubles.toArray(differences), EPSILON);
	}
	
	@Test
	public void generateDifferences_Linear3Seeds_Linear(){
		List<Double> sequence = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0);
		List<Double> differences = AdditionDifferences.generateDifferences(sequence, 3);
		assertArrayEquals(new double[]{6, 9, 12, 15}, Doubles.toArray(differences), EPSILON);
	}

}
