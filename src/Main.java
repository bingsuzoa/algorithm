import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[] graph;
    static boolean[] checked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new int[N];
        checked = new boolean[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i < N; i++) {
            graph[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int count = 0;
        while(start < graph.length) {
            while(end < graph.length && !checked[graph[end]]) {
                checked[graph[end]] = true;
                end++;
            }

            count += (end - start);
            checked[graph[start]] = false;
            start++;
        }
        System.out.println(count);
    }
}