package m2.day0206;

import java.util.ArrayList;
import java.util.Scanner;

public class Main1504_recu {

	static int N;
	static int E;
	static ArrayList<ArrayList<Node>> al;

	static ArrayList<Node>[] arr;

	static int minDistance = Integer.MAX_VALUE;
	static boolean[] visit;

	static int necessary1;
	static int necessary2;

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		N = scan.nextInt();
		E = scan.nextInt();
		arr = new ArrayList[N + 1];

		// arr 초기화
		// 점 편하게 가져오려고 1부터 한다.
		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<Node>();
		}

		// 점 받아와서 노드로 만들고 저장하자
		for (int i = 0; i < E; i++) {
			int s = scan.nextInt();
			int e = scan.nextInt();
			int d = scan.nextInt();

			arr[s].add(new Node(e, d));
		}

		necessary1 = scan.nextInt();
		necessary2 = scan.nextInt();

		visit = new boolean[N + 1];

		distanceCal(1, 0, 0);

		if (minDistance == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(minDistance);

	}

	private static void distanceCal(int start, int distance, int cnt) {
		if(cnt == N) {
			if(start != N) {
				return;
			}
		}
		
		if (start == N) {
			if (visit[necessary1] == true && visit[necessary2] == true)
				if (distance < minDistance)
					minDistance = distance;
			return;
		}

		visit[start] = true;
		for (Node node : arr[start]) {

			int tmpIdx = node.getIndex();
			int tmpDis = node.getDistance();
//			if(!visit[tmpIdx])
				distanceCal(tmpIdx, distance + tmpDis, cnt + 1);
		}
		visit[start] = false;
	}
}

class Node {
	private int index;
	private int distance;

	Node(int index, int distance) {
		this.index = index;
		this.distance = distance;
	}

	public int getIndex() {
		return index;
	}

	public int getDistance() {
		return distance;
	}

	@Override
	public String toString() {
		return index + ", " + distance;
	}
}