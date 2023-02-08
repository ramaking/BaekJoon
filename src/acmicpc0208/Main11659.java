package acmicpc0208;

import java.util.Arrays;
import java.util.Scanner;


public class Main11659 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int m = sc.nextInt();

		int[] arr = new int[n+1];		
		for(int i = 1; i <= n; i++) {
			arr[i] = arr[i-1]+sc.nextInt();
		}
		
//		System.out.println(Arrays.toString(arr));
		
		for(int t = 0 ; t < m; t++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			
			System.out.println(arr[j] - arr[i-1]);
		}
		
		sc.close();

	}

}


