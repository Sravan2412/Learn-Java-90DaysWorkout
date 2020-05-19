package week2.day6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicatesFromList {
	
  // PROGRAM
	/* How to remove duplicates from a list? 
	 * List = "A,B,C,D,A,D,E,F"
	 */
	

	public static void main(String[] args) {
		
		String input = "ABCDADEF";
		List<Character> list = new ArrayList<>();
		
	  // 1st method
		/* for (int i = 0; i < input.length(); i++) {
		 * if(!list.contains(input.charAt(i))) {
		 * list.add(input.charAt(i)); } }
		 * System.out.println(list);
		 */
		
	  // 2nd method
		for (int i = 0; i < input.length(); i++) {
			list.add(input.charAt(i));
		}
		Set<Character> set = new HashSet<>(list);
		System.out.println(set);
	}
}
