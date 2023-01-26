package acmicpc0126_;

import java.util.Arrays;
import java.util.Scanner;

public class Main4153 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while(true) {
			int[] arr = new int[3];
			for(int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			
			if(arr[0] == 0 && arr[1] == 0 && arr[2] == 0) {
				break;
			}
			
			Arrays.sort(arr);
			
			if( Math.pow(arr[0], 2) +  Math.pow(arr[1], 2) == Math.pow(arr[2], 2)) {
				System.out.println("right");
			} else {
				System.out.println("wrong");
			}
			
		}
		
		sc.close();
	}
}
