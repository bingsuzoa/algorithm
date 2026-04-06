import java.util.*;
import java.io.*;

class Main {
    static int[] graph;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        graph = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i++) {
            graph[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N + 1][3];

        Stack<Integer> stack = new Stack<>();
        for(int i = 1; i <= N; i++) {

            while(!stack.isEmpty() && graph[stack.peek()] <= graph[i]) {
                stack.pop();
            }
            dp[i][2] += stack.size();
            if(!stack.isEmpty()) {
                dp[i][1] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear();

        for(int i = N; i>= 1; i--) {

            while(!stack.isEmpty() && graph[stack.peek()] <= graph[i]) {
                stack.pop();
            }
            dp[i][2] += stack.size();
            if(!stack.isEmpty()) {
                int tmp =  stack.peek();
                if(dp[i][1] == 0 || Math.abs(i - tmp) < Math.abs(dp[i][1] - i)) {
                    dp[i][1] = tmp;
                }
                else if(Math.abs(i - tmp) == Math.abs(dp[i][1] - i)) {
                    if(tmp < dp[i][1]) {
                        dp[i][1] = tmp;
                    }
                }

            }
            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            if(dp[i][2] == 0) {
                sb.append("0").append("\n");
            } else {
                sb.append(dp[i][2] + " " + dp[i][1]).append("\n");
            }
        }
        System.out.println(sb);
    }
}