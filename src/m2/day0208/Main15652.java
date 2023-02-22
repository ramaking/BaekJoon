package m2.day0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15652 {

	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static int[] numbers;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		
		m = Integer.parseInt(st.nextToken());
		
		numbers = new int[m];

		combRepe(0, 1);

		System.out.println(sb.toString());
	}
	
	static void combRepe(int cnt, int start) {
		
		if(cnt == m) {
			for(int i = 0; i < m; i ++) {
				sb.append(numbers[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = start; i <= n; i++) {
			numbers[cnt] = i;
			combRepe(cnt+1,i);
			
		}
	}

}
