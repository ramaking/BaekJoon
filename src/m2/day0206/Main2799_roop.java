package m2.day0206;

import java.util.Scanner;

//n ~ 어딘가 m개까지 5의 배수가 몇개인지
//m ~ 1의 지점까지 5의 배수가 몇개인지
//
//10이란 결국 2*5 이기 때문

public class Main2799_roop {
	
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
		
		//반복 버전
		for(int i = 0; i < n; i++) {
			for(int j = i+1; j < n; j++) {
				for(int k = j+1; k < n; k++) {
					sum = numbers[i] + numbers[j] + numbers[k];
					if(sum <= m && max < sum) {
						max = sum;
					}
				}
			}
		}
		
//		select(0,0);
		
		System.out.println(max);
		
		sc.close();

	}
	
	//재귀 버전
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


