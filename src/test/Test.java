package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test {
	static int[][] map; // 초기값
	static int[][] temp;
	static int[][] removeSum;
	static int n, m, k, c;
	static int[] di = {1, 1, -1, -1 };
	static int[] dj = {-1, 1, 1, -1 };
	static int[] lineI = {1, -1, 0, 0};
	static int[] lineJ = {0, 0, 1, -1};
	static int ans = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) {
					map[i][j] = -1001;
				}
			}
		}
		
		for(int i = 0; i < m; i++) {
			// 땅 회복
			recoverGround();
			print();
			//4방 탐색 나무수 만큼 더하기
			plusTree();
			print();
			//번식
			makeTree();
			print();
			//박멸 선정 최대 값 i j
			removeTree();
			print();
		}
		
		System.out.println(ans);
		
		
		
		
	}
	
	private static void removeTree() {
		int max = 0, maxI = -1, maxJ = -1;
		int ci, cj, ni, nj;
		removeSum = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(map[i][j] > 0) {
					for(int d = 0; d < 4; d++) {
						ci = i;
						cj = j;
						for(int h = 0; h < k; h++) {
							ni = ci + di[d];
							nj = cj + dj[d];
							if(!boundaryCheck(ni, nj)) break;
							if(map[ni][nj] == -1001 || map[ni][nj] == 0 ) break;
							
							else {
								removeSum[i][j] += map[ni][nj];
								
							}
							ci = ni;
							cj = nj;
						}
					}
					if(max < removeSum[i][j]) {
						max = removeSum[i][j];
						maxI = i;
						maxJ = j;
					}
				}
			}
		}
		
		if(maxI != -1) {
			for(int d = 0; d < 4; d++) {
				ci = maxI;
				cj = maxJ;
				for(int h = 0; h < k; h++) {
					ni = ci + di[d];
					nj = cj + dj[d];
					if(!boundaryCheck(ni, nj) || map[ni][nj] == -1001) break;

					if(map[ni][nj] == 0 || map[ni][nj] < 0) {
						map[ni][nj] = -c;
						break;
					}
					
					
						
					ci = ni;
					cj = nj;
				}
				
				
			}
			
			ans += max;
		}
		
		
		
		
	}

	private static void makeTree() {
		temp = new int[n][n];
		int ni, nj;
		for(int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				
				if(map[i][j] > 0) {
					int sum = 0;
					for(int d= 0; d < 4; d++) {
						ni = i + lineI[d];
						nj = j + lineJ[d];
						if(!boundaryCheck(ni, nj)) continue;
						if(map[ni][nj] == 0)
							sum++;
					}
					int tempTree = map[i][j]/ sum;
					
					for(int d= 0; d < 4; d++) {
						ni = i + lineI[d];
						nj = j + lineJ[d];
						if(!boundaryCheck(ni, nj)) continue;
						if(map[ni][nj] == 0)
							temp[ni][nj] += tempTree;
					}
					
				}
				
				
				
				
			}
		}
		
		for(int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] += temp[i][j];
				
			}
		}
	}

	private static void plusTree() {
		int ni, nj;
		for(int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				
				if(map[i][j] > 0) {
					int sum = 0;
					for(int d= 0; d < 4; d++) {
						ni = i + lineI[d];
						nj = j + lineJ[d];
						if(!boundaryCheck(ni, nj) || map[ni][nj] < 0) continue;
						System.out.println("2222");
						sum++;
					}
					System.out.println();
					
					map[i][j] += sum;
				}
			}
		}
		
	}
	
	static boolean boundaryCheck(int i , int j) {
		if(i < 0 || i >= n|| j < 0 || j >= n) return false;
		return true;
	}

	private static void recoverGround() {
		for(int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(map[i][j] == -1001) continue;
				if(map[i][j] < 0) map[i][j]++;
			}
		}
	}

	static void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("=======================");
	}
}
