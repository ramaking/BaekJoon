package m4.day0404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main_19236_2 {
	static Fish[][] map; // 초기값
	static int[] di = {-1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dj = {0, -1, -1, -1, 0, 1, 1, 1 };
	static int max = 0;

	public static void main(String[] args) throws NumberFormatException, IOException, CloneNotSupportedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new Fish[4][4];
		for(int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 4; j++) {
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				map[i][j] = new Fish(num, dir-1);

			}
		}
		
//		print(map);
		move(0,0, map, 0);
		
		System.out.println(max);
		
	}
	
	static void move(int si, int sj, Fish[][] bMap, int sum) {
		
		Fish[][] cMap = new Fish[4][4];
		deepCopy(cMap, bMap);
		
		//이 물고기는 먹힘
		sum += cMap[si][sj].num;
		int sharkDir = cMap[si][sj].dir;
		cMap[si][sj] = null;
//		print(cMap);
		
		//작은 물고기 순으로 움직이기
		
		for(int n = 1; n <= 16; n++) {
			moveFish(cMap, n, si, sj);
		}

		//상어의 다음 이동 지점 결정
		int ci = si;
		int cj = sj;
		int ni, nj;
		while(true) {
			ci = ci + di[sharkDir];
			cj = cj + dj[sharkDir];
			if(ci < 0 || ci >= 4 || cj < 0 || cj >= 4) {
				if(max < sum) {
					max = sum;
//					System.out.println(max);
				}
				return;
			}
			if(cMap[ci][cj] == null) continue;
			else {
				move(ci, cj, cMap, sum);
			}
		}
		
		
	}
	
	static void moveFish(Fish[][] cMap ,int n, int si, int sj) {
		int ni, nj;
		boolean canChange = false;
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				if(cMap[i][j] != null && cMap[i][j].num == n) {
					ni = i;
					nj = j;
					for(int d = 0; d < 8; d++) {	//방향 결정
						
						ni = i + di[(cMap[i][j].dir+d)%8];
						nj = j + dj[(cMap[i][j].dir+d)%8];
						
						//범위를 나가거나 상어 45도 돌림
						if(ni < 0 || ni >= 4 || nj < 0 || nj >= 4 || (ni == si && nj == sj)) {
							continue;
						}
						
						//물고기 방향 변경
						cMap[i][j].dir = 
								(cMap[i][j].dir+d)%8;
						canChange = true;
						break;
					}
					
					//바뀐게 없음 이동 안함
					if(!canChange) {
						return;
					}
					
//					System.out.println(n + "번 물고기 " + i + " : " + j+ "에서 " + ni + " " + nj);
					
					//빈칸을 만나면 이동
					if(cMap[ni][nj] == null) {
						cMap[ni][nj] = cMap[i][j].clone();
						cMap[i][j] = null;
						return;
					}
					
					//물고기를 만나면 교체
					if(cMap[ni][nj] != null) {
						Fish tempF = cMap[i][j].clone();
						cMap[i][j] = cMap[ni][nj].clone();
						cMap[ni][nj] = tempF.clone();
					}
					return;
				}
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
