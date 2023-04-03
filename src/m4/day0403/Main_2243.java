package m4.day0403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.xml.transform.Source;

/*
 * 1 ~ 1000000 으로 배열 만들기 각 칸에는 그 순위 사탕의 ㄱ수가 들어감
 * 1 ~ 1000000 으로 트리 짜기 각 칸에는 누적합
 * 
 * 범위 나가면 무시
 * 안쪽이면 연산 후 나누기
 * 넣을 때는 그 1 ~ 1000000(index)을 검색해서 들어가야 하고
 * 뺄 때는 몇번째 값(cnt)인지를 찾아야 함
 * 
 * 누적합을 저장하되, 찾는 과정에서 오른 쪽은 왼쪽의 합을 전달해서 그  값을 빼면서 오른쪽을 찾아야 가야할 듯
 */



public class Main_2243 {
	static int[] tree = new int[1000000*4+1];
	static int n;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int i = 0; i <n; i++) {
			st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());
			
			//insert
			if(type == 2) {
				int insertNum = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				modify(1, 1000000, 1, insertNum, cnt);
				
			} else {	//delete
				int deleteCnt = Integer.parseInt(st.nextToken());
				int result = findSort(1, 1000000, 1, deleteCnt);
				sb.append(result).append("\n");
			}
			
		}
		
		System.out.println(sb.toString());
	}
	
	static void print(int n) {
		for(int i = 0; i <= n; i++) {
			System.out.print(tree[i] + " ");
		}
		System.out.println();
	}

	//특정 값을 입력함 + - 가능
	static void modify(int start, int end, int index, int insertNum, int cnt) {
		//변경 범위 밖
		if(insertNum < start || end < insertNum) {
			return;
		}
		
		tree[index] = tree[index] + cnt;
		
		//끝에 도착
		if(start == end) {
			return;
		}
		
		int mid = (start+end)/2;

		modify(start, mid, index*2, insertNum, cnt);
		modify(mid+1, end, index*2+1, insertNum, cnt);
		
	}
	
	//몇번째 값을 찾음
	static int findSort(int start, int end, int index, int deleteCnt) {
		
		tree[index] -= 1;
		
		
		if(start == end) {
			return start;
		}
		
		int mid = (start+end)/2;
		
		if(tree[index*2] < deleteCnt) {
			return findSort(mid+1, end, index*2+1, deleteCnt-tree[index*2]);
		} else {
			return findSort(start, mid, index*2, deleteCnt);
		}
		
	}
	
	
}
