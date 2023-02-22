package m2.day0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2961 {
	static int n;
	static int[] s;
	static int[] b;
	static boolean[] visited;
	static long sum = Long.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		

		n = Integer.parseInt(br.readLine());
		
		s = new int[n];
		b = new int[n];
		visited = new boolean[n];
		
		StringTokenizer st;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			s[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
		}
		
		recu(0);
		
		System.out.println(sum);



	}
	
	static void recu(int cnt) {
		if(cnt == n) {
			long sNum = 1;
			long bNum = 0;
			boolean change = false;
			for(int i = 0; i <n; i++) {
				if(visited[i]) {
					sNum *= s[i];
					bNum += b[i];
					change = true;
				}
			}
			
			if(!change) {
				return;
			}
			
			sum = Math.min(sum, Math.abs(sNum-bNum));
			return;
		}
		
		visited[cnt] = true;
		recu(cnt+1);
		visited[cnt] = false;
		recu(cnt+1);
		
	}

}
