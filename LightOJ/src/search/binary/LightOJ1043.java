package search.binary;

import java.util.Scanner;

public class LightOJ1043 {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		for(int i = 1; i<= testCase;i++) {
			double ab = sc.nextFloat();
			double ac = sc.nextFloat();
			double bc = sc.nextFloat();
			double ratio = sc.nextFloat();
			
			double ad = Math.sqrt(ratio/(ratio+1))*ab;
			
			System.out.println("Case "+i+": "+ad);
		}
	}

}
