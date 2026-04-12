import java.util.*;
import java.io.*;

class Main {
    static int[] graph;
    static int[] dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        while(N --> 0) {
            int n = Integer.parseInt(br.readLine());
            graph = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < graph.length; i++) {
                graph[i] = Integer.parseInt(st.nextToken());
            }

            int goal = Integer.parseInt(br.readLine());
            dp = new int[goal + 1];
            dp[0] = 1;

            for(int coin : graph) {
                for(int i = coin; i <= goal; i++) {
                    dp[i] += dp[i - coin];
                }
            }
            sb.append(dp[goal]).append("\n");
        }
        System.out.println(sb);
    }
}