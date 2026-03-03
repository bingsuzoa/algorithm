import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        StringTokenizer st1 = new StringTokenizer(br.readLine());

        int[] graph = new int[M];
        for(int i =0 ; i < graph.length; i++) {
            graph[i] = Integer.parseInt(st1.nextToken());
        }

        if(N <= 2) {
            System.out.println(0);
            return;
        }

        int count = 0;
        for(int i = 1; i < graph.length - 1; i++) {
            int[] info = getMax(i, graph);

            int min = Math.min(info[0], info[1]);
            if(min >= graph[i]) {
                count += min - graph[i];
            }
        }

        System.out.println(count);
    }

    private static int[] getMax(int pos, int[] graph) {
        int left = 0;
        int right = 0;
        for(int i = 0; i < pos; i++) {
            left = Math.max(graph[i], left);
        }
        for(int i = pos + 1; i < graph.length; i++) {
            right = Math.max(graph[i], right);
        }
        return new int[]{left, right};
    }
}