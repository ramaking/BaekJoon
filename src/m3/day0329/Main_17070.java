package m3.day0329;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17070 {

	static int[][][] dp;
	static int[][] board;
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		dp = new int[n][n][3];
		board = new int[n][n];
		StringTokenizer st;
		for (int i = 0; i < dp.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < dp[0].length; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 1) {
					board[i][j] = -1;
				}
			}
		}
		dp[0][1][0] = 1;

		for (int i = 0; i < dp.length; i++) {
			for (int j = 2; j < dp[0].length; j++) {
				
				if (board[i][j] != -1) {
					dp[i][j][0] += dp[i][j - 1][0] + dp[i][j - 1][1];
				}
				if(i > 0) {
					if (!(board[i - 1][j] == -1 || board[i][j - 1] == -1 || board[i][j] == -1))
						dp[i][j][1] += dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2] + dp[i - 1][j - 1][0];

					if (board[i][j] != -1) {
						dp[i][j][2] += dp[i - 1][j][2] + dp[i - 1][j][1];
					}
				} 
				

			}
		}

//		for (int i = 0; i < dp.length; i++) {
//			for (int j = 0; j < dp[0].length; j++) {
//				System.out.print(dp[i][j][0]+dp[i][j][1]+dp[i][j][2] + " ");
//			}
//			System.out.println();
//		}

		System.out.println(dp[n-1][n-1][0]+dp[n-1][n-1][1]+dp[n-1][n-1][2]);

	}

}
