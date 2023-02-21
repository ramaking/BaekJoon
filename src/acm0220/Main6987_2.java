package acm0220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//1. 각 승 패는 자신 이외의 짝이 있어야한다.
//2. 무는 자신이외의 짝이 있어야한다.

public class Main6987_2 {

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

			back(0,1);

			if (isValid) {
				System.out.print(1 + " ");
			} else {
				System.out.print(0 + " ");
			}

			// 유효성 검사

		}

	}

	static void back(int country, int nCoun){
		
		if(isValid) {
			return;
		}
		if(nCoun == 6) {
			
			if(country == 5) {
				
				if(check()) {
					isValid = true;
					
				}
				return;
			}
			
			
			back(country+1, country+2);
			return;
		}
		
		//이김
		if(score[nCoun][2] > 0 && score[country][0]> 0) {
			score[country][0] --;
			score[nCoun][2] --;
			back(country, nCoun+1);
			score[country][0] ++;
			score[nCoun][2] ++;
		}
		
		//비김
		if(score[nCoun][1] > 0 && score[country][1]> 0) {
			score[country][1] --;
			score[nCoun][1] --;
			back(country, nCoun+1);
			score[country][1] ++;
			score[nCoun][1] ++;
		}
		
		//짐
		if(score[nCoun][0] > 0 && score[country][2]> 0) {
			score[country][2] --;
			score[nCoun][0] --;
			back(country, nCoun+1);
			score[country][2] ++;
			score[nCoun][0] ++;
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
