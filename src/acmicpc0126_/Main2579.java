package acmicpc0126_;

import java.util.Scanner;

public class Main2579 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();

		int[] arr = new int[N+1];
		for(int i = 1; i <= N; i++){
			arr[i] = sc.nextInt(); 
		}
		
		int [] jumpSum = new int[N+1];
		int [] walkSum = new int[N+1];
		
		jumpSum[N] = jumpSum[N-1] = walkSum[N] = arr[N];
		
		walkSum[N-1] = arr[N-1] + arr[N];
		
		jumpSum[N-2] = arr[N] + arr[N-2];
		
		walkSum[N-2] = jumpSum[N-2];
		
		for(int i = N-3; i >= 0; i --) {
			jumpSum[i] =Math.max(walkSum[i+2], jumpSum[i+2]) + arr[i];
			
			walkSum[i] = jumpSum[i+1] + arr[i];
		}
		
		System.out.println(Math.max(jumpSum[0], walkSum[0]));
		
		
		
		

	}
}
