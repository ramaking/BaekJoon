package acmicpc0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//슬라이딩 윈도우? 풀이
public class Main2164_2 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		//뒤로 넘길 카드를 고려하여 2배로 만듬
		int[] arr = new int[n*2+1];
		
		//i번 째 카드를 i 로 초기화
		for(int i = 1; i <= n; i++) {
			arr[i] = i;
		}
		
		//index를 가리키는 포인터 활용
		int startPointer = 1;
		int endPointer = n+1;
		
		//교차되는 지점까지 반복
		while(startPointer != endPointer){
			
			//버림
			if(startPointer%2 == 1) {
				startPointer++;
			} else {	//뒤로 넘김
				arr[endPointer++] = arr[startPointer++];
				
			}
		}
		
		
		System.out.println(arr[endPointer-1]);
		
	}

}


