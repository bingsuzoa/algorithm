import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static Map<Integer, Integer> stairs;
    static Map<Integer, Integer> snakes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        stairs = new HashMap<>();
        snakes = new HashMap<>();

        int max = 101;
        for(int i = 0; i < N; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st1.nextToken());
            int end = Integer.parseInt(st1.nextToken());
            max = Math.max(max, Math.max(start, end));
            stairs.put(start, end);
        }

        for(int i = 0; i < M; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st1.nextToken());
            int end = Integer.parseInt(st1.nextToken());
            max = Math.max(max, Math.max(start, end));
            snakes.put(start, end);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> {
            return o1[1] - o2[1];
        });

        pq.add(new int[]{1, 0});
        int[] dist = new int[max];
        Arrays.fill(dist, max + 1);
        dist[1] = 0;

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int pos = cur[0];
            int count = cur[1];

            if(pos == 100) {
                System.out.println(count);
                return;
            }

            for(int i = 1; i <= 6; i++) {
                int next = pos + i;
                if(next > 100) break;

                while(stairs.containsKey(next)) {
                    next = stairs.get(next);
                }
                while(snakes.containsKey(next)) {
                    next = snakes.get(next);
                }
                if(dist[next] > count + 1) {
                    dist[next] = count + 1;
                    pq.add(new int[]{next, count + 1});
                }
            }
        }
    }
}