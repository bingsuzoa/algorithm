import java.util.*;
import java.io.*;

class Main {
    static int[] dp;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        System.out.println(dfs(N));
    }

    private static int dfs(int N) {
        if(dp[N] != Integer.MAX_VALUE) {
            return dp[N];
        }
        if(N == 1) {
            return 0;
        }
        if(N % 3 == 0) {
            dp[N] = Math.min(dp[N], dfs(N/3) + 1);
        }
        if(N % 2 == 0) {
            dp[N] = Math.min(dp[N], dfs(N/2) + 1);
        }
        dp[N] = Math.min(dp[N], dfs(N-1) + 1);
        return dp[N];
    }
}