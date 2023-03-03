package m3.day0302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576 {

	static int M, N;
	static int[][] map;
	static int[] di = { 1, 0, -1, 0 };
	static int[] dj = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		Queue<int[]> queue = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp == 1) {
					queue.add(new int[] {i, j});
				}
				map[i][j] = temp;
			}
		}
		
		int ci,cj,ni,nj;
		int day = 0;
		
		int ans;
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			for(int i = 0; i < size; i++) {
				int[] now = queue.poll();
				ci = now[0];
				cj = now[1];
				for(int d= 0; d< 4; d++) {
					ni = ci + di[d];
					nj = cj + dj[d];
					
					if(ni < 0 || ni >= N || nj < 0 || nj >= M) continue;
					
					if(map[ni][nj] != 0) continue;
					map[ni][nj] = 1;
					queue.add(new int[] {ni, nj});
				}
			}
			day++;
		}
		
		ans = day-1;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0 ; j < M; j++) {
				if(map[i][j] == 0) {
					ans = -1;
					break;
				}
			}
		}

		System.out.println(ans);
	}
	
	static void print() {
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("===========================");
	}
	

}
