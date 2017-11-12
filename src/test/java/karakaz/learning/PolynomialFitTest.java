package karakaz.learning;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PolynomialFitTest{

	/**
	 * Test with perfect data
	 */
	@Test
	public void testPerfect(){
		double coef[] = new double[] { 1, -2, 3 };

		double x[] = new double[] { -2, 1, 0.5, 2, 3, 4, 5, 7, 8, 9.2, 10.2, 4.3, 6.7 };
		double y[] = new double[x.length];

		for(int i = 0; i < y.length; i++){
			double v = 0;
			double xx = 1;
			for(double c : coef){
				v += c * xx;
				xx *= x[i];
			}
			y[i] = v;
		}

		System.out.println("testPerfect()");
		
		for(int i = 0; i < x.length; i++){
			System.out.print(String.format("%.2f", x[i]) + "\t");
		}
		System.out.println();
		
		for(int i = 0; i < y.length; i++){
			System.out.print(String.format("%.2f", y[i]) + "\t");
		}
		System.out.println("\n");
		
		
		PolynomialFit alg = new PolynomialFit(2);

		alg.fit(x, y);

		double found[] = alg.getCoef();

		for(int i = 0; i < coef.length; i++){
			assertEquals(coef[i], found[i], 1e-8);
		}
	}

	/**
	 * Make one of the observations way off and see if it is removed
	 */
	@Test
	public void testNoise(){
		double coef[] = new double[] { 1, -2, 3 };

		double x[] = new double[] { -2, 1, 0.5, 2, 3, 4, 5, 7, 8, 9.2, 10.2, 4.3, 6.7 };
		double y[] = new double[x.length];

		for(int i = 0; i < y.length; i++){
			double v = 0;
			double xx = 1;
			for(double c : coef){
				v += c * xx;
				xx *= x[i];
			}

			y[i] = v;
		}

		y[4] += 3.5;

		System.out.println("testNoise()");
		
		for(int i = 0; i < x.length; i++){
			System.out.print(String.format("%.2f", x[i]) + "\t");
		}
		System.out.println();
		
		for(int i = 0; i < y.length; i++){
			System.out.print(String.format("%.2f", y[i]) + "\t");
		}
		System.out.println("\n");
		
		PolynomialFit alg = new PolynomialFit(2);

		alg.fit(x, y);

		double found[] = alg.getCoef();

		// the coefficients that it initialy computes should be incorrect

		for(int i = 0; i < coef.length; i++){
			assertTrue(Math.abs(coef[i] - found[i]) > 1e-8);
		}

		// remove the outlier
		alg.removeWorstFit();

		// now see if the solution is perfect
		found = alg.getCoef();

		for(int i = 0; i < coef.length; i++){
			assertEquals(coef[i], found[i], 1e-8);
		}
	}
}
