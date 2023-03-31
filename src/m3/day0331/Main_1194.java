package m3.day0331;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1194 {
	
	static int n, m;
	static char[][] map;
	static int si, sj;
	static int[] di = {1, 0, -1, 0};
	static int[] dj = {0, 1, 0, -1};
	static int min = Integer.MAX_VALUE;
	static char[][] temp;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		temp = new char[n][m];
		visited = new boolean[n][m];
		String line;
		for (int i = 0; i < n; i++) {
			line = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = line.charAt(j);
				if(map[i][j] == '0') {
					si = i;
					sj = j;
				}
			}
			
		}
		
		totalBfs();
		
		if(min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
		
//		print();
		
	}
	
	static void totalBfs() {
		Queue<BfsClass> bfsQueue = new ArrayDeque<>();
		BfsClass bfs = new BfsClass();
		bfs.si = si;
		bfs.sj = sj;
		bfs.cnt = 0;
		bfs.key = new HashMap<>();
		
		bfsQueue.add(bfs);
		
		BfsClass tempBBB;
		while(!bfsQueue.isEmpty()) {
			tempBBB = bfsQueue.poll(); 
			deepCopy();
			
			for (int i = 0; i < tempBBB.keyIndex.size(); i++) {
				int[] index = tempBBB.keyIndex.get(i);
				temp[index[0]][index[1]] = 0;
			}
//			print();
//			ArrayList<Character> list = (ArrayList<Character>)tbfs.key.values();
//			for (int i = 0; i < list.size(); i++) {
//				
//			}
			
			Queue<int[]> queue = new ArrayDeque<>();
			int ci = tempBBB.si, cj = tempBBB.sj, ni, nj, cnt = tempBBB.cnt;
//			System.out.println(cnt);
			queue.add(new int[] {ci, cj, cnt});
			
			visitedClear();
//			boolean[][] visited = new boolean[n][m];
			visited[ci][cj] = true;
			
			while(!queue.isEmpty()) {
				int[] now = queue.poll();
				
				ci = now[0];
				cj = now[1];
				cnt = now[2];
				
				for(int d = 0; d < 4; d++) {
					ni = ci + di[d];
					nj = cj + dj[d];
					if(ni < 0 || ni >= n || nj < 0 || nj >= m || visited[ni][nj] || temp[ni][nj] == '#')
						continue;
					
					if(temp[ni][nj] == '1') {
						if(min > cnt+1) {
							min = cnt+1;
						}
//						return cnt+1;
					}
					
					if('A' <= temp[ni][nj] && temp[ni][nj] <= 'F') {
						if(tempBBB.key.get(temp[ni][nj]) == null) {
							continue;
						} 
					}
					
					if('a' <= temp[ni][nj] && temp[ni][nj] <= 'f') {
						
						if(!tempBBB.key.containsKey((char)(temp[ni][nj]-'a'+'A'))) {
							BfsClass tempb = new BfsClass();
							tempb.si = ni;
							tempb.sj = nj;
							tempb.cnt = cnt+1;
							tempb.key = (HashMap<Character, Character>)tempBBB.key.clone();
							tempb.key.put( (char)(temp[ni][nj]-'a'+'A'), temp[ni][nj]);
							tempb.keyIndex = (ArrayList)tempBBB.keyIndex.clone();
							tempb.keyIndex.add(new int[] {ni, nj});
							bfsQueue.add(tempb);
						} else {
							System.out.println("already have");
						}
						
					}
//					if(cnt+1 > min) {
//						return;
//					}
					visited[ni][nj] = true;
					queue.add(new int[] {ni, nj, cnt+1});
				}
			}
		}
		
//		return -1;
	}
	
	static void visitedClear() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				visited[i][j] = false;
			}
		}
	}
	
	static void deepCopy() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				temp[i][j] = map[i][j];
			}
		}
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
	
	static class BfsClass{
		int si;
		int sj;
		int cnt;
		HashMap<Character, Character> key = new HashMap<>();
		ArrayList<int[]> keyIndex = new ArrayList<>();
	}
	
}
