package acmicpc;

import java.io.IOException;
import java.util.Scanner;

//어떤 수를 입력 받았을 때 그 보다 작은 값이 몇개인지 세는 로직이 필요함

public class Main1300 {

	static int N;
	
	static int k;
	
	public static void binarySearch() {
		
		//lower 과 higher 는 값이다.
		//값을 토대로 이보다 작은 값의 개수를 세어 원하는 값과 비교한다.
		int lower = 1;
		int higher = N*N;
		int middle = 0;
		
		while(lower <= higher) {
			
			middle = (lower + higher)/2;
			
			int sum = 0;
			for(int i = 1; i <= N; i++) {
				//각 줄에서 middle 보다 작거나 같은 값의 개수를 세고 더한다.
				sum += Math.min(N, middle/i);
			}
			
			//그렇게 센 값의 개수는 k에 대비된다. 원하는 k와 비교하여 middle 값을 변경한다.
			if(sum > k) {
				higher = middle -1;
			}
			if(sum < k) {
				lower = middle +1;
			}
			if(sum == k) {
				return;
			}
			
			
		}
		
		return;
	}
	
	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		
		k = sc.nextInt();
		
		sc.close();

	}	
}
