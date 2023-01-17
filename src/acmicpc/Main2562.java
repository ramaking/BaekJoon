package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main2562 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int index = 0;
		int max = 0;
		
		for(int i = 1 ; i <= 9; i++) {
			String line = br.readLine();
			int num = Integer.parseInt(line);
			
			if(num > max) {
				max = num;
				index = i;
			}
			
		}
		
		System.out.println(max);
		System.out.println(index);

	}

}
