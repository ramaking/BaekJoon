package m3.day0301;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17144 {

	static int R, C, T;
	static int[][] map;
	static int[][] temp;
	static int[] di = { 0, 1, 0, -1 };
	static int[] dj = { 1, 0, -1, 0 };
	static ArrayList<int[]> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int [R][C];
		temp = new int[R][C];
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				temp[i][j] = map[i][j];
				if(map[i][j] == -1) {
					list.add(new int[] {i, j});
				}
			}
		}
//		print();
		for(int t = 0; t < T; t++) {
			deepcopy();
			clear();
			for(int i = 0; i < R; i++) {
				for(int j = 0; j < C; j++) {
					if(map[i][j] != 0 && map[i][j] != -1) {
						diffuse(i, j);
//						print();
					}
				}
			}
			airCondition();
			int[] temp1 = list.get(0);
			temp[temp1[0]][temp1[1]] = -1;
			temp1 = list.get(1);
			temp[temp1[0]][temp1[1]] = -1;
//			print();
		}
		
		int[] temp1 = list.get(0);
		temp[temp1[0]][temp1[1]] = 0;
		temp1 = list.get(1);
		temp[temp1[0]][temp1[1]] = 0;
		
		int sum = 0;
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				sum += temp[i][j];
			}
		}
		System.out.println(sum);
	}

	private static void print() {
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				System.out.print(temp[i][j]+ " ");
			}
			System.out.println();
		}
		System.out.println("---------------------");
	}

	private static void clear() {
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				temp[i][j] = 0;
			}
		}
	}

	private static void deepcopy() {
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				map[i][j] = temp[i][j];
			}
		}
	}

	private static void airCondition() {
		
		int[] start = list.get(0);
		int ci, cj, ni, nj;
		int dir = 3;
		ci = start[0]-1;
		cj = start[1];
		while(true) {
			
			ni = ci + di[dir];
			nj = cj + dj[dir];
//			System.out.println(ni + " : " + nj);
			if(ni < 0 || ni > start[0] || nj < 0 || nj >= C) {
				dir = (dir+1)%4;
				continue;
			}
			if(ni == start[0] && nj == start[1]) {
				temp[ci][cj] = 0;
				break;
			}
			temp[ci][cj] = temp[ni][nj];
			ci = ni;
			cj = nj;
		}
		
		
		
		start = list.get(1);
		dir = 1;
		ci = start[0]+1;
		cj = start[1];
		while(true) {
			
			ni = ci + di[dir];
			nj = cj + dj[dir];
//			System.out.println(ni + " : " + nj);
			if(ni >= R || ni < start[0] || nj < 0 || nj >= C) {
				if(dir-1 == -1) {
					dir = 3;
				} else {
					dir = dir-1;
				}
				
				continue;
			}
			if(ni == start[0] && nj == start[1]) {
				temp[ci][cj] = 0;
				break;
			}
			temp[ci][cj] = temp[ni][nj];
			ci = ni;
			cj = nj;
		}
		
	}

	private static void diffuse(int si , int sj) {
		int ni, nj;
		int cnt = 0;
		for(int d = 0; d < 4; d++) {
			ni = si + di[d];
			nj = sj + dj[d];
			if(ni < 0 || ni >= R || nj < 0 || nj >= C || map[ni][nj] == -1)
				continue;
			cnt++;
			temp[ni][nj] += map[si][sj]/5;
		}
		temp[si][sj] += map[si][sj] - map[si][sj]/5*cnt;
	}

}
