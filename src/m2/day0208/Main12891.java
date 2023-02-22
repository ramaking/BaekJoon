package m2.day0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main12891 {
	static int s, p;
	static int[] alpaNum = new int[4];
	static String DNA;
	static int[] alpa;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		s = Math.abs(Integer.parseInt(st.nextToken()));
		p = Math.abs(Integer.parseInt(st.nextToken()));

		alpa = new int[4];

		DNA = br.readLine();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			alpaNum[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < p; i++) {
			if (DNA.charAt(i) == 'A') {
				alpa[0]++;
				continue;
			}
			if (DNA.charAt(i) == 'C') {
				alpa[1]++;
				continue;
			}
			if (DNA.charAt(i) == 'G') {
				alpa[2]++;
				continue;
			}
			if (DNA.charAt(i) == 'T') {
				alpa[3]++;
				continue;
			}
		}
		
		int sum = 0;
		
		boolean pro = true;
		
		for (int i = 0; i < 4; i++) {
			if (alpa[i] < alpaNum[i])
				pro = false;

		}
		if(pro) {
			sum++;
		}

		
		for (int i = 1; i < s - p + 1; i++) {
			if (checkPass(i, DNA.charAt(i-1)))
				sum++;
		}

		System.out.println(sum);

	}

	static boolean checkPass(int index, char char1) {

//		alpa[index][num]--;
		if (char1 == 'A') {
			alpa[0]--;
		}
		if (char1 == 'C') {
			alpa[1]--;
		}
		if (char1 == 'G') {
			alpa[2]--;
		}
		if (char1 == 'T') {
			alpa[3]--;
		}

		if (DNA.charAt(index + p-1) == 'A') {
			alpa[0]++;
		}
		if (DNA.charAt(index + p-1) == 'C') {
			alpa[1]++;
		}
		if (DNA.charAt(index + p-1) == 'G') {
			alpa[2]++;
		}
		if (DNA.charAt(index + p-1) == 'T') {
			alpa[3]++;
		}

		for (int i = 0; i < 4; i++) {
			if (alpa[i] < alpaNum[i])
				return false;

		}

		return true;
	}

}
