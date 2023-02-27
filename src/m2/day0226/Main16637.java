package m2.day0226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main16637 {

	static int n;

	static boolean visited[];
	static boolean tempVisited[];
	static char[] expre;
	static int max = Integer.MIN_VALUE;
	static Stack<Integer> stack = new Stack<>();
	static ArrayDeque<Integer> deq = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		visited = new boolean[n];

		expre = br.readLine().toCharArray();

		subSet(1);

		System.out.println(max);
	}

	static void subSet(int cnt) {
		if (cnt == n) {

//			System.out.println(Arrays.toString(visited));
			tempVisited = visited.clone();
			max = Math.max(max, setExpre(0, n));
			
			return;
		}

		if (cnt - 2 >= 0) {
			if (!visited[cnt - 2]) {
				visited[cnt] = true;
				subSet(cnt + 2);
				visited[cnt] = false;
				subSet(cnt + 2);
			} else {
				visited[cnt] = false;
				subSet(cnt + 2);
			}
		} else {
			visited[cnt] = true;
			subSet(cnt + 2);
			visited[cnt] = false;
			subSet(cnt + 2);
		}

	}


	private static int setExpre(int startIdx, int endIdx) {
//		System.out.println(Arrays.toString(expre));
		for (int i = startIdx; i < endIdx; i++) {

			if (tempVisited[i]) {
				int num1 = deq.pollLast();
				
				int num2 = expre[i+1]-'0';
				if (expre[i] == '+') {
					deq.add(num1+num2);
				} else if (expre[i] == '-') {
					deq.add(num1-num2);
				} else if (expre[i] == '*') {
					deq.add(num1*num2);
				}
				i = i+1;
				
			} else {

				if (expre[i] == '+') {
					deq.add(-1);
				} else if (expre[i] == '-') {
					deq.add(-2);
				} else if (expre[i] == '*') {
					deq.add(-3);
				} else {
					deq.add(expre[i] - '0');
				}
			}

		}

		int result = stackCulc();

		return result;
	}
	
	private static int stackCulc() {
		if (deq.isEmpty()) {
			return 0;
		}
		int result = deq.poll();
		while (!deq.isEmpty()) {
			int temp = deq.poll();

			if (temp == -1) {
				result += deq.poll();
			} else if (temp == -2) {
				result -= deq.poll();
			} else if (temp == -3) {
				result *= deq.poll();
			}
		}
		return result;
	}

}
