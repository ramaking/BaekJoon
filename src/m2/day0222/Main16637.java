package m2.day0222;

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
			System.out.println(expre[startIdx]);
			return expre[startIdx]-'0';
		}
		for (int i = startIdx; i < endIdx; i++) {
			
			if (tempVisited[i]) {
				tempVisited[i] = false;

				for (int j = i; j < endIdx; j++) {
					if (tempVisited[j]) {
						tempVisited[j] = false;
						curVal = setExpre(i, j + 1);
						nexIdx = j + 1;
						break;
					}
				}
			} else {
				nexIdx = i;

				curVal = expre[i] - '0';

				System.out.println("val : " + expre[i]);
			}

			if (expre[i] == '+') {
				// 결과 + 현재
				result = curVal + setExpre(i+1, endIdx);
			} else if (expre[i] == '-') {
				result = curVal - setExpre(i+1, endIdx);
			} else if (expre[i] == '*') {
				result = curVal * setExpre(i+1, endIdx);
			}

			i = nexIdx;

		}
		System.out.println("result : "+result);
		return result;
	}

//	static int culc(int startIdx, int endIdx) {
//		System.out.println(Arrays.toString(tempVisited));
//		int result = expre[startIdx]-'0';
//		int currentValue = 0;
//		int nextI = 0;
//		
//		for(int i = startIdx; i < endIdx ; i++) {
//			
//			//괄호를 찾았을 때
//			if(tempVisited[i]) {
//				tempVisited[i] = false;
//				//짝이 되는 괄호를 찾는다.
//				for(int j = i+2; j < endIdx; j+=2) {
//					if(tempVisited[j]) {
//						tempVisited[j] = false;
//						currentValue = culc(i,j+1);
//						nextI = j;
//						break;
//					}
//				}
//				
//			} else {
//				currentValue = expre[i]-'0';
//				nextI = i;
//			}
//			if(i+1 < endIdx) {
//				if(expre[i+1] == '+') {
//					result += currentValue;
//				}else if(expre[i+1] == '-') {
//					result -= currentValue;
//				}else if(expre[i+1] == '*') {
//					result *= currentValue;
//				}
//			}
//			
//			
//			
//			i = nextI;
//		}
//		System.out.println(result);
//		return result;
//	}

}
