package m4.day0403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.xml.transform.Source;


/*
 * dfs 4개로 돌리고 ㅗ 자 8개만 따로 돌려서 비교 진행
 */

public class Main_14500 {
	static int[][] map;
	static int n, m;
	static int max = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		for(int i = 0; i <n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i <n; i++) {
			for (int j = 0; j < m; j++) {
				dfs(i, j);
				for(int d = 0; d < 8; d ++) {
					
				}
			}
		}
		
		
	}

	private static void dfs(int i, int j) {
		// TODO Auto-generated method stub
		
	}
	
	
}
