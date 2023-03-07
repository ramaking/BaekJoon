package m3.day0302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1541 {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		
		boolean findMinus = false;
		int sum = 0;
		int tempSum = 0;
		StringBuilder sb = new StringBuilder();
		char lastEx = '/';
		for(int i = 0; i < line.length(); i++) {
			if(line.charAt(i) == '-' && findMinus) {
				//다음 마이너스 찾을 때 까지 더하고 빼기
				sum -= tempSum;
				lastEx = '-';
			}else if(line.charAt(i) == '-' && !findMinus) {
				findMinus = true;
				tempSum = 0;
				lastEx = '-';
				
			}else if(line.charAt(i) == '+' && findMinus) {
				lastEx = '+';
			}else if(line.charAt(i) == '+' && !findMinus) {
				lastEx = '+';
			} else {
				sb.append(line.charAt(i));
			}
		}
		
		if(lastEx == '-') {
			
		} else if(lastEx == '+') {
			
		}
		
	}

}
