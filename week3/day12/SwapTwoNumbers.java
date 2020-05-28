package week3.day12;

public class SwapTwoNumbers {
	
   // PROGRAM:
	 /* Write a java program to swap two numbers
		Input: a = 5, b= 10
		output: a = 10, b = 5
		(Note: Try without the third variable) */

	public static void main(String[] args) {
		
		int a = 5;
		int b = 10;
		
		int c = 0;
		
		System.out.println("Before swapping : " + "a = "+ a+ "  b = "+ b);
		
	  // 1st method without using third variable.
		// a=a+b;   b=a-b;   a=a-b;
		
	  // 2nd method without using third variable.
		 a=a*b;  b=a/b;  a=a/b;
		
	  // 3rd method without using third variable.
		// a=a-b;   b=a+b;   a=b-a;
		 
      // 4th method using third variable.
		// c=a;  a=b;  b=c;
		
		 System.out.println("After swapping : " + "a = "+ a+ "  b = "+ b);
}}