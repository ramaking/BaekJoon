package m2.day0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main6603 {
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			int k = Integer.parseInt(st.nextToken());
			
			//탈출 조건
			if(k == 0) {
				break;
			}
			
			int[] arr = new int [k];
			boolean[] visited = new boolean[k];
			for(int i = 0; i < k; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			//조합
			comb(0,0,arr, visited, k);
			sb.append("\n");
		}
		


		System.out.println(sb.toString());
	}
	
	static void comb(int cnt, int idx,int[] arr ,  boolean[] visited, int k) {
		
		//출력 조건
		if(cnt == 6) {
			for(int i = 0; i < k; i++) {
				if(visited[i]) {
					sb.append(arr[i] + " ");
				}
			}
			sb.append("\n");
			return;
		}
		
		//6개 미만
		if(idx == k) {
			return;
		}
		
		visited[idx] = true;
		comb(cnt+1, idx+1,arr , visited, k);
		visited[idx] = false;
		comb(cnt, idx+1,arr, visited, k);
		
	}

}


