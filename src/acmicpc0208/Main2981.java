package acmicpc0208;

import java.util.Scanner;


public class Main2981 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();

		int[] arr = new int[n];		
		arr[0] = sc.nextInt();
		arr[1] = sc.nextInt();
		
		//2개의 (q-p)M을 구함
		int gcd = Math.abs(arr[0]-arr[1]);

		
		for(int i = 2; i < n; i++) {
			arr[i] = sc.nextInt();
			gcd = getGcd(gcd, Math.abs(arr[i-1] - arr[i]));
		}
		
		//약수 출력
		for(int i = 2; i <= gcd; i++) {
			if(gcd%i == 0) {
				System.out.print(i+" ");
			}
		}
		
		sc.close();

	}

	static int getGcd(int a, int b) {
		if(a < b) {
			int temp = a;
			a = b;
			b = temp;
		}
		
		if(b == 0) {
			return a;
		}
		
		return getGcd(b, a%b);
	}
}


