package m3.day0302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17070 {
	static int n;
	static int[][] map;
	static int sum = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0,1,0);
		
		System.out.println(sum);

	}

	static void dfs(int si, int sj, int dir) {
		// 종료 지점 도달 시 sum++ 하고 종료
		if (si == n - 1 && sj == n - 1) {
			sum++;
			return;
		}

		// 현재 상태에 따라 경우의 수 나누기
		/*
		 * 1. 오른쪽 : 오른족 혹은 대각선 2. 대각선 : 오른쪽 혹은 대각선 혹은 아래쪽 3. 아래쪽 : 대각선 혹은 아래쪽
		 */

		if (dir + 1 < 3 && sj+1 < n && map[si][sj + 1] != 1) {
			map[si][sj+1] = 1;
			dfs(si, sj + 1, 0);
			map[si][sj+1] = 0;
		}
		
		if( si+1 < n && sj+1 < n && map[si][sj+1] != 1 && map[si+1][sj+1] != 1 && map[si+1][sj] != 1) {
			
			map[si][sj+1] = 1;
			map[si+1][sj+1] = 1;
			map[si+1][sj] = 1;
			dfs(si + 1, sj + 1, 1);
			map[si][sj+1] = 0;
			map[si+1][sj+1] = 0;
			map[si+1][sj] = 0;
		}
		
		if (dir - 1 >= 0 && si+1 < n && map[si+1][sj] != 1) {
			map[si+1][sj] = 1;
			dfs(si + 1, sj, 2);
			map[si+1][sj] = 0;
		}
	}
}
