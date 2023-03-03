package test.copy;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1916_최소비용구하기 {
    static class Edge implements Comparable<Edge>{
        int node;
        long weight;
        public Edge(int node, long weight) {
            super();
            this.node = node;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o) {
            // TODO Auto-generated method stub
            return Long.compare(this.weight, o.weight);
        }
    }
    static int N;
    static int M;
    static int adjList[][];
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        adjList = new int[N+1][N+1];
        
        for(int i = 1; i < N+1; i++) {
        	Arrays.fill(adjList[i], Integer.MAX_VALUE);
        }

        
        
        for (int i = 0; i < M; i++) {
        	int a = sc.nextInt();
        	int b = sc.nextInt();
        	int c = sc.nextInt();
        	
        	if(adjList[a][b] > c)
        		adjList[a][b] = c;
        }

        System.out.println(dijkstra(sc.nextInt(), sc.nextInt()));
        
        

    }


    private static long dijkstra(int start, int end) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean visited[] = new boolean[N +1];


        pq.add(new Edge(start,0));

        while(!pq.isEmpty()) {
            Edge now = pq.poll();
            if(visited[now.node]) continue;

            visited[now.node] = true;

            if(now.node == end) {
                return now.weight;
            }

            for(int i = 1; i <= N; i++) {
                if(!visited[i]) {
                    pq.add(new Edge(i, now.weight+ adjList[now.node][i]));
                }
            }

        }
        return 0;

    }

}