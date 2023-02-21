package acm0220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


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

			if(!end)
				back(0,1);

			if (isValid) {
				System.out.print(1 + " ");
			} else {
				System.out.print(0 + " ");
			}


		}

	}

	//다음 나라는 이전 나라를 확인할 필요 없음
	static void back(int country, int nCoun){
		//한번이라도 유효하면 다음은 검증할 필요없음
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

	//디버깅용..
	static void print() {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(score[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("----------------------");
	}

	//마지막 체크용..
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
