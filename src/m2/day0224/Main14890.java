package m2.day0224;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main14890 {

	static int n,l;
	static boolean[] low, col;
	static int[] id = { 0, -1, 0, 1};
	static int[] jd = { -1, 0, 1, 0 };

	static int[] whatI = {1,0};
	static int[] whatJ = {0,1};
	static int[][] arr;
	static int result = 0;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());

		arr = new int[n][n];
		low = new boolean[n];
		col = new boolean[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		for(int i = 0; i < n; i++) {
			if(longCheck(i,0,3)) {
				
			}
		}
		
		for(int i = 0; i < n; i++) {
			longCheck(i,n-1,0);
		}
		
		for(int i = 0; i < n; i++) {
			longCheck(0,i,4);
		}
		
		for(int i = 0; i < n; i++) {
			longCheck(n-1,i,2);
		}
		
		
		System.out.println(result);

	}
	
	static boolean longCheck(int startI, int startJ, int dir) {
		int temp = arr[startI][startJ];
		int ci = startI, cj = startJ, ni, nj;
		for(int i = 0; i < n; i++) {
			ni = ci + id[dir];
			nj = cj + jd[dir];
			
			//바운더리 체크
			
			if(arr[ni][nj] == temp) {
				continue;
			}else if(arr[ni][nj] == temp+1){
				if(shortCheck(ci, cj, dir)) {
					continue;
				} else {
					return false;
				}
			} else {
				
			}
		}
		return true;
	}
	
	static boolean shortCheck(int startI, int startJ, int dir) {{
		for(int i = 0; i < l; i++) {
			
		}
	}
		return true;
	}

}
