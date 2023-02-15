package acmicpc0212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main10866 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		int head = 10000;
		int tair = 10001;

		int[] arr = new int[20002];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			switch (st.nextToken()) {
			case "push_front":
				arr[head] = Integer.parseInt(st.nextToken());
				head--;
				break;
			case "push_back":
				arr[tair] = Integer.parseInt(st.nextToken());
				tair++;
				break;
			case "pop_front":
				if (tair - head == 1) {
					sb.append("-1\n");
				} else {
					sb.append(arr[++head] + "\n");
//					head++;
				}

				break;
			case "pop_back":
				if (tair - head == 1) {
					sb.append("-1\n");
				} else {
					sb.append(arr[--tair] + "\n");
//					tair--;
				}
				break;
			case "size":
				sb.append(tair - head-1 + "\n");
				break;
			case "empty":
				if (tair - head == 1) {
					sb.append("1\n");
				} else {
					sb.append("0\n");
				}
				break;
			case "front":
				if (tair - head == 1) {
					sb.append("-1\n");
				} else {
					sb.append(arr[head+1] + "\n");
				}
				break;
			case "back":
				if (tair - head == 1) {
					sb.append("-1\n");
				} else {
					sb.append(arr[tair-1] + "\n");
				}
				break;

			}

		}
		
		System.out.println(sb.toString());

	}

}
