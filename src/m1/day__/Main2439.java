package m1.day__;

import java.util.Scanner;

public class Main2439 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        for(int i = 0; i < N; i++) {
        	//blank
        	for(int j = 1; j < N-i; j++) {
        		System.out.print(" ");
        	}
        	
        	//*
        	for(int j = 0; j <= i; j++) {
        		System.out.print("*");
        	}
        	
        	//계행
        	System.out.println();
        }
        
        sc.close();
    }

}