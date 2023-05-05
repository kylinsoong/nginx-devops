package io.github.cloudadc.dumpplane;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestParse {
	
	public static void main(String[] args) {
		
		
		// Defining the input string
		String input = "nginx.conf 15.55.240.8";

		// Defining the regex pattern to match an IPv4 address
		String regex = "\\b(?:\\d{1,3}\\.){3}\\d{1,3}\\b";

		// Compiling the regex pattern
		Pattern pattern = Pattern.compile(regex);

		// Matching the pattern against the input string
		Matcher matcher = pattern.matcher(input);
		
		if(matcher.find()) {
			System.out.println(matcher.group());
		}
		
	}

}
