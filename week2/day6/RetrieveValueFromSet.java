package week2.day6;

import java.util.LinkedHashSet;
import java.util.Set;

public class RetrieveValueFromSet {
	
  // PROGRAM:
	/* How to retrieve a value from a Set? 
	 * Set = "1,2,3,4,5,6,7,8,9" 
	 * retrieve and print only the value - 7
	 */
	

	public static void main(String[] args) {
		
		Set<Integer> set = new LinkedHashSet<>();
		
		set.add(1); set.add(2); set.add(3); set.add(4); set.add(5); set.add(6); set.add(7);
		set.add(8); set.add(9);

	  // 1st method
		/* for (Integer eachnum : set) { 
		 * if(eachnum == 7) {
		 * System.out.println(eachnum); } }
		 */
		
	  // 2nd method
		set.forEach(eachnum -> {
			if(eachnum.equals(7))
				System.out.println(eachnum);
			});
	}
}
