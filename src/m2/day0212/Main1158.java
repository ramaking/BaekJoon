package m2.day0212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main1158 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Stack<Integer[]> stack = new Stack<Integer[]>();
		
		stack.add(new Integer[] {Integer.parseInt(st.nextToken()), 1});
		
		int[] arr = new int[n+1];
		
		arr[1] = 0;
		
		for(int i = 2;i <= n; i++) {
			int current = Integer.parseInt(st.nextToken());
			while(true) {
				if(stack.isEmpty()) {
					arr[i] = 0;
					stack.add(new Integer[] {current, i});
					break;
				}
				Integer[] top = stack.pop();
				if(top[0] > current) {
					stack.add(top);
					stack.add(new Integer[] {current, i});
					arr[i] = top[1];
					break;
				}
			}
//			System.out.println(Arrays.toString(arr));
		}
		
		for(int i = 1; i <= n; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
