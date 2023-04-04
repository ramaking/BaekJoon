package m4.day0404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.xml.transform.Source;

public class Main_2458 {

	static int n, m;
	static int[][] list;

	public static void main(String[] args) throws NumberFormatException, IOException, CloneNotSupportedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		list = new int[n+1][n+1];

		int from, to;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			list[from][to] = 1;
			
		}
		
		for(int i = 1; i <= n; i++) {
			list[i][i] = 100;
		}
		

		for(int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if(list[i][k] > 0 && list[k][j] > 0) {	//갈 수 있는 경로의 경우 어디서 왔는지 표기 어디로 갈건지 표기
						list[k][i] = -1;
						list[j][k] = -1;
						list[i][j] = 1;
						list[j][i] = -1;
					}
				}
			}
		}
		
		
		int cnt = 0;
		boolean isVal = false;
		for(int i = 1; i <= n; i++) {
			isVal = false;
			for(int j = 1; j <= n; j++) {
				if(list[i][j] == 0) {
					break;
				}
				if(j == n) {
					isVal = true;
				}
			}
			if(isVal) cnt++;
		}
		
		System.out.println(cnt);

	}
	
	
	
	
}
