package acmicpc0208;

import java.util.Scanner;

public class Main1300 {
	
	public static void main(String[] args){
		Scanner sc = new Scanner (System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int start = 1;
		int end = k;
		int middle = (start+end)/2;
		while(start <= end) {

			middle = (start+end)/2;
			int sum = 0;
			for(int i = 1; i <= n; i++) {
				sum += Math.min(middle/i, n);
			}
			
			if(sum >= k) {
				end = middle - 1;
			}
			
			if(sum < k) {
				start = middle +1;
			}
			
//			if(sum == k) {
//				break;
//			}

//			System.out.println("start : " + start + "     end : " + end + "    sum : " + sum + "    middle : " + middle);
		}
		
		System.out.println(start);
	}

}


