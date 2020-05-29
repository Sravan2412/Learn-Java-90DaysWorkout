package week3.day13;

public class TransposeTheMatrix {
	
  // PROGRAM:
	/* Write a java program to transpose the matrix. 
	 * Actual Matrix
	 * 1 2 3 
	 * 4 5 6 
	 * 7 8 9 
	 * Transposed Matrix 
	 * 1 4 7 
	 * 2 5 8 
	 * 3 6 9
	 */

	public static void main(String[] args) {
		
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		
		System.out.println("Normal Matrix");
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j]+" ");	
			} System.out.println();                 }
		
		System.out.println("Transposed Matrix");
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[j][i]+" ");
			} System.out.println();                 }
}}
