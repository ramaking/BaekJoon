package acmicpc0126_;

import java.util.Scanner;

public class Main5347 {
	
	public static int LCM(int a, int b) {
		int tmp;
		if( a < b) {
			tmp = b;
			b = a;
			a= tmp;
		}
		
		if(b== 0) {
			return a;
		}
		return LCM(b, a%b);
	}
	
	
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int i = 0; i < tc; i++) {

			int a = sc.nextInt();
			int b = sc.nextInt();
			
			System.out.println(a/LCM(a, b)*b
					);
			
		}
		
		sc.close();
		
		
		

	}
}
