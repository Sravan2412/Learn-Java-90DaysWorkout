package week1.day2;

public class SumOfGivenNumbers {

	public static void main(String[] args) {
		
		/* PROGRAM: 
		   Write a java code to find the sum of the given numbers
		   Input: "asdf1qwer9as8d7"
		   output: 1+9+8+7 = 25
		*/
		
		
		String Input = "asdf1qwer9as8d7";
		String newInput = Input.replaceAll("[\\D]", "");
		int count = 0;
		
		
		// 1st approach ---------------> Starts here
		for (int i = 0; i < newInput.length(); i++) {
			char charAt = newInput.charAt(i);
			count = count + Character.getNumericValue(charAt);
		}
		System.out.println(count);
		//             <--------------- finish here
		
		
		
		// 2nd approach ---------------> Starts here
//		for (char intValue : newInput.toCharArray() ) {
//			int digit = intValue - '0';
//			count= count + digit;
//		}
//		System.out.println(count);
		//            <--------------- finish here
		
		
		
	
		// 3rd approach ---------------> Starts here
//		for (int i = 0; i < Input.length(); i++) {
//			if(Character.isDigit(Input.charAt(i))) {
//				count = count + Character.getNumericValue(Input.charAt(i));
//			}
//		}
//		    System.out.println(count);	
		//            <--------------- finish here
 }
 }
