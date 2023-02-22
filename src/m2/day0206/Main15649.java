package m2.day0206;

import java.util.Arrays;
import java.util.Scanner;

public class Main15649 {
	static int n,m;
	static int[] result;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		visited = new boolean[n+1];
		
		m = sc.nextInt();
		
		result = new int[m];
		
		printNum(0);
		
		System.out.println(sb.toString());
		
		sc.close();
	}
	
	static void printNum(int cnt) {
		if(cnt == m) {
			for(int i = 0; i < m; i++) {
				sb.append(result[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 1; i <= n; i++ ) {
			if(!visited[i]) {
				visited[i] = true;
				result[cnt] = i;
				printNum(cnt + 1);
				visited[i] = false;
			}
		}
		
	}
	

	
}


