import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int[][] graph;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        dp = new int[N][M][2];

        for (int i = 0; i < graph.length; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for (int j = 0; j < graph[i].length; j++) {
                graph[i][j] = Integer.parseInt(st1.nextToken());
            }
        }
        for(int i= 0; i < dp.length; i++) {
            for(int j =0 ; j < dp[i].length;j++) {
                Arrays.fill(dp[i][j], -100000001);
            }
        }

        for (int j = 0; j < graph[0].length; j++) {
            if (j == 0) {
                dp[0][0][0] = graph[0][0];
            } else {
                dp[0][j][0] = graph[0][j] + dp[0][j - 1][0];
            }
            dp[0][j][1] = dp[0][j][0];
        }

        for(int i = 1; i < graph.length; i++) {
            for(int j = 0; j < graph[i].length; j++) {
                int up = Math.max(dp[i-1][j][0], dp[i-1][j][1]) + graph[i][j];
                if(j == 0) {
                    dp[i][j][0] = Math.max(dp[i][j][0], up);
                } else {
                    int left = dp[i][j-1][0] + graph[i][j];
                    dp[i][j][0] = Math.max(dp[i][j][0], Math.max(up, left));
                }
            }

            for(int j = graph[i].length - 1; j >= 0; j--) {
                int up = Math.max(dp[i-1][j][0], dp[i-1][j][1]) + graph[i][j];
                if(j == M-1) {
                    dp[i][j][1] = Math.max(dp[i][j][1], up);
                } else {
                    int right = dp[i][j+1][1] + graph[i][j];
                    dp[i][j][1] = Math.max(dp[i][j][1], Math.max(up, right));
                }
            }
        }

        System.out.println(Math.max(dp[N - 1][M - 1][1], dp[N - 1][M - 1][0]));
    }
}