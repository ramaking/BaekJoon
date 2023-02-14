package acmicpc0212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main1707 {

	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static boolean isLoop;
	static int V;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < t; tc++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());

			list = new ArrayList[V + 1];
			for (int i = 1; i <= V; i++) {
				list[i] = new ArrayList<>();
			}
			visited = new boolean[V + 1];

			isLoop = false;

			if (V == 1) {
				isLoop = true;
			}

			int E = Integer.parseInt(st.nextToken());

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				list[from].add(to);
				list[to].add(from);
			}

			for (int i = 1; i <= V; i++) {
				if (isLoop) {
					break;
				}
				if (!visited[i]) {
					dfs(i);
				}
			}

			if (isLoop) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}

		}

	}

	static void dfs(int index) {
		if (isLoop) {
			return;
		}
		System.out.println("방문노드 : " + index);
		if (visited[index]) {
			isLoop = true;
			return;
		}
		visited[index] = true;

		// 그래프 간 노드가 두개?
		// A => B , B => A 는?

//		for(int i = 0; i < list[index].size(); i++) {
//			int to = list[index].get(i);
//			if(used[index][to]) {
//				used[index][to] = false;
//				used[to][index] = false;
//				dfs(to);
//			}
//				
//		}

		for (int i = 0; i < list[index].size(); i++) {
			int to = list[index].get(i);
//			list[index].remove(0);
//			int temp = list[to].indexOf(index);
//			list[to].remove(temp);
			dfs(to);
		}

//		while (!list[index].isEmpty()) {
//			int to = list[index].get(0);
//			list[index].remove(0);
//			int temp = list[to].indexOf(index);
//			list[to].remove(temp);
//			dfs(to);
//		}
	}

}
