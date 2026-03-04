import java.util.*;
import java.io.*;

class Main {
    static Set<Integer> set;
    static int[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        graph = new int[N + 1];

        for(int i =1 ; i < graph.length; i++) {
            graph[i] = Integer.parseInt(br.readLine());
        }

        set = new HashSet<>();
        boolean[] visited = new boolean[N+1];
        for(int i = 1; i < graph.length; i++) {
            Arrays.fill(visited, false);
            if(graph[i] >= graph.length) continue;
            visited[i] = true;
            if(check(graph[i], i, visited)) {
                isFill(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(set.size()).append("\n");
        int[] answer = new int[set.size()];
        int idx = 0;
        for(int value : set) {
            answer[idx++] = value;
        }
        Arrays.sort(answer);

        for(int value : answer) {
            sb.append(value).append("\n");
        }

        System.out.println(sb);
    }
    private static boolean check(int pos, int start, boolean[] visited) {
        if(pos == start) {
            return true;
        }
        if(visited[pos] || graph[pos] >= graph.length) {
            return false;
        }
        visited[pos] = true;
        return check(graph[pos], start, visited);
    }

    private static void isFill(int pos) {
        if(set.contains(pos)) return;

        set.add(pos);
        isFill(graph[pos]);
    }

}