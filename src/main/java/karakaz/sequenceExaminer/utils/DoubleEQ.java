package karakaz.sequenceExaminer.utils;

public class DoubleEQ{
	
	public static double epsilon = 0.000000001;
	
	public static boolean equals(double number1, double number2){
		return Math.abs(number1 - number2) < epsilon;
	}
	
	public static boolean zero(double number){
		return Math.abs(number) < epsilon;
	}
	
	public static boolean one(double number){
		return Math.abs(number - 1) < epsilon;
	}
	
	public static boolean minusOne(double number){
		return Math.abs(number + 1) < epsilon;
	}
}
