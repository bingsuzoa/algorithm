import java.util.*;
import java.io.*;

class Main {
    static int N, a, b;
    static int[] graph;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        graph = new int[N];

        int tag = 1;
        int idx = 0;
        int max = 0;
        while(a > 0) {
            if(idx >= graph.length) {
                System.out.println(-1);
                return;
            }
            graph[idx++] = tag++;
            a--;
        }

        if(idx == graph.length) {
            if(b == 1) {
                getAnswer(0);
            } else {
                System.out.println(-1);
            }
            return;
        }

        max = tag - 1;
        tag = 1;
        idx = graph.length - 1;
        while(b > 1) {
            if(max < tag || idx < 0 || graph[idx] != 0) {
                System.out.println(-1);
                return;
            }
            graph[idx--] = tag++;
            b--;
        }

        int need = 0;
        for(int i = 0; i < graph.length; i++) {
            if(graph[i] == 0) need++;
        }
        getAnswer(need);
    }

    private static void getAnswer(int count) {
        sb.setLength(0);

        for(int i = 0; i < count; i++) {
            sb.append(1).append(' ');
        }
        for(int v : graph) {
            if(v == 0) continue;
            sb.append(v).append(' ');
        }

        System.out.println(sb);
    }
}