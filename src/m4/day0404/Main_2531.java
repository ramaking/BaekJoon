package m4.day0404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.xml.transform.Source;

public class Main_2531 {

	static int n, d, k, c;
	static int[] dish;

	public static void main(String[] args) throws NumberFormatException, IOException, CloneNotSupportedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		dish = new int[n];
		int[] getDish = new int[d + 1];

		int temp;

		for (int i = 0; i < n; i++) {
			temp = Integer.parseInt(br.readLine());
			dish[i] = temp;
		}

		int max = 0;
		int count = 0;

		for (int i = 0; i < n + k; i++) {
			getDish[dish[(i) % n]]++;
			if (getDish[dish[(i) % n]] == 1) {
				count++;
			}

			if (i >= k) {
				if (i > k) {
					getDish[dish[i - k]]--;
					if (getDish[dish[i - k]] == 0)
						count--;
				}

				if (getDish[c] == 0) {
					if (max < count + 1) {
						max = count + 1;
					}
				}
			}

			if (max < count) {
				max = count;
			}
		}

		System.out.println(max);

	}
}
