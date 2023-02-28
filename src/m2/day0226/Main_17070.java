package m2.day0226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17070 {
	static int n;
	static int[][] map;
	static int[] di = {0,1,1};
	static int[] dj = {1,1,0};
	
	//1 : 오른 쪽
	//2 : 대각선 
	//3 : 아래
	static int dir = 1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		
//		visited = new boolean[n+1];
		
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		map[1][1] = 1;
		map[1][2] = 1;
		

		
	}
	
	static void setPipe(int head, int dir
			
			) {
		
	}
}
