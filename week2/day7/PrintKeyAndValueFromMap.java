package week2.day7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class PrintKeyAndValueFromMap {
	
  // PROGRAM:
	/* Write a Java Program to print the keys and values from the Map 
	 * map = {A=1, B=2, C=3, D=4, E=5} 
	 * (Min 3 ways) 
	 * Note: Even if you google understand what you are doing! 
	 * output: 
	 * A->1 
	 * B->2
	 * C->3 
	 * D->4 
	 * E->5
	 */

	public static void main(String[] args) {
		
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		map.put('A', 1); map.put('B', 2); map.put('C', 3); map.put('D', 4); map.put('E', 5);
		
	 // 1st method
		/* System.out.println("A value is : "+map.get('A'));
		 * System.out.println("B value is : "+map.get('B'));
		 * System.out.println("C value is : "+map.get('C'));
		 * System.out.println("D value is : "+map.get('D'));
		 * System.out.println("E value is : "+map.get('E'));
		 */	
		
	 // 2nd method
		/* for (Map.Entry<Character, Integer> result : map.entrySet()) {
		 * System.out.println(result.getKey()+" = "+result.getValue()); }
		 */
		
	 // 3rd method
		/* map.forEach((eachKey,eachValue)-> System.out.println(eachKey+" = "+eachValue));
		*/
		
	 // 4th method
		/* map.entrySet().iterator()
		 * .forEachRemaining(eachset->System.out.println(eachset.getKey()+" = "+eachset.getValue()));
		 */
		
	 // 5th method
		/* Iterator<Entry<Character, Integer>> iter = map.entrySet().iterator();
		 * while(iter.hasNext()) { 
		 * Entry<Character, Integer> eachEntry = iter.next();
		 * System.out.println(eachEntry.getKey()+"="+eachEntry.getValue()); }
		 */
		
	 // 6th method
		map.entrySet().forEach((eachkey)->System.out.println(eachkey.getKey()+" = "+eachkey.getValue()));
		
		
		
		
	 // How to update Value inside a map in a newer way instead of using .put method.
		map.entrySet().forEach((eachentry)-> {
			if(eachentry.getKey().equals('A')||eachentry.getKey().equals('B')) {
				eachentry.setValue(10);         }
		}); System.out.println(map);
		
	 // How to update Value inside a map in a newer way using .put method.
		/* map.keySet().forEach((eachkey)-> {
		 * if(eachkey.equals('A')||eachkey.equals('B')) { 
		 * map.put(eachkey, 10);          } 
		 * }); System.out.println(map);
		 */
	
	}}
