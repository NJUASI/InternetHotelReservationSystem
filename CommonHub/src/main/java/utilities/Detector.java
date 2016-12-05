package utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Detector {

	
	public static boolean idDetector(String express, int length){
		
		String expression = "[0-9]{"+String.valueOf(length)+"}";
		
		Pattern pattern = Pattern.compile(expression);
		Matcher matcher = pattern.matcher(express);
		boolean result = matcher.matches(); //当条件满足时，将返回true，否则返回false
		
		return result;
	}
	
}
