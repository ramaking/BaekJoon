package m2.day0224;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main1012_dfs {
	
	static boolean[][] arr;
	static int M,N;
	static int[] iDir = {0,1,0,-1};
	static int[] jDir = {1,0,-1,0};
	static Queue<int[]> que = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 0; tc < T; tc++) {

			M = sc.nextInt();
			N = sc.nextInt();
			
			arr = new boolean[M][N];
			
			int K = sc.nextInt();
			for(int kNum = 0; kNum < K; kNum ++) {
				
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				arr[x][y] = true;
			}
			int sum = 0;
			for(int i = 0; i < M; i++) {
				for(int j = 0; j < N; j++) {
					if(arr[i][j]) {
						dfs(i,j);
						sum ++;
					}
				}
			}
			
			System.out.println(sum);
		}

	}
	
	
	static void dfs(int iIndex, int jIndex) {
		arr[iIndex][jIndex] = false;
		for(int i = 0; i < 4; i++) {
			int nI = iIndex + iDir[i];
			int nJ = jIndex + jDir[i];
			
			if(nI >= 0 && nI < M && nJ >= 0 && nJ < N && arr[nI][nJ]) {
				dfs(nI, nJ);
			}
		}
	}

}
