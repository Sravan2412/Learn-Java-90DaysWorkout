package week3.day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortAndReverseAnArray {
	
  // PROGRAM:
	/* Write a java program to sort it and reverse it. 
	 * Input: int[] array = {5,1,33,79,22,11,45}; 
	 * output: 
	 * Sorted: {1,5,11,22,33,45,79} 
	 * reversed: {79,45,33,22,11,5,1}
	 */
	

	public static void main(String[] args) {
		
		 // For 1st method input is below
		 int[] array = {5,1,33,79,22,11,45};
		 
		 // For 2nd method input is below
		 Integer[] array1 = {5,1,33,79,22,11,45};
		 
		 // To Sort an int[] or Integer[] we can use Arrays.sort function.
		 Arrays.sort(array);
		
		 // 1st method
	  /* for (int i = 0; i < array.length; i++) {
		 // Sorted output:
		 System.out.print(array[i]+" ");        }
		 System.out.println();
		 for (int i = array.length-1; i>=0; i--) {
		 // Reverse output
		 System.out.print(array[i]+" ");         }
	  */
		 
		 
		 
		 // 2nd method
	 	 // To convert an int array to String we can use Arrays.toString
		 System.out.println(Arrays.toString(array));
		 
		 // Only for this "Arrays.asList()" function it only accepts " Integer[] "  input, not  " int[] " input.
		 Collections.reverse(Arrays.asList(array1));
		 System.out.println(Arrays.asList(array1));
	  
		 
}}