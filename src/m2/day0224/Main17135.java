package m2.day0224;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main17135 {

	static int n, m, d;
	static boolean[][] visited;
	static int[] id = { 0, -1, 0 };
	static int[] jd = { -1, 0, 1 };
	static int[][] arr;
	static int[][] temp;
	static ArrayList<int[]> killList = new ArrayList<int[]>();
	static int killCnt = 0;
	static int max = 0;

	static int[] card = new int[3];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		temp = new int[n][m];

		d = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		comb(0, 0);
		System.out.println(max);

	}

	static void comb(int cnt, int index) {
		if (cnt == 3) {
			killCnt = 0;
//			System.out.println(Arrays.toString(card));
			copyArr();
			process();

			if (max < killCnt) {
				max = killCnt;
			}

			return;
		}
		for (int i = index; i < m; i++) {
			card[cnt] = i;
			comb(cnt + 1, i + 1);
		}

	}

	private static void copyArr() {
		for (int i = 0; i < n; i++) {

			for (int j = 0; j < m; j++) {
				temp[i][j] = arr[i][j];
			}

		}
	}

	private static void process() {
		// 최대 n번 프로세스 진행
		for (int i = 0; i < n; i++) {
//			print();
			// 궁수 3명 쏘기
			for (int j = 0; j < 3; j++) {
				visited = new boolean[n][m];
				bfs(j);
			}

			// 죽이기
			kill();
//			print();
			// 적 한 칸씩 내리기
			down();
		}

	}

	private static void kill() {
		// TODO Auto-generated method stub
		for (int i = 0; i < killList.size(); i++) {
			int[] tempindex = killList.get(i);
			int ti = tempindex[0];
			int tj = tempindex[1];
			if (temp[ti][tj] == 1) {
				temp[ti][tj] = 0;
				killCnt++;
//				print();
			}
		}

		killList.clear();
	}

	private static void down() {
		// TODO Auto-generated method stub
		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j < m; j++) {
				if (temp[i][j] == 1) {
					if (i + 1 < n) {
						temp[i + 1][j] = 1;
						temp[i][j] = 0;
					} else {
						temp[i][j] = 0;
					}
				}
			}
		}
	}

	static void bfs(int archor) {
		int dis = 0;
		Queue<int[]> queue = new ArrayDeque<>();
		// 시작지점
		queue.add(new int[] { n , card[archor]});
		int ci, cj, ni, nj;
		while (!queue.isEmpty()) {
			if (dis == d) {
				return;
			}
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] current = queue.poll();
				ci = current[0];
				cj = current[1];
				for (int d = 0; d < 3; d++) {
					ni = ci + id[d];
					nj = cj + jd[d];
					if (ni >= 0 && ni < n && nj >= 0 && nj < m && !visited[ni][nj]) {
						if (temp[ni][nj] == 1) {
							killList.add(new int[] { ni, nj });
							
							return;
						} else {
							queue.add(new int[] { ni, nj });
							visited[ni][nj] = true;
						}
					}
				}
			}

			dis++;
		}

	}

	static void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(temp[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("---------------------");
	}

}
