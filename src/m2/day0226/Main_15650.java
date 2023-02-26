package m2.day0226;

import java.util.Scanner;

public class Main_15650 {
	static int n, m;
	static int[] card;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();

		card = new int[m];

		comb(0, 1);
		System.out.println(sb.toString());
		sc.close();
	}

	private static void comb(int cnt, int start) {

		if (cnt == m) {
			for (int i = 0; i < m; i++) {
				sb.append(card[i] + " ");

			}
			sb.append("\n");
			return;
		}

		for (int i = start; i <= n; i++) {
			card[cnt] = i;
			comb(cnt + 1, i+1);
		}
	}
}
