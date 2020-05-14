package week1.day3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidEmailAddressOrNot {
	
	public static void main(String[] args) {
		
		/* PROGRAM:
			 * Write a Java program to verify whether the given String is valid email address.
			 * 
			 * input : "sravan.mr@testleaf.com"
			 * Output : true
			 * 
			 * input : "sravan.mr@testleaf.co.us"
			 * Output : true
			 * 
			 * input : "sravan mr@testleaf.com"
			 * Output : false
			 * 
			 * Note: Spl characters ._ are only allowed.
		*/
		
		
		String input1 = "sravan.mr@testleaf.com";
		String input2 = "sravan.mr@testleaf.co.us";
		String input3 = "sravan mr@testleaf.com";
		
		String pattern = "[a-zA-Z0-9._]+@[a-z]+.[a-z.]{2,}";
		Pattern compile = Pattern.compile(pattern);
		Matcher matcher = compile.matcher(input1);
		System.out.println("Output of input1 is : "+matcher.matches());
		System.out.println("Output of input2 is : "+ compile.matcher(input2).matches());
		System.out.println("Output of input3 is : "+ compile.matcher(input3).matches());
	}
}
