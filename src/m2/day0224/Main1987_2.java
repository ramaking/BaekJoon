package m2.day0224;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1987_2 {
	
	static int r, c;
	static char[][] arr;
	static boolean[][] visited;
	static int[] id = { 1, 0, -1, 0 };
	static int[] jd = { 0, 1, 0, -1 };
	static int max = 1;
	static boolean[] used = new boolean[26];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		arr = new char[r][];
		visited = new boolean[r][c];
		String line;
		for (int i = 0; i < r; i++) {
			line = br.readLine();
			arr[i] = line.toCharArray();
		}

		dfs(0, 0, 1);

		System.out.println(max);
	}

	private static void dfs(int si, int sj, int cnt) {
		used[arr[si][sj]-'A'] = true;
		visited[si][sj] = true;
		
		if(max < cnt) {
			max = cnt;
		}
		
		int ni, nj;
		for(int d = 0; d < 4; d++) {
			ni = si + id[d];
			nj = sj + jd[d];
			if(ni >= 0 && ni < r && nj >= 0 && nj < c) {
				if(!visited[ni][nj] && !used[arr[ni][nj]-'A'] ) {
					dfs(ni, nj, cnt + 1);
					visited[ni][nj] = false;
					used[arr[ni][nj]-'A'] = false;
				}
			}
		}
		
	}
}