package m3.day0302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_5719_2 {

	static int M, N;
	static int start, end;
	static int[][] adjMat;
	static boolean[][] isShortest;
	static boolean[] visited;

	static int[] distance;
	static ArrayList<HashSet<Integer>> path;
	static ArrayList<HashMap<Integer, Integer>> adjMap;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while (true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			if (M == 0 && N == 0) {
				break;
			}

			isShortest = new boolean[N][N];
			distance = new int[N];
			Arrays.fill(distance, Integer.MAX_VALUE);

			path = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				path.add(new HashSet<>());
			}

			adjMat = new int[N][N];

			for (int i = 0; i < N; i++) {
				Arrays.fill(adjMat[i], Integer.MAX_VALUE);
			}
			visited = new boolean[N];

			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());

			int from, to, dis;
			for (int i = 0; i < M; i++) {
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
			visited = new boolean[N];
			tempQ.add(index);
			while (!tempQ.isEmpty()) {
				int idx = tempQ.poll();

				if (idx == start || visited[idx]) {
					continue;
				}
				visited[idx] = true;
//				System.out.println("idx : "+idx);
				int size = path.get(idx).size();
				Integer[] tempArr = path.get(idx).toArray(new Integer[size]);
				for (int i = 0; i < size; i++) {
//					System.out.println(tempArr[i]);
					if (!visited[tempArr[i]]) {
						tempQ.add(tempArr[i]);
						adjMat[tempArr[i]][idx] = Integer.MAX_VALUE;
					}
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
		pq.add(new Edge(start, start, 0));

		while (!pq.isEmpty()) {
			Edge edge = pq.poll();
//			System.out.println(edge.from + " : " + edge.to);
			if (edge.to == end) {
				return edge.dis;
			}

			if (visited[edge.to]) {
				continue;
			}

			visited[edge.to] = true;

			for (int i = 0; i < N; i++) {
				int edgedis = adjMat[edge.to][i];
				if (!visited[i] && edgedis != Integer.MAX_VALUE) {
					pq.add(new Edge(edge.to, i, edgedis + edge.dis));

				}
			}
		}
		return -1;

	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(adjMat[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void mostShort(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(start, start, 0));

		while (!pq.isEmpty()) {
			Edge edge = pq.poll();
			HashSet<Integer> tempSet = path.get(edge.to);
			if (distance[edge.to] > edge.dis) {
				distance[edge.to] = edge.dis;
				tempSet.clear();
				tempSet.add(edge.from);
			} else if (distance[edge.to] == edge.dis) {
				tempSet.add(edge.from);
			} else {
				continue;
			}

//			visited[edge.to] = true;

			for (int i = 0; i < N; i++) {
				int edgedis = adjMat[edge.to][i];
				if (edgedis != Integer.MAX_VALUE) {
					if (distance[i] >= (edgedis + edge.dis)) {
						pq.add(new Edge(edge.to, i, edgedis + edge.dis));
					}
				}
			}
		}
	}

	static class Edge implements Comparable<Edge> {
		public Edge(int from, int to, int dis) {
			super();
			this.from = from;
			this.to = to;
			this.dis = dis;
		}

		int from, to, dis;

		@Override
		public int compareTo(Edge o) {
			return this.dis - o.dis;

		}
	}
}
