import java.util.*;
import java.io.*;

class Main {
    static int[][] graph;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];

        for(int i = 0; i < N; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st1.nextToken());
            }
        }
        dp = new int[N][M][3];
        for(int i =0 ; i < dp.length; i++) {
            for(int j = 0; j < dp[i].length; j++) {
                Arrays.fill(dp[i][j], 1001);
            }
        }

        for(int j = 0; j < M; j++) {
            for(int k = 0; k < 3; k++) {
                dp[0][j][k] = graph[0][j];
            }
        }

        for(int i = 1; i < dp.length; i++) {
            for(int j = 0; j < dp[i].length; j++) {
                if(j - 1 >= 0) {
                    dp[i][j][0] = Math.min(dp[i-1][j-1][1], dp[i][j][0]);
                    dp[i][j][2] = Math.min(dp[i-1][j-1][1], dp[i][j][2]);
                }
                if(j + 1 < dp[0].length) {
                    dp[i][j][0] = Math.min(dp[i-1][j+1][2], dp[i][j][0]);
                    dp[i][j][1] = Math.min(dp[i-1][j+1][2], dp[i][j][1]);
                }
                dp[i][j][1] = Math.min(dp[i-1][j][0], dp[i][j][1]);
                dp[i][j][2] = Math.min(dp[i-1][j][0], dp[i][j][2]);

                dp[i][j][0] += graph[i][j];
                dp[i][j][1] += graph[i][j];
                dp[i][j][2] += graph[i][j];
            }
        }
        int answer = 1001;
        for(int j = 0; j < dp[0].length; j++) {
            for(int k = 0; k < 3; k++) {
                answer = Math.min(answer, dp[N-1][j][k]);
            }
        }
        System.out.println(answer);
    }
}