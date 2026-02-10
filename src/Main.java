import java.util.*;
import java.io.*;

class Main {
    static int[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        graph = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0 ; i < graph.length; i++) {
            graph[i] = Integer.parseInt(st.nextToken());
        }

        int min = Math.max(graph[0], N - graph[graph.length -1]);

        for(int i = 1; i < graph.length; i++) {
            int road = graph[i] - graph[i-1];

            if(min * 2 < road) {
                int diff = road - (min * 2);
                min += (int)Math.ceil((double)diff / 2);
            }
        }
        System.out.println(min);

    }
}