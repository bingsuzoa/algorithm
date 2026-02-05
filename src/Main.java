import java.util.*;
import java.io.*;

class Main {
    static int MOD = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        Arrays.fill(dp, MOD);

        dp[0] = MOD;
        dp[1] = MOD;
        if(N <= 1) {
            System.out.println(-1);
            return;
        }
        dp[2] = 1;
        if(N == 2) {
            System.out.println(1);
            return;
        }
        if(N == 3) {
            System.out.println(-1);
            return;
        }
        if(N == 4) {
            System.out.println(2);
            return;
        }
        dp[5] = 1;

        for(int i = 3; i < dp.length; i++) {
            dp[i] = Math.min(dp[i], dp[i-2] + 1);
            if(i - 5 >= 0) {
                dp[i] = Math.min(dp[i], dp[i-5] + 1);
            }
        }

        if(dp[N] == MOD) {
            System.out.println(-1);
        } else {
            System.out.println(dp[N]);
        }
    }
}