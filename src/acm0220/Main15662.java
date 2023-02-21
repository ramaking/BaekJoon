package acm0220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main15662 {

	static int[][] gear;
	static int k;
	static int t;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		t= Integer.parseInt(br.readLine());
		gear = new int[t][8];

		for (int i = 0; i < t; i++) {
			String line = br.readLine();
			for (int j = 0; j < 8; j++) {
				gear[i][j] = line.charAt(j)-'0';
			}
		}

		k = Integer.parseInt(br.readLine());

		for (int i = 0; i < k; i++) {
			visited = new boolean[t];
			st = new StringTokenizer(br.readLine());
			int gearNum = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			rotate(gearNum-1, dir);
		}
		
		int sum = 0;
		for(int i = 0; i<t; i++) {
			if(gear[i][0] == 1) {
				sum++;
			}
		}
		
		System.out.println(sum);
		

	}

	//어떤 톱니바퀴를 어떤 방향으로 돌릴 지
	static void rotate(int gearNum, int dir) {
		
		//이미 방문한 곳은 넘어감
		visited[gearNum] = true;
		
		//현재 방향에 따라 다음 방향 결정
		int nDir = 1;
		if(dir == 1) {
			nDir = -1;
		}
		
		//왼쪽 기어 확인
		if (gearNum - 1 >= 0 && !visited[gearNum - 1]) {
			if(gear[gearNum - 1][2] != gear[gearNum][6]) {
				rotate(gearNum - 1, nDir);
			}
		}
		
		//오른쪽 기어 확인
		if (gearNum + 1 < t && !visited[gearNum + 1]) {
			if(gear[gearNum + 1][6] != gear[gearNum][2]) {
				rotate(gearNum + 1, nDir);
			}
		}
		
		//회전
		
		if(dir == -1) {	//반시계
			int temp = gear[gearNum][0];
			for(int i = 1 ; i < 8; i++) {
				gear[gearNum][i-1] = gear[gearNum][i];
			}
			gear[gearNum][7] = temp;
		}else {	//시계
			int temp = gear[gearNum][7];
			for(int i = 7 ; i > 0; i--) {
				gear[gearNum][i] = gear[gearNum][i-1];
			}
			gear[gearNum][0] = temp;
		}
	}
	
	

}
