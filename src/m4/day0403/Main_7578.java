package m4.day0403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.xml.transform.Source;

/*
 * 입력받은 기계
 * 이때 arrayList  로 반대편 값의 인덱스를 담음
 * 이걸로 트리 구성
 * 맨 아래는 항상 0일거고,
 * 양 쪽의 머신의 교차점의 개수를 저장
 * 교차점을 찾기 위해 각 부분의 가장 왼쪽, 가장 오른쪽을 비교할 필요가 있을 듯
 * 각 교차점 + 새롭게 발생하는 교차점
 * 왼쪽은 위의 가장 왼쪽과 아래의 가장 오른쪽을 보냄
 * 오른쪽은 위의 가장 오른쪽과 아래의 가장 왼쪽을 보냄
 * 이 두 값을 이용해서...
 * 
 * 
 * 아니면 하나씩 넣는 과정에서 교차되는지 확인하고 그 만큼 더하기?
 * 이게 맞는 듯
 * 리프 1000000짜리 트리 만들고
 * 넣는 과정에서 범위에 걸리면 하나씩 늘리면서 안으로 들어가기?
 * 넣을 때 앞뒤를 넣고 
 * 
 * 500000짜리 트리를 만들고
 * 도착점의 개수의 구간합을 저장하고
 * 
 * 쿼리를 날리기 시작
 * 쿼리는 0에 해당하는 도착점부터 날리기 시작
 * 도착점의 이전 지점으로 가는 구간의 합
 * 
 */



public class Main_7578 {
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
//				System.out.println(result);
				sb.append(result).append("\n");
			}
//			print(16);
			
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
//			System.out.println("skip : " + start +  " : " + end);
			return;
		}
		
//		System.out.println("change : " + start +  " : " + end);
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
//			System.out.println("index : " + index);
//			System.out.println("start : " + start);
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
