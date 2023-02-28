package m2.day0226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17471 {
	static int n;
	static int[] popul;	//인구수
	static ArrayList<Integer>[] list;	//인접 구역 리스트
	static boolean[] used;	//부분 집합 구하기에 사용되는 배열
	static ArrayList<Integer> teamA = new ArrayList<>();	//1구역
	static ArrayList<Integer> teamB = new ArrayList<>();	//2구역
	static int min = Integer.MAX_VALUE;	//출력할 최소값

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		popul = new int[n + 1];
		list = new ArrayList[n + 1];
		used = new boolean[n + 1];
		for (int i = 0; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= n; i++) {
			popul[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());

			for (int k = 0; k < num; k++) {
				list[i].add(Integer.parseInt(st.nextToken()));	//인접 리스트 추가
			}
		}

		subSet(0);
		
		if(min == Integer.MAX_VALUE) {
			System.out.println(-1);	// 나누기 불가
		} else {
			System.out.println(min);	//최소값 출력
		}
		
	}

	static void subSet(int cnt) {
		if (cnt == n+1) {	//모든 구역이 다 나뉘면 검증 진행
			
//			System.out.println(Arrays.toString(used));
			int Asum = 0;	//1구역 합계
			int Bsum = 0;	//2구역 합계
			
			//구역 나누기 + 합계 미리 계산하기
			for(int i = 1; i <= n; i++) {
				if(used[i]) {
					teamA.add(i);
					Asum += popul[i];
				} else {
					teamB.add(i);
					Bsum += popul[i];
				}
			}
			
			//공집합과 완전집합? 은 제외
			if(teamA.size()==0 || teamB.size()== 0) {
				teamA.clear();
				teamB.clear();
				return;
			}
			
			// 각 팀이 모두 인접하지 않다면 return
			if(!isUni(teamA) ||  !isUni(teamB)) {
				teamA.clear();
				teamB.clear();
				return;
			}

			// 인접하다면 인구수 차이 확인
			min = Math.min(min, Math.abs(Asum-Bsum));

			//팀 초기화
			teamA.clear();
			teamB.clear();
			return;
		}

		used[cnt] = true;
		subSet(cnt + 1);
		used[cnt] = false;
		subSet(cnt + 1);

	}

	//bfs로 이접 여부 확인
	static boolean isUni(ArrayList<Integer> teamlist) {
		//방문 배열
		boolean[] visited = new boolean[n+1];
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(teamlist.get(0));	//구역의 첫번째 값에서 시작
		visited[teamlist.get(0)] = true;
		while(!queue.isEmpty()) {
			int now = queue.poll();
			for(int i = 0; i < list[now].size(); i++) {	//인접 구역들을 검증
				int next = list[now].get(i);
				
				//인접 구역이 방문하지 않았으며 팀 소속이어야 함
				if(!visited[next] && teamlist.contains(next)) {	 
					visited[next] = true;
					queue.add(next);
				}
			}
		}
		
		//팀 전체를 방문했는지 확인
		for(int i = 0; i < teamlist.size(); i++) {
			if(!visited[teamlist.get(i)]) {
				return false;
			}
		}
		
		return true;
	}

}
