package m4.day0405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main_21611 {
	static int[][] map;
	static int n, m;
	static int[] di = {0, 1, 0, -1 };
	static int[] dj = {-1, 0, 1, 0 };
	static int[] magicI = {-1, 1, 0, 0};
	static int[] magicJ = {0, 0, -1, 1};
	static int ans = 0;
	static int maxNum = 0;

	public static void main(String[] args) throws NumberFormatException, IOException, CloneNotSupportedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] != 0) maxNum++;
			}
		}
		
		System.out.println(maxNum);

		for(int t = 0; t < m; t++) {
			st = new StringTokenizer(br.readLine());
			int md = Integer.parseInt(st.nextToken());
			int ms = Integer.parseInt(st.nextToken());
			//마법실행
			magic(md, ms);
			
			int ci = n/2;
			int cj = n/2;
			int cnt = 0;
			int num = 1;
			int d = 0;
			int pNum = 0;
			int pNumCount = 0;
			int cNum = 0;
			int cNumCount = 0;
			boolean isEnd = false;
			Queue<Integer> queue = new ArrayDeque<>();
			
			
			while(true) {
				if(isEnd) break;
				//큐에 담으면서 연속된 값 찾기
				for(int i = 0; i < num; i++) {
					ci = ci + di[d];
					cj = cj + dj[d];
					if(!boundCheck(ci, cj) || map[ci][cj] == 0) {
						isEnd = true;
						break;
					}
					if(cNum != map[ci][cj]) {
						if(cNumCount > 4) {
							for(int tempcnt = 0; tempcnt < cNumCount; tempcnt++) {
								queue.poll();
							}
							
						} else {
							pNum = cNum;
							pNumCount = cNumCount;
							cNum = map[ci][cj];
							cNumCount = 1;
						}
						
					} else if(cNum == map[ci][cj]) {
						cNumCount++;
					}
					queue.add(map[ci][cj]);
//					System.out.println(ci + " " + cj + " " + map[ci][cj]);
				}
				
				cnt++;
				d = (d+1)%4;
				if(cnt%2 == 0) {
					num++;
				}
			}
			
			//큐에 담긴 값 다시 넣어주기
			
			//값 나눠서 불리기
			
		}
		
		
		
		
		System.out.println(ans);

	}
	
	private static void magic(int md, int ms) {
		
	}

	static boolean boundCheck(int ni, int nj) {
		if(ni < 0 || ni >= n || nj < 0 || nj >= n)
			return false;
		return true;
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

}
