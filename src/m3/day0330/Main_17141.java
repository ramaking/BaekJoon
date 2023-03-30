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

public class Main_17141 {

	static int n, m;
	static int [][] map;
	static int[][] temp;
	static boolean[][] visited;
	static ArrayList<int[]> virus = new ArrayList<>();
	static int[] card;
	static int[] di = {1,0,-1,0};
	static int[] dj = {0,1,0,-1};
	static int min = Integer.MAX_VALUE;
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int [n][n];
		temp = new int [n][n];
		card = new int[m];
		
		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map.length; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num == 2) {
					virus.add(new int[] {i,j});
				} else if(num == 1){
					map[i][j] = -1;
					
				}
			}
		}
		
		comb(0,0);
		
		if(min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			
			System.out.println(min);
		}
		
	}
	
	static void comb(int cnt, int index) {
		
		if(cnt == m) {
//			System.out.println(Arrays.toString(card));
			deepCopy();
			visited = new boolean[n][n];
			int cmin = bfs();
			
			//바이러스가 다 퍼졌는데 부족하면 -1
			if(check()) {
				min = Math.min(min, cmin);
//				System.out.println(min);
			}
//			print();
			return;
		}
		
		for(int i = index; i < virus.size(); i++) {
			card[cnt] = i;
			comb(cnt+1, i+1);
		}
		
	}
	
	private static int bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		int ci, cj, ni, nj;
		for(int i = 0; i < card.length; i++) {
			ci = virus.get(card[i])[0];
			cj = virus.get(card[i])[1];
			queue.add(new int[] {ci, cj});
			visited[ci][cj] = true;
			temp[ci][cj] = -1;
		}
		
		
		int cnt = 1;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] now = queue.poll();
				ci = now[0];
				cj = now[1];
				
				for (int d = 0; d < 4; d++) {
					ni = ci + di[d];
					nj = cj + dj[d];
					if(ni < 0 || ni >= n || nj < 0 || nj >= n || visited[ni][nj] || temp[ni][nj] != 0) 
						continue;
					queue.add(new int [] {ni, nj});
					visited[ni][nj] = true;
					temp[ni][nj] = cnt;
				}
			}
			
			
			cnt++;
			
		}
		return cnt-2;
		
	}
	
	static boolean check() {
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if(temp[i][j] == 0)
					return false;
			}
		}
		return true;
	}

	static void deepCopy() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				temp[i][j] = map[i][j];
			}
		}
	}
	
	static void print() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				System.out.print(temp[i][j] + " ");

			}
			System.out.println();
		}
		System.out.println("====================");
	}

}
