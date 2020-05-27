package week3.day10;

public class AverageOfNumbersInArray {
	
  // PROGRAM:
	/* Write a java program to find the average of the numbers in an array.
	 * input: int[] array = {20, 30, 25, 35, -16, 60, -100};
	 * output: Average: 7
	 */
	
	public static void main(String[] args) {
		
		int[] array= {20, 30, 25, 35, -16, 60, -100};
		int count = 0;
		
	  // 1st method
		/* for (int i = 0; i < array.length; i++) {
			count+= array[i];                  }
		*/
		
	  // 2nd method
		for (int eachNum : array) {
			count+=eachNum;
		}
		
		System.out.println(count);
		System.out.println((float)count/array.length);
}}
