package m3.day0330;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_12920 {
	static ArrayList<Integer> list;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] value = new int[n+1];
		int[] weigth = new int[n+1];
		int[] count = new int[n+1];
		int[][] dp; 
		
		int mv = 0;
		for(int i = 1; i <= n; i++) {
			
			st = new StringTokenizer(br.readLine());
			weigth[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
			count[i] = Integer.parseInt(st.nextToken());
			mv+= value[i]*count[i];
		}
		
		dp = new int[n+1][mv+1];
		
		int result = 0;
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if(j < weigth[i]) {	//못 넣음
					dp[i][j] = dp[i-1][j];
				} else {
					if(j*weigth[i] < dp[0].length) {
						if(j/weigth[i] >= count[i]) {	//넣을 수 있지만 개수 초과
							dp[i][j] = Math.max(value[i]*count[i] + dp[i-1][j-count[i]*weigth[i]],
									dp[i-1][j]);
						}else {
							dp[i][j] =
									Math.max(value[i] * j/weigth[i] + dp[i-1][j-j/weigth[i]*weigth[i]],
											dp[i-1][j]);
//									value[i] + dp[i-1][j*weigth[i]];
						}
//					} else {
//						if(j/weigth[i] >= count[i]) {	//넣을 수 있지만 개수 초과
//							dp[i][j] = Math.max(
//									Math.max(value[i]*count[i],dp[i-1][j]),
//									value[i] + dp[i-1][j*weigth[i]]
//									);
//						}else {
//							dp[i][j] = Math.max(
//									Math.max(value[i] * j/weigth[i],dp[i-1][j]),
//									value[i] + dp[i-1][j*weigth[i]]
//									);
//						}
					}
					
				}
				
				if(dp[i][j] > result) {
					result = dp[i][j];
				}
				
			}
		}
		
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println(result);

		
	}
}
