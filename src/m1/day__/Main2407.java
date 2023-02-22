package m1.day__;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main2407 {
	
	

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	String line = br.readLine();
    	
    	StringTokenizer st = new StringTokenizer(line);

    	String n = st.nextToken() ;
    	String r = st.nextToken() ;
    	
    	BigInteger bInt1 = new BigInteger(n);
    	BigInteger bInt2 = new BigInteger(r);
    	
    	BigInteger result = BigInteger.valueOf(1);
    	
    	for(int i = 1; bInt2.compareTo(BigInteger.valueOf(i-1)) == 1; i++) {
//    		System.out.println(bInt1.subtract(BigInteger.valueOf(i-1)).toString());
    		result = result.multiply(bInt1.subtract(BigInteger.valueOf(i-1)));
    	}
    	
//    	System.out.println(result.toString());
    	
    	for(int i = 1; bInt2.compareTo(BigInteger.valueOf(i-1)) == 1; i++) {
    		result = result.divide(BigInteger.valueOf(i));
    	}
    	

    	
    	
    	
    	//최소값 출력
    	System.out.println(result.toString());
    	
    	
    	
    	
    }

}