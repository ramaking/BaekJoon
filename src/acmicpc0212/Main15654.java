package acmicpc0212;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main15654 {

	static int n,m;
	static int[] arr;
	static boolean[] visited;
	static int[] result;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		
		sb = new StringBuilder();
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		arr = new int[n];
		visited = new boolean[n];
		result = new int[m];
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		permu(0);
		
		System.out.println(sb.toString());
		
		sc.close();
		
	}
	
	static void permu(int cnt) {
		
		if(cnt == m) {
			for(int i = 0; i < result.length; i++) {
				sb.append(result[i]+ " ");
//				System.out.print(result[i]+ " ");
			}
			sb.append("\n");
//			System.out.println();
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(visited[i]) {
				continue;
			}
			visited[i] = true;
			result[cnt] = arr[i];
			permu(cnt+1);
			visited[i] = false;
		}
	}

}
