package acmicpc0126_;

import java.util.Scanner;

public class Main2579 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();

		int[] arr = new int[N];
		for(int i = 0; i < N; i++){
			arr[i] = sc.nextInt(); 
		}
		
		int [] dp = new int[N];
		
		if(N == 1) {
			System.out.println(arr[0]);
		} else if(N == 2) {
			System.out.println(arr[0] + arr[1]);
		} else {
			dp[0] = arr[0];
			dp[1] = arr[0] + arr[1];
			dp[2] = Math.max(arr[0], arr[1]) + arr[2];
			
			
			for(int i = 3; i < dp.length; i++) {
				dp[i] = Math.max(dp[i-2], dp[i-3] + arr[i-1]) + arr[i];
			}
			
			System.out.println(dp[N-1]);
		}
		
		
		
		
		
		sc.close();
		
		
		

	}
}
