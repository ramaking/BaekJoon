package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2438 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		
		int N = Integer.parseInt(line);
		
		for(int i = 0 ; i < N; i++) {
			for(int j = 0 ; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	

	}

}
