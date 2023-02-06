package acmicpc0206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1916 {
	
	static int n , m, start, end;
	static ArrayList<ArrayList<Node>> list;
	static int[] distance;
	static final int intMax = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		list = new ArrayList<>();
		
		for(int i = 0; i <= n; i++) {
			list.add(new ArrayList<Node>());
		}
		
		distance = new int[n+1];
		
		Arrays.fill(distance, intMax);

		m = Integer.parseInt(br.readLine());
		
		for(int i = 0 ;i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list.get(a).get(b).setDistance(c);
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		dijstra(start);
		
		
		
	}
	
	static void dijstra(int start) {
		distance[start] = 0;
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.add(new Node(start, 0));
		
		while(true) {
			if(queue.isEmpty()) {
				break;
			}
			Node node = queue.poll();
			int index = node.getIndex();
			int dis = node.getDistance();
			for(int i = 0; i < list.get(index).size(); i++) {
				int cost = distance[index] + list.get(index).get(i).getDistance();
			}
		}
		
		
		
	}
	
	static class Node implements Comparable<Node>{
		public Node(int index, int distance) {
			super();
			this.index = index;
			this.distance = distance;
		}
		public int getIndex() {
			return index;
		}
		public void setIndex(int index) {
			this.index = index;
		}
		public int getDistance() {
			return distance;
		}
		public void setDistance(int distance) {
			this.distance = distance;
		}
		private int index;
		private int distance;
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return 0;
		}
		
		
	}
	
}


