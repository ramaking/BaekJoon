package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1018 {
	
	//최대 64개를 색찰할 수 있음
	static int min = 64;
	
	static char[][] board;
	
	//좌표를 받고 색칠하는 경우의 수를 전달
	public static int paint(int i, int j, char color) {
		
		int sum = 0;
		
		for(int iIndex = 0; iIndex < 8; iIndex++) {
			for(int jIndex = 0; jIndex < 8; jIndex++) {
				
				//칠하는 개수가 최소값을 지나면 의미가 없음
				if(sum > min) {
					return 64;
				}
				
				//같기를 원하는 위치에 색이 다르다면
				if(((iIndex%2 == 0 && jIndex%2 == 0) ||(iIndex%2 == 1 && jIndex%2 == 1)) && board[iIndex+i][jIndex+j] != color) {
					sum++;
				}
				
				//다르기를 원하는 위치에 색이 같다면
				if(((iIndex%2 == 0 && jIndex%2 == 1) || (iIndex%2 == 1 && jIndex%2 == 0))&& board[iIndex+i][jIndex+j] == color) {
					sum++;
				}
			}
		}
		
		return sum;
	}

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	String line = br.readLine();
    	
    	StringTokenizer st = new StringTokenizer(line);

    	int N = Integer.parseInt(st.nextToken()) ;
    	int M = Integer.parseInt(st.nextToken()) ;
    	
    	board = new char[N][M];
    	
    	for(int i = 0; i < N; i++) {
    		line = br.readLine();
    		for(int j = 0; j < M; j++) {
    			board[i][j] = line.charAt(j);
    		}
    	}
    	
    	int wMin;
    	int bMin;
    	boolean isZero = false;
    	
    	//외곽으로 부터 최소 8칸은 떨어져 있어야 함
    	for(int i = 0; i < N-7; i++) {
    		for(int j = 0; j < M-7; j++) {
    			wMin = paint(i,j,'W');
    			bMin = paint(i,j,'B');
    			if(wMin < min) {
    				min = wMin;
    			}
    			
    			if(bMin < min) {
    				min = bMin;
    			}
    			
    			if(min == 0) {
    				isZero = true;
    				break;
    			}
    		}
    		if(isZero) {
    			break;
    		}
    		
    	}
    	
    	//최소값 출력
    	System.out.println(min);
    	
    	
    	
    	
    }

}