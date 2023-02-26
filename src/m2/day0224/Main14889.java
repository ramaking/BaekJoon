package m2.day0224;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main14889 {
	static int n, min = Integer.MAX_VALUE;
	static int[][] arr;
	static boolean[] used;
	static ArrayList<Integer> team1 = new ArrayList<>();
	static ArrayList<Integer> team2 = new ArrayList<>();
	static boolean isEnd =false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		arr = new int[n][n];
		used = new boolean[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		comb(0, 0);
		
		System.out.println(min);

	}

	private static void comb(int cnt, int start) {
		if(isEnd) {
			return;
		}

		if (cnt == n / 2) {
//			System.out.println(Arrays.toString(card));
//			System.out.println(Arrays.toString(used));

			for (int i = 0; i < n; i++) {
				if(used[i]) {
					team1.add(i);
				} else {
					team2.add(i);
				}
			}
//			System.out.println(team1);
//			System.out.println(team2);
			
			int team1sum = 0;
			//점수 계산
			for(int i = 0; i < n/2; i++) {
				for(int j= 0; j < n/2; j++) {
					team1sum += arr[team1.get(i)][team1.get(j)];
				}
			}
			
			int team2sum = 0;
			//점수 계산
			for(int i = 0; i < n/2; i++) {
				for(int j= 0; j < n/2; j++) {
					team2sum += arr[team2.get(i)][team2.get(j)];
				}
			}
			
			int sum = Math.abs(team1sum - team2sum);
			if(min > sum) {
				min = sum;
			}
			
			if(min == 0) {
				isEnd = true;
			}
			
			team1.clear();
			team2.clear();

			return;
		}

		for (int i = start; i < n; i++) {
			used[i] = true;
			comb(cnt + 1, i + 1);
			used[i] = false;
		}

	}

}
