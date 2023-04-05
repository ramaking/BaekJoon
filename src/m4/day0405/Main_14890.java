package m4.day0405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.xml.transform.Source;

/*
 * 내려가는 것만 고려해서 경우의 수를 줄임
 * 
 */

public class Main_14890 {
	static int[][] map; // 초기값
	static boolean[][] can; // 상어 이동에 사용될 임시
	static int R, C, M;

	static int[] di = {0, -1, 1, 0, 0 };
	static int[] dj = {0, 0, 0, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException, CloneNotSupportedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

	}
}
