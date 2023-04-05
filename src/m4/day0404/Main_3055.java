package m4.day0404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3055 {

	static char[][] map;
	static char[][] temp;
	static int[] di = {1, 0, -1 ,0};
	static int[] dj = {0, 1, 0 ,-1};
	static int r, c;
	static int min;
	static boolean isEnd = false;
	
	public static void main(String[] args) throws NumberFormatException, IOException, CloneNotSupportedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new char[r][c];
		temp = new char[r][c];
		for(int i = 0; i < r; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		int cnt = 0;
		while(true) {
			//temp 에 현재 맵 카피
			deepCopy();
			cnt++;
			
			//슴도치 이동 이동할 고슴도치가 없으면 종료
			if(!moveS()) {
				break;
			}
			
			//도착하면 종료
			if(isEnd) {
				break;
			}
			
			//물 이동
			moveWater();
			
			//temp 를 map 으로 다시 카피
			reverseCopy();
			
//			for (int i = 0; i < r; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
//			System.out.println("=============");
		}
		
		//도착 성공
		if(isEnd) {
			System.out.println(cnt);
		} else {
			System.out.println("KAKTUS");
		}
		
	}
	

	private static void deepCopy() {
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				temp[i][j] = map[i][j];
			}
		}
	}
	
	private static void reverseCopy() {
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				map[i][j] = temp[i][j];
			}
		}
	}
	
	//벽이나 비버 굴 말고는 다 4방으로 밀어서  temp 에 넣기
	private static void moveWater() {
		int ni, nj;
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				
				if(map[i][j] == '*') {
					for(int d = 0; d < 4; d++) {
						ni = i + di[d];
						nj = j + dj[d];
						if(ni < 0 || ni >= r || nj < 0 || nj >= c 
								|| map[ni][nj] == 'X' || map[ni][nj] == 'D')
							continue;
						temp[ni][nj] = '*';
					}
				}
			}
		}
	}

	//고슴도치를 찾아서 4방으로 복제 기존 고슴도치는 이제 과거의 유물..
	//움직일 고슴도치가 없으면 fail..
	private static boolean moveS() {
		int ni, nj;
		boolean isAlive = false;
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				
				if(map[i][j] == 'S') {
					temp[i][j] = 'F';
					isAlive = true;
					for(int d = 0; d < 4; d++) {
						ni = i + di[d];
						nj = j + dj[d];
						if(ni < 0 || ni >= r || nj < 0 || nj >= c 
								|| map[ni][nj] == '*' || map[ni][nj] == 'X' ||map[ni][nj] == 'F')
							continue;
						if(map[ni][nj] == 'D') {
							isEnd = true;
							return true;
						}
						temp[ni][nj] = 'S';
					}
				}
			}
		}
		return isAlive;
	}
}
