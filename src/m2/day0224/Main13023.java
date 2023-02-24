package m2.day0224;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main13023 {

	static int n, m;
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static int[] distance;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		list = new ArrayList[n];
		visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		distance = new int[n];

		int from, to;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			list[from].add(to);
			list[to].add(from);
		}

		boolean isParty = false;
		
		
		//dfs : 한번이라도 5이상 나오면 종료
		for(int i = 0; i < n; i++) {
			visited = new boolean[n];
			if(dfs(i, 1)) {
				isParty = true;
				break;
			} 
		}
		
		

		if (isParty)
			System.out.println(1);

		else
			System.out.println(0);
	}

	private static boolean dfs(int maxIdx, int cnt) {
		visited[maxIdx] = true;
		if(cnt == 5) {
			return true;
		}
		for(int next : list[maxIdx]) {
			if(!visited[next])
				if(dfs(next, cnt +1)) {
					return true;
				}
		}
		
		return false;
	}

}
