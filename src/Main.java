import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];

        if(N == 1) {
            dp[1] = 1;
            System.out.println(1);
            return;
        }
        if(N == 2) {
            dp[1] = 1;
            dp[2] = 2;
            System.out.println(2);
            return;
        }

        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i < dp.length; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }

        System.out.println(dp[N] % 10007);
    }

}