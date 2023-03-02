package m3.day0302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 구조적으로 잘못됨
 * 그리디가 아님
 * 재귀적으로 5 4 3 2 1 순으로 체크하면서 넘어가야 할 듯
 * 반례 : 8 * 8 러 채워진 박스는  4가 나와야 하지만 5로 먼저 채워버리면 안됨
 * 어쩐지 골2 치고 너무 쉽더라니...
 */

public class Main_17136 {

	static int[][] map = new int[10][10];
	static boolean[][] willVisit = new boolean[10][10];
	static int[] used = { 0, 5, 5, 5, 5, 5 };
	static int min = Integer.MAX_VALUE;
	static int sum = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1)
					willVisit[i][j] = true;
			}
		}
		
		find();
		
		if(min == Integer.MAX_VALUE) {
			
			System.out.println(-1);
		} else {
			System.out.println(min);
		}

	}

	private static boolean check(int si, int sj, int n) {
		int ni, nj;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				ni = i + si;
				nj = j + sj;
				if (ni < 0 || ni >= 10 || nj < 0 || nj >= 10 || map[ni][nj] != 1 || !willVisit[ni][nj]) {
					return false;
				}
			}
		}
		return true;
	}

	private static void setTrue(int si, int sj, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				willVisit[si + i][sj + j] = true;
			}
		}
	}

	private static void setFalse(int si, int sj, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				willVisit[si + i][sj + j] = false;
			}
		}
	}

	private static void find() {
		boolean isChangable = false;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (map[i][j] == 1 && willVisit[i][j] == true) {
					isChangable = true;
					for (int n = 5; n > 0; n--) {
						if (check(i, j, n)) {
							if( used[n] == 0) {
//								if(n == 1) {
//									return;
//								}
								continue;
							}
							if(sum+1 > min) {
								continue;
							}
							setFalse(i, j, n);
							sum++;
							used[n]--;
							
							find();
							sum--;
							setTrue(i, j, n);
							used[n]++;

						}
					}
					
					return;
				}
			}
		}
		
		if (!isChangable && allCheck()) {
//			System.out.println(sum);
//			System.out.println(Arrays.toString(used));
			min = Math.min(min, sum);
		}

	}

	private static boolean allCheck() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (willVisit[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	
	private static void print() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(willVisit[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("----------------------------");
	}

}
