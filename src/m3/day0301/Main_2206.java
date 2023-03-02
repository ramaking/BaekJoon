package m3.day0301;

import java.io.BufferedReader;

/*
 * 구조적으로 잘못됨
 * 그리디가 아님
 * 재귀적으로 5 4 3 2 1 순으로 체크하면서 넘어가야 할 듯
 * 반례 : 8 * 8 러 채워진 박스는  4가 나와야 하지만 5로 먼저 채워버리면 안됨
 * 어쩐지 골2 치고 너무 쉽더라니...
 */
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2206 {

	//1000 * 1000 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int [n];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		for(int i = 0; i < n; i++) {
			System.out.println(arr[i]);
		}
	}


}
