package m2.day0222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main4963 {

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
						bfs(i,j);
						ans++;
					}
				}
			}
			System.out.println(ans);
		}
		
		
		
	}
	
	private static void bfs(int si, int sj) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {si, sj});
		visited[si][sj] = true;
		int ni,nj,ci,cj;
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			ci = temp[0];
			cj = temp[1];
			
			for(int d = 0; d < 8; d++) {
				ni = ci + di[d];
				nj = cj + dj[d];
				if(ni >= 0 && ni < h && nj >= 0 && nj < w && !visited[ni][nj] && arr[ni][nj] == 1) {
					visited[ni][nj] = true;
					queue.add(new int[] {ni,nj});
				}
			}
			
		}
	}
	

}
