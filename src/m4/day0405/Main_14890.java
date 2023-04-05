package m4.day0405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.xml.transform.Source;

/*
 * 왼쪽에서 시작해서 오른쪽으로 쭉 이동
 * 각 상어의 속도와 시간
 * 시간 계산
 * 사람 이동 100
 * 상어 100*100
 * 
 */

public class Main_14890 {
	static Shark[][] map; // 초기값
	static Shark[][] temp; // 상어 이동에 사용될 임시
	static int R, C, M;

	static int[] di = {0, -1, 1, 0, 0 };
	static int[] dj = {0, 0, 0, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException, CloneNotSupportedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new Shark[R + 1][C + 1];

		int r, c, s, d, z;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());

			map[r][c] = new Shark(s, d, z);
		}

		int result = 0;
		for (int i = 1; i <= C; i++) {
//			print();
			temp = new Shark[R + 1][C + 1];
			result += catchShark(i);
			moveShark();
			deepCopy();
		}

		System.out.println(result);
	}

	private static void deepCopy() throws CloneNotSupportedException {
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				if (temp[i][j] != null) {
//					System.out.println(i + " " + j +  " " +temp[i][j].direc);
					map[i][j] = (Shark) temp[i][j].clone();
				}

			}
		}
	}

	private static void moveShark() throws CloneNotSupportedException {
		int ni = 0, nj = 0, nd = 0;
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				if (map[i][j] != null) {
//					System.out.println(i + " " + j + " " + map[i][j].direc + " " + map[i][j].size);
					nd = map[i][j].direc;
					int si = map[i][j].speed * di[map[i][j].direc];
					int sj = map[i][j].speed * dj[map[i][j].direc];
					
					ni = i;
					nj = j;
					
					int modI = si%(2*(R-1));
					int modJ = sj%(2*(C-1));
					
//					System.out.println("mod " + modI + " " + modJ);
					
					while(true) {
						if(modI == 0) {
							break;
						}
						if(ni + modI > R) {
							modI = modI - (R-ni);
							nd = 1;
							ni = R;
						} else if (ni + modI < 1) {
							modI = modI + (ni-1);
							nd = 2;
							ni = 1;
						} else {
							ni = ni + modI;
							modI = 0;
						}
						
						modI *= -1;
					}
					
					while(true) {
						if(modJ == 0) {
							break;
						}
						if(nj + modJ > C) {
							modJ = modJ - (C-nj);
							nd = 4;
							nj = C;
						} else if (nj + modJ < 1) {
							modJ = modJ + (nj-1);
							nd = 3;
							nj = 1;
						} else {
							nj = nj + modJ;
							modJ = 0;
						}
						
						modJ *= -1;
//						System.out.println(modJ);
					}
					
//					System.out.println(ni + " " + nj + " " + nd);
					
					if (temp[ni][nj] != null) {
						if (temp[ni][nj].size < map[i][j].size) {
							temp[ni][nj] = (Shark) map[i][j].clone();
							temp[ni][nj].direc = nd;
						}
					} else {
						temp[ni][nj] = (Shark) map[i][j].clone();
						temp[ni][nj].direc = nd;
					}

					map[i][j] = null;
				}
			}
		}
	}

	//
	private static int catchShark(int j) {
		int result = 0;
		for (int i = 1; i <= R; i++) {
			if (map[i][j] != null) {
				result = map[i][j].size;
				map[i][j] = null;
				return result;
			}
		}
		return result;
	}

	static void print() {
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				if (map[i][j] == null) {
					System.out.print(0 + " ");
				} else {

					System.out.print(map[i][j].size + " ");
				}
			}
			System.out.println();
		}
		System.out.println("================");
	}

	static class Shark {
		public Shark(int speed, int direc, int size) {
			this.speed = speed;
			this.direc = direc;
			this.size = size;
		}

		int speed;
		int direc;
		int size;

		@Override
		protected Object clone() throws CloneNotSupportedException {

			return new Shark(speed, direc, size);
		}
	}
}
