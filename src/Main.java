import java.util.*;
import java.io.*;

class Main {
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dp = new int[10001][4];

        int N = Integer.parseInt(br.readLine());

        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[3][2] = 1;
        dp[3][1] = 1;
        dp[3][3] = 1;

        for(int i = 4; i < dp.length; i++) {
            dp[i][1] = dp[i-1][1];
            dp[i][2] = dp[i-2][1] + dp[i-2][2];
            dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
        }
        StringBuilder sb = new StringBuilder();

        while(N --> 0) {
            int n = Integer.parseInt(br.readLine());
            int sum = 0;
            for(int j = 0; j < dp[0].length; j++) {
                sum += dp[n][j];
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }

}