package m3.day0329;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1. 서로 대응되도록 하나씩 방문처리를 해서 탐색 후 백트래킹
2. dp 로 하나의 다리로 만들 수 있는 최대의 경우의 수를 저장하기?
이걸 위해서는 ... 
dp[1] = mC1
dp[2] = mC2
dp[3] = mC3
...
dp[x] = mCx
mCx = m-1Cx-1 + m-1Cx
최대 30개의 값이 주어지면,
30C15 정도가 최대가 될 듯
그럼 m까지 다 구하면 됨
2차원 dp 배열로 저장..
 */

public class Main_1010 {
	
	static int[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			dp = new int [m+1][m+1];
			
			makeDp(n,m);
			System.out.println(dp[m][n]);
			
		}
	}

	private static void makeDp(int n, int m) {
		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = 1;
			dp[0][i] = 1;
		}
		dp[0][0] = 0;
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
				if(i == m && j == n) {
					return;
				}
			}
		}
		
	}

}
