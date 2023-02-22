package m2.day0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15719 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		boolean[] arr = new boolean[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int result = 0;
		for(int i = 0; i < n; i++) {
			int index = Integer.parseInt(st.nextToken());
			if(arr[index] == true) {
				result = index;
				break;
			}
			arr[index] = true;
		}
		
		System.out.println(result);

	}

}


