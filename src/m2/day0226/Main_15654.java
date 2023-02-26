package m2.day0226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15654 {
	static int n, m;
	static int[] card;
	static int[] number;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		number = new int[n+1];
		visited = new boolean[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		
		
		Arrays.sort(number);

		
		card = new int[m];
		
		
		

		permu(0);
		System.out.println(sb.toString());
	}

	private static void permu(int cnt) {

		if (cnt == m) {
			for (int i = 0; i < m; i++) {
				sb.append(card[i] + " ");

			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= n; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			card[cnt] = number[i];
			permu(cnt + 1);
			visited[i] = false;
		}
	}
}
