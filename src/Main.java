import java.util.*;
import java.io.*;

class Main {
    static int[][] graph;
    static int[][] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        graph = new int[N][3];

        for(int i =0 ;i < graph.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < graph[i].length; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[N][3];
        for(int i =0 ; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        int answer = Math.min(dfs(0,0), Math.min(dfs(0,1), dfs(0,2)));
        System.out.println(answer);
    }

    private static int dfs(int cur, int color) {
        if(dp[cur][color] != Integer.MAX_VALUE) {
            return dp[cur][color];
        }
        if(cur == dp.length -1) {
            return graph[cur][color];
        }
        for(int next = 0; next < 3; next++) {
            if(next == color) continue;
            dp[cur][color] = Math.min(dp[cur][color], dfs(cur + 1, next) + graph[cur][color]);
        }
        return dp[cur][color];
    }
}