package ac0216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2023 {
	
	static int[] card;
	static int n;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		
		card = new int [n];
		
		permu(1, 0);
		
	}
	
	static void permu(int depth, int cnt) {
		if(cnt == depth) {
			
			if(isPrime(depth)) {
				if(depth == n) {
					System.out.println(makeNum(depth));
				}else {
					permu(depth + 1, cnt);
				}
			}

			return;
		}
		
		for(int i = 1; i <= 9; i++) {
			card[cnt] = i;
			permu(depth, cnt+1);
		}
	}
	
	static boolean isPrime(int depth) {
		
		int num = makeNum(depth);
		
		if(num == 1) {
			return false;
		}
		
		for(int i = 2; i <= Math.sqrt(num); i++) {
			if(num%i == 0) {
				return false;
			}
		}
		return true;
	}
	
	static int makeNum(int depth) {
		int num = card[0];
		for(int i = 1; i < depth; i++) {
			num = num*10+card[i];
		}
		return num;
	}

}
