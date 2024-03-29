package m4.day0405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.xml.transform.Source;

/*
 * 내려가는 것만 고려해서 경우의 수를 줄임
 * 이전에 비해 하나 내려가면 길이 유지 확인
 * 유효한 부분은 true 로 만들기
 * 
 */

public class Main_14890 {
	static int[][] map; // 초기값
	static boolean[][] alreadyIUse; // 상어 이동에 사용될 임시
	static boolean[][] alreadyJUse; // 상어 이동에 사용될 임시
	static int n, l;
	static boolean[] icantUse;
	static boolean[] jcantUse;


	public static void main(String[] args) throws NumberFormatException, IOException, CloneNotSupportedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		alreadyIUse = new boolean[n][n];
		alreadyJUse = new boolean[n][n];
		icantUse = new boolean[n];
		jcantUse = new boolean[n];
		
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		check(n, 0);
		
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			if(!icantUse[i]) cnt++;
			if(!jcantUse[i]) cnt++;
		}
		
		
		System.out.println(cnt);

	}


	private static void check(int iStart, int jStart) {
		for(int i = 0; i < n; i++) {
			int postNum = map[i][0];
			for(int j = 1; j < n; j++) {
				if(icantUse[i]) break;

				if(map[i][j] < postNum - 1) {
					icantUse[i] = true;
					break;
				} else if(map[i][j] == postNum - 1) {
					boolean inval = false;
					for(int k = 0; k < l; k++) {
						if(j + k >= n 
								|| alreadyJUse[i][j+k] 
								|| map[i][j+k] != postNum-1) {
							icantUse[i] = true;
							inval  = true;
							break;
						}
						alreadyJUse[i][j+k] = true;
					}
					if(!inval)
						j = j+l-1;
				}
				postNum = map[i][j];
			}
		}
		
		for(int i = 0; i < n; i++) {
			int postNum = map[i][n-1];
			for(int j = n-2; j >= 0; j--) {
				if(icantUse[i]) break;

				if(map[i][j] < postNum - 1) {
					icantUse[i] = true;
					break;
				} else if(map[i][j] == postNum - 1) {
					boolean inval = false;
					for(int k = 0; k < l; k++) {
						if(j - k < 0 
								|| alreadyJUse[i][j-k] 
								|| map[i][j-k] != postNum-1) {
							icantUse[i] = true;
							inval  = true;
							break;
						}
						alreadyJUse[i][j-k] = true;
					}
					if(!inval)
						j = j-l+1;
				}
				postNum = map[i][j];
			}
		}
		
		for(int j = 0; j < n; j++) {
			int postNum = map[0][j];
			for(int i = 1; i < n; i++) {
				if(jcantUse[j]) break;
				if(map[i][j] < postNum - 1) {
					jcantUse[j] = true;
					break;
				}
				if(map[i][j] == postNum) {
					
					
				} else if(map[i][j] == postNum - 1) {
					boolean inval = false;
					for(int k = 0; k < l; k++) {
						if(i + k >= n 
								|| alreadyIUse[i+k][j] 
								|| map[i+k][j] != postNum-1) {
							jcantUse[j] = true;
							inval = true;
							break;
						}
						alreadyIUse[i+k][j] = true;
					}
					if(!inval)
						i = i+l-1;
				}
				postNum = map[i][j];
			}
		}
		
		for(int j = 0; j < n; j++) {
			int postNum = map[n-1][j];
			for(int i = n-2; i >= 0; i--) {
				if(jcantUse[j]) break;
				if(map[i][j] < postNum - 1) {
					jcantUse[j] = true;
					break;
				}
				if(map[i][j] == postNum) {
					
					
				} else if(map[i][j] == postNum - 1) {
					boolean inval = false;
					for(int k = 0; k < l; k++) {
						if(i - k < 0 
								|| alreadyIUse[i-k][j] 
								|| map[i-k][j] != postNum-1) {
							jcantUse[j] = true;
							inval = true;
							break;
						}
						alreadyIUse[i-k][j] = true;
					}
					if(!inval)
						i = i-l+1;
				}
				postNum = map[i][j];
			}
		}
	}
	
	
}
