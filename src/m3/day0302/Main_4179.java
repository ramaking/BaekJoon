package m3.day0302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4179 {

	static int r, c;
	static char[][] map;
	static int[] di = { 1, 0, -1, 0 };
	static int[] dj = { 0, 1, 0, -1 };
	static Queue<int[]> jihun = new ArrayDeque<>();
	static Queue<int[]> fire = new ArrayDeque<>();
	static int min = -1;
	static int dis = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new char[r][c];

		for (int i = 0; i < r; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < c; j++) {
				if (map[i][j] == 'J') {
					jihun.add(new int[] { i, j, 0 });
				} else if (map[i][j] == 'F') {
					fire.add(new int[] { i, j });
				}
			}
		}

		boolean isEnd = false;

		while (true) {
			if (isEnd)
				break;
			
			// 지훈 bfs 복사하는 과정에서 탈출 가능하면 탈출
			// 탈출 불가능하면 즉, 지훈이 더이상 퍼져나갈 곳이 없으면 종료
			while (true) {

				int size = jihun.size();

				if (size == 0) {
					isEnd = true;
					break;
				}
				for (int i = 0; i < size; i++) {
					int[] now = jihun.poll();
					int ci = now[0];
					int cj = now[1];
					map[ci][cj] = 'T';
					int dist = now[2];
//					System.out.println(ci + " " + cj + " " + dist);
					dis = dist;

					for (int d = 0; d < 4; d++) {
						int ni = ci + di[d];
						int nj = cj + dj[d];
						if (ni < 0 || ni >= r || nj < 0 || nj >= c) {
							min = dist + 1;
							isEnd = true;
							break;
						} else if (map[ni][nj] == '.') {
							map[ni][nj] = 'J';
						}
					}
				}
				break;
			}
//			print();
			
			// 불 bfs 복사 지훈과 들판 태우기
			while (true) {
				int size = fire.size();

				for (int i = 0; i < size; i++) {
					int[] now = fire.poll();
					int ci = now[0];
					int cj = now[1];

					for (int d = 0; d < 4; d++) {
						int ni = ci + di[d];
						int nj = cj + dj[d];
						if (ni < 0 || ni >= r || nj < 0 || nj >= c) {
							continue;
						} else if (map[ni][nj] != 'F' && map[ni][nj] != '#') {
							map[ni][nj] = 'F';
							fire.add(new int[] {ni, nj});
						}
					}
				}
				break;
			}
//			print();
			
			//여기서 진짜 지훈이만 다시 queue에 담아줌
			for(int i = 0; i < r; i++) {
				for(int j = 0; j < c; j++) {
					if(map[i][j] == 'J') {
						jihun.add(new int[] {i, j, dis+1});
					}
				}
			}
		}

		if (min == -1) {

			System.out.println("IMPOSSIBLE");
		} else {
			System.out.println(min);
		}

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
