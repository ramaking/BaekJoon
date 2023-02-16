package acmicpc0212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1167 {
	
	static ArrayList<ArrayList<Edge>> list = new ArrayList<>();
	static int n;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i = 0; i <= n; i++) {
			list.add(new ArrayList<Edge>());
		}
		visited = new boolean[n];
		
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int temp = Integer.parseInt(st.nextToken());
			while(true) {
				int to = Integer.parseInt(st.nextToken());
				if(to == -1) {
					break;
				}
				int dis = Integer.parseInt(st.nextToken());
				list.get(temp).add(new Edge(to, dis));
				
			}
		}
		
		System.out.println(dfs(1, 0));
		
	}
	
	static int dfs(int index, int sum) {
		visited[index] = true;
//		int temp = sum;
		int[] arr = new int[list.get(index).size()];
		
		for(int i = 0; i < list.get(index).size(); i++){
			int to = list.get(index).get(i).to;
			int dis = list.get(index).get(i).dis;
			if(!visited[index])
				arr[i] = dfs(to ,sum + dis);
		}
		
//		Arrays.sort(arr);
		//가장 큰 값 반환
		
		return sum;
		
	}
	
	static class Edge{
		int to;
		int dis;
		public Edge(int to, int dis) {
			this.to = to;
			this.dis = dis;
		}
	}

}
