package m2.day0212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main16935 {

	static int n, m, r, num;
	static int[][] arr;
	static int[][] temp;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());


		arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			num = Integer.parseInt(st.nextToken());

			switch (num) {
			case 1:
				mirrir1();
				break;
			case 2:
				mirrir2();
				break;
			case 3:
				rote3();
				break;
			case 4:
				rote4();
				break;
			case 5:
				rote5();
				break;
			case 6:
				rote6();
				break;

			}
		}

		print();

	}

	//상하반전
	static void mirrir1() {
		temp = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				temp[n - i - 1][j] = arr[i][j];
			}
		}
		arr = new int[n][m];
		arrCopy();
	}

	//좌우반전
	static void mirrir2() {
		temp = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				temp[i][m - j - 1] = arr[i][j];
			}
		}
		arr = new int[n][m];
		arrCopy();

	}

	//시계회전
	static void rote3() {

		//가로 세로 반전
		int tempNum = n;
		n = m; 
		m = tempNum;
		temp = new int[n][m];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				temp[j][m - i - 1] = arr[i][j];
			}
		}
		arr = new int[n][m];
		arrCopy();

	}

	//반시계회전
	static void rote4() {

		//가로 세로 반전
		int tempNum = n;
		n = m; 
		m = tempNum;
		temp = new int[n][m];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				temp[n - j - 1][i] = arr[i][j];
			}
		}
		arr = new int[n][m];
		arrCopy();

	}

	//시계 단위 회전
	static void rote5() {

		temp = new int[n][m];
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < m / 2; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[i + n / 2][j];
				arr[i + n / 2][j] = arr[i + n / 2][j + m / 2];
				arr[i + n / 2][j + m / 2] = arr[i][j + m / 2];
				arr[i][j + m / 2] = temp;
			}
		}

	}

	//반시계 단위 회전
	static void rote6() {

		temp = new int[n][m];
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < m / 2; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[i][j + m / 2];
				arr[i][j + m / 2] = arr[i + n / 2][j + m / 2];
				arr[i + n / 2][j + m / 2] = arr[i + n / 2][j];
				arr[i + n / 2][j] = temp;
			}
		}

	}

	//배열 카피
	static void arrCopy() {

		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[0].length; j++) {
				arr[i][j] = temp[i][j];
			}
		}
	}

	//출력
	static void print() {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
