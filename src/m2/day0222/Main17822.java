package m2.day0222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17822 {

	static int n,m,t;
	static int[][] arr;
	static int[][] rota;
	static int[] iDir = {1,0,-1,0};
	static int[] jDir = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
//		rota = new int[t][3];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			
				int xi =Integer.parseInt(st.nextToken());
				int di =Integer.parseInt(st.nextToken());
				int ki =Integer.parseInt(st.nextToken());
				//회전
				while(true) {
					rotate(xi-1, di, ki);
					xi = xi+ xi;
					if(xi > n) {
						break;
					}
				}
				
//				print();
				
//				//지우기
//				eraser(xi);
//				
//				//지울게 없다면 평균 계싼
//				culc();
			
		}
	}
	
	private static void print() {
		// TODO Auto-generated method stub
		for(int i = 0; i < n; i++) {
			for(int j = 0 ; j < m; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("------------------");
	}

	//돌리기
	static void rotate(int xi, int di, int ki) {
		int dir = -1;
		if(di == 0) {
			dir = 1;
		}
		
		//k번 만큼 돌림 
		int[] tempArr = new int[m];
		int tempIdx = 0;
		for(int i = 0; i < m; i++) {
			//돌리는 인덱스가 0보다 작아짐
			if(i+dir*ki < 0) {
				tempIdx = (m-(i+dir*ki)-1);
				//m 보다 커짐
			}
			tempIdx = (i+dir*ki)% m;
			tempArr[tempIdx] = arr[xi][i];
		}
		
		//배열 복사
		for(int i = 0; i < m; i++) {
			arr[xi][i] = tempArr[i];
		}
		
		
	}
	
	//지우기
	static void eraser(int xi) {
		//지우는건 -1 로 변경
		int tI = 0, tJ = 0;
		int num = 0;
		for(int j = 0; j < m; j++) {
			num = arr[xi][j];
			for(int d = 0; d < 4; d++) {
				tI = xi + iDir[d];
				tJ = j + jDir[d];
				if(arr[tI][tJ] != -1 && arr[tI][tJ] == num) {
					arr[tI][tJ] = -1;
					arr[xi][j] = -1;
				}
			}
		}
	}
	
	//평균 후 계산
	static void culc() {
		//-1 은 빼고 계산
	}

}
