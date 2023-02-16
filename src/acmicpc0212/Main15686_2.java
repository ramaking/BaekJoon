package acmicpc0212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main15686_2 {

	static int n, m;
	static ArrayList<int[]> chicArr;
	static ArrayList<int[]> houseArr;
	static int min = Integer.MAX_VALUE;
	static int[][] chicCost;
	static int[] numbers;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		numbers = new int[m];

		chicArr = new ArrayList<>();
		houseArr = new ArrayList<>();


		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				int num = Integer.parseInt(st.nextToken());

				// 치킨집일 경우
				if (num == 2) {
					chicArr.add(new int[] { i, j });
				} else if (num == 1) {
					houseArr.add(new int[] { i, j });
				}

			}
		} // end input

		chicCost = new int[chicArr.size()][houseArr.size()];

		for (int i = 0; i < chicArr.size(); i++) {
			for (int j = 0; j < houseArr.size(); j++) {
				chicCost[i][j] = Math.abs(chicArr.get(i)[0] - houseArr.get(j)[0])
						+ Math.abs(chicArr.get(i)[1] - houseArr.get(j)[1]);
			}
		}
		combChic(0, 0);

		System.out.println(min);

	}

	static void combChic(int cnt, int index) {
		if (cnt == m) {
			int sum = 0;

			for (int j = 0; j < houseArr.size(); j++) {
				int subMin = Integer.MAX_VALUE;
				for (int i = 0; i < m; i++) {
					subMin = Math.min(subMin, chicCost[numbers[i]][j]);
				}
				sum += subMin;
			}

			min = Math.min(min, sum);

			return;
		}

		for (int i = index; i < chicArr.size(); i++) {
			numbers[cnt] = index;
			combChic(cnt + 1, i + 1);
			combChic(cnt, i + 1);
		}

	}

	static void print(int[][] arr) {
		for (int i = 0; i <= n; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println("-------------------------");
	}

}
