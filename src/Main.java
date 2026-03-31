import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        System.out.println(solution(10, 18, 1, 5));
    }

    private static int solution(int S, int T, int X, int Y) {
        int[][] dp = new int[1002][1002];
        for(int i =0 ; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        return dfs(dp, S, T, X, Y);
    }

    private static int dfs(int[][] dp, int bs, int T, int bx, int Y) {
        if(dp[bs][bx] != Integer.MAX_VALUE) {
            return dp[bs][bx];
        }
        if(step2(bs, T, bx, Y)) {
            return 0;
        }
        dp[bs][bx] = Math.min(dp[bs][bx], dfs(dp, bs + 1, T, bx, Y) + 1);
        dp[bs][bx] = Math.min(dp[bs][bx], dfs(dp, bs , T, bx + 1, Y) + 1);
        return dp[bs][bx];
    }

    private static boolean step2(int S, int T, int X, int Y) {
        int minseo = S % Y == 0 ? S / Y : S / Y + 1;
        int monster = T % X == 0 ? T / X : T / X + 1;

        if(minseo >= monster) {
            return true;
        }
        return false;
    }
}