package acmicpc;

import java.io.IOException;
import java.util.Scanner;

//어떤 수를 입력 받았을 때 그 보다 작은 값이 몇개인지 세는 로직이 필요함

public class Main1300 {

	public static void main(String[] args) throws IOException {

//		Scanner sc = new Scanner(System.in);
//
//		int N = sc.nextInt();
//		
//		int k = sc.nextInt();
		
		for(int i = 1; i < 10; i ++) {
			for(int j = 1; j < 10; j ++) {
				System.out.print( i*j + "\t");
			}
			System.out.println();
		}
		
//		sc.close();

	}	
}
