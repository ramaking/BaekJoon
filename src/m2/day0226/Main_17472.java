package m2.day0226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17472 {
	static int n, m;
	static int[][] map; // 전체 맵
	static boolean[][] visited; // 섬마다 번호를 매기기 위한 방문 배열
	static int[] di = { 1, 0, -1, 0 };
	static int[] dj = { 0, 1, 0, -1 };
	static ArrayList<Edge>[] list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 섬 발견 시 index 번째 섬으로 색칠
		int index = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j] && map[i][j] == 1) {

					// bfs로 인접 땅 칠하기
					bfs(i, j, index);
					index++;
				}
			}
		}

		list = new ArrayList[index];
		for (int i = 0; i < index; i++) {
			list[i] = new ArrayList<Edge>();
		}

//		print();

		// 섬마다 다리 설치(간선 생성)
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// 0이 아닌 곳(땅)이 라면 다리 생성 시도
				if (!(map[i][j] == 0)) {
					makeBridge(i, j, map[i][j]);
				}
			}
		}

//		//간선 정보 디버깅
//		for(int i = 1; i < index; i++) {
//			System.out.print(i + " : " );
//			for(int j = 0; j  < list[i].size(); j++) {
//				System.out.print(list[i].get(j).to + " ");
//			}
//			System.out.println();
//		}
//		System.out.println("----------------------------");

		// MST 로 섬간의 최소 거리로 연결
		System.out.println(prime(1));
	}

	private static int prime(int x) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean[] visit = new boolean[list.length];
		int result = 0;
		int cnt = 0;

		// 임의로 x번째 섬을 첫번째 방문 섬으로 선정
		pq.add(new Edge(x, 0));
		while (!pq.isEmpty() && cnt < list.length - 1) {
			Edge edge = pq.poll();
//			System.out.println(edge.to + " : " + edge.weigth);
			if (visit[edge.to])
				continue; // 방문 섬이면 넘어감
			visit[edge.to] = true;
			result += edge.weigth;
			cnt++;
			for (Edge temp : list[edge.to]) { // 해당 섬에 연결된 섬을 찾음
				if (!visit[temp.to]) { // 방문 한 적이 없으면 pq 에 삽입
					pq.add(new Edge(temp.to, temp.weigth));
				}
			}

		}
//		System.out.println(Arrays.toString(visit));
		// 모든 섬을 방문했는지 확인
		for (int i = 1; i < visit.length; i++) {
			if (!visit[i]) { // 하나라도 방문하지 않은 섬이 있다면 -1 return
				return -1;
			}
		}
		return result;
	}

	// 다리 만들기 (간선 생성하기)
	private static void makeBridge(int i, int j, int index) {
		// 4방향에 바다가 있다면 다리를 설치해봄
		for (int d = 0; d < 4; d++) { // 인접 구역들을 검증
			int ni, nj, ci, cj;
			ci = i;
			cj = j;
			int range = 0;
			// 한 방향으로 쭉 밀기
			while (true) {
				ni = ci + di[d];
				nj = cj + dj[d];
				// 범위 체크
				if (ni < 0 || ni >= n || nj < 0 || nj >= m) {
					break;
				}
				ci = ni;
				cj = nj;
				// 자기 땅으로는 만들 필요 없음
				if (map[ni][nj] == index) {
					break;
				}
				// 다른 섬 도착
				if (map[ni][nj] != 0) {
					// 다리의 길이가 1이하이면 탈락
					if (range < 2) {
						break;
					}
					// 다리 생성 성공
					list[index].add(new Edge(map[ni][nj], range));
//						System.out.println("start : " + i + " : " + j);
//						System.out.println("make bri : " + index + " to " + map[ni][nj] + " : range " + (range));
//						System.out.println("end : " + ni + " : " + nj);
					break;
				}
				// 다리 길이 증가
				range++;
			}
		}

	}

	private static void print() {
		// TODO Auto-generated method stub
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("---------------------------");
	}

	private static void bfs(int i, int j, int index) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { i, j }); // 구역의 첫번째 값에서 시작
		visited[i][j] = true;
		map[i][j] = index;
		int ci, cj, ni, nj;
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			ci = now[0];
			cj = now[1];
			for (int d = 0; d < 4; d++) { // 인접 구역들을 검증
				ni = ci + di[d];
				nj = cj + dj[d];
				if (ni >= 0 && ni < n && nj >= 0 && nj < m && !visited[ni][nj] && map[ni][nj] == 1) {
					map[ni][nj] = index;
					visited[ni][nj] = true;
					queue.add(new int[] { ni, nj });
				}
			}
		}

	}

	static class Edge implements Comparable<Edge> {
		public Edge(int to, int weigth) {
			super();
			this.to = to;
			this.weigth = weigth;
		}
		int to, weigth;

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.weigth - o.weigth;
		}

	}

}
