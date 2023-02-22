package m2.day0212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main15686 {

	static int n, m;
	static int[][] arr;
	static int[][] temp;
	static int[] dirI = { 1, 0, -1, 0 };
	static int[] dirJ = { 0, 1, 0, -1 };
	static Queue<int[]> queue = new LinkedList<>();
	static ArrayList<int[]> chicArr;
//	static boolean[] chicVisited;
	static ArrayList<int[]> houseArr;
	static int[][] tempChic;
	static int min = Integer.MAX_VALUE;
	static int[][] chicCost;
	static boolean[] chicVisited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n + 1][n + 1];
		temp = new int[n + 1][n + 1];
		tempChic = new int[m][2];

		chicArr = new ArrayList<>();
		houseArr = new ArrayList<>();

		int chicIdx = 0;
		int houseIdx = 0;

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				int num = Integer.parseInt(st.nextToken());

				// 치킨집일 경우
				if (num == 2) {
					chicArr.add(new int[] { i, j });
					arr[i][j] = 0;
				} else if (num == 1) {
					houseArr.add(new int[] { i, j });
					arr[i][j] = num;
				}

			}
		} // end input
		
		chicCost = new int[chicArr.size()][houseArr.size()];
		
		

		for (int i = 0; i < chicArr.size(); i++) {
			for (int j = 0; j < houseArr.size(); j++) {
				chicCost[i][j] = Math.abs(chicArr.get(i)[0] - houseArr.get(j)[0])
						+ Math.abs(chicArr.get(i)[1] - houseArr.get(j)[1]);
			}
		}
		chicVisited = new boolean[chicArr.size()];
		combChic(0, 0);

		System.out.println(min);

	}

	static void combChic(int cnt, int index) {
		if (cnt == m) {
			int sum = 0;
			
			for(int i = 0; i < houseArr.size(); i++) {
				int subMin = Integer.MAX_VALUE;
				for(int j = 0; j < chicArr.size(); j++) {
					
					if(chicVisited[j]) {
						if(subMin > chicCost[j][i]) {
							subMin = chicCost[j][i];
						}
					}
				}
				sum += subMin;
			}
			
			if(min > sum) {
				min = sum;
			}

//			for (int i = 0; i <= n; i++) {
//				temp[i] = arr[i].clone();
//			}
//			// temp 배열에 치킨집 채우기
//			for (int i = 0; i < tempChic.length; i++) {
//				
//				int tempI = tempChic[i][0];
//				int tempJ = tempChic[i][1];
//				temp[tempI][tempJ] = 2;
//			}

			// bfs sum 구하기
//			bfs();
			return;
		}

		for (int i = index; i < chicArr.size(); i++) {
			chicVisited[index] = true;
//			tempChic[cnt][0] = chicArr.get(i)[0];
//			tempChic[cnt][1] = chicArr.get(i)[1];
			combChic(cnt + 1, i + 1);
			chicVisited[index] = false;
			combChic(cnt, i + 1);
		}

	}

	
	static void bfs() {
		int sum = 0;
		for (int i = 0; i < houseArr.size(); i++) {
			if (sum > min) {
				break;
			}
			int[][] tempBfs = new int[n + 1][n + 1];
			for (int j = 0; j <= n; j++) {
				tempBfs[j] = temp[j].clone();
			}

			queue.clear();
			int houseI = houseArr.get(i)[0];
			int houseJ = houseArr.get(i)[1];
			queue.add(new int[] { houseI, houseJ });
			boolean flag = false;
			while (!queue.isEmpty()) {
				if (flag) {
					break;
				}
				int[] temp11 = queue.poll();
				int cI = temp11[0];
				int cJ = temp11[1];

				for (int j = 0; j < 4; j++) {
					int nI = cI + dirI[j];
					int nJ = cJ + dirJ[j];
					if (nI >= 1 && nI <= n && nJ >= 1 && nJ <= n) {
						if (tempBfs[nI][nJ] == 0 || tempBfs[nI][nJ] == 1) {
							queue.add(new int[] { nI, nJ });
							tempBfs[nI][nJ] = 3;
						} else if (tempBfs[nI][nJ] == 2) {
							// 치킨 거리 증가
							sum += Math.abs(houseI - nI) + Math.abs(houseJ - nJ);

							flag = true;
							break;
						}
					}
				}

			}

		}

		if (min > sum) {
			min = sum;
		}
	}

	static void print(int[][] arr) {
		for (int i = 0; i <= n; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println("-------------------------");
	}

}
