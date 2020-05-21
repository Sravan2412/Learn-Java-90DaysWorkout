package week2.day8;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public class CountOfCharsInStringUsingMap {

      // PROGRAM:
       /*  Write a java program to find the count the characters in the given string.
        *  String text = "I will become a Billionaire within One year";
	*  Output: { =7, a=3, B=1, b=1, c=1, e=5, h=1, i=6, I=1, l=4, m=1, n=3, O=1, o=2, r=2, t=1, w=2, y=1}
	*/

	public static void main(String[] args) {
		
		String text = "I will become a Billionaire within One year";
		char[] charArray = text.toCharArray();
		Set<Character> set = new LinkedHashSet<Character>();
		
	  // 1st method
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		for (Character c : charArray) {
			if(map.containsKey(c)) {
				map.put(c, map.get(c)+1);
			}else {
				map.put(c, 1);
			}
		} System.out.println(map);
		
		
	  // 2nd method
		/* for (int i = 0; i < charArray.length; i++) {
		 * int rep = text.replaceAll("[^"+charArray[i]+"]", "").length(); 
		 * boolean add = set.add(charArray[i]); 
		 * if(add) 
		 * System.out.print(charArray[i] + "="+ rep); System.out.print(" ");
		 * }
		 */

	  // 3rd method
	       /* Hashtable<Character, Integer> charCount= new Hashtable<Character, Integer>();
		* int i=0;
		* while(i<str.length()) {
		*	Integer ifPresent =charCount.computeIfPresent(str.charAt(i), (k,v)->v+1);
		*	if(ifPresent==null)
		*	 charCount.computeIfAbsent(str.charAt(i),k->1);			
		*	i++;
		* }
		* System.out.println(charCount);
		*/
}}

