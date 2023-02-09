package acmicpc0206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main1916_1 {
	
	static int n , m, start, end;
	static int[][] arr;
	static int[] distance;
	static final int intMax = 100000001;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n+1][n+1];
		
		distance = new int[n+1];
		Arrays.fill(distance, intMax);
		
		for(int i = 1; i <= n; i++) {
			Arrays.fill(arr[i], intMax);
		}

		for(int i = 1; i <= n; i++) {
			arr[i][i] = 0;
		}

		m = Integer.parseInt(br.readLine());
		
		for(int i = 0 ;i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			arr[a][b] = c;
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		dijkstra(start);
		
		System.out.println(distance[end]);
		
	}
	
	static void dijkstra(int start) {
		distance[start] = 0;
		
		PriorityQueue<Integer[]> queue = new PriorityQueue<>((int)Math.pow(n, 2),(a,b)-> {
			return a[1]- b[1];
		});
		queue.add(new Integer[] {start , 0});
		
		while(true) {
			if(queue.isEmpty()) {
				break;
			}
			Integer[] node = queue.poll();
			int index = node[0];
			int dis = node[1];
			
			//꺼낸 값이 의미 없으면 넘김
			if(distance[index] < dis) {
				continue;
			}
			
			for(int i = 1; i <= n; i++) {
				if(arr[index][i] != intMax) {
//				System.out.println(index + " " + i);
					int cost = distance[index] + arr[index][i];
					if(distance[i] > cost) {
						distance[i] = cost;
						queue.add(new Integer[] {i, cost});
//						System.out.println(i+" : "+cost);
					}
				}
				 
			}
//			System.out.println(Arrays.toString(distance));
			
		}
		
		
		
	}
	
	
}


