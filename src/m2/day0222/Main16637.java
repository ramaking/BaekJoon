package m2.day0222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main16637 {

	static int n, m, diceI, diceJ;
	
	static boolean visited[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visited = new boolean[n+1];
		
	}
	
	static void subSet(int cnt , int isOdd) {
		
		if(cnt == n+1 && isOdd%2 == 0) {
			
			culc(0, n+1);
			
			return;
		}
		
		visited[cnt] = true;
		subSet(cnt+1, isOdd+1);

		visited[cnt] = false;
		subSet(cnt+1, isOdd);
	}
	
	static int culc(int startIdx, int endIdx) {
		int result = 0;
		int tempEnd = 0;
		for(int i = startIdx; i < endIdx ; i++) {
			if(visited[i]) {
				for(int j = i; j < endIdx; j++) {
					if(visited[j]) {
						tempEnd = j;
						culc(i,j);
						break;
					}
				}
			} else {
				
			}
		}
		
		return result;
	}
	
}
