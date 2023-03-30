//package m3.day0329;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//
///*
// * 범위의 최소값 * 범위
// * 그 범위를 1 ~ N 까지 한번씩 다
// * 1 ~ n까지의 합
// * n(n-1)/2 번 돔 약 n^2
// * 
// * =>
// * 
// * 최소값을 저장하는 트리
// * (최소값 * 범위)의 최대값을 저장하는 트리
// * 양쪽중 큰 값을 저장한다.
// * 각 값을 구하는 방법은 구간의 최솟값과 구간의 곱
// * 
// */
//
//public class Main_1725 {
//	static int n;
//	static int[] num;
//	static int[][] maxTree;
//	static int[] minTree;
//
//	public static void main(String[] args) throws IOException {
//		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		StringTokenizer st = new StringTokenizer(br.readLine());
//
//		n = Integer.parseInt(st.nextToken());
//		
//		num = new int[n+1];
//		maxTree = new int[n*4][3];
//		minTree = new int[n*4];
//		
//		for (int i = 1; i <= n; i++) {
//			num[i] = Integer.parseInt(br.readLine());
//		}
//		
//		makeMinTree(1, n, 1);
//		int max = 0;
//		for (int i = 1; i <= n; i++) {
//			for (int j = i; j <= n; j++) {
//				max = Math.max(getMin(1,n,1,i,j)*(j-i+1),max);
//			}
//		}
//		System.out.println(max);
//		
////		makeMaxTree(1, n, 1);
////		System.out.println(Arrays.toString(minTree));
////		System.out.println(Arrays.toString(maxTree));
//		
//		
////		StringBuilder sb = new StringBuilder();
////		sb.append(maxTree[1]).append("\n");
////		System.out.println(sb.toString());
//
//	}
//
//
////	private static int getMax(int start, int end, int index, int left, int right) {
////		if(end < left || right < start) return 0;
////		
////		if(left <= start && end <= right) return maxTree[index];
////		
////		int mid = (start+end)/2;
////		return Math.max(getMax(start, mid, index*2, left, right), getMax(mid+1 , end, index*2+1, left, right));
////		
////	}
//	
//	private static int getMin(int start, int end, int index, int left, int right) {
//		if(end < left || right < start) return Integer.MAX_VALUE;
//		
//		if(left <= start && end <= right) return minTree[index];
//		
//		int mid = (start+end)/2;
//		return Math.min(getMin(start, mid, index*2, left, right), getMin(mid+1 , end, index*2+1, left, right));
//		
//	}
//
//	private static int makeMaxTree(int start, int end, int index, int left, int right) {
//		if(start == end) return maxTree[index] = minTree[start];
//		
//		int mid = (start+end)/2;
//		
//		maxTree[index] = Math.max(
//				Math.max(leftVal
//						, rigthVal)
//				,getMin(start, end, 1, start, end)*(end-start+1));
//		
//		return maxTree[index];
//		
//	}
//	
//	private static int makeMinTree(int start, int end, int index) {
//		if(start == end) {
//			minTree[index] = num[start];
//			maxTree[index][0] = minTree[index];
//			maxTree[index][1] = start;
//			maxTree[index][2] = start;
//			return minTree[index];
//		}
//		
//		int mid = (start+end)/2;
//		
//		minTree[index] = Math.min(makeMinTree(start, mid, index*2), makeMinTree(mid+1, end, index*2+1));
//		int leftVal = minTree[index*2]*(mid-start+1);
//		int rigthVal = minTree[index*2+1]*(end-start+1);
//		maxTree[index] = Math.max(
//				Math.max(leftVal
//						, rigthVal)
//				,getMin(start, end, 1, start, end)*(end-start+1));
//		
//		return minTree[index];
//		
//	}
//	
//	
//	
//}
