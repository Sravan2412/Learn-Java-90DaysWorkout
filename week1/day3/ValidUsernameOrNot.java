package week1.day3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidUsernameOrNot {

	public static void main(String[] args) {
		
		/* PROGRAM:
		 * Write a Java program to validate whether the given username is valid or not.
		 * 
		 * input : "Gates$123"
		 * Output : true
		 * 
		 * input : "Gates1"
		 * Output : false
		 * 
		 * Note:
		 * 1. It should contain minumum 8 characters
		 * 2. It allows alpha numeric characters and spl characters like ._@$
	*/

		String input1 = "Gates$123";
		String input2 = "Gates1";
		
		String pattern = "[a-zA-Z0-9._@$]{8,}";
		Pattern compile = Pattern.compile(pattern);
		Matcher matcher = compile.matcher(input1);
		System.out.println("Output of input1 is : "+ matcher.matches());
		System.out.println("Output of input2 is : "+ compile.matcher(input2).matches());

	}
}