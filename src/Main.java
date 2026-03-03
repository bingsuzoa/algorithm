import java.util.*;
import java.io.*;

class Main {
    static List<int[]>[] list;
    static int MOD = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+ 1];
        for(int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st1.nextToken());
            int e = Integer.parseInt(st1.nextToken());
            int w = Integer.parseInt(st1.nextToken());

            list[s].add(new int[]{e, w});
            list[e].add(new int[]{s, w});
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((o1,o2) -> {
            return o1[1] - o2[1];
        });

        int[] dist = new int[N + 1];
        Arrays.fill(dist, MOD);
        dist[1] = 0;

        queue.add(new int[]{1, 0});
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int pos = cur[0];
            int count = cur[1];

            if(pos == N) {
                System.out.println(count);
                return;
            }

            for(int[] next : list[pos]) {
                int to = next[0];
                int weight = next[1];
                if(dist[to] > count + weight) {
                    dist[to] = count + weight;
                    queue.add(new int[]{to, dist[to]});
                }
            }
        }
    }
}