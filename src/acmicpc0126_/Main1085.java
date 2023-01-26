package acmicpc0126_;

import java.util.Scanner;

public class Main1085 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		
		int i = Math.min(w-x, x);

		int j = Math.min(y, h-y);
		System.out.println(Math.min(i, j));
	}
}
