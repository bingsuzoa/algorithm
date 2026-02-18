import java.util.*;
import java.io.*;

class Main {
    static int[][] graph;
    static int[] dx = {1, 1, 1};
    static int[] dy = {0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];

        for(int i = 0; i < N; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st1.nextToken());
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        for(int j = 0; j < M; j++) {
            queue.add(new int[]{0, j, -1, graph[0][j]});
        }

        int answer = Integer.MAX_VALUE;

        while(!queue.isEmpty()) {
            int[] befo = queue.poll();
            int x = befo[0];
            int y = befo[1];
            int dir = befo[2];
            int cost = befo[3];

            if(x == N-1) {
                answer = Math.min(answer, cost);
                continue;
            }

            for(int i = 0; i < 3; i++) {
                if(dir == i) continue;
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= N || nx < 0 || ny >= M || ny < 0) continue;
                queue.add(new int[]{nx, ny, i, cost + graph[nx][ny]});
            }

        }
        System.out.println(answer);

    }
}