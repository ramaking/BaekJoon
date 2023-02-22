package m1.day__;

import java.util.Scanner;

public class Main1654 {

	public static int[] arr;

	public static long highter;

	public static int K;

	public static long N;

	public static long binarySearch(){
		
		long lower = 1;
		// highter = arr.length-1;
		long middle = (lower + highter)/2;

		int sum = 0;

		while(lower <= highter){
			// System.out.println(middle);

			for(int j = 0; j < K; j++){
				sum += arr[j]/middle;
			}

			if(sum < N){
				highter = middle-1;
			} 

			else if(sum >= N){
				lower = middle+1;
			}

			middle = (lower + highter)/2;

			sum = 0;
		}

		return middle;
	}
	
    public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);

		K = sc.nextInt();

		N = sc.nextInt();
		
		arr = new int[K];

		long sum = 0;

		for(int i = 0; i < K; i++){
			arr[i] = sc.nextInt();
			sum += arr[i];
		}

		highter = sum/N;
		// System.out.println(highter);



		// Arrays.sort(arr);

		System.out.println(binarySearch());
		
		sc.close();
		



    	
    }

}