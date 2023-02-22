package m1.day0126;

import java.util.Scanner;

public class Main1517 {
	static int[]  p;
	static long sum = 0;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		p = new int[n];
		
		for(int i = 0; i < p.length; i++) {
			p[i] = sc.nextInt();
		}
		
		sort(0, p.length-1);
		
		System.out.println(sum);
		
		sc.close();
	}
	
	static void sort(int start, int end) {
		if(end- start < 1) return;
		
		int mid = (start + end)/2;
		
		sort(start, mid);
		sort(mid+1, end);
		
		merge(start, mid, end);
		
		
	}
	
	static void merge(int start,int mid, int end) {
		int[] temp = new int[end - start +1];
		
		int tempIndex = 0;
		int lowIndex = start;
		int highIndex = mid+1;
		
		int flagIndex = start;
		
		while(lowIndex <= mid && highIndex <= end) {
			if(p[lowIndex] <= p[highIndex]) {
				
				temp[tempIndex ++] = p[lowIndex++];
				sum += tempIndex - (lowIndex - flagIndex);
				
			} else {
				temp[tempIndex ++] = p[highIndex++];
			}
		}
		
		while(lowIndex <= mid) {
			
			temp[tempIndex++] = p[lowIndex++];
			sum += tempIndex - (lowIndex - flagIndex);
		}
		
		while(highIndex <= end) {
			temp[tempIndex++] = p[highIndex++];
		}
		
		for(int i = start; i <= end; i++) {
			p[i] = temp[i-start];
		}
		
	}
}
