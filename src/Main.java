import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[12];
        dp[1] = 1;

        StringBuilder sb = new StringBuilder();

        for(int i = 2; i < dp.length; i++) {
            for(int j = 1; j <= 3; j++) {
                if(i - j >= 1) {
                    dp[i] += dp[i-j];
                }
            }
            if(i <= 3) {
                dp[i]++;
            }
        }
        while(N --> 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append("\n");
        }
        System.out.println(sb);
    }
}