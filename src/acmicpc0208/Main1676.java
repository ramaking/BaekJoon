package acmicpc0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main1676 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int temp = n;
		int sum = 0;
		while(temp >= 5) {
			sum += temp/5;
			temp /= 5;
		}
		
		System.out.println(sum);

		
	}

}


