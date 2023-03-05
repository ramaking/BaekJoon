package m3.day0301;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16236 {
	static int n;
	static int[][] fish;
	static int[] di = {-1, 0, 1, 0};
	static int[] dj = {0, -1, 0, 1};
	static boolean[][] visited;
	static int si, sj;
	static int sharkSize = 2;
	static int stom = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		fish = new int [n][n];
		visited = new boolean[n][n];
		int ans = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				fish[i][j] = Integer.parseInt(st.nextToken());
				if(fish[i][j] == 9) {
					fish[i][j] = 0;
					si = i;
					sj = j;
				}
			}
		}
		PriorityQueue<Point> pq = new PriorityQueue<>();
		Queue<Point> queue = new ArrayDeque<>();
		queue.add(new Point(si, sj));
		visited[si][sj] = true;
		int ci , cj, ni, nj;
		int cnt = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				Point now = queue.poll();
				ci = now.i;
				cj = now.j;
				
				for(int d = 0; d < 4; d++) {
					ni = ci + di[d];
					nj = cj + dj[d];
					
					if(ni < 0 || ni >= n|| nj < 0 || nj >= n)
						continue;
					if(visited[ni][nj])
						continue;
					
					if(fish[ni][nj] <= sharkSize) {
						visited[ni][nj] = true;
						if(fish[ni][nj] == 0 || fish[ni][nj] == sharkSize) {
							queue.add(new Point(ni, nj));
						} else if(fish[ni][nj] < sharkSize) {
							pq.add(new Point(ni, nj));
						}
					}
				}
			}
			cnt++;
			//먹이 queue size 가 0이 아니면...
			if(pq.size() != 0) {
				visited = new boolean[n][n];
				Point peed = pq.poll();
				stom ++;
				if(sharkSize == stom) {
					sharkSize++;
					stom = 0;
				}
				fish[peed.i][peed.j] = 0;
				queue.clear();
				pq.clear();
				ans += cnt;
				queue.add(new Point (peed.i, peed.j));
				cnt = 0;
//				print();
			}
			
			
		}
		System.out.println(ans);
		
	}

	private static void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(fish[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("----------------");
	}

	static class Point implements Comparable<Point>{
		public Point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}

		int i,j;

		@Override
		public int compareTo(Point o) {
			if(this.i > o.i) {
				return 1;
			} else if(this.i == o.i) {
				if(this.j > o.j) {
					return 1;
				} else {
					return -1;
				}
				
			}
			return -1;
		}
		
	}

}
