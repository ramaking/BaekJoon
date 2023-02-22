package m1.day__;

import java.util.Scanner;

public class Main3052 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] arr = new int[10];
        int num;
        int sum = 0;
        
        //나머지가 될 수 없는 -1 로 초기화
        for(int i = 0; i < 10; i ++) {
        	arr[i] = -1;
        }
        
        //입력
        for(int i = 0; i < 10; i++) {
        	num = sc.nextInt();
        	
        	//flag
        	boolean isSame = false;
        	for(int index = 0; index < i; index++) {
        		
        		if(num%42 == arr[index]) {
        			isSame = true;
        			break;
        		}
        	}
        	arr[i] = num%42;
        	
        	if(!isSame) {
        		sum++;
        	}
        	
        }
        
        
        System.out.println(sum);
        sc.close();
    }

}