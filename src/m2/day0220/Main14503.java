package m2.day0220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main14503 {
	static int n, m;
	static int[][] room;
	static int[] iDir = {-1,0,+1,0};
	static int[] jDir = {0,+1,0,-1};
	static int rI;
	static int rJ;
	static int rD;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		room = new int[n][m];
		
		st = new StringTokenizer(br.readLine());
		rI = Integer.parseInt(st.nextToken());
		rJ = Integer.parseInt(st.nextToken());
		rD = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		move();
//		int count = 0;
//		for(int i = 0 ; i < n; i++) {
//			for(int j = 0 ; j < m; j++) {
//				if(room[i][j] == 2) {
//					
//				}
//			}
//		}
		System.out.println(count);
	}
	
	static void move() {
		while(true) {
			if(room[rI][rJ] == 0) {
				room[rI][rJ] = 2;
				count++;
			}
			
			boolean isDirty = false;
			//4방 탐색
			for(int d = 0; d < 4; d++) {
				int nI = rI+iDir[d];
				int nJ = rJ+jDir[d];
				
				//4방향 중 청소되지 않은 빈칸이 있음
				if(nI >= 0 && nI < n && nJ >= 0 && nJ < m && room[nI][nJ] == 0) {
					isDirty = true;
					break;
				}
			}
			
			if(isDirty) {
				//회전
				rD = rD-1;
				if(rD == -1) {
					rD = 3;
				}
				int nI = rI+iDir[rD];
				int nJ = rJ+jDir[rD];
				
				//청소되지 않은 빈칸인 경우 전진
				if(room[nI][nJ] == 0) {
					rI = nI;
					rJ = nJ;
				}
			} else {	//안더러움
				int nI = rI+iDir[(rD+2)%4];
				int nJ = rJ+jDir[(rD+2)%4];
				//후진
				if(room[nI][nJ] != 1) {
					rI = nI;
					rJ = nJ;
				} else if(room[nI][nJ] == 1) {	//종료 조건
					break;
				}
			}
			
		}
	}


	
	
	
	
	
	
}
