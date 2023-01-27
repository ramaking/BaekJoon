package acmicpc;

import java.util.Arrays;
import java.util.Scanner;

public class Main1920 {

	public static int[] arr;

	public static int binarySearch(int i){
		int lower = 0;
		int highter = arr.length-1;
		int middle = (lower + highter)/2;

		while(highter >= lower){
			if(arr[middle] == i){
				return 1;
			}

			if(arr[middle] < i){
				lower = middle+1;
			} else if(arr[middle] > i){
				highter = middle-1;
			}

			middle = (lower + highter)/2;
		}

		return 0;
	}
	
    public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		arr = new int[N];

		for(int i = 0; i < N; i++){
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);


		int M = sc.nextInt();


		for(int i = 0 ; i < M ; i++){
			System.out.println(binarySearch(sc.nextInt()));
			
		}
		
		sc.close();


    	
    }

}