package acmicpc0212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main14888 {

	static int n, m, r, rota;
	static int[] arr;
	static int[] cul;
	static Set<String> set;
	static StringBuilder sb;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static char[] charArr;
	static boolean[] visited;
	static char[] tempArr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		arr = new int [n];
		
		visited = new boolean[n-1];
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		cul = new int[4];
		
		sb = new StringBuilder();
		
		for(int i = 0; i < 4; i++) {
			cul[i] = Integer.parseInt(st.nextToken());
			for(int j =0 ; j < cul[i]; j++) {
				sb.append(i);
			}
		}
		
		charArr = sb.toString().toCharArray();
		
//		System.out.println(sb.toString());
//		System.out.println(Arrays.toString(charArr));
		
		tempArr = new char[n-1];
		
//		set = new HashSet<>();
//		
		permu(0);
		

		System.out.println(max);
		System.out.println(min);
		

	}
	
	static void permu(int cnt) {
		
		if(cnt == n-1) {
			int sum = arr[0];
//			String temp = sb.toString();
			for(int i = 0; i < n-1; i++) {
				if(tempArr[i] == '0') {
					sum = sum + arr[i+1];
				} else if(tempArr[i] == '1') {
					sum = sum - arr[i+1];
				} else if(tempArr[i] == '2') {
					sum = sum * arr[i+1];
				} else if(tempArr[i] == '3') {
					sum = sum / arr[i+1];
				}
			}
			
			if(min > sum) {
				min = sum;
			}
			if(max < sum) {
				max = sum;
			}
			
			
			//sb 초기화
//			sb = new StringBuilder();
			return;
		}
		
		
		
		for(int i = 0; i < n-1; i++) {
			
			if(visited[i] == true) {
				continue;
			}
				
			tempArr[cnt] = charArr[i];
			visited[i] = true;
			permu(cnt+1);
			visited[i] = false;
		}
		
	}

	
	
	
	
	
	
	
	

}
