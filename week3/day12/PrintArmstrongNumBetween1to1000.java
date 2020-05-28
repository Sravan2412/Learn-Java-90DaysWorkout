package week3.day12;

public class PrintArmstrongNumBetween1to1000 {
	
  // PROGRAM:
	// Print the armstrong numbers between 1 and 1000.

	public static void main(String[] args) {
		
		int r=0;
		for (int i = 0; i < 1000; i++) {
			int sum=0;
			int temp=i; 
		while (temp>0) {
			r= temp%10;
			sum+= Math.pow(r, 3);
			temp/=10;
		}
		
		if(sum==i) {
			System.out.println("Armstrong number is : "+ sum);
		}
		}

}}