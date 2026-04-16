import java.util.*;
import java.io.*;

class Main {
    static int N,M;
    static int[][] graph;
    static int[][] lefts;
    static int[][] rights;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        lefts = new int[N][M];
        rights = new int[N][M];
        dp = new int[N][M];

        for(int i = 0; i < graph.length; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for(int j = 0; j < graph[i].length; j++) {
                graph[i][j] = Integer.parseInt(st1.nextToken());
            }
        }

        for(int i = 0; i < graph.length; i++) {
            for(int j = 0;j < graph[i].length; j++) {
                lefts[i][j] = -2000000001;
                rights[i][j] = -2000000001;
            }
        }

        for(int j = 0; j < graph[0].length; j++) {
            if(j == 0) {
                lefts[0][j] = graph[0][j];
                rights[0][j] = graph[0][j];
            } else {
                lefts[0][j] = lefts[0][j-1] + graph[0][j];
                rights[0][j] = lefts[0][j];
            }
            dp[0][j] = lefts[0][j];
        }

        for(int i = 1; i < graph.length; i++) {
            for(int j = 0; j < graph[i].length; j++) {
                if(j == 0) {
                    lefts[i][j] = Math.max(lefts[i][j], dp[i-1][j] + graph[i][j]);
                } else {
                    lefts[i][j] = Math.max(lefts[i][j], Math.max(dp[i-1][j], lefts[i][j-1]) + graph[i][j]);
                }
            }
            for(int j = graph[i].length - 1; j >= 0; j--) {
                if(j == M-1) {
                    rights[i][j] = Math.max(rights[i][j], dp[i-1][j] + graph[i][j]);
                } else {
                    rights[i][j] = Math.max(rights[i][j], Math.max(dp[i-1][j], rights[i][j+1]) + graph[i][j]);
                }
            }
            for(int j = 0;j < graph[i].length; j++) {
                dp[i][j] = Math.max(lefts[i][j], rights[i][j]);
            }
        }

        System.out.println(dp[N-1][M-1]);
    }

}