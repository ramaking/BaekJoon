package m2.day0222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1697 {

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
		int current = 0;
		while(!queue.isEmpty()) {
			current = queue.poll();
			if(current == k) {
				System.out.println(arr[current]);
				break;
			}
			
			if(current -1 >= 0 && !visited[current-1]) {
				if(current-1 == k) {
					System.out.println(arr[current]+1);
					break;
				}
				queue.offer(current-1);
				visited[current-1] = true;
				arr[current-1] = arr[current]+1;
			}
			if(current +1 < 100001 && !visited[current+1]) {
				if(current+1 == k) {
					System.out.println(arr[current]+1);
					break;
				}
				queue.offer(current+1);
				visited[current+1] = true;
				arr[current+1] = arr[current]+1;
			}
			if(current*2 < 100001 && !visited[current*2]) {
				if(current*2 == k) {
					System.out.println(arr[current]+1);
					break;
				}
				queue.offer(current*2);
				visited[current*2] = true;
				arr[current*2] = arr[current]+1;
			}
			
			
		}
	}
	

}
