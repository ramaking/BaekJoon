package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main3187 {

	public static int[] di = { -1, 0, 1, 0 };
	public static int[] dj = { 0, 1, 0, -1 };

	public static int R;
	public static int C;

	public static int sheepCount = 0;
	public static int wolfCount = 0;

	public static char[][] arr;
	
	static int sheep = 0;
	static int wolf = 0;
	
	static Queue<int[]> queue = new LinkedList<>();

	public static void bfs(int indexI, int indexJ) {
		

		int[] index = { indexI, indexJ };
		queue.offer(index);

		sheep = 0;
		wolf = 0;

		int curI;
		int curJ;
		int nextI;
		int nextJ;

		while (true) {
			if (queue.isEmpty()) {
				if (sheep > wolf) {
					sheepCount += sheep;
				} else {
					wolfCount += wolf;
				}
				break;
			}
			
			index = queue.poll();

			curI = index[0];
			curJ = index[1];
			
			// .이라면
			if (arr[curI][curJ] == '.') {
				arr[curI][curJ] = '#';
			} else if (arr[curI][curJ] == 'k') {
				sheep++;
				arr[curI][curJ] = '#';
			} else if (arr[curI][curJ] == 'v') {
				wolf++;
				arr[curI][curJ] = '#';
			}

			for (int i = 0; i < 4; i++) {
				nextI = curI + di[i];
				nextJ = curJ + dj[i];

				// # 이 아니라면
				if (nextI >= 0 && nextI < R && nextJ >= 0 && nextJ < C && arr[nextI][nextJ] != '#') {
					int[] nextIndex = {nextI, nextJ};
					queue.offer(nextIndex);

				}

			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line = br.readLine();

		StringTokenizer st = new StringTokenizer(line);

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = new char[R][C];

		for (int i = 0; i < R; i++) {
			line = br.readLine();

			for (int j = 0; j < C; j++) {
				arr[i][j] = line.charAt(j);
			}
		}
		
		

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (arr[i][j] == 'k' || arr[i][j] == 'v') {
					bfs(i, j);
				}
			}
		}

		System.out.println(sheepCount + " " + wolfCount);

	}

}
