package week3.day12;

public class Print1st10FibonacciNumInReverseOrder {
	
  // PROGRAM:
	/* Print the first 10 fibonacci numbers in reverse order 
	 * output: 34,21,13,8,5,3,2,1,1,0 */

	public static void main(String[] args) {	
		
		int range=10, a=0, b=0, c=1;
		int[] array = new int[range];
		
		System.out.println("Fibonacci series in forward order : ");
		// Fibonacci series in forward order
		for (int i = 0; i < range; i++) {
		array[i] =  a=b;
			        b=c;
			       c=a+b;
	        System.out.print(a+ " ");
		}
		System.out.println();
		
		System.out.println("Fibonacci series in reverse order : ");
		// Fibonacci series in reverse order
		for (int i = array.length-1; i >= 0; i--) {
			System.out.print(array[i]+" ");
		}
}}
