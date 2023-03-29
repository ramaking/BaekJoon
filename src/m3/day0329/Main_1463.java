package m3.day0329;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_1463 {

	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		dfs(num, 0);
		
		System.out.println(ans);
	}
	
	static void dfs(int num, int cnt) {
		
		if(cnt >= ans) return;
		
		if(num == 1 ) {
			ans = Math.min(cnt, ans);
			return;
		}
		
		if(num%3 == 0) {
			dfs(num/3, cnt+1);
		}
		
		if(num%2 == 0) {
			dfs(num/2, cnt+1);
		}
		
		dfs(num-1, cnt+1);
	}

}
