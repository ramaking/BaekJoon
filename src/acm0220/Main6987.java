package acm0220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//1. 각 승 패는 자신 이외의 짝이 있어야한다.
//2. 무는 자신이외의 짝이 있어야한다.

public class Main6987 {

	static int[][] score = new int[6][3];
	static boolean isValid = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			isValid = false;
			boolean end = false;
			for (int j = 0; j < 6; j++) {
				// 승
				int a = Integer.parseInt(st.nextToken());
				score[j][0] = a;
				int b = Integer.parseInt(st.nextToken());
				score[j][1] = b;
				int c = Integer.parseInt(st.nextToken());
				score[j][2] = c;
				if(a == 6 || b == 6 || c == 6) {
					end =true;
					break;
				} else if(a + b + c != 5) {
					end =true;
					break;
				}
				
			}

			int[] temp = new int[score[0][0]];
			if(!end) {
				comb(0, 0, 0, 2, temp, 0);
			}
			

			if (isValid) {
				System.out.print(1 + " ");
			} else {
				System.out.print(0 + " ");
			}

			// 유효성 검사

		}

	}

	// 다른 팀을 어떻게 고를 건지 조합
	static void comb(int cnt, int index, int me, int need, int[] card, int country) {
		if (isValid) {
			return;
		}
		if (country == 6) {
			// 검사 끝

			if (need == 1) {
				// 승무패 검사 끝

				// 완전!
				if (check()) {
					isValid = true;
					
				}

			} else {
				// 무 검사 시작
				int[] temp = new int[score[0][1]];
				comb(0, 0, 1, 1, temp, 0);
			}

			return;
		}

		if (cnt == card.length) {

			count(card, need, country, me);
			if (country + 1 == 6) {
				comb(0, 0, me, need, null, country + 1);
				return;
			}
//			System.out.println("size : " + score[country + 1][me]);
//			print();
			
			int[] temp = new int[score[country + 1][me]];
			comb(0, 0, me, need, temp, country + 1);

			unCount(card, need, country, me);

			return;
		}

		for (int i = index; i < 6; i++) {
			if (score[i][need] > 0 && i != country) {
				card[cnt] = i;
				comb(cnt + 1, i + 1, me, need, card, country);
			}

		}

	}

	private static void count(int[] index, int need, int country, int me) {
		for (int i = 0; i < index.length; i++) {
			score[country][me]--;
			score[index[i]][need]--;
		}
	}

	private static void unCount(int[] index, int need, int country, int me) {
		for (int i = 0; i < index.length; i++) {
			score[country][me]++;
			score[index[i]][need]++;
		}
	}

	static void print() {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(score[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("----------------------");
	}

	static boolean check() {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 3; j++) {
				if (score[i][j] != 0) {
					return false;
				}
			}
		}
		return true;
	}

}
