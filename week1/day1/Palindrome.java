package week1.day1;

public class Palindrome {

	public static void main(String[] args) {
	
		
	    /* PROGRAM:
		    Check for the palindrome of the given string:
			Input: "malayalam"
			output: Yes, Palindrome
			Input: "testleaf"
			output: No, not a palindrome
	    */
		
		
		
		// 1st approach
				// for output ---> Yes it is a palindrome
//				String word = "malayalam";
//				StringBuffer stb = new StringBuffer(word);
//				StringBuffer reverse = stb.reverse();
//				String rev = reverse.toString();
//				if(rev.equals(word)) {
//					System.out.println("Yes, it is a palindrome");
//				} else { 
//					System.out.println("No, it is not a palindrome");
//				}

		
		// 2nd approach
				String word = "malayalam";
				// Creating an empty string to store the reverse value
				String rev = "";
				
				for (int i = word.length()-1; i >=0; i--) {
					rev += word.charAt(i);
				}
				// condition ? True statement : False statement
				System.out.println(rev.equals(word)?"Yes, It is a Palindrome":"No, it is not a palindrome");
			
				
		// 1st approach
				// for output ---> No, it is not a palindrome
//				String word = "testleaf";
//				StringBuffer stb = new StringBuffer(word);
//				StringBuffer reverse = stb.reverse();
//				String rev = reverse.toString();
//				if(rev.equals(word)) {
//					System.out.println("Yes, it is a palindrome");
//				} else { 
//					System.out.println("No, it is not a palindrome");
//				}

			}
	}
