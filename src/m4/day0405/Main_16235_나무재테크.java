package m4.day0405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main_16235_나무재테크 {
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
		for (int i = 0; i < k; i++) {
			spring();
			autumn();
			winter();
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
				for (int k = 5; k <= maxTreeAge[i][j]; k = k + 5) {
					if (tree[i][j][k] != 0) {
						for (int d = 0; d < 8; d++) {
							ni = i + di[d];
							nj = j + dj[d];
							if (ni < 0 || ni >= n || nj < 0 || nj >= n)
								continue;
							tree[ni][nj][1] += tree[i][j][k];
//							System.out.println(tree[ni][nj][1]);
							if(maxTreeAge[ni][nj] == 0) {
								maxTreeAge[ni][nj] = 1;
							}
						}
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
		int tempNutri = 0;
		boolean isEnd = false;
		int maxValue = maxTreeAge[si][sj];
		for (int k = 1; k <= maxValue; k++) {
			
			//이미 영양부족
			if (tree[si][sj][k] != 0 && isEnd) {
				tempNutri += (k / 2) * tree[si][sj][k];
				tree[si][sj][k] = 0;
			}
			
			if (tree[si][sj][k] != 0) {
				//영양 충분
				if (tree[si][sj][k] * k <= nutriMap[si][sj]) {
					temp[k + 1] = tree[si][sj][k];
					nutriMap[si][sj] -= tree[si][sj][k] * k;
					tree[si][sj][k] = 0;
					maxTreeAge[si][sj] = k + 1;
					
					//영양애매
				} else {
					// 살릴 수 있는 만큼 살리고 나머지는 죽이고 영양분으로 전환 isEnd true 로 바꾸기
					int treeSize = tree[si][sj][k];
					for (int i = 1; i <= treeSize; i++) {
						if (nutriMap[si][sj] < k) {
							tempNutri += (k / 2);
							tree[si][sj][k]-- ;
						} else {
							tree[si][sj][k]-- ;
							nutriMap[si][sj] -= k;
							temp[k + 1]++;
							maxTreeAge[si][sj] = k + 1;
						}
						
					}
					isEnd = true;
				}
			}
		}

		//성장 적용
		for (int i = 1; i <= maxValue + 1; i++) {
			tree[si][sj][i] += temp[i];
		}
		//죽은 나무 영양 적용
		nutriMap[si][sj] += tempNutri;
	}

}
