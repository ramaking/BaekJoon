package m1.day__;

import java.util.Scanner;

public class Main2884 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int H = sc.nextInt();
        int M = sc.nextInt();
        
        int nextH = H;
        int nextM = M-45;
        if(M-45 < 0) {
        	nextM = 60-(45-M);
        	if(H-1 < 0) {
        		nextH = 23;
        	} else {
        		nextH = H-1;
        	}
        }
        
        System.out.println(nextH + " " + nextM);
        sc.close();
    }

}