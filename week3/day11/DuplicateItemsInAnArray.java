package week3.day11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class DuplicateItemsInAnArray {
	
  // PROGRAM:
	/* Write a java programs to print the duplicate items in the array.
	 * int[] my_array = {1, 2, 5, 5, 6, 6, 7, 2};
	 */

	public static void main(String[] args) {
		
		int[] my_array = {1, 2, 5, 5, 6, 6, 7, 2};
		
	  // 1st method
		/* for (int i = 0; i < my_array.length; i++) {
		 * for (int j = i+1; j < my_array.length; j++) { 
		 * if(my_array[i]==my_array[j])
		 * System.out.println(my_array[i]);      }}
		 */
		
	  // 2nd method
		for (int i = 0; i < my_array.length; i++) {
			if(my_array[Math.abs(my_array[i])] > 0)
				my_array[Math.abs(my_array[i])] = -my_array[Math.abs(my_array[i])];
			else
				System.out.println(Math.abs(my_array[i])+" ");     }
}}
