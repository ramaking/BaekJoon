package acmicpc0212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main26260 {
	
	static int[] arr;
	static boolean[] visited;
	static int n;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> list = new ArrayList<>();

		Collections.sort(list);
		
		arr = new int[n+1];
		visited = new boolean[n+1];
		visited[0] = true;
//		visited[n+1] = true;
		
		st = new StringTokenizer(br.readLine());
		int minIndex = 0;
		for(int i = 1; i <= n; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
			if(num == -1) {
				minIndex = i;
			}
		}
		
		int newNum = Integer.parseInt(br.readLine());
		arr[minIndex] = newNum;
		
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		postOrder(1, (n+1)/2, n);

	}
	
	static void postOrder(int start, int middle, int end) {
		if(start >= end) {
			return;
		}
//		if(visited[middle]) {
//			return;
//		}
//		visited[middle] = true;
//		if(middle - (middle+start)/2 >= 1)
			postOrder(start, (middle+start)/2, middle-1);
//		if(middle + (end - middle)/2 <= n)
			postOrder(middle+1, (end + middle)/2, end);
		System.out.print(arr[middle] + " ");
	}

}
