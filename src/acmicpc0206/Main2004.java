package acmicpc0206;

import java.util.Scanner;

//n ~ 어딘가 m개까지 5의 배수가 몇개인지
//m ~ 1의 지점까지 5의 배수가 몇개인지
//
//10이란 결국 2*5 이기 때문

public class Main2004 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		if(m > n/2) {
			m = n-m;
		}
		
		int num5 = 0;
		int num2 = 0;
		
		for(int i = 0; i < m; i++) {
			if((i+1) /10 == 0) {
				num5--;
				num2--;
			} else if((i+1) / 5 == 0) {
				num5--;
			} else if((i+1) / 2 == 0) {
				num2--;
			}
			
			if((n-i) /10 == 0) {
				num5++;
				num2++;
			} else if((n-i) / 5 == 0) {
				num5++;
			} else if((n-i) / 2 == 0) {
				num2++;
			}
		}
		
		int result = 0;
		System.out.println("num5 : "+num5 + "    num2 : "+num2);
		
		if(num5%2 == 0 && num2%2 == 0) {
			
			result = Math.min(num5, num2);
		} else {
			result = 0;
		}
		
		System.out.println(result);
		sc.close();

	}

}


