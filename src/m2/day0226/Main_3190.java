package m2.day0226;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3190 {
	
	static int n, k, l;
	static int snakeDir = 0;
	static int currentSec = 0;
	static int headI = 1, headJ = 1;
	static boolean isEnd = false;

	static int[] di = {0,1,0,-1};
	static int[] dj = {1,0,-1,0};
	static Queue<int[]> snake = new ArrayDeque<>();
	static int[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n+1][n+1];
		StringTokenizer st;
		
		k = Integer.parseInt(br.readLine());
		for(int t = 0; t < k; t++) {
			st = new StringTokenizer(br.readLine());
			int iIdx = Integer.parseInt(st.nextToken());
			int jIdx = Integer.parseInt(st.nextToken());
			map[iIdx][jIdx] = 2;
		}
		
		l = Integer.parseInt(br.readLine());
		
		snake.add(new int[] {1,1});
		map[1][1] = 1;
		for(int t = 0; t < l; t++) {
			if(isEnd) {
				break;
			}
			st = new StringTokenizer(br.readLine());
			int sec = Integer.parseInt(st.nextToken());
			char dir = st.nextToken().charAt(0);
			go(sec, dir);
		}
		
		while(!isEnd) {
			go(Integer.MAX_VALUE, 'a');
		}
		
		System.out.println(currentSec);
		
		
	}
	
	static void go(int sec, char dir) {
		for(int i = currentSec; i < sec; i++) {
			currentSec++;
			headI = headI + di[snakeDir];
			headJ = headJ + dj[snakeDir];
//			print();
			if(headI >= 1 && headI < n+1 && headJ >= 1 && headJ < n+1 && map[headI][headJ] != 1) {
				//머리 늘이기
				snake.add(new int[] {headI, headJ});
				if(map[headI][headJ] == 2) {
					
					//사과면 안지움
				} else {
					//꼬리 지우기
					int[] temp = snake.poll();
					map[temp[0]][temp[1]] = 0;
				}
				map[headI][headJ] = 1;
				//게임 종료
			} else {
				isEnd = true;
				return;
			}
			
		}

		//왼쪽
		if(dir == 'L') {
			snakeDir = (snakeDir+3)%4;
			
		//오른쪽
		}else {
			snakeDir = (snakeDir+1)%4;
		}
		
	}

	static void print() {
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				System.out.print(map[i][j] +" ");
			}
			System.out.println();
		}
		System.out.println("---------------------------");
	}
}
