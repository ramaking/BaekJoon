package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main1271 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		
		StringTokenizer st = new StringTokenizer(line);
		
		String N = st.nextToken();
		String M = st.nextToken();
		
		BigInteger bigNumber = new BigInteger(N);
		
		BigInteger bigNumber2 = new BigInteger(M);
		
		System.out.println(bigNumber.divide(bigNumber2));
		
		System.out.println(bigNumber.remainder(bigNumber2));
		
		
		System.out.println();
	}

}
