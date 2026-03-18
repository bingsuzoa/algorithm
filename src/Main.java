import java.util.*;
import java.io.*;

class Main {
    static int N,M;
    static int[] graph;
    static int[] prefix;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer input = new StringTokenizer(br.readLine());
        N = Integer.parseInt(input.nextToken());
        M = Integer.parseInt(input.nextToken());

        graph = new int[N + 1];
        prefix = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1;i < graph.length; i++) {
            graph[i] = Integer.parseInt(st.nextToken());
        }

        prefix[1] = graph[1];
        for(int i = 2; i < prefix.length; i++) {
            prefix[i] = prefix[i-1] + graph[i];
        }

        while(M --> 0) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st1.nextToken());
            int m = Integer.parseInt(st1.nextToken());

            sb.append(prefix[m] - prefix[n-1]).append("\n");
        }
        System.out.println(sb);
    }
}