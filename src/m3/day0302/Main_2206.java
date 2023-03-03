package m3.day0302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2206 {

	static int N, M;
	static int[][] map;
	static int[][] temp;
	static int[] di = { 1, 0, -1, 0 };
	static int[] dj = { 0, 1, 0, -1 };
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		temp = new int[N][M];

		String line;
		for (int i = 0; i < N; i++) {
			line = br.readLine();
			for (int j = 0; j < M; j++) {
				int tempNum = line.charAt(j) - '0';
				if (tempNum == 1) {
					map[i][j] = -1; // 벽은 -1로 채움
				} else {
					map[i][j] = tempNum;
				}
			}
		}
		
		map[N-1][M-1] = -2;

		// 처음 bfs 로 초기 비용 탑재
		Queue<int[]> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][M];
		queue.add(new int[] { 0, 0 });
		visited[0][0] = true;
		int cnt = 1;
		while (!queue.isEmpty()) {

			int size = queue.size();

			for (int i = 0; i < size; i++) {
				int[] now = queue.poll();
				int ci = now[0];
				int cj = now[1];
				map[ci][cj] = cnt;

				for (int d = 0; d < 4; d++) {
					int ni = ci + di[d];
					int nj = cj + dj[d];
					if (ni < 0 || ni >= N || nj < 0 || nj >= M) {
						continue;
					}
					if (map[ni][nj] != -1 && !visited[ni][nj]) {

						visited[ni][nj] = true;
						queue.add(new int[] { ni, nj });
						
					}
				}
			}
			cnt++;
		}
		deepcopy();

//		print();

		// 벽돌 선택하기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == -1) {
					deepcopy();

					// 가장 큰 값으로 초기화
					temp[i][j] = Integer.MAX_VALUE;
					
					// 인접 4개 중 -1이 아닌 가장 작은 값을 선택하고 그 지점에서 bfs 시작 단, 주변을 고려하여 선정
					int[] tempPoint = findStartpoint(i, j);
//					System.out.println(tempPoint[0] + " : " + tempPoint[1]);
					if (tempPoint[0] != -1) {
						bfs(tempPoint[0], tempPoint[1]);
						print();
					}

				}
			}
		}

		if(min == Integer.MAX_VALUE) {
			min = -1;
		}
		System.out.println(min);

	}

	private static int[] findStartpoint(int si, int sj) {
		int[] result = new int[2];
		result[0] = -1;
		result[1] = -1;
		int min = Integer.MAX_VALUE;
		int ni, nj;
		for (int d = 0; d < 4; d++) {
			ni = si + di[d];
			nj = sj + dj[d];

			
			if (ni < 0 || ni >= N || nj < 0 || nj >= M)
				continue;
			if(temp[ni][nj] <= 0) continue;
			if (min > temp[ni][nj]) {
				min = temp[ni][nj];
				result[0] = ni;
				result[1] = nj;
				

			}
		}

		return result;
	}

	private static void bfs(int si, int sj) {
		
		boolean isEnd = false;
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { si, sj });
		boolean[][] visited = new boolean[N][M];
		visited[si][sj] = true;
		int ci, cj, ni, nj;
		while (!queue.isEmpty()) {
			if(isEnd) break;
			int[] now = queue.poll();
			ci = now[0];
			cj = now[1];

			for (int d = 0; d < 4; d++) {
				ni = ci + di[d];
				nj = cj + dj[d];
				
				if(ni == N-1 && nj == M-1) {
					temp[ni][nj] = temp[ci][cj]+1;
					isEnd = true;
					break;
				}

				if (ni < 0 || ni >= N || nj < 0 || nj >= M || visited[ni][nj])
					continue;
				visited[ni][nj] = true;
				if (temp[ni][nj] == -1)
					continue;
				if (temp[ni][nj] == temp[ci][cj] + 1) {
					continue;
				}
				
				if (temp[ni][nj] == 0 || temp[ni][nj] > temp[ci][cj] + 1 || temp[ni][nj] == -2){
					temp[ni][nj] = temp[ci][cj] + 1;
					queue.add(new int[] { ni, nj });
					System.out.println(ni +" : " + nj);
				}
			}

		}

		if (temp[N - 1][M - 1] != -2) {
			if (min > temp[N - 1][M - 1]) {
				min = temp[N - 1][M - 1];
			}
		}

	}

	static void print() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(temp[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("===========================");
	}

	static void deepcopy() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				temp[i][j] = map[i][j];
			}
		}
//		temp[N - 1][M - 1] = -2;
	}

}
