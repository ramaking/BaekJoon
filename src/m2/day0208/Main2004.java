package m2.day0208;

import java.util.Scanner;

//n ~ 어딘가 m개까지 5의 배수가 몇개인지
//m ~ 1의 지점까지 5의 배수가 몇개인지
//
//10이란 결국 2*5 이기 때문

public class Main2004 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
//		int m = sc.nextInt();
		
		n = n & 5;
		
		int result = 0;
		
		while(n/5 < 5) {
			
			
			for(int i = 1; i < n; i *= 5) {
				
				if(i/5 != 0) {
					result++;
				}
			}
			
			if(n < 5) {
				break;
			} else {
				n -= 5;
			}
			
		}
		
		System.out.println(result);
		sc.close();

	}

}


