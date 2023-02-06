package acmicpc0126_;

import java.util.Scanner;

public class Main2960 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int k = sc.nextInt();
		
		boolean[] arr = new boolean[n+1];
		
		int index = 1;
		
		int num = 0;
		
		boolean flag = false;
		
		for(int i = 2; i <= n; i++ ) {
			if(arr[i] == false) {
				int multi = 1;
				while(multi * i <= n) {
					if(!arr[i*multi]) {
						arr[i*multi] = true;
						if(index == k) {
							flag = true;
							num = i*multi;
							break;
						}
						index ++;
					}
					multi++;
				}
			}
			if(flag) {
				break;
			}
			
		}
		System.out.println(num);
		
		sc.close();
		
		
		

	}
}
