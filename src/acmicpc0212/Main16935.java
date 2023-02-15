package acmicpc0212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main16935 {

	static int n, m, r, num;
	static int cn, cm, pn, pm;
	static int[][] arr;
	static int[][] temp;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		cn = n;
		cm = m;

		pn = n;
		pm = m;
//		dir = Math.max(n, m);

		arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		num = Integer.parseInt(br.readLine());

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

			break;
		case 6:

			break;

		}

		print();

	}
	
	static void mirrir1() {
		for (int r1 = 0; r1 < r; r1++) {
			temp = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					temp[n - i - 1][j] = arr[i][j];
				}

			}
			arr = new int[n][m];
			arrCopy();
		}

	}

	static void mirrir2() {
		for (int r1 = 0; r1 < r; r1++) {
			temp = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					temp[i][m - j - 1] = arr[i][j];
				}

			}
			arr = new int[n][m];
			arrCopy();
		}

	}

	static void rote3() {
		for (int r1 = 0; r1 < r; r1++) {

			cn = pm;
			cm = pn;
			temp = new int[cn][cm];
			for (int i = 0; i < cm; i++) {
				for (int j = 0; j < cn; j++) {
					temp[j][cm - i - 1] = arr[i][j];
				}
			}

			arr = new int[cn][cm];
			arrCopy();
			int tempNum = pm;
			pm = pn;
			pn = tempNum;
		}
	}

	static void rote4() {
		for (int r1 = 0; r1 < r; r1++) {

			cn = pm;
			cm = pn;
			temp = new int[cn][cm];
			for (int i = 0; i < cm; i++) {
				for (int j = 0; j < cn; j++) {
					temp[cn - j - 1][i] = arr[i][j];
				}
			}

			arr = new int[cn][cm];
			arrCopy();
			int tempNum = pm;
			pm = pn;
			pn = tempNum;
		}
	}

	static void arrCopy() {
		
		for (int i = 0; i < cn; i++) {
			
			for (int j = 0; j < cm; j++) {
				
				arr[i][j] = temp[i][j];
			}
		}
	}

	static void print() {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
