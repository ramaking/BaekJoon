package m4.day0405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 * 
 * 좌표별로 나이별 나무의 개수를 저장하는 10*10*1000 2차원 배열
 * 어린나무 부터 참조하면서 영양분 빨아먹기
 * 
 * 각 좌표 별 나이 젤 많은 나무 나이 저장하는 배열
 * 
 * 좌표별 영양분 10*10 배열
 * 영양분 초기값 5로 세팅
 * 
 * 
 */

public class Main_16235 {
	static int[][][] tree;
	static int[][] nutri;
	static int[][] nutriMap;
	static int[][] maxTreeAge;
	static int n, m, k;
	static int[] di = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dj = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException, CloneNotSupportedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		tree = new int[n][n][1000];
		nutri = new int[n][n];
		maxTreeAge = new int[n][n];
		nutriMap = new int[n][n];

		// 좌표 별 영양 정보
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				nutriMap[i][j] = 5;
				nutri[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 초기 나무 점보
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			tree[a - 1][b - 1][c] = 1;
			maxTreeAge[a - 1][b - 1] = c;
		}
		print();
		for (int i = 0; i < k; i++) {
			spring();
			print();
			autumn();
			print();
			winter();
			print();
		}

		print();

	}

	static void print() {
		int sum = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 1; k <= maxTreeAge[i][j]; k++) {
					sum += tree[i][j][k];
				}
			}
		}

		System.out.println(sum);
	}

	private static void winter() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				nutriMap[i][j] += nutri[i][j];
			}
		}

	}

	private static void autumn() {
		int ni, nj;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k <= maxTreeAge[i][j]; k = k + 5) {
					for (int d = 0; d < 8; d++) {
						ni = i + di[d];
						nj = j + dj[d];
						if (ni < 0 || ni >= n || nj < 0 || nj >= n)
							continue;
						tree[ni][nj][1]++;
					}
				}

			}
		}
	}

	private static void spring() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				culc(i, j);

			}
		}

	}

	private static void culc(int si, int sj) {
		int[] temp = new int[1000];
		boolean isEnd = false;
		int maxValue = maxTreeAge[si][sj];
		for (int k = 1; k <= maxValue; k++) {
			if (tree[si][sj][k] != 0 && isEnd) {
				nutriMap[si][sj] += (k / 2) * tree[si][sj][k];
			}
			if (tree[si][sj][k] != 0) {
				if (tree[si][sj][k] * k < nutriMap[si][sj]) {
					temp[k + 1] = tree[si][sj][k];
					nutriMap[si][sj] -= tree[si][sj][k] * k;
					tree[si][sj][k] = 0;
					maxTreeAge[si][sj] = k+1;
//					System.out.println("ss");
				} else {
					// 살릴 수 있는 만큼 살리고 나머지는 죽이고 영양분으로 전환 isEnd true 로 바꾸기
					for (int i = 1; i <= tree[si][sj][k]; i++) {
						if (nutriMap[si][sj] < k) {
							nutriMap[si][sj] += (k / 2);
						} else {
							nutriMap[si][sj] -= k;
							temp[k + 1]++;
						}
						maxTreeAge[si][sj] = k+1;
					}
					isEnd = true;
				}
			}
		}
		
		for(int i = 1; i <= maxValue+1; i++) {
			tree[si][sj][i] += temp[i];
		}

	}

}
