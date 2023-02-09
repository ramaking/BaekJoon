package acmicpc0206;

import java.util.Scanner;


public class Main1244 {
	static boolean[] switchStat;
	static int n;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
//		int[] arr = new int[n];		
//		for(int i = 0; i < n; i++) {
//			arr[i] = sc.nextInt();
//		}
		
		switchStat = new boolean[n+1];
		
		for(int i = 1; i <= n; i++) {
			if(sc.nextInt() == 1) {
				switchStat[i] = true;
			}
			
		}
		
		int stuNum = sc.nextInt();
		
		for(int i = 0; i < stuNum; i++) {
			int castle = sc.nextInt();
			int switIdx = sc.nextInt();
			
			//남학생
			if(castle == 1) {
				for(int j = 1; switIdx*j <= n; j++) {
					toggle(switIdx*j);
				}
			}
			
			//여학생
			if(castle == 2) {
				findSuround(switIdx);
			}
		}

		int index = 1;
		while(index != n+1) {
			if(index % 20 == 0) {
				System.out.println(switchStat[index] ? 1 : 0);
			}else {
				System.out.print((switchStat[index]? 1: 0) + " ");
			}
			index++;
		}
		
		
		
		sc.close();

	}
	
	static void findSuround(int idx) {
		toggle(idx);
		int surIdx = 1;
		while(true) {
			
			int nextLeft = idx - surIdx;
			int nextRight = idx + surIdx;
			
			if(nextLeft > 0 && nextRight <= n && switchStat[nextLeft] == switchStat[nextRight] ) {
				surIdx++;
			}else {
				break;
			}
		}
		for(int i = 1; i < surIdx; i++) {
			toggle(idx-i);
			toggle(idx+i);
		}
	}
	
	static void toggle(int idx) {
		if(switchStat[idx]) {
			switchStat[idx] = false;
		} else {
			switchStat[idx] = true;
		}
	}

}


