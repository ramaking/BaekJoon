package m3.day0331;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1194_2 {

	static int n, m;
	static char[][] map;
	static boolean[][][] visited;
	static int si, sj;
	static int[] di = { 1, 0, -1, 0 };
	static int[] dj = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		visited = new boolean[n][m][65];
		String line;
		for (int i = 0; i < n; i++) {
			line = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = line.charAt(j);
				if (map[i][j] == '0') {
					si = i;
					sj = j;
				}
			}

		}

		int result = totalBfs();

		System.out.println(result);

//		print();

	}

	static int totalBfs() {

		Queue<int[]> queue = new ArrayDeque<>();
		int ci = si, cj = sj ,ck = 0 , ni, nj;
		queue.add(new int[] { ci, cj, ck});

		visited[ci][cj][ck] = true;
		int cnt = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] now = queue.poll();
				

				ci = now[0];
				cj = now[1];
				ck = now[2];
				System.out.println(ci + " : " + cj + " : " + ck);
				for (int d = 0; d < 4; d++) {
					ni = ci + di[d];
					nj = cj + dj[d];
					if (ni < 0 || ni >= n || nj < 0 || nj >= m || visited[ni][nj][ck] || map[ni][nj] == '#')
						continue;

					if (map[ni][nj] == '1') {
						
						return cnt+1;
					}

					if ('A' <= map[ni][nj] && map[ni][nj] <= 'F') {
						System.out.println("door " + map[ni][nj]);
						System.out.println((ck >> (map[ni][nj]-'A'+1)));
						System.out.println(map[ni][nj]-'A');
						System.out.println();
						if((ck >> (map[ni][nj]-'A')) != 1) {
							continue;
						}
					}

					if ('a' <= map[ni][nj] && map[ni][nj] <= 'f') {
						
						if((ck >> (map[ni][nj]-'a')) != 1) {
							System.out.println("key " + map[ni][nj]);
							System.out.println((ck >> (map[ni][nj]-'a'+1)));
							System.out.println(map[ni][nj]-'a'+1);
							System.out.println();
							int temp = 1 << (map[ni][nj] -'a');
							visited[ni][nj][ck | temp] = true;
							queue.add(new int [] {ni, nj, ck | temp });
						} 
						

					}
					
					visited[ni][nj][ck] = true;
					queue.add(new int[] { ni, nj, ck });
				}
			}
			
			cnt++;
		}
		return -1;

	}

	static void print() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("===================");
	}

}
