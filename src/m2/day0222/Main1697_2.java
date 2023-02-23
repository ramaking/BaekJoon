package m2.day0222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1697_2 {

	static int n,k;
	static boolean[] visited = new boolean[100001];
	static int[] arr = new int[100001];
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		bfs(n);
	}
	
	private static void bfs(int n2) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(n2);
		visited[n2] = true;
		arr[n2] = 0;
		int current;
		int nIdx = -1;
		int cnt = 0;
		while(!queue.isEmpty()) {
			
			int size = queue.size();
			
			for(int i = 0; i < size; i++) {
				current = queue.poll();
				
				if(current == k) {
					System.out.println(cnt);
					break;
				}
				
				if(current -1 >= 0 && !visited[current-1]) {
					nIdx = current-1;
					queue.add(nIdx);
					visited[nIdx] = true;
				}
				if(current +1 < 100001 && !visited[current+1]) {
					nIdx = current+1;
					queue.add(nIdx);
					visited[nIdx] = true;
				}
				if(current*2 < 100001 && !visited[current*2]) {
					nIdx = current*2;
					queue.add(nIdx);
					visited[nIdx] = true;
				}
				
//				if(nIdx == k) {
//					System.out.println(cnt+1);
//					return;
//				}
				
			}
			
			cnt++;
			
			
			
		}
	}
	

}
