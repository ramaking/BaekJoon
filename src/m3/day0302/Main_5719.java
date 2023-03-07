package m3.day0302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_5719 {

	static int M, N;
	static int start, end;
	static int[][] adjMat;
	static boolean[] visited;
	
	static ArrayList<PriorityQueue<Edge>> distance;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while(true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			
			if(M == 0 && N == 0) {
				break;
			}
			
			distance = new ArrayList<>();
			
			for(int i = 0; i < N; i++) {
				distance.add(new PriorityQueue<>());
			}
			
			adjMat = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				Arrays.fill(adjMat[i], Integer.MAX_VALUE);
			}
			visited = new boolean[N];
			
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());

			int from, to, dis;
			for (int i = 0; i < M ; i++) {
				st = new StringTokenizer(br.readLine());
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
				dis = Integer.parseInt(st.nextToken());
				adjMat[from][to] = dis;
			}
			
//			print();
			
			mostShort(start);
			
			int index = end;
			Queue<Integer> tempQ = new ArrayDeque<>();
			tempQ.add(index);
			while(!tempQ.isEmpty()) {
				int idx = tempQ.poll();
				if(idx == start) {
					continue;
				}
				int size = distance.get(idx).size();
				for(int i = 0; i < size; i++) {
					Edge edge = distance.get(idx).poll();
//					System.out.println(edge.dis);
					tempQ.add(edge.from);
					adjMat[edge.from][idx] = Integer.MAX_VALUE;
				}
				
			}
			
//			print();
			visited = new boolean[N];
			sb.append(dijkstra(start)).append("\n");
		}
		
		System.out.println(sb.toString());
		

	}
	
	private static int dijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge (start, start, 0));
		
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
//			System.out.println(edge.from + " : " + edge.to);
			if(edge.to == end) {
				return edge.dis;
			}
			
			visited[edge.to] = true;
			
			for(int i = 0; i < N; i++) {
				int edgedis = adjMat[edge.to][i];
				if(!visited[i] && edgedis != Integer.MAX_VALUE) {
					pq.add(new Edge (edge.to, i, edgedis + edge.dis));
					
				}
			}
		}
		return -1;
		
	}

	private static void print() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(adjMat[i][j] + " ");
			}
			 System.out.println();
		}
	}

	private static void mostShort(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge (start, start, 0));
		
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			PriorityQueue<Edge> tempPq = distance.get(edge.to);
			if(tempPq.size() == 0) {
				tempPq.add(new Edge(edge.from, edge.to, edge.dis));
			} else {
				Edge postEdge = tempPq.poll();
				if(postEdge.dis > edge.dis) {
					while(!tempPq.isEmpty()) {
						tempPq.poll();
					}
					tempPq.add(edge);
				} else if(postEdge.dis == edge.dis) {
					tempPq.add(postEdge);
					tempPq.add(edge);
				} else {
					tempPq.add(postEdge);
					if(edge.to == end)
						break;
				}
			}
			
			visited[edge.to] = true;
			
			for(int i = 0; i < N; i++) {
				int edgedis = adjMat[edge.to][i];
				if(!visited[i] && edgedis != Integer.MAX_VALUE) {
					if(distance.get(i).size()== 0 
							|| distance.get(i).peek().dis > (edgedis + edge.dis)) {
						pq.add(new Edge (edge.to, i, edgedis + edge.dis));
					}
				}
			}
		}
	}

	static class Edge implements Comparable<Edge>{
		public Edge(int from, int to, int dis) {
			super();
			this.from = from;
			this.to = to;
			this.dis = dis;
		}
		int from, to, dis;
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.dis - o.dis;
		}
	}
}
