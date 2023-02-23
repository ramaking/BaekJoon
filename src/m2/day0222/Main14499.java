package m2.day0222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main14499 {

	static int n, m, diceI, diceJ;
	static int[][] arr;
	
	//동서 남북
	static int[] iDir = {0, 0, 0, -1, +1 };
	static int[] jDir = {0, +1, -1, 0, 0 };
	static int[][] dice = {
			{0,0,0},
			{0,0,0},
			{0,0,0},
			{0,0,0},
		};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		diceI = Integer.parseInt(st.nextToken());
		diceJ = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < k; i++) {
			excute(Integer.parseInt(st.nextToken()));
		}
		
	}
	
	static void excute(int exeNum) {
		
		//다음 좌표 특정
		int nI = diceI + iDir[exeNum];
		int nJ = diceJ + jDir[exeNum];
		
		//바운더리 체크
		if(nI < 0 || nI >= n || nJ < 0 || nJ >= m) {
			return;
		}
		diceI = nI;
		diceJ = nJ;
		
		rotate(exeNum);
		
		if(arr[nI][nJ] == 0) {
			arr[nI][nJ]= dice[1][1];
			
		} else {
			dice[1][1] = arr[nI][nJ];
			arr[nI][nJ] = 0;
		}
		System.out.println(dice[3][1]);
		
	}
	
	//zz..
	static void rotate(int what) {
		int temp = dice[3][1];
		if(what == 1) {
			dice[3][1] = dice[1][0];
			dice[1][0] = dice[1][1];
			dice[1][1] = dice[1][2];
			dice[1][2] = temp;
		} else if(what == 2) {
			dice[3][1] = dice[1][2];
			dice[1][2] = dice[1][1];
			dice[1][1] = dice[1][0];
			dice[1][0] = temp;
		} else if(what == 3) {
			dice[3][1] = dice[2][1];
			dice[2][1] = dice[1][1];
			dice[1][1] = dice[0][1];
			dice[0][1] = temp;
		}  else if(what == 4) {
			dice[3][1] = dice[0][1];
			dice[0][1] = dice[1][1];
			dice[1][1] = dice[2][1];
			dice[2][1] = temp;
		} 
	}
}
