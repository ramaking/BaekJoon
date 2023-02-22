package m1.day0126;

import java.util.Scanner;

public class Main11399 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] p = new int[n];
		
		for(int i = 0; i < p.length; i++) {
			p[i] = sc.nextInt();
		}
		
		for(int i = 0 ; i< p.length-1; i++) {
			for(int j = 0; j < p.length-1-i; j++) {
				if(p[j] > p[j+1]) {
					int temp = p[j];
					p[j] = p[j+1];
					p[j+1] = temp;
				}
			}
		}
		
		int sum = 0;
		for(int i = 0; i < p.length; i++) {
			for(int j = 0; j <= i; j++) {
				sum += p[j];
			}
		}
		
		System.out.println(sum);
		
		sc.close();
		
		
		

	}
}
