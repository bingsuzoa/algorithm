import java.util.*;
import java.io.*;

class Main {
    static int N, C;
    static long[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        graph = new long[N];
        for(int i = 0; i < graph.length; i++) {
            graph[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(graph);

        long right = graph[graph.length - 1];
        long left = 1;

        while(left <= right) {
            long min = (left + right) / 2;

            if(isPossible(min)) {
                left = min + 1;
            } else {
                right = min - 1;
            }
        }
        System.out.println(right);

    }

    private static boolean isPossible(long min) {
        int count = 1;
        long sum = 0;

        for(int i = 1; i < graph.length; i++) {
            sum += (graph[i] - graph[i-1]);
            if(sum >= min) {
                sum = 0;
                count ++;
                if(count == C) return true;
            }
        }
        if(count == C) {
            return true;
        }
        return false;
    }
}