package m4.day0404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main_19236 {
	static Fish[][] map; // 초기값
	static int[] di = {-1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dj = {0, -1, -1, -1, 0, 1, 1, 1 };
	static int max = 0;

	public static void main(String[] args) throws NumberFormatException, IOException, CloneNotSupportedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] fishs = new int[17][2];
		map = new Fish[4][4];
		for(int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 4; j++) {
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				map[i][j] = new Fish(num, dir-1);
				fishs[num][0] = i;
				fishs[num][1] = j;
			}
		}
		
		move(0,0, map, 0, fishs);
		
		System.out.println(max);
		
	}
	
	static void move(int si, int sj, Fish[][] bMap, int sum, int[][] bfishs) {
		
		
		Fish[][] cMap = new Fish[4][4];
		deepCopy(cMap, bMap);
		int[][] cfishs = new int[17][2];
		deepCopy2(cfishs, bfishs);
		
//		print(cMap);
//		for(int i = 1; i <= 16; i++) {
//			System.out.println(Arrays.toString(cfishs[i]));
//		}
//		System.out.println("===================");
		
		//이 물고기는 먹힘
		cfishs[cMap[si][sj].num][0] = -1;
		cfishs[cMap[si][sj].num][1] = -1;
		sum += cMap[si][sj].num;
		int sharkDir = cMap[si][sj].dir;
		cMap[si][sj] = null;
		System.out.println(si + " " + sj + " " + sharkDir);
		print(cMap);
//		for(int i = 1; i <= 16; i++) {
//			System.out.println(Arrays.toString(cfishs[i]));
//		}
//		System.out.println("===================");
		
		//작은 물고기 순으로 움직이기
		int ni = -1, nj = -1, ci, cj;
		for(int i = 1; i <= 16; i++) {
//			System.out.println(i);
//			print(cMap);
			if(cfishs[i][0] != -1) {	//이동 가능 물고기
//				System.out.println("can move");
				ci = cfishs[i][0];
				cj = cfishs[i][1];
				for(int d = 0; d <= 8; d++) {	//방향 결정
					
					ni = ci + di[(cMap[ci][cj].dir+d)%8];
					nj = cj + dj[(cMap[ci][cj].dir+d)%8];
					
					//범위를 나가거나 상어 45도 돌림
					if(ni < 0 || ni >= 4 || nj < 0 || nj >= 4 || (ni == si && nj == sj)) {
						continue;
					}
					
					//물고기 방향 변경
					cMap[ci][cj].dir = 
							(cMap[ci][cj].dir+d)%8;
//					System.out.println("횢ㄴ");
					break;
				}
				
//				System.out.println(ci + " " + cj);
//				System.out.println(ni + " " + nj);
				
				//바뀐게 없음 이동 안함
				if(ci == ni && cj == nj) {
					continue;
				}
				
				//빈칸을 만나면 이동
				if(cMap[ni][nj] == null) {
					cMap[ni][nj] = cMap[ci][cj].clone();
					cfishs[i][0] = ni;
					cfishs[i][1] = nj;
					cMap[ci][cj] = null;
//					ci = ni;
//					cj = nj;
					continue;
				}
				
				//물고기를 만나면 교체
				if(cMap[ni][nj] != null) {
					int tempI = ci;
					int tempJ = cj;
					
					cfishs[i][0] = ni;
					cfishs[i][1] = nj;
//					ci = ni;
//					cj = nj;
					cfishs[cMap[ni][nj].num][0] = tempI;
					cfishs[cMap[ni][nj].num][1] = tempJ;
					
					Fish tempF = cMap[ci][cj].clone();
					cMap[ci][cj] = cMap[ni][nj];
					cMap[ni][nj] = tempF.clone();
				}
				
			}
		}
		
		
		//상어의 다음 이동 지점 결정
		ci = si;
		cj = sj;
		while(true) {
			ni = ci + di[sharkDir];
			nj = cj + dj[sharkDir];
			if(ni < 0 || ni >= 4 || nj < 0 || nj >= 4) {
				if(max < sum) {
					max = sum;
					System.out.println(max);
				}
				return;
			}
			if(cMap[ni][nj] == null) continue;
			else {
				move(ni, nj, cMap, sum, cfishs);
			}
		}
		
		
	}

	static void deepCopy(Fish[][] cMap, Fish[][] dMap) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (dMap[i][j] != null) {
					cMap[i][j] = dMap[i][j].clone();
				}
			}
		}
	}
	
	static void deepCopy2(int[][] cMap, int[][] dMap) {
		for (int i = 0; i < 17; i++) {
			for (int j = 0; j < 2; j++) {
				cMap[i][j] = dMap[i][j];
				
			}
		}
	}

	static void print(Fish[][] map) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (map[i][j] == null) {
					System.out.print(0 + " ");
				} else {

					System.out.print(map[i][j].num + " ");
				}
			}
			System.out.println();
		}
		System.out.println("================");
	}

	static class Fish {
		public Fish(int num, int dir) {
			this.num = num;
			this.dir = dir;
		}

		int num;
		int dir;

		protected Fish clone() {

			return new Fish(num, dir);
		}
	}
}
