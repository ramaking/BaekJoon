package m2.day0222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1759 {

	static int l, c;
	static char[] mo = {'a', 'e', 'i', 'o', 'u'};
	static int moNum = 0;
	static int jaNum = 0;
	static char[] arr;
	static int[] card;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		arr = new char[c];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < c; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		card = new int[l];
		Arrays.sort(arr);
		
		
		comb(0, 0);

	}
	
	static void comb(int cnt, int start) {
		if(cnt == l) {
//			System.out.println(Arrays.toString(card));
			jaNum = 0;
			moNum = 0;
			if(check()) {
				print();
			}
			
			return;
		}
		
		for(int i = start; i < c; i++) {
			card[cnt] = i;
			comb(cnt+1, i+1);
		}
		
	}
	
	static boolean check() {
		
		for(int i = 0; i < l; i++) {
			if(isMo(arr[card[i]])) {
				moNum++;
			} else {
				jaNum++;
			}
			
			if(moNum >= 1 && jaNum >= 2) {
				return true;
			}
		}
		
		
		
		return false;
	}
	
	static boolean isMo(char what) {
		for(int i = 0; i < 5; i++) {
			if(what == mo[i]) {
				return true;
			}
		}
		return false;
	}
	
	static void print() {
		for(int i = 0; i < l; i++) {
			System.out.print(arr[card[i]]);
		}
		System.out.println();
	}

}
