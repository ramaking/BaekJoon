package m2.day0222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3109_2 {

	static int r, c;
	static boolean[][] arr;
	static int max = 0;
	static int[] dir = { +1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new boolean[r][c];

		String line;
		for (int i = 0; i < r; i++) {
			line = br.readLine();
			for (int j = 0; j < c; j++) {
				if (line.charAt(j) == '.') {
					arr[i][j] = false;
				} else {
					arr[i][j] = true;
				}
			}
		}
		for (int i = 0; i < r; i++) {
			if (!arr[r-i-1][0]) {
				arr[r-i-1][0] = true;
				recu(r-i-1, 0);
			}
		}
//		print();
		System.out.println(max);

	}

	static boolean recu(int row, int col) {
//		print();
		if (col == c - 1) {
			max++;
			return true;

		}

		for (int i = 0; i < 3; i++) {
			if (row + dir[i] >= 0 && row + dir[i] < r && col + 1 < c && !arr[row + dir[i]][col + 1]) {
				arr[row + dir[i]][col + 1] = true;
				if(recu(row + dir[i], col + 1)) {
					return true;
				}
				

			}
		}

		return false;
	}

	static void print() {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("------------------------");
	}

}
