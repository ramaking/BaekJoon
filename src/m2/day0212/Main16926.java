package m2.day0212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main16926 {

	static int n, m, r, rota;
	static int[][] arr;
	static int[] dirI = { 1, 0, -1, 0 };
	static int[] dirJ = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		arr = new int[n + 1][m + 1];

		rota = Math.min(n, m);

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < r; i++) {
			select();
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}

	static void select() {
//		System.out.println("sele");
		for (int i = 1; i <= rota / 2; i++) {
//			System.out.println("ro");
			rotate(i);
//			for(int j = 1; j <= n; j++) {
//				System.out.println(Arrays.toString(arr[i]));
//			}
		}

	}

	static void rotate(int index) {
		int cI = index;
		int cJ = index;
		int dIndex = 0;
		int copy = arr[index][index];
		int temp = 0;
		boolean isFirst = true;
		while (true) {
			if (cI == index && cJ == index && !isFirst) {

				break;
			}

			isFirst = false;

			int nI = cI + dirI[dIndex];
			int nJ = cJ + dirJ[dIndex];

			if (nI >= index && nI <= n - index + 1 && nJ >= index && nJ <= m - index + 1) {
				temp = arr[nI][nJ];
				arr[nI][nJ] = copy;
				copy = temp;
				cI = nI;
				cJ = nJ;
			} else {
				dIndex = (dIndex + 1) % 4;
			}
		}
	}

}
