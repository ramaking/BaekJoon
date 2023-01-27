package acmicpc0126_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main1181 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		
		int N = Integer.parseInt(line);
		
		
		
		String [] wordArr = new String[N];
		
		for(int i = 0; i < N; i++) {
			wordArr[i] = br.readLine();
		}
		
		Arrays.sort(wordArr, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				if(o1.length() > o2.length()) {
					
				}
				return 0;
			}
		});
		
		
		
		
		//1. 길이 순 정렬
		//2. 사전(앞자리부터 알파벳 정렬)순 정렬
		
		
	}
}
