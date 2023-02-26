package m2.day0226;

import java.util.Scanner;

public class Main_15649 {
	static int n, m;
	static boolean[] visited;
	static int[] card;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();

		visited = new boolean[n+1];
		card = new int[m];

		permu(0);
		System.out.println(sb.toString());
		sc.close();
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
			if (visited[i])
				continue;
			visited[i] = true;
			card[cnt] = i;
			permu(cnt + 1);
			visited[i] = false;
		}
	}
}
