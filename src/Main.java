import java.util.*;
import java.io.*;

class Main {
    static int N,K;
    static int[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new int[K+1];

        for(int i =0; i < N; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st1.nextToken());
            int v = Integer.parseInt(st1.nextToken());

            for(int j = K; j >= w; j--) {
                graph[j] = Math.max(graph[j], graph[j - w] + v);
            }
        }
        int max = 0;
        for(int i =0; i < graph.length; i++) {
            max = Math.max(max, graph[i]);
        }
        System.out.println(max);
    }
}