package m4.day0404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main_1941 {

	static char[][] map;
	static boolean[][] used;
	static int totalCount = 0;
	static int sCnt, yCnt;
	static int[] di = {1, 0, -1 ,0};
	static int[] dj = {0, 1, 0 ,-1};
	static int ri, rj;
	
	public static void main(String[] args) throws NumberFormatException, IOException, CloneNotSupportedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new char[5][5];
		used = new boolean[5][5];
		for(int i = 0; i < 5; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
//		for(int i = 0; i < 5; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		
		recu(0,0);
		
		System.out.println(totalCount);
	}

	private static void recu(int index, int count) {
//		if(index == 25) return;
		if(count == 7) {
			sCnt = 0;
			yCnt = 0;
			bfs(ri, rj);
			if(sCnt + yCnt == 7) {
				
				if(sCnt > yCnt) {
//					System.out.println(index-1);
//					System.out.println(sCnt + " " + yCnt);
					totalCount++;
				}
			}
			return;
			
		}
		
		for(int i = index; i < 25; i++) {
			int ni = i/5;
			int nj = i%5;
			used[ni][nj] = true;
			ri = ni;
			rj = nj;
			recu(i+1,count+1);
			used[ni][nj] = false;
		}
		
		
	}

	private static void bfs(int si, int sj) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {si, sj});
		boolean[][] visited = new boolean[5][5];
		visited[si][sj] = true;
		int ci, cj, ni, nj;
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			ci = now[0];
			cj = now[1];
			if(map[ci][cj] == 'Y')
				yCnt++;
			if(map[ci][cj] == 'S')
				sCnt++;
			
			for(int d= 0; d< 4; d++) {
				ni = ci + di[d];
				nj = cj + dj[d];
				if(ni < 0 || ni >= 5 || nj < 0 || nj >= 5 || !used[ni][nj]|| visited[ni][nj])
					continue;
				queue.add(new int[] {ni, nj});
				visited[ni][nj] = true;
			}
			
		}
	}
}
