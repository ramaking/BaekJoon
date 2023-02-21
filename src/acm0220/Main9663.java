package acm0220;

import java.io.IOException;
import java.util.Scanner;

public class Main9663 {
	static int n;
	static int [] queen;
	static int sum = 0;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		queen = new int[n+1];
		
		
		setQueen(1);
		
		System.out.println(sum);
		
		sc.close();
	}
	
	static void setQueen(int depth) {
		
		if(depth > n) {
			sum ++;
			return;
		}
		
		for(int i = 1; i <= n; i++) {
			
			if(isVaild(depth, i)) {
				queen[depth] = i;
				setQueen(depth+1);
			}
		}
		
	}

	private static boolean isVaild(int depth, int lo) {
		
		for(int i = 1; i < depth; i++) {
			if(queen[i] == lo || depth-i == Math.abs(queen[i]-lo)) return false;
		}
		
		return true;
	}


}
