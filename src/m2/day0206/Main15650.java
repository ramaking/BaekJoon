package m2.day0206;

import java.util.Scanner;

// 14% 틀림

public class Main15650 {

	
	static int n, m;
	static int[] numbers;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		m = sc.nextInt();
		
		numbers = new int[m];
	
		nm(1,0);
		
		sc.close();

	}
	
	static void nm(int start, int cnt) {
		if(cnt == m) {
			for(int i = 0; i < numbers.length; i++) {
				System.out.print(numbers[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = start; i <= n; i++) {
			numbers[cnt] = i;
			nm(i + 1, cnt + 1);
		}
	}
	
}


