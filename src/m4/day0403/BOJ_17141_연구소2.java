package m4.day0403;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17141_연구소2 {

    static class virus {
        int x, y, cnt;

        public virus(int x, int y, int cnt) {
            super();
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

    }

    static int N, M;
    static int dx[] = { -1, 0, 1, 0 };
    static int dy[] = { 0, -1, 0, 1 };
    static int map[][];
    static boolean visited[][];
    static int zeroCnt;
    static ArrayList<Point> viruss;
    static int selectedVirus[];

    static boolean isSelected[];
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // N * N
        M = Integer.parseInt(st.nextToken()); // M개를 선택할거임
        int cnt = 0;
        map = new int[N][N];
        viruss = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == 0) {
                    zeroCnt++;
                }
                if (temp == 2) {
                    viruss.add(new Point(i, j));
                    zeroCnt++;
                }

                map[i][j] = temp;

            }

        } // input end

        isSelected = new boolean[viruss.size()];
        comb(0, 0);

        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }

    }

    private static void bfs(int[] selectedVirus) {
        Queue<virus> q = new LinkedList<>();
        visited = new boolean[N][N];
        int cnt = 0;
        int copyMap[][] = deepCopy();
        for (int i = 0; i < M; i++) {
            Point now = viruss.get(selectedVirus[i]);
            q.add(new virus(now.x, now.y, 0));
            cnt++;
            visited[now.x][now.y] = true;
        }
        int minTime = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            minTime++;
            for (int T = 0; T < size; T++) {

                virus now = q.poll();
                int time = now.cnt;
                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < N && copyMap[nx][ny] != 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        copyMap[nx][ny] = now.cnt + 10;
                        cnt++;
                        if (zeroCnt == cnt) {
//                        for (int[] temp : copyMap) {
//                            System.out.println(Arrays.toString(temp));
//                        }
//                        System.out.println(now.cnt);
                        result = Math.min(result, now.cnt+1);
                    }
                        q.add(new virus(nx, ny, now.cnt + 1));
                    }

                }
            }

            if (zeroCnt == cnt) {
//                for (int[] temp : copyMap) {
//                    System.out.println(Arrays.toString(temp));
//                }
//                System.out.println(now.cnt);
                result = Math.min(result, minTime);
            }
        }

    }
    
    

    private static void comb(int idx, int start) {
        if (idx == M) {
            selectedVirus = new int[idx];
            int cnt = 0;
            for (int i = 0; i < isSelected.length; i++) {
                if (isSelected[i] == true) {
                    // System.out.print(i + " ");
                    selectedVirus[cnt++] = i;
//                    System.out.println(Arrays.toString(selectedVirus));
                    bfs(selectedVirus);
                }
            }
            return;
        }

        for (int i = start; i < viruss.size(); i++) {
            isSelected[i] = true;
            comb(idx + 1, i + 1);
            isSelected[i] = false;

        }

    }

    private static int[][] deepCopy() {
        int copyMap[][] = new int[N][N];
        for (int i = 0; i < copyMap.length; i++) {
            for (int j = 0; j < copyMap.length; j++) {
                copyMap[i][j] = map[i][j];
            }
        }
        return copyMap;
    }

}