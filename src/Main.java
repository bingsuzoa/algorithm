import java.util.*;
import java.io.*;

class Main {
    static int[][] graph;
    static int[][][] dp;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        dp = new int[N][M][2];
        for(int i = 0; i < dp.length; i++) {
            for(int j =0 ; j < dp[i].length; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }

        for(int i = 0; i < graph.length; i++) {
            String input = br.readLine();
            for(int j =0; j < input.length(); j++) {
                graph[i][j] = input.charAt(j) - '0';
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> {
            return o1[2] - o2[2];
        });

        pq.add(new int[]{0, 0, 0, 0});

        //0 - 벽안부수고 이동, 1 벽부수고 이동했을 때 최소 이동횟수
        dp[0][0][0] = 1;

        int max = Integer.MAX_VALUE;
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[0];
            int y = cur[1];
            int count = cur[2];
            int busuda = cur[3];

            if(dp[x][y][busuda] <= count) continue;
            if(x == N-1 && y == M-1) {
                max = Math.min(dp[N-1][M-1][0], max);
                max = Math.min(dp[N-1][M-1][1], max);
                break;
            }

            for(int i = 0; i< 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= graph.length || ny < 0 ||ny >= graph[0].length) continue;

                if(graph[nx][ny] == 0 && dp[nx][ny][busuda] > count + 1) {
                    dp[nx][ny][busuda] = count + 1;
                    pq.add(new int[]{nx, ny, count + 1, busuda});
                } else {
                    if(busuda == 1) continue;
                    if(dp[nx][ny][1] > count + 1) {
                        dp[nx][ny][1] = count + 1;
                        pq.add(new int[]{nx, ny, count + 1, 1});
                    }
                }

            }
        }
        if(max == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(max);
        }
    }

}