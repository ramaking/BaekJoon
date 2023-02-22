package m1.day__;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10818 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int N = Integer.parseInt(line);
		
		int max = -1000001;
		int min = 1000001;
		
		line = br.readLine();
		StringTokenizer st = new StringTokenizer(line);
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num > max) {
				max = num;
			}
			if(num < min) {
				min = num;
			}
		}
		
		System.out.print(min + " " + max);
		

	}

}
