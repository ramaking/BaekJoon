package m2.day0212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17406 {

	static int[][] arr;
	static int[][] temp;
	static int n,m,k;
	static int[] iD = {+1, 0, -1, 0};
	static int[] jD = {0, +1, 0, -1};
	
	static int[][] numbers;
	static boolean[] visited;
	static int[][] card;
	
	static int min = Integer.MAX_VALUE;
	
	

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr  = new int[n+1][m+1];
		temp  = new int[n+1][m+1];
		numbers = new int[k][3];
		visited = new boolean[k];
		card = new int[k][3];
		
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			numbers[i][0] = r;
			numbers[i][1] = c;
			numbers[i][2] = s;
			
			
		}
		
		permu(0);
		
		
		System.out.println(min);

	}
	
	static void permu(int cnt) {
		if(cnt == k) {
			
			arrCopy();
			
			for(int i = 0; i < k; i++) {
				rotate(card[i][0], card[i][1], card[i][2]);
			}
			min = Math.min(min, getSum());
			
		}
		
		for(int i = 0; i < k; i++) {
			if(visited[i]) continue;
			card[cnt] = numbers[i];
			visited[i] = true;
			permu(cnt+1);
			visited[i] = false;
			
		}
	}
	
	static void rotate(int i, int j, int s) {
		for(int k = 0; k < s; k++) {
			int tempNum = temp[i-s+k][j-s+k];
			int cI = i-s+k;
			int cJ = j-s+k;
			int nI = 0;
			int nJ = 0;
			int dIdx = 0;
			while(true) {
				if(nI == i-s+k && nJ == j-s+k) {
					break;
				}
				
				nI = cI + iD[dIdx];
				nJ = cJ + jD[dIdx];
				
				if(nI >= i-s+k && nI <= i+s-k && nJ >= j-s+k && nJ <= j+s-k) {
					temp[cI][cJ] = temp[nI][nJ];
					cI = nI;
					cJ = nJ;
					
					
				} else {
					dIdx = (dIdx+1)%4;
				}
				
			}
			temp[i-s+k][j-s+k+1] = tempNum;
			
		}
		
	}
	
	static int getSum() {
		int min = Integer.MAX_VALUE;
		for(int i = 1; i<= n; i++) {
			int sum = 0;
			for(int j = 1; j <= m; j++) {
				sum += temp[i][j];
			}
			min = Math.min(sum, min);
		}
		
		return min;
	}
	
	static void arrCopy() {
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				temp[i][j] = arr[i][j];
			}
		}
	}

}
