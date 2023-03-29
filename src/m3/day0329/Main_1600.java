package m3.day0329;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 1. dfs 로 상황마다 4방 혹은 8방 나이트 움직임을 선택해서 원하는 지점까지 도달할 수 있는 지 체크 
이때, 도달한 지점까지 나이트 움직임을 몇번 사용했는지와 총 움직임 횟수를 표기한다.
이후 가지치기 단계에서 총 이동횟수가 정답을 넘어가면 컷
이미 도달한 지점이더라도 더 짧게 도착하면 상관없음
다 하고 도착지점 확인해서 초기값이면 -1

2. dp 풀이법?
한 지점에 도착하는 값이 이전의 값에 영향을 받나? 
즉, 최소값을 저장하는 가?
2가지 부분으로 확인해야하는데, 나이트 움직임을 몇번 사용했는가와 일반 움직임을 몇번 사용했는가
나이트는 무시하더라도 일반을 체크해야한다.
근데 이걸 위해서는 모든값은 max 로 초기화하고
총 12방에서 도달한 값이 최소가 되는지를 확인해야함... 이게 맞음?
0,0을 0으로 초기화하고 1들은 -1로 초기화
마지막 지점을 확인하고 max면 -1 반환
 */

public class Main_1600 {

	static int[][] dpNum;
	static int[][] dpNight;
	static boolean[][] cantvisit;
	static int[] di = { 0, 1, 0, -1 };
	static int[] dj = { 1, 0, -1, 0 };
	static int[] dni = { 2, 1, -1, -2, -2, -1, 1, 2 };
	static int[] dnj = { 1, 2, 2, 1, -1, -2, -2, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		dpNum = new int[H][W];
		dpNight = new int[H][W];
		cantvisit = new boolean[H][W];

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				if (st.nextToken().equals("1")) {
					cantvisit[i][j] = true;
				}
			}
		}

		for (int i = 0; i < dpNum.length; i++) {
			Arrays.fill(dpNum[i], Integer.MAX_VALUE);
//			Arrays.fill(dpNight[i], Integer.MAX_VALUE);

		}
		dpNum[0][0] = 0;
		dpNight[0][0] = 0;
		int ni, nj;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if(cantvisit[i][j]) continue;

				for (int dn = 0; dn < 8; dn++) {
					ni = i + dni[dn];
					nj = j + dnj[dn];
					if (ni < 0 || ni >= H || nj < 0 || nj >= W || cantvisit[ni][nj])
						continue;
					if (dpNight[ni][nj] < K) {
						if (dpNum[i][j] > dpNum[ni][nj]) {
							dpNum[i][j] = dpNum[ni][nj] + 1;
							dpNight[i][j] = dpNight[ni][nj] + 1;
						}
					}

				}

				for (int d = 0; d < 4; d++) {
					ni = i + di[d];
					nj = j + dj[d];
					if (ni < 0 || ni >= H || nj < 0 || nj >= W || cantvisit[ni][nj])
						continue;
					if (dpNum[i][j] > dpNum[ni][nj]) {
						dpNum[i][j] = dpNum[ni][nj] + 1;
					}
				}

			}
		}
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if(dpNum[i][j] == Integer.MAX_VALUE) {
					System.out.print(-1+" ");
				}else {
					
					System.out.print(dpNum[i][j] + " ");
				}
			}
			System.out.println();
		}
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
	
					System.out.print(dpNight[i][j] + " ");

			}
			System.out.println();
		}
		

		if (dpNum[H - 1][W - 1] == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			
			System.out.println(dpNum[H - 1][W - 1]);
		}

	}

}
