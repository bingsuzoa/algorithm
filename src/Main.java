import java.util.*;
import java.io.*;


class Main {
    static int[] dp;
    static int[] graph;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new int[N];
        graph = new int[N];

        for(int i = 0; i < N; i++) {
            graph[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0;i < graph.length; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(graph[j] < graph[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(N - max);
    }

}