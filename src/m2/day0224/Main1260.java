package m2.day0224;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1260 {

	static int n, m, v;
	static boolean[] visited;
	static ArrayList<Integer>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n+1];
		visited = new boolean[n+1];
		for(int i = 0; i <= n; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		int from, to;
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			
			list[from].add(to);
			list[to].add(from);
			
		}
		
		for(int i = 0; i <= n; i++) {
			Collections.sort(list[i]);
		}
		
		dfs(v);
		System.out.println();
		visited = new boolean[n+1];
		
		bfs(v);

	}

	private static void bfs(int v2) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(v2);
		visited[v2] = true;
		
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			System.out.print(temp + " ");
			for(int i : list[temp]) {
				if(!visited[i]) {
					queue.add(i);
					visited[i] = true;
				}
			}
			
			
		}
		
	}

	private static void dfs(int v2) {
		visited[v2] = true;
		System.out.print(v2+" ");
		for(int i : list[v2]) {
			if(!visited[i])
				dfs(i);
		}
		
	}
	

}
