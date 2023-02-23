package m2.day0222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main17822 {

	static int n, m, t;
	static int[][] arr;
	static int[][] rota;
	static int[] iDir = { 1, 0, -1, 0 };
	static int[] jDir = { 0, 1, 0, -1 };
	static boolean isEraserable;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());

		arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int k = 0; k < t; k++) {
			st = new StringTokenizer(br.readLine());

			int xi = Integer.parseInt(st.nextToken());
			int di = Integer.parseInt(st.nextToken());
			int ki = Integer.parseInt(st.nextToken());
			// xi 배수 회전
			int index = xi;
			while (true) {
				rotate(index - 1, di, ki);
				index = index + xi;
				if (index > n) {
					break;
				}
			}
//			print();
			isEraserable = false;
			
			//지우기
			eraser();
//			print();
			//지울게 없다면 평균으로 나누기
			if (!isEraserable) {
				culc();
			}
//			print();
		}

		//결과 출력
		count();
	}

	private static void count() {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] != -1) {
					sum += arr[i][j];
				}
			}
		}
		System.out.println(sum);
	}

	//디버깅 프린트
	private static void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("------------------");
	}

	// 돌리기
	static void rotate(int xi, int di, int ki) {
		int dir = -1;
		if (di == 0) {
			dir = 1;
		}

		// k번 만큼 돌림
		int[] tempArr = new int[m];
		int tempIdx = 0;
		for (int j = 0; j < m; j++) {
			// 돌리는 인덱스가 0보다 작아짐
			if (j + dir * ki < 0) {
				tempIdx = (m + (j + dir * ki));
				// m 보다 커짐
			} else if (j + dir * ki >= m) {
				tempIdx = (j + dir * ki) % m;
			} else {
				tempIdx = (j + dir * ki) % m;
			}
			tempArr[tempIdx] = arr[xi][j];
		}
		// 배열 복사
		for (int i = 0; i < m; i++) {
			arr[xi][i] = tempArr[i];
		}
//		print();
	}
	static void eraser() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] != -1) {
					bfs(i,j);
				}
			}
		}
	}

	private static void bfs(int si, int sj) {
		// TODO Auto-generated method stub
		boolean[][] visited = new boolean[n][m];
		Queue<int[]> queue = new ArrayDeque<>();
		ArrayList<int[]> list = new ArrayList<>();
		list.add(new int[] {si,sj});
		queue.offer(new int[] {si,sj});
		visited[si][sj] = true;
		int cnt = 1;
		int tI, tJ, cI, cJ, num = arr[si][sj];
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			cI = temp[0];
			cJ = temp[1];
			
			for (int d = 0; d < 4; d++) {
				tI = cI + iDir[d];
				tJ = cJ + jDir[d];
				// i의 범위만 체크 함 j는 로테이션이기 때문
				if (tI >= 0 && tI < n) {
					if (tJ == -1) {
						tJ = m - 1;
					} else if (tJ == m) {
						tJ = 0;
					}
					if (arr[tI][tJ] != -1 && arr[tI][tJ] == num && !visited[tI][tJ]) {
						list.add(new int[] {tI, tJ});
						queue.offer(new int[] {tI, tJ});
						cnt ++;
						visited[tI][tJ] = true;
//						System.out.println(tI + " " + tJ);
					}
				}

			}
		}
		
		//주변에 같은 게 있었다면 list에서 하나씩 -1 로 바꿈
		if(cnt > 1) {
//			System.out.println("size : " +list.size());
			isEraserable = true;
			arr[si][sj] = -1;
			for(int i = 0; i < list.size(); i++) {
				int[] temp = list.get(i);
				arr[temp[0]][temp[1]] = -1;
			}
		}
		
	}

	// 평균 후 계산
	static void culc() {
		// -1 은 빼고 계산
		double sum = 0;
		double count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] != -1) {
					sum += arr[i][j];
					count++;
				}
			}
		}
		double avg = sum / count;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] != -1) {
					if (avg > arr[i][j]) {
						arr[i][j] = arr[i][j] + 1;
					} else if (avg < arr[i][j]) {
						arr[i][j] = arr[i][j] - 1;
					}
				}
			}
		}
	}

}
