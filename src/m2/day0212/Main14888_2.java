package m2.day0212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14888_2 {

	static int n, m, r, rota;
	static int[] numbers;
	static int[] cul;
	static StringBuilder sb;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static int[] charArr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		numbers = new int[n];
		charArr = new int[n - 1];


		for (int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());

		cul = new int[4];

		sb = new StringBuilder();

		for (int i = 0; i < 4; i++) {
			cul[i] = Integer.parseInt(st.nextToken());
		}

		calc(0, 0);

		System.out.println(max);
		System.out.println(min);

	}

	static void calc(int cnt, int index) {
		if (cnt == n - 1) {
			int sum = numbers[0];
			for (int i = 0; i < n - 1; i++) {
				if (charArr[i] == 0) {
					sum += numbers[i + 1];
				}
				if (charArr[i] == 1) {
					sum -= numbers[i + 1];
				}
				if (charArr[i] == 2) {
					sum *= numbers[i + 1];
				}
				if (charArr[i] == 3) {
					sum /= numbers[i + 1];
				}

			}
			max = Math.max(max, sum);
			min = Math.min(min, sum);

			return;
		}

		for (int i = 0; i < 4; i++) {
			if (cul[i] != 0) {
				cul[i]--;
				charArr[cnt] = i;
				calc(cnt + 1, index + 1);
				cul[i]++;
			}
		}
	}

}
