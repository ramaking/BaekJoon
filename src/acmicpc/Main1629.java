package acmicpc;

import java.util.Scanner;

public class Main1629 {
	
	public static int C;
	
	public static long pow(int A, int ex) {
		
		if(ex == 1) {
			return A%C;
		}
		
		long temp = pow(A, ex/2);
		
		if(ex %2 == 1) {
			return (temp%C*temp%C*A%C)%C;
		} else{
			return (temp%C*temp%C)%C;
		}
		
	}
	
    public static void main(String[] args) {

    	Scanner sc = new Scanner(System.in);
    	
    	int A = sc.nextInt();
    	int B = sc.nextInt();
    	C = sc.nextInt();
    	
    	System.out.println(pow(A,B));
    	
    	sc.close();
    }

}