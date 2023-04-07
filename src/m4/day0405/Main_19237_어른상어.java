package m4.day0405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 * 상어의 넘버와 방향을 남기는 linkedlist
 * 상어 위치를 남기는 배열
 * 상어 방향 초기값 세팅
 * 초기값 세팅 상어 냄새 뿌리기
 * 냄새를 남기는 배열
 * 움직이는 상어의 순서는 상관없고 그냥 먼저 찾는 상어 가 움직이면 됨
 * 
 * 모든 상어 냄새 1씩 빼기
 * 상어 이동
 * 	1. 우선순위에 따라 보면서 빈칸이 있으면 감
 * 빈칸이 없으면 다시 보면서 가장 높은 우선순위의 자기 냄새로 이동
 * 
 * 상어 이동
 * 배열을 보고 숫자가 작은 상어가 남음 linkedlist에서 겹치는 큰 상어를 제거
 * 1. 상어 냄새 남기기
 * 
 */

public class Main_19237_어른상어 {
	static int[][] map; // 초기값
	static Smell[][] smell;
	static int n, m, k;
	static Shark[] sharkArr;
	static int[] di = { 0, -1, 1, 0, 0 };
	static int[] dj = { 0, 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException, CloneNotSupportedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		sharkArr = new Shark[m + 1];
		smell = new Smell[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if (map[i][j] != 0) {
					smell[i][j] = new Smell(map[i][j], k);
					sharkArr[map[i][j]] = new Shark(map[i][j], i, j);
				}
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= m; i++) {
			sharkArr[i].dir = Integer.parseInt(st.nextToken());
		}

		for (int s = 1; s <= m; s++) {
			for (int i = 1; i <= 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= 4; j++) {
					sharkArr[s].dirList[i][j] = Integer.parseInt(st.nextToken());
				}
			}

		}
		int cnt = 0;
		for (; cnt <= 1000; cnt++) {
//			print();
			// 상어가 1개 남으면 종료
			if (!checkSharkNum()) {
				break;
			}

			moveShark();

			smellMinus();

			makeSmell();
		}
		
		if(cnt != 1001) {
			System.out.println(cnt);
		} else {
			System.out.println(-1);
		}
		

	}

	private static boolean checkSharkNum() {
		for (int i = 2; i <= m; i++) {
			if (sharkArr[i] != null) {
				return true;
			}
		}
		return false;
	}

	private static void makeSmell() {
		Shark shark;
		for (int i = 1; i <= m; i++) {
			if (sharkArr[i] != null) {
				shark = sharkArr[i];
				smell[shark.i][shark.j] = new Smell(shark.num, k);
			}
		}
	}

	private static void moveShark() {
		for (int i = 1; i <= m; i++) {
			if (sharkArr[i] != null) {
				check(i);
			}
		}
	}

	private static void check(int i) {
		int ni, nj;
		Shark shark = sharkArr[i];

		// 빈칸찾기
		for (int d = 1; d <= 4; d++) {
			ni = shark.i + di[shark.dirList[shark.dir][d]];
			nj = shark.j + dj[shark.dirList[shark.dir][d]];
			if (ni < 0 || ni >= n || nj < 0 || nj >= n)
				continue;
			if (smell[ni][nj] == null) {
				if (map[ni][nj] != 0) {
					if (map[ni][nj] > shark.num) {
						// 기존 상어 삭제
						// 상어 작은걸로 초기화
						sharkArr[map[ni][nj]] = null;
						map[ni][nj] = shark.num;
					} else {
						// 이 상어 삭제
						map[shark.i][shark.j] = 0;
						sharkArr[i] = null;
					}
				} else {
					map[shark.i][shark.j] = 0;
					map[ni][nj] = shark.num;
					shark.i = ni;
					shark.j = nj;
					shark.dir = shark.dirList[shark.dir][d];

				}
				return;
			}
		}

		// 자신의 냄새 찾기
		for (int d = 1; d <= 4; d++) {

			ni = shark.i + di[shark.dirList[shark.dir][d]];
			nj = shark.j + dj[shark.dirList[shark.dir][d]];
			if (ni < 0 || ni >= n || nj < 0 || nj >= n)
				continue;
			if (smell[ni][nj].num == i) {
				map[shark.i][shark.j] = 0;
				map[ni][nj] = shark.num;
				shark.i = ni;
				shark.j = nj;
				shark.dir = shark.dirList[shark.dir][d];

				return;
			}
		}

	}

	private static void smellMinus() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (smell[i][j] != null) {
					smell[i][j].time -= 1;
					if (smell[i][j].time == 0) {
						smell[i][j] = null;
					}
				}
			}
		}
	}

	static void print() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("===============");
	}

	static class Shark {
		int num;
		int dir;
		int i, j;
		int[][] dirList = new int[5][5];

		public Shark(int num, int i, int j) {
			this.num = num;
			this.i = i;
			this.j = j;
		}

	}

	static class Smell {
		int num;
		int time;

		public Smell(int num, int time) {
			this.num = num;
			this.time = time;
		}

	}

}
