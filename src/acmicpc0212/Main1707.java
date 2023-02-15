package acmicpc0212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1707 {

	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static int[] numArr;
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
			numArr = new int[V+1];

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
					dfs(i, 0);
				}
			}

			if (isLoop) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}

		}

	}



	static void dfs(int index, int cnt) {
		if (isLoop) {
			return;
		}
		
//		System.out.println("방문노드 : " + index);
		if (visited[index]) {
//			System.out.println(numArr[index] + " " + cnt);
//			System.out.println((numArr[index] - cnt) % 2);
			if((cnt - numArr[index]) % 2 == 1) {
				isLoop = true;
				return;
			}
		}
		numArr[index] = cnt;
		visited[index] = true;

		for (int i = 0; i < list[index].size(); i++) {
			int to = list[index].get(0);
			list[index].remove(0);
			int temp = list[to].indexOf(index);
			list[to].remove(temp);
			dfs(to, cnt+1);
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
