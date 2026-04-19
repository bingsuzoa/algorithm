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
        dp = new int[N][M][2];

        for(int i = 0;i < graph.length; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for(int j = 0; j < graph[0].length; j++) {
                graph[i][j] = Integer.parseInt(st1.nextToken());
            }
        }

        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[i].length; j++) {
                Arrays.fill(dp[i][j], -1000001);
            }
        }
        dp[0][0][0] = graph[0][0];
        dp[0][0][1] = graph[0][0];

        for(int j = 1; j < graph[0].length; j++) {
            dp[0][j][0] = dp[0][j-1][0] + graph[0][j];
            dp[0][j][1] = dp[0][j][0];
        }

        for(int i = 1; i < graph.length; i++) {
            //left
            for(int j = 0; j < graph[0].length; j++) {
                int up = Math.max(dp[i-1][j][0], dp[i-1][j][1]);
                if(j == 0) {
                    dp[i][j][0] = Math.max(dp[i][j][0], up + graph[i][j]);
                } else {
                    dp[i][j][0] = Math.max(dp[i][j][0], up + graph[i][j]);
                    dp[i][j][0] = Math.max(dp[i][j][0], dp[i][j-1][0]  + graph[i][j]);
                }
            }

            //right
            for(int j = graph[0].length -1; j >= 0; j--) {
                int up = Math.max(dp[i-1][j][0], dp[i-1][j][1]);

                if(j == graph[0].length -1) {
                    dp[i][j][1] = Math.max(dp[i][j][1], up  + graph[i][j]);
                } else {
                    dp[i][j][1] = Math.max(dp[i][j][1], up  + graph[i][j]);
                    dp[i][j][1] = Math.max(dp[i][j][1], dp[i][j+1][1]  + graph[i][j]);
                }
            }
        }
        System.out.println(Math.max(dp[N-1][M-1][0], dp[N-1][M-1][1]));
    }
}