package acmicpc0206;

import java.util.Scanner;

//n ~ 어딘가 m개까지 5의 배수가 몇개인지
//m ~ 1의 지점까지 5의 배수가 몇개인지
//
//10이란 결국 2*5 이기 때문

public class Main2798 {
	
	static int n,m;
	static int[] numbers;
	static int max = -1;
	static int sum = 0;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		numbers = new int[n];
		
		for(int i = 0 ; i < n; i++) {
			numbers[i] = sc.nextInt();
		}
		
		select(0,0);
		
		System.out.println(max);
		
		sc.close();

	}
	
	static void select(int start, int cnt) {
		if(cnt == 3) {
			if(sum <= m && max < sum) {
				max = sum;
			}
			return;
		}
		
		for(int i = start; i < n; i++) {
			sum += numbers[i];
			select(i+1, cnt +1);
			sum -= numbers[i];
		}
		
	}

}


