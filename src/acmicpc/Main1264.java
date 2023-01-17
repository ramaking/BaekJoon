package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main1264 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String line = br.readLine();
			
			if(line.contains("#")) {
				break;
			}
			int sum = 0;
			for(int i = 0; i < line.length(); i++) {
				if(line.charAt(i) == 'a' || line.charAt(i) == 'e' || line.charAt(i) == 'i' || line.charAt(i) == 'o' || line.charAt(i) == 'u' || line.charAt(i) == 'A' || line.charAt(i) == 'E' || line.charAt(i) == 'I' || line.charAt(i) == 'O' || line.charAt(i) == 'U' ) {
					sum++;
				}
			}
			System.out.println(sum);
		}
		
		

	}

}
