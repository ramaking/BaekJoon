package acmicpc0126_;

import java.util.Arrays;
import java.util.Scanner;

public class Main10974 {

	static int n, r;
	static boolean[] visited;
	static int[] arr;
	static int[] out;

	public static void combination(int depth) {

		// depth의 값과 r이 같은 경우,
		// out을 반복문을 돌리면서 해당 요소를 num으로 받아서 출력 후 return으로 종료
		if (depth == r) {
			for(int i = 0; i < n; i++) {
				if(visited[i]) {
					System.out.print(arr[i] + " ");
				}
			}

			System.out.println();
			return;
		}

		// arr의 길이 만큼 반복문을 수행
		// 순서를 고려하기위해 0부터 탐색 ex){1, 2} {2, 1}
		for (int i = 0; i < arr.length; i++) {
			if (!visited[i]) { // visited의 i번째가 false라면
				visited[i] = true; // 해당 i번째의 값을 true로 바꾸고
				combination(depth + 1);
				visited[i] = false;
			}
		}
		return;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		r = sc.nextInt();
		

		arr = new int[n];
		for(int i = 1; i <= n; i++) {
			arr[i-1] = i;
		}
//		System.out.println(Arrays.toString(arr));

		out = new int[n];
		visited = new boolean[n];

		combination(0);
		
		sc.close();
	}
}
