package m2.day0220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1074 {
	static int n, r, c;
	static int index = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		;

		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		int N = (int) Math.pow(2, n);

		find(N/2,N/2,N/2);
		System.out.println(index);
	}

	static void find(int cR, int cC, int size) {
//		System.out.println(index);
		if(size == 0) {
			return;
		}
		int nR = cR;
		int nC = cC;
		
		if (r < cR && c < cC) {
			nR = cR - size/2;
			nC = cC - size/2;
		}
		
		if (r < cR && c >= cC) {
			index += Math.pow(size,2);
			nR = cR - size/2;
			nC = cC + size/2;
		}

		if (r >= cR && c < cC) {
			index += Math.pow((size),2)*2;
			nR = cR + size/2;
			nC = cC - size/2;
		}
		
		if (r >= cR && c >= cC) {
			index += Math.pow((size),2)*3;
			nR = cR + size/2;
			nC = cC + size/2;
		}

		find(nR, nC, size/2);
	}

}
