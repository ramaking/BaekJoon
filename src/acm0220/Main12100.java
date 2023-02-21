package acm0220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main12100 {
	static int n;
	static int max = 0;
	static int[][] arr, temp, roteTemp;
	static int[] card;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n][n];
		temp = new int[n][n];
		roteTemp = new int[n][n];
		card = new int[5];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		permu(0);
		
		System.out.println(max);
			
	}
	
	static void permu(int cnt) {
		
		if(cnt == 5) {
//			System.out.println(Arrays.toString(card));
			//배열 복사
			copyArr();
			
			//스윕
			for(int i = 0; i < 5; i++) {
				swip(card[i]);
				
			}
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			card[cnt] = i;
			permu(cnt+1);
		}
	}
	
	static void copyArr() {
		for(int i = 0; i < n; i++) {
			for(int j = 0 ; j < n ; j ++) {
				temp[i][j] = arr[i][j];
			}
		}
	}
	
	static void swip(int swipNum) {
		//그 방향에 맞게 돌리기
		for(int i = 0;  i< swipNum; i++) {
			rotate();
		}
//		
		//밀기
		push();
		
		
		//원래 방향에 맞게 돌려놓기
		if(swipNum != 0) {	//0이면 안돌려도 됨..
			for(int i = 0;  i< 4-swipNum; i++) {
				rotate();
			}
		}
		
		
	}
	
	//90도 돌리는 기능
	static void rotate() {
		//회전
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				roteTemp[j][n-i-1] = temp[i][j];
			}
		}
		
		//복사
		for(int i = 0; i < n; i++) {
			for(int j=  0; j < n; j++) {
				temp[i][j] = roteTemp[i][j];
			}
		}
		
	}
	
	//아래로 내리는 기능
	static void push() {
		Queue<Integer> queue = new LinkedList<>();
		
		for(int j = 0; j < n; j++) {
			int tempNum = 0;
			//열 별로 진행
			for(int i = n-1; i >= 0; i--) {
				
				//0이 아닌 다른 값이 왔을 때
				if(temp[i][j] != 0) {
					
					//이전과 같은 값이면 합침
					if(tempNum == temp[i][j]) {
						queue.add(tempNum*2);
						tempNum = 0;
						
					} else {	//다른 값이면 이전 값을 큐에 넣고 새로운 값을 가짐
						
						if(tempNum == 0) {	//이전 값이 0이면 새로운 값만 가짐
						} else {
							queue.add(tempNum);
						}
						
						tempNum = temp[i][j];

					}
					
					//값을 0으로 채움
					temp[i][j] = 0;
				}
				
			}
			
			//열 연산이 끝나고 남아있는 값이 0이 아니라면 큐에 넣음
			if(tempNum != 0)
				queue.add(tempNum);
//			System.out.println(Arrays.toString(queue.toArray(new Integer[queue.size()])));
			
			
			//큐에 있는 값을 아래서 부터 출력함
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				int pollNum = queue.poll();
				temp[n-i-1][j] = pollNum;
				if(max < pollNum) {
					max = pollNum;
				}
			}
			
			
			
		}
		
	}
	
	static void print() {
		for(int i = 0; i < n; i++) {
			for(int j=  0; j < n; j++) {
				System.out.print(temp[i][j] + " ");;
			}
			System.out.println();
		}
		System.out.println("----------------------");
	}


}
