package m2.day0224;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2667_dfs {

	static int n;
	static int[][] arr;
	static int[] di = {-1,0,1,0};
	static int[] dj = {0,1,0,-1};
	static boolean[][] visited;
	static int cnt = 0;
	static ArrayList<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		visited = new boolean[n][n];
		String line;
		for(int i = 0; i < n; i++) {
			line = br.readLine();
			for(int j = 0 ; j < n; j++) {
				arr[i][j] = line.charAt(j)-'0';
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0 ; j < n; j++) {
				if(arr[i][j] == 1 && !visited[i][j]) {
					dfs(i,j);
					list.add(cnt);
					cnt = 0;
				}
			}
		}
		
		Collections.sort(list);
		
		System.out.println(list.size());
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}
	
	private static void dfs(int si, int sj) {
//		int cnt = 0;
		int ni,nj,ci,cj;
		cnt++;
		visited[si][sj] = true;
		for(int d = 0; d < 4; d++) {
			ni = si + di[d];
			nj = sj + dj[d];
			if(ni >= 0 && ni < n && nj >= 0 && nj < n && !visited[ni][nj] && arr[ni][nj] == 1) {
				visited[ni][nj] = true;
				dfs(ni, nj);
				
			}
		}
		
	}
	

}
