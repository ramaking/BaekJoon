package m2.day0224;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main4963_dfs {

	static int w,h;
	static int[][] arr;
	static int[] di = {-1,-1,0,1,1,1,0,-1};
	static int[] dj = {0,1,1,1,0,-1,-1,-1};
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w == 0 && h == 0) {
				return;
			}
			int ans = 0;
			arr = new int[h][w];
			visited = new boolean[h][w];
			for(int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(arr[i][j] == 1 && !visited[i][j]) {
						dfs(i,j);
						ans++;
					}
				}
			}
			System.out.println(ans);
		}
		
		
		
	}
	
	private static void dfs(int si, int sj) {
		int ni,nj,ci,cj;
		visited[si][sj] = true;
		for(int d = 0; d < 8; d++) {
			ni = si + di[d];
			nj = sj + dj[d];
			if(ni >= 0 && ni < h && nj >= 0 && nj < w && !visited[ni][nj] && arr[ni][nj] == 1) {
//				visited[ni][nj] = true;
				dfs(ni, nj);
			}
		}
		
	}
	

}
