package karakaz.sequenceExaminer.utils;

import java.text.DecimalFormat;

import org.apache.commons.lang3.StringUtils;

public abstract class BaseDecimalFormatter{

	private static final int DECIMAL_PRECISION = 2;
	protected static final String NUMBER_FORMAT = "#." + StringUtils.repeat('#', DECIMAL_PRECISION);
	protected static final DecimalFormat DECIMAL_FORMATTER = new DecimalFormat(NUMBER_FORMAT);
	
	public static String format(double number){
		return DECIMAL_FORMATTER.format(number);
	}
	
}
