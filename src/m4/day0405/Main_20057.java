package m4.day0405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 가운데에서 시작
 * 방향은  좌 하 우 상 순서
 * 1 1 2 2 3 3 4 4... 밖으로 나갈 때 까지
 * 이동하려는 칸에 모래가 있는 경우 그 칸으로 부터 연산진행
 * 원래 값으로 부터 연산을 진행해서 다 나눠주고, 나머지 55% 가 밀림
 *  이때, 격자 밖으로 나가는 모래를 전부 한 변수에 담아서 저장함
 * 
 * 
 */

public class Main_20057 {
	static int[][] map; // 초기값
	static int n;
	static int[] di = {0, 1, 0, -1 };
	static int[] dj = {-1, 0, 1, 0 };
	static int ans = 0;

	public static void main(String[] args) throws NumberFormatException, IOException, CloneNotSupportedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}
		int ci = n/2;
		int cj = n/2;
		int d = 0;
		int cnt = 0;
		int num = 1;
		int ni, nj;
		
		boolean isEnd=  false;
		
		while(true) {
			if(isEnd) break;
			
			for(int i = 0; i < num; i++) {
				ni = ci + di[d];
				nj = cj + dj[d];
				if(ni < 0 || ni >= n|| nj < 0 ||nj >= n) {
					isEnd = true;
					break;
				}
				makeWind(d, ni, nj);
				map[ni][nj] = 0;
				ci = ni;
				cj = nj;
			}
			
			cnt++;
			d = (d + 1)%4;
			if(cnt%2 == 0) {
				num++;
			}
//			print();
		}
		
		
		System.out.println(ans);

	}
	
	static void makeWind(int d, int si, int sj) {
		int ni, nj;
		
		int sum = 0;
		
		ni = si + di[d] + di[d];
		nj = sj + dj[d] + dj[d];
		if(boundCheck(ni, nj)) {
			map[ni][nj] += map[si][sj] * 5 / 100;
		} else {
			ans += map[si][sj] * 5 / 100;
		}
		sum += map[si][sj] * 5 / 100;
		
		ni = si + di[d] + di[(d+1)%4];
		nj = sj + dj[d] + dj[(d+1)%4];
		if(boundCheck(ni, nj)) {
			map[ni][nj] += map[si][sj] * 10 / 100;
		} else {
			ans += map[si][sj] * 10 / 100;
		}
		sum += map[si][sj] * 10 / 100;
		
		ni = si + di[d] + di[(d+3)%4];
		nj = sj + dj[d] + dj[(d+3)%4];
		if(boundCheck(ni, nj)) {
			map[ni][nj] += map[si][sj] * 10 / 100;
		} else {
			ans += map[si][sj] * 10 / 100;
		}
		sum +=  map[si][sj] * 10 / 100;
		
		ni = si + di[(d+3)%4];
		nj = sj + dj[(d+3)%4];
		if(boundCheck(ni, nj)) {
			map[ni][nj] += map[si][sj] * 7 / 100;
		} else {
			ans += map[si][sj] * 7 / 100;
		}
		sum +=  map[si][sj] * 7 / 100;
		
		ni = si + di[(d+1)%4];
		nj = sj + dj[(d+1)%4];
		if(boundCheck(ni, nj)) {
			map[ni][nj] += map[si][sj] * 7 / 100;
		} else {
			ans += map[si][sj] * 7 / 100;
		}
		sum +=  map[si][sj] * 7 / 100;
		
		ni = si + di[(d+1)%4] + di[(d+1)%4];
		nj = sj + dj[(d+1)%4] + dj[(d+1)%4];
		if(boundCheck(ni, nj)) {
			map[ni][nj] += map[si][sj] * 2 / 100;
		} else {
			ans += map[si][sj] * 2 / 100;
		}
		sum +=  map[si][sj] * 2 / 100;
		
		ni = si + di[(d+3)%4] + di[(d+3)%4];
		nj = sj + dj[(d+3)%4] + dj[(d+3)%4];
		if(boundCheck(ni, nj)) {
			map[ni][nj] += map[si][sj] * 2 / 100;
		} else {
			ans += map[si][sj] * 2 / 100;
		}
		sum +=  map[si][sj] * 2 / 100;
		
		ni = si + di[(d+1)%4] + di[(d+2)%4];
		nj = sj + dj[(d+1)%4] + dj[(d+2)%4];
		if(boundCheck(ni, nj)) {
			map[ni][nj] += map[si][sj] * 1 / 100;
		} else {
			ans += map[si][sj] * 1 / 100;
		}
		sum +=  map[si][sj] * 1 / 100;
		
		ni = si + di[(d+3)%4] + di[(d+2)%4];
		nj = sj + dj[(d+3)%4] + dj[(d+2)%4];
		if(boundCheck(ni, nj)) {
			map[ni][nj] += map[si][sj] * 1 / 100;
		} else {
			ans += map[si][sj] * 1 / 100;
		}
		sum +=  map[si][sj] * 1 / 100;
		
		map[si][sj] -= sum;
		
		ni = si + di[d];
		nj = sj + dj[d];
		if(boundCheck(ni, nj)) {
			map[ni][nj] += map[si][sj];
		} else {
			ans += map[si][sj];
		}
		
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
