import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] visited = new int[200000];
        Arrays.fill(visited, 100010);
        visited[N] = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{N, 0});

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int pos = cur[0];
            int cost = cur[1];

            if(pos == K) {
                visited[pos] = Math.min(visited[pos], cost);
                continue;
            }

            int walk = pos + 1;
            int fly = pos * 2;
            int back = pos - 1;
            if(walk < visited.length && visited[walk] > cost + 1) {
                visited[walk] = cost + 1;
                queue.add(new int[]{walk, cost + 1});
            }
            if(fly < visited.length && visited[fly] > cost + 1) {
                visited[fly] = cost + 1;
                queue.add(new int[]{fly, cost + 1});
            }
            if(back >= 0 && visited[back] > cost + 1) {
                visited[back] = cost + 1;
                queue.add(new int[]{back, cost + 1});
            }
        }
        System.out.println(visited[K]);
    }
}