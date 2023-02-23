package m2.day0222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1012 {

	static int n;
	static int[][] arr;
	static int[] di = {-1,0,1,0};
	static int[] dj = {0,1,0,-1};
	static boolean[][] visited;
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
					list.add(bfs(i,j));
				}
			}
		}
		
		Collections.sort(list);
		
		System.out.println(list.size());
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}
	
	private static int bfs(int si, int sj) {
		int cnt = 0;
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {si, sj});
		visited[si][sj] = true;
		int ni,nj,ci,cj;
		while(!queue.isEmpty()) {
			cnt++;
			int[] temp = queue.poll();
			ci = temp[0];
			cj = temp[1];
			
			for(int d = 0; d < 4; d++) {
				ni = ci + di[d];
				nj = cj + dj[d];
				if(ni >= 0 && ni < n && nj >= 0 && nj < n && !visited[ni][nj] && arr[ni][nj] == 1) {
					visited[ni][nj] = true;
					queue.add(new int[] {ni,nj});
				}
			}
			
		}
		return cnt;
	}
	

}
