package m2.day0224;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main10026 {
	
	static int n;
	static char[][] arr;
	static boolean[][] visited;
	static int[] id = { 1, 0, -1, 0 };
	static int[] jd = { 0, 1, 0, -1 };
	static ArrayList<Character> list = new ArrayList<>();
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());

		arr = new char[n][n];
		visited = new boolean[n][n];
		String line;
		for (int i = 0; i < n; i++) {
			line = br.readLine();
			arr[i] = line.toCharArray();
		}
		
		//적록색약 X
		cnt = 0;
		visited = new boolean[n][n];
		for(int i = 0; i < n ; i++) {
			for(int j = 0; j < n; j++) {
				if(!visited[i][j]) {
//					System.out.println(arr[i][j]);
					list.add(arr[i][j]);
					bfs(i,j);
					cnt++;
					list.clear();
				}
			}
		}
		System.out.print(cnt + " ");
		
		//적록색약 O
		cnt = 0;
		visited = new boolean[n][n];
		for(int i = 0; i < n ; i++) {
			for(int j = 0; j < n; j++) {
				if(!visited[i][j]) {
//					System.out.println(arr[i][j]);
					list.add(arr[i][j]);
					if(arr[i][j] == 'R') {
						list.add('G');
					} else if(arr[i][j] == 'G') {
						list.add('R');
					}
					bfs(i,j);
					cnt++;
					list.clear();
				}
			}
		}
		System.out.print(cnt);
		
	}
	
	static void bfs(int si, int sj) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {si, sj});
		visited[si][sj] = true;
		int ci,cj,ni,nj;
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			ci = now[0];
			cj = now[1];
			for(int d = 0; d < 4; d++) {
				ni = ci + id[d];
				nj = cj + jd[d];
				if(ni >= 0 && ni < n && nj >= 0 && nj < n && !visited[ni][nj]) {
					if(list.contains(arr[ni][nj])) {
						visited[ni][nj] = true;
						queue.add(new int[] {ni,nj});
					}
				}
			}
		}
		
	}
	
}