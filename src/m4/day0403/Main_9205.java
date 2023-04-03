package m4.day0403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 경로문제
 * 단, 각 거리가 1000이하이어야 함
 * 자기 자신에서 거리가 1000이하인 좌표를 찾아 움직이다가 종점에 도착할 수 있으면 종료(원하는 지점일 경우 true 리턴)
 * 다 끝났는데 도착하지 못하면 종료(큐를 다 돌리고 false 리턴)
 * 한 곳을 두번 방문할 필요 없음(방문체크)
 * 이때 각 지점마다 다른 모든 정점 까지의 거리를 구하는 건 비효율 적
 * 미리 갈 수 있는 지 구해주면 편할 듯
 * 즉 102 * 102 배열을 만들고 
 */

public class Main_9205 {
	static int t, n;
	static int hi, hj;
	static int ri, rj;
	static int [][] comven;
	static ArrayList<Integer>[] list;
//	static boolean [][] visitable;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int tc = 0 ;tc < t; tc++) {
			n = Integer.parseInt(br.readLine());
			comven = new int[n+2][2];
			list = new ArrayList[n+2];
			for(int i = 0; i < n+2; i++) {
				list[i] = new ArrayList<>();
			}
//			visitable = new boolean[n+2][n+2];
			visited = new boolean[n+2];
			
			st = new StringTokenizer(br.readLine());
			hi = Integer.parseInt(st.nextToken());
			hj = Integer.parseInt(st.nextToken());
			comven[0][0] = hi;
			comven[0][1] = hj;
			
			
			for(int i = 1; i < n+1; i++) {
				st = new StringTokenizer(br.readLine());
				comven[i][0] = Integer.parseInt(st.nextToken());
				comven[i][1] = Integer.parseInt(st.nextToken());
				
				
			}
			
			st = new StringTokenizer(br.readLine());
			ri = Integer.parseInt(st.nextToken());
			rj = Integer.parseInt(st.nextToken());
			comven[n+1][0] = ri;
			comven[n+1][1] = rj;
			
			//방문 가능한지 체크
			for (int i = 0; i < n+2; i++) {
				for(int j = 0; j < n+2; j++) {
					if((Math.abs(comven[j][0] - comven[i][0]) +
							Math.abs(comven[j][1] - comven[i][1])) <= 1000) {
						list[i].add(j);
						list[j].add(i);
//						visitable[i][j] = true;
//						visitable[j][i] = true;
						
					}
				}
			}
			
			
			
			
//			System.out.println(list[1].);
			
			if(bfs()) {
				System.out.println("happy");
			} else {
				System.out.println("sad");
			}
			
			
			
		}
		
	}

	private static boolean bfs() {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(0);
		visited[0] = true;
		int now, next;
		while(!queue.isEmpty()) {
			now = queue.poll();
			
			if(now == n+1) {
				return true;
			}
			
			for(int i = 0 ; i < list[now].size(); i++) {
				next = list[now].get(i);
				if(!visited[next]) {
					visited[next] = true;
					queue.add(next);
				}
			}
		}
		
		return false;
	}
	
}
