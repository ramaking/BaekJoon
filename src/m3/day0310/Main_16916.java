package m3.day0310;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_16916 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		String pattern = br.readLine();
		
		makeTable(pattern);
		
	}

	private static void makeTable(String pattern) {
		int pLen = pattern.length();
		int[] table = new int[pLen];
		
		int idx = 0;
		for(int i = 1; i < pLen; i++) {
			
			while(idx > 0 && pattern.charAt(i) != pattern.charAt(idx)) {
				idx = table[idx-1];
			}
			
			if(pattern.charAt(i) == pattern.charAt(idx)) {
				table[i] = idx++;
			}
		}
	}
	
	
}
