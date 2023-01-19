package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.function.Consumer;

class MyTree {
	HashSet<Integer> tree;
	boolean isInTrueMan;

	MyTree() {
		tree = new HashSet<>();
		isInTrueMan = false;
	}
}

public class Main1043 {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int M = sc.nextInt();

		int trueManNum = sc.nextInt();

		boolean[] trueMan = new boolean[N + 1];

		// 파티의 개수만큼 트리
		MyTree[] myTree = new MyTree[M];

		// 파티에 참석한 사람 기록
		int[][] partyPerson = new int[M][N];

		// 트루맨 입력
		for (int i = 0; i < trueManNum; i++) {
			trueMan[sc.nextInt()] = true;
		}

		// 파티수 만큼 반복
		for (int i = 0; i < M; i++) {
			myTree[i] = new MyTree();

			// 연관있는 트리 index 저장
			int[] treeList = new int[M];
			int treeListIndex = 0;

			// 파티에 몇명 오는지
			int personNum = sc.nextInt();

			// 파티에 누구누구 오는지
			for (int j = 0; j < personNum; j++) {

				int person = sc.nextInt();

				partyPerson[i][j] = person;

				// 이번 트리에 온 사람 추가
				myTree[i].tree.add(person);
				
				if(!myTree[i].isInTrueMan)
					myTree[i].isInTrueMan = trueMan[person];

				// 기존 tree 에 있는 사람인지 확인
				for (int k = 0; k < i; k++) {

					// 기존에 등장햇던 사람이라면 이 트리에 병합 예정
					// 어떤 트리들을 병합 할지 기존 트리 중에 다 뽑아 놓음
					if (myTree[k] != null && myTree[k].tree.contains(person)) {
						boolean isInIndex = false;
						for(int h = 0; h < treeListIndex; h++) {
							if(treeList[h] == k) {
								isInIndex = true;
							}
						}
						
						if(!isInIndex) {
							//이미 k 가 인덱스에 있으면 생략해야함
							treeList[treeListIndex] = k;
							treeListIndex++;
						}
						
					}
				}

			} // 파티 종료

			// 트리 병합
			for (int j = 0; j < treeListIndex; j++) {
				
//				System.out.println("index : " + i + "  트리 : "+treeList[j]);
				// 병합할 트리를 분해
				Iterator<Integer> iter = myTree[treeList[j]].tree.iterator();

				while (iter.hasNext()) {
					int man = iter.next();
//					System.out.println(man + " 병합");
					myTree[i].tree.add(man);
				}
				if (myTree[treeList[j]].isInTrueMan) {
					myTree[i].isInTrueMan = true;
				}

				myTree[treeList[j]] = null;
			}

		}
		
//		System.out.println(Arrays.toString(myTree));


		// 입력이 끝나면 트루맨이 없는 곳을 ++ 해서 출력
		for (int i = 0; i < M; i++) {
			
//			System.out.println("index : " +i +  "  is null? : " + myTree[i] + "  is in trueman? : " + myTree[i].isInTrueMan);

			// 트리가 존재하고 true 그룹이라면 그 그룹 사람들은 다 트루맨
			if (myTree[i] != null && myTree[i].isInTrueMan) {
//				System.out.println("트루맨 검증 index : " + i);
				Iterator<Integer> iter = myTree[i].tree.iterator();
				while (iter.hasNext()) {
					int man = iter.next();
//					System.out.println(man +" 는 트루맨");
					trueMan[man] = true;
				}
			}
		}

		int sum = 0;
		for (int i = 0; i < M; i++) {
			boolean isInTrueMan = false;
			for (int j = 0; j < N; j++) {
				if (trueMan[partyPerson[i][j]]) {
					isInTrueMan = true;
					break;
				}
			}
			if (!isInTrueMan) {
				sum++;
			}
		}
		
//		System.out.println(Arrays.toString(trueMan));

		System.out.println(sum);

		sc.close();

		// 과장을 할지 말지 고민.
		// 진실을 아는 사람이 존재함
		// 진실과 거짓을 한 사람에게 모두 말하면 안됨

		// 진실을 아는 사람이 있는 곳에서는 진실만 말해야 함
		// 따라서 진실을 아는 사람이 포함된 모든 곳과 그 곳에 있던 모든 사람이 있는 곳은 빼야한다.
		// 마찬 가지로 진실을 아는 사람과 같이 있던 모든 사람도 진실을 안다고 생각해야한다.

		// 배열을 만들어서 arraylist 를 여러개 생성한다.
		// 배열에 arraylist 에 연결된 걸 붙이다가 중복되면 arraylist를 병합

		// 누가 진실맨인지 확인하고 나중에 진실맨이 포함된 파티르 전부 빼면됨

		// 1. 파티 참석자들의 관계 파악
		// 2. 관계를 바탕으로 진실맨 추적
		// 3. 진실맨이 들어간 파티는 전부 false

	}

}