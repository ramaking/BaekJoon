package m3.day0310;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_11438 {
	static int N;
	static ArrayList<Integer>[] list;
	static int[] depth;
	static boolean[] visited;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		list = new ArrayList[N+1];
		depth = new int[N+1];
		visited = new boolean[N+1];
		dp = new int[N+1][30];
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		StringTokenizer st;
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			list[from].add(to);
			list[to].add(from);
		}
		
		dfs(1, 0);
		
		calc();
		
		int M = Integer.parseInt(br.readLine());
		
		
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
		}
		
		System.out.println(sb.toString());
		
	}
	private static void calc() {
		for(int j = 1; j < 30; j++) {
			for(int i = 1; i <= N; i++) {
				dp[i][j] = dp[dp[i][j-1]][j-1];
			}
		}
	}
	
	
	
	private static void dfs(int index, int depthNum) {
		visited[index] = true;
		depth[index] = depthNum;
		for(int i = 0; i < list[index].size(); i++) {
			dp[list[index].get(i)][0] = index;
			dfs(list[index].get(i), depthNum+1);
		}
		
	}

	
	
}
