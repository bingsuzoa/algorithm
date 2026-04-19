import java.util.*;
import java.io.*;

class Main {
    static int N, K;
    static PriorityQueue<int[]> pq;
    static PriorityQueue<Long> weights;
    static long answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        pq = new PriorityQueue<>((o1,o2) -> {
            return o1[0] - o2[0];
        });

        while(N --> 0) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st1.nextToken());
            int V = Integer.parseInt(st1.nextToken());
            pq.add(new int[]{M,V});
        }

        weights = new PriorityQueue<>((o1,o2) -> {
            return o1.compareTo(o2);
        });

        while(K --> 0) {
            weights.add(Long.parseLong(br.readLine()));
        }

        PriorityQueue<int[]> tmp = new PriorityQueue<>((o1,o2) -> {
            if(o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o2[1] - o1[1];
        });
        while(!weights.isEmpty()) {
            long bagWeight = weights.poll();

            while(!pq.isEmpty() && pq.peek()[0] <= bagWeight) {
                tmp.add(pq.poll());
            }

            if(!tmp.isEmpty()) {
                answer += tmp.poll()[1];
            }
        }
        System.out.println(answer);
    }
}