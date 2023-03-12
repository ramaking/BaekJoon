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
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < line.length(); i++) {
			if(line.charAt(i) == '-' && findMinus) {
				sum -= Integer.parseInt(sb.toString());
				sb.delete(0, sb.length());
				
			} else if(line.charAt(i) == '-' && !findMinus) {
				sum += Integer.parseInt(sb.toString());
				sb.delete(0, sb.length());
				findMinus = true;
			} else if(line.charAt(i) == '+' && findMinus) {
				sum -= Integer.parseInt(sb.toString());
				sb.delete(0, sb.length());
			} else if(line.charAt(i) == '+' && !findMinus) {
				sum += Integer.parseInt(sb.toString());
				sb.delete(0, sb.length());
			} else {
				sb.append(line.charAt(i));
			}
		}
		
		if(findMinus) {
			sum -= Integer.parseInt(sb.toString());
		} else {
			sum += Integer.parseInt(sb.toString());
		}
		
		System.out.println(sum);
	}

}
