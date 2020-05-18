package week2.day5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PrintList {
	
	/* PROGRAM:
	 * Write a java program to print the list (Need 3 different answers) 
	 * Input: "Bugatti Chiron"
	 */
	
	public static void main(String[] args) {
		
		String input = "Bugatti Chiron";
		List<Character> list = new ArrayList<Character>();
		for (int i = 0; i < input.length(); i++) {
			list.add(input.charAt(i));
		}
		
	// 1st Approach 
		/* for (int i = 0; i < list.size(); i++) { 
		 * System.out.print(list.get(i)); }
		 */
		
	// 2nd Approach
		/* for (Character eachList : list) {
		 * System.out.print(eachList); }
		 */
		
	// 3rd Approach
		/* Iterator<Character> iter = list.iterator(); 
		 * while (iter.hasNext()) {
		 * System.out.print(iter.next());   }
		 */
		 
	// 4th Approach
		int count = 0;
		while (count<list.size()) {
			System.out.print(list.get(count));
			count++;
		}
		
}}
