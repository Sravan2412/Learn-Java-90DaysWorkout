package week1.day2;

public class NumberOfUppercaseLowercase {

	public static void main(String[] args) {
		
		/* PROGRAM:
		    Write a java program to find the number of Uppercase, lowercase, numbers and spaces in the following String.
			Input:  "1. It is Work from Home  not Work for Home"
		*/
		
		
		String input = "1. It is Work from Home  not Work for Home";
		char[] charArray = input.toCharArray();
		int uppercase = 0, lowercase = 0, numbers = 0, spaces = 0;
		for (int i = 0; i < charArray.length; i++) {
			char newChar = charArray[i];
			
				if(Character.isUpperCase(newChar))
					    uppercase++;	
				if (Character.isLowerCase(newChar))
					    lowercase++;		
				if (Character.isDigit(newChar)) 
					    numbers++;		
				if (Character.isSpace(newChar)) 
					    spaces++;
			
		}
		System.out.println("Count of Uppercase is : "+uppercase);
		System.out.println("Count of Lowercase is : "+lowercase);
		System.out.println("Count of Numbers is : "+numbers);
		System.out.println("Count of Spaces is : "+spaces);

	}
}
