package m3.day0330;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 1. 조합으로 바이러스 가능 부분을 바이러스로 변환
 * 2. bfs로 바이러스를 퍼뜨림
 * 3. 최대시간 반환 후 최소값 갱신
 */

public class Main_2636 {

	static int n, m;
	static int[][] map;
	static int[] di = { 1, 0, -1, 0 };
	static int[] dj = { 0, 1, 0, -1 };
	static int cnt;
	static boolean[][] visited;
	static Queue<int[]> queue = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		cnt = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 1)
					cnt++;
				map[i][j] = num;
			}
		}
		int time = 0;

		int temp = cnt;
		while (cnt != 0) {
			temp = cnt;
			visited = new boolean[n][m];
			time++;
			bfs();
//			System.out.println(cnt);
		}

		System.out.println(time);
		System.out.println(temp);

	}

	private static void bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		int ci, cj, ni, nj;
		queue.add(new int[] { 0, 0 });
		visited[0][0] = true;

		while (!queue.isEmpty()) {

			int[] now = queue.poll();
			ci = now[0];
			cj = now[1];
			
			if(map[ci][cj] == 1) {
				map[ci][cj] = 0;
				cnt--;
				continue;
			}

			for (int d = 0; d < 4; d++) {
				ni = ci + di[d];
				nj = cj + dj[d];
				if (ni < 0 || ni >= n || nj < 0 || nj >= m || visited[ni][nj])
					continue;
				queue.add(new int[] { ni, nj });
				visited[ni][nj] = true;
			}

		}

	}


	static void print() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				System.out.print(map[i][j] + " ");

			}
			System.out.println();
		}
		System.out.println("====================");
	}

}
