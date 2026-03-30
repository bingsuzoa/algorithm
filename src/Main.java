import java.util.*;
import java.io.*;

class Main {
    static int N, M, X;
    static List<int[]>[] list;
    static int[] graph;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        graph = new int[N+1];
        result = new int[N+1];
        Arrays.fill(graph, Integer.MAX_VALUE);
        Arrays.fill(result, Integer.MAX_VALUE);

        for(int i =0 ; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            String[] arr = br.readLine().split(" ");
            int x = Integer.parseInt(arr[0]);
            int y = Integer.parseInt(arr[1]);
            int z = Integer.parseInt(arr[2]);
            list[x].add(new int[]{y, z});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> {
            return o1[1] - o2[1];
        });


        for(int start = 1; start <= N; start++) {
            boolean goBack = false;
            pq.clear();
            Arrays.fill(graph, Integer.MAX_VALUE);
            pq.add(new int[]{start, 0});
            graph[start] = 0;

            while(!pq.isEmpty()) {
                int[] cur = pq.poll();
                int from = cur[0];
                int cost = cur[1];

                if(!goBack && from == X) {
                    result[start] = Math.min(result[start], cost);

                    goBack = true;
                    pq.clear();
                    Arrays.fill(graph, Integer.MAX_VALUE);
                    graph[X] = 0;
                    pq.add(new int[]{X, 0});
                    continue;
                }

                if(goBack && from == start) {
                    result[start] += cost;
                    break;
                }

                for(int[] next : list[from]) {
                    int to = next[0];
                    int toCost = next[1];
                    if(graph[to] > cost + toCost) {
                        graph[to] = cost + toCost;
                        pq.add(new int[]{to, graph[to]});
                    }
                }
            }
        }

        int max = 0;
        for(int i = 1; i < result.length; i++) {
            max = Math.max(max, result[i]);
        }
        System.out.println(max);
    }
}