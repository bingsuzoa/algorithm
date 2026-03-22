import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[] counts;
    static int[] memori;
    static int MOD = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        counts = new int[N+1];
        Arrays.fill(counts, MOD);
        memori = new int[N+1];
        memori[N] = N;
        counts[N] = 0;

        dfs(N, N, 0);

        Stack<Integer> stack = new Stack<>();
        int idx = 1;
        stack.push(idx);
        while(idx < N) {
            stack.push(memori[idx]);
            idx = memori[idx];
        }

        StringBuilder sb = new StringBuilder();
        sb.append(stack.size() - 1).append("\n");
        while(!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);

    }
    private static void dfs(int cur, int befo, int count) {
        if(cur == 1) return;

        if(cur % 3 == 0) {
            if(counts[cur/3] > count + 1) {
                counts[cur/3] = count + 1;
                memori[cur/3] = cur;
                dfs(cur/3, cur, count + 1);
            }
        }
        if(cur % 2 == 0) {
            if(counts[cur/2] > count + 1) {
                counts[cur/2] = count + 1;
                memori[cur/2] = cur;
                dfs(cur/2, cur, count + 1);
            }
        }
        if(counts[cur -1] > count + 1) {
            counts[cur-1] = count + 1;
            memori[cur-1] = cur;
            dfs(cur -1, cur, count + 1);
        }
    }
}