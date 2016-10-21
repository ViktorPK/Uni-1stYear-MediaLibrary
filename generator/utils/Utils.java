package viktor.generator.utils;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Martin
 *
 */
public class Utils {
	
	/**
	 * @param line
	 * @return
	 */
	public static String capitalise(String line) {

		String capitalised = "";
		
		for ( String word : line.split(" " ) ) {
			
			capitalised += Character.toUpperCase(word.charAt(0)) + word.substring(1) + " ";
			
		}
		
		return capitalised.substring(0, capitalised.length() - 1);
	
	}
	
	/**
	 * @param start
	 * @param end
	 * @return
	 */
	public static int randomBetween( int start, int end ) {
	     
		return start + (int)Math.round( Math.random() * (end - start) );
    
	}
	
}