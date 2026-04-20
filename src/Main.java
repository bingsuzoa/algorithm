import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static List<int[]>[] list;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        dp = new long[N + 1];

        for(int i = 0;i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[1] = 0;

        for(int i =0 ;i < M; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st1.nextToken());
            int B = Integer.parseInt(st1.nextToken());
            list[A].add(new int[]{i, B});
            list[B].add(new int[]{i, A});
        }



        PriorityQueue<long[]> pq = new PriorityQueue<>((o1, o2) -> {
            return Long.compare(o1[0],o2[0]);
        });

        //초, 출발지, cycle
        pq.add(new long[]{0, 1});
        while(!pq.isEmpty()) {
            long[] cur = pq.poll();
            long minute = cur[0];
            long from = cur[1];

            if(dp[(int)from] < minute) continue;

            if(from == N) {
                System.out.println(minute);
                return;
            }

            for(int[] next : list[(int)from]) {
                int time = next[0];
                int to = next[1];

                long nextTime;
                if(minute <= time) {
                    nextTime = time;
                } else {
                    long cycle = ((minute - time) + (M - 1)) / M;
                    nextTime = time + M * cycle;
                }

                if(dp[to] > nextTime + 1) {
                    dp[to] = nextTime + 1;
                    pq.add(new long[]{nextTime + 1, to});
                }
            }
        }
    }

}