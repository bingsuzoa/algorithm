import java.util.*;
import java.io.*;

class Main {
    static int C, N;
    static int[] dp;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        dp = new int[C + 100];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i = 0 ; i < N; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st1.nextToken());
            int value = Integer.parseInt(st1.nextToken());

            for(int j = value; j < dp.length; j++) {
                if(dp[j-value] == Integer.MAX_VALUE)  continue;
                    dp[j] = Math.min(dp[j], dp[j - value] + cost);
            }
        }

        int max = Integer.MAX_VALUE;
        for(int i = C; i < dp.length; i++) {
            max = Math.min(max, dp[i]);
        }
        System.out.println(max);
    }
}