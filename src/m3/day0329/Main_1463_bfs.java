package m3.day0329;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main_1463_bfs {

	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		
		System.out.println(ans);
	}
	
	static int bfs(int num) {
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[num+1];
		queue.add(num);
		visited[num] = true;
		
		int cnt = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				int now = queue.poll();
				if(now == 1) {
					return cnt;
				}
				if(!visited[now]) {
					if(now%3 == 0) {
						queue.add(now/3);
						visited[now/3] = true;
					}
					if(now%2 == 0) {
						queue.add(now/2);
						visited[now/2] = true;
					}
					
					queue.add(now-1);
					visited[now-1] = true;
				}
				
			}
			cnt ++;
		}
		
		return cnt;
	}

}
