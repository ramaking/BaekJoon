package m2.day0222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3109 {

	static int r, c;
	static boolean[][] arr, temp;
	static int max1 = 0;
	static int max2 = 0;
	static int[] dir1 = { -1, 0, +1 };
	static int[] dir2 = { +1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new boolean[r][c];
		temp = new boolean[r][c];
		
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
		
		copyArr();
		
		for (int i = 0; i < r; i++) {
			if (!temp[i][0]) {
				temp[i][0] = true;
				recu1(i, 0);
			}
		}
		
		copyArr();
		
		for (int i = 0; i < r; i++) {
			if (!temp[r-i-1][0]) {
				temp[r-i-1][0] = true;
				recu2(r-i-1, 0);
			}
		}
		
		
		
		
//		print();
		System.out.println(Math.max(max1,  max2));

	}

	static void recu1(int row, int col) {
//		print();
		if (col == c - 1) {
			max1++;
			return;

		}

		for (int i = 0; i < 3; i++) {
			if (row + dir1[i] >= 0 && row + dir1[i] < r && col + 1 < c && !temp[row + dir1[i]][col + 1]) {
				temp[row + dir1[i]][col + 1] = true;
				recu1(row + dir1[i], col + 1);
				return;

			}
		}

		return;
	}
	
	static void recu2(int row, int col) {
//		print();
		if (col == c - 1) {
			max2++;
			return;

		}

		for (int i = 0; i < 3; i++) {
			if (row + dir2[i] >= 0 && row + dir2[i] < r && col + 1 < c && !temp[row + dir2[i]][col + 1]) {
				temp[row + dir2[i]][col + 1] = true;
				recu2(row + dir2[i], col + 1);
				return;

			}
		}

		return;
	}
	
	static void copyArr() {
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				temp [i][j] = arr[i][j];
			}
		}
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
