package acmicpc0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//큐를 활용한 풀이
public class Main2164 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Queue<Integer> queue = new LinkedList<>();
		
		//큐에 추가
		for(int i = 1; i <= n; i++) {
			queue.add(i);
		}
		
		
		int temp;
		int index = 1;
		//큐에 하나만 남을 때 까지
		while(queue.size() != 1){
			temp = queue.poll();
			
			//버림
			if(index%2 == 1) {
				
			} else {	//뒤로 넘김
				queue.add(temp);
			}
			index++;
		}
		
		temp = queue.poll();
		
		System.out.println(temp);
		
	}

}


