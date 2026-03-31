import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        int[] answer = solution(7, 7, 1, 7, new int[]{1, 1, 7, 2, 5, 3, 6}, new int[]{2, 3, 3, 5, 4, 2, 7});
        System.out.println(answer[0] + " " + answer[1]);
    }

    private static int[] solution(int V, int E, int A, int B, int[] x, int[] y) {
        int[] answer = new int[2];
        List<int[]>[] list = init(V, E, A, B, x, y);

        int[][] graph = new int[V + 1][2];
        for(int i = 0; i < graph.length; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> {
            if(o1[1] == o2[1]) {
                return o1[2] - o2[2];
            }
            return o1[1] - o2[1];
        });

        pq.add(new int[]{A, 0, 0, 0, 0});
        graph[A][0] = 0;
        graph[A][1] = 0;

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int from = cur[0];
            int cost = cur[1];
            int totalCount = cur[2];
            int upCount = cur[3];
            int downCount =cur[4];

            if(cost > graph[from][0]) continue;
            if(cost == graph[from][0] && totalCount > graph[from][1]) continue;

            if(from == B) {
                answer[0] = upCount;
                answer[1] = downCount;
                break;
            }

            for(int[] next : list[from]) {
                int to = next[0];
                int toCost = next[1];

                if(graph[to][0] > cost + toCost || (graph[to][0] == cost + toCost && graph[to][1] > totalCount + 1)) {
                    graph[to][0] = cost + toCost;
                    graph[to][1] = totalCount + 1;
                    if(toCost == 1) {
                        pq.add(new int[]{to, graph[to][0], graph[to][1], upCount + 1, downCount});
                    } else {
                        pq.add(new int[]{to, graph[to][0], graph[to][1], upCount, downCount + 1});
                    }
                }
            }
        }
        return answer;
    }

    private static List<int[]>[] init(int V, int E, int A, int B, int[] x, int[] y) {
        List<int[]>[] list = new ArrayList[V + 1];

        for(int i =0 ; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < x.length; i++) {
            int start = x[i];
            int end = y[i];
            list[start].add(new int[]{end, 1});
            list[end].add(new int[]{start, 0});
        }
        return list;
    }
}