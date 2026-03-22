import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[] dist;
    static int[] memori;
    static int MOD = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dist = new int[N+1];
        memori = new int[N+1];
        Arrays.fill(dist, MOD);

        Queue<int[]> queue = new LinkedList<>();
        memori[N] = N;
        dist[N] = 0;
        queue.add(new int[]{N, 0});

        while(!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int cur = tmp[0];
            int count = tmp[1];

            if(cur == 1) break;

            int[] next = new int[3];
            next[0] = cur % 3 == 0 ? cur / 3  : 0;
            next[1] = cur % 2 == 0 ? cur / 2 : 0;
            next[2] = cur - 1;

            for(int i =0 ; i < next.length; i++) {
                if(next[i] == 0) continue;
                if(dist[next[i]] == MOD) {
                    dist[next[i]] = count + 1;
                    memori[next[i]] = cur;
                    queue.add(new int[]{next[i], count + 1});
                }
            }
        }

        Stack<Integer> stack = new Stack<>();
        int idx = 1;
        stack.push(idx);
        while(idx < N) {
            stack.push(memori[idx]);
            idx = memori[idx];
        }

        StringBuilder sb = new StringBuilder();
        sb.append(stack.size() -1).append("\n");
        while(!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
    }
}