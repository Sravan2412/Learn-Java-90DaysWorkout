package week3.day13;

public class AddTwoMatrices {
	
// PROGRAM:
 /* Write a java program to add two matrices
	Matrices 1:
	1 2 3 
	4 5 6 
	7 8 9 
	Matrices 2:
	9 8 7 
	6 5 4 
	3 2 1 
	Solution: 
	10 10 10 
	10 10 10 
	10 10 10 
  */
	
	public static void main(String[] args) {
		
		int[][] matrix1 = {{1,2,3},{4,5,6},{7,8,9}};
		int[][] matrix2 = {{9,8,7},{6,5,4},{3,2,1}};
		int[][] matrix3 = new int[3][3];
		for (int i = 0; i < matrix1.length; i++) {
			for (int j = 0; j < matrix2.length; j++) {
				matrix3[i][j] = matrix1[i][j]+matrix2[i][j];
				System.out.print(matrix3[i][j]+" ");
			} 
			System.out.println(); }
}}
