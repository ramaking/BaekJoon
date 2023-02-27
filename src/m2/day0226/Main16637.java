package m2.day0226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main16637 {

	static int n;

	static boolean visited[];
	static boolean tempVisited[];
	static char[] expre;
	static int max = Integer.MIN_VALUE;
	static Queue<String> queue = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		visited = new boolean[n];

		expre = br.readLine().toCharArray();

		subSet(0, 0);

		System.out.println(max);
	}

	static void subSet(int cnt, int isOdd) {
		// 짝수개의 괄호만 연산 진행
		if (cnt == n + 1) {
			if (isOdd % 2 == 0) {
				System.out.println(Arrays.toString(visited));
				tempVisited = visited.clone();
////				setExpre(0, n);
				max = Math.max(max, setExpre(0, n));
			}

			return;
		}

		visited[cnt] = true;
		subSet(cnt + 2, isOdd + 1);

		visited[cnt] = false;
		subSet(cnt + 2, isOdd);

	}

	private static int setExpre(int startIdx, int endIdx) {
//		System.out.println(Arrays.toString(tempVisited));
//		System.out.println(startIdx + " : " + endIdx);
		int result = 0;
		int curVal = 0;
		int nexIdx = 0;
		if(endIdx - startIdx == 1) {
			return expre[startIdx]-'0';
		}
		for (int i = startIdx; i < endIdx; i++) {
			
//			if (tempVisited[i]) {
//				tempVisited[i] = false;
//
//				for (int j = i; j < endIdx; j++) {
//					if (tempVisited[j]) {
//						tempVisited[j] = false;
//						curVal = setExpre(i, j + 1);
//						System.out.println("cur3 : "+curVal);
//						nexIdx = j + 1;
//						break;
//					}
//				}
//			} else {
				nexIdx = i;

				if(expre[i] == '+' || expre[i] == '-' || expre[i] == '*') {
					
				} else {
					curVal = expre[i] - '0';
					System.out.println("cur1 : "+curVal);
				}
				

				
//			}

			if (expre[i] == '+') {
				// 결과 + 현재
				result = curVal + setExpre(i+1, endIdx);
				System.out.println("cur2 : "+curVal);
				System.out.println("res : "+result);
			} else if (expre[i] == '-') {
				result = curVal - setExpre(i+1, endIdx);
			} else if (expre[i] == '*') {
				result = curVal * setExpre(i+1, endIdx);
			}
			curVal = result;

			i = nexIdx;

		}
		System.out.println("result : "+result);
		return result;
	}

}
