import java.util.*;
import java.io.*;

class Main {
    static int[][] dp;
    static int[] graph;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new int[N + 1];
        for(int i = 1; i < graph.length; i++) {
            graph[i] = Integer.parseInt(br.readLine());
        }

        dp = new int[N + 1][3];
        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -10000);
        }

        dfs(0, 0);
        int max  = -100000;
        for(int value : dp[0]) {
            max = Math.max(value, max);
        }
        System.out.println(max);
    }

    private static int dfs(int cur, int count) {
        if(cur >= graph.length) {
            return -10000;
        }
        if(dp[cur][count] != -10000) {
            return dp[cur][count];
        }
        if(cur == N) {
            return graph[N];
        }
        if(count == 2) {
            dp[cur][count] = Math.max(dp[cur][count], dfs(cur + 2, 1) + graph[cur]);
        } else {
            dp[cur][count] = Math.max(dp[cur][count], dfs(cur + 1, count + 1) + graph[cur]);
            dp[cur][count] = Math.max(dp[cur][count], dfs(cur + 2, 1) + graph[cur]);
        }
        return dp[cur][count];
    }
}