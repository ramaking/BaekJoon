package m3.day0301;

import java.io.BufferedReader;

/*
 * 구조적으로 잘못됨
 * 그리디가 아님
 * 재귀적으로 5 4 3 2 1 순으로 체크하면서 넘어가야 할 듯
 * 반례 : 8 * 8 러 채워진 박스는  4가 나와야 하지만 5로 먼저 채워버리면 안됨
 * 어쩐지 골2 치고 너무 쉽더라니...
 */
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2750 {

	static int[][] map = new int[10][10];
	static boolean[][] willVisit = new boolean[10][10];
	static int[] used = { 0, 5, 5, 5, 5, 5 };
	static int sum = 0;;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int [n];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		for(int i = 0; i < n; i++) {
			System.out.println(arr[i]);
		}
	}

	private static boolean check() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if(map[i][j] == 1) return false;
			}
		}
		return true;
	}

	private static boolean find(int si, int sj, int n) {
		int ni, nj;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				ni = i + si;
				nj = j + sj;
				// 이 색종이는 너무 큼
				if (ni < 0 || ni >= 10 || nj < 0 || nj >= 10 || map[ni][nj] != 1) {
					return false;
				}
			}
		}
		
		used[n]--;
		// 방문 처리
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i + si][j + sj] = 0;
			}
		}
		sum++;
		
		return true;

	}

}
