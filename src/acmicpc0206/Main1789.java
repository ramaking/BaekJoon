package acmicpc0206;

import java.util.Scanner;


public class Main1789 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		long s = sc.nextLong();
		long sum = 0;
		long i = 0;
		while(true) {
			i++;
			if(sum + i > s) {
				break;
			}
			
			sum += i;
			
		}
		System.out.println(i-1);
		
		
		sc.close();

	}

}


