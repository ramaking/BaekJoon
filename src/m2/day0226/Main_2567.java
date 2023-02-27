package m2.day0226;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2567 {
	static int n;
	
	//전체 그림을 나타내는 2차원 배열
	static int[][] arr = new int[100][100];
	
	//4방 탐색에 사용될 방향
	static int[] di = {1,0,-1,0};
	static int[] dj = {0,1,0,-1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t = 0; t < n; t++) {
			st = new StringTokenizer(br.readLine());
			int iIdx = Integer.parseInt(st.nextToken());
			int jIdx = Integer.parseInt(st.nextToken());
			
			//입력받은 좌표로 스카프 색칠
			for(int i = iIdx; i < iIdx+10; i++) {
				for(int j = jIdx; j < jIdx+10; j++) {
					arr[i][j] = 1;
				}
			}
		}
		
		
		int ni, nj;
		
		int cnt = 0;
		
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j ++) {
				
				//스카프를 기준으로 주변 탐색
				if(arr[i][j] == 1) {
					
					//4 방향
					for(int d = 0; d < 4; d++) {
						ni = i + di[d];
						nj = j + dj[d];
						
						//영역을 벗어나도 둘레로 인정
						if(ni < 0 || ni >= 100 || nj < 0 || nj >= 100) {
							cnt++;
						} else {
							
							//주변이 0 이면 둘레로 인정
							if(arr[ni][nj] == 0) {
								cnt++;
							}
						}
					}
				}
			}
		}
		
		System.out.println(cnt);
	}
	

}
