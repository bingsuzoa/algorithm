import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{N, 0});


        int[] graph = new int[100001];
        Arrays.fill(graph, 100002);

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int pos = cur[0];
            int time = cur[1];

            if(graph[pos] <= time) continue;
            graph[pos] = time;

            if(pos == 0) {
                if(pos + 1 < graph.length) {
                    queue.add(new int[]{pos + 1, time + 1});
                }
            } else {
                if(pos + 1 < graph.length) {
                    queue.add(new int[]{pos + 1, time + 1});
                }
                if(pos - 1 >= 0) {
                    queue.add(new int[]{pos -1, time + 1});
                }
                if(pos * 2 < graph.length) {
                    queue.add(new int[]{pos * 2, time});
                }
            }

        }
        System.out.println(graph[K]);
    }
}