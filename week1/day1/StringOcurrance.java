package week1.day1;

public class StringOcurrance {
	
	public static void main(String[] args) {
		
	/* PROGRAM:
	    Write a Java Program to find the occurance of the character 'o' in the following String.
		Input: "You have no choice other than following me!"
		output: Occurance of o is: 6
    */
		
		
		String word = "You have no choice other than following me!";
		int count=0;
		char[] array = word.toCharArray();
		for(int i=0; i < word.length(); i++) {
			
			// 1st approach ---------------> Starts here
//			if(array[i]=='o') {
//				count++;
//			}
			              //<--------------- finish here
			
			
			// 2nd approach ---------------> Starts here
//			if(word.charAt(i)=='o') {
//				count++;
//				          //<--------------- finish here
//			}
		}
		// Output sysout statement for both 1st and 2nd approach is below
		     // System.out.println("The occurance of o is : " +count);
		
		
		
			// 3rd approach ---------------> Starts here
			String replaceAll = word.replaceAll("[^o]", "");
			int length = replaceAll.length();
			System.out.println("The occurance of o is : " +length);
						  //<--------------- finish here

	}
}
