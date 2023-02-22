package m2.day0222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1992 {
	static int n;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		String line;
		for (int i = 0; i < n; i++) {
			line = br.readLine();
			for (int j = 0; j < n; j++) {
				arr[i][j] = line.charAt(j) - '0';
			}
		}
		
//		if(!check(0,0,arr[0][0], n))
			print(0,0,n);
	}
	
	static void print(int iD, int jD, int n) {
		if(check(iD, jD, arr[iD][jD], n)) {
			System.out.print(arr[iD][jD]);
		} else {
			System.out.print("(");
			print(iD, jD, n/2);
			print(iD, jD+n/2, n/2);
			print(iD+n/2, jD, n/2);
			print(iD+n/2, jD+n/2, n/2);
			System.out.print(")");
		}
		
	}
	
	static boolean check(int iD, int jD, int num, int size) {
		for(int i = iD; i < iD+size; i++) {
			for(int j = jD; j < jD+size; j++) {
				if(arr[i][j] != num)
					return false;
			}
		}
		return true;
	}

}
