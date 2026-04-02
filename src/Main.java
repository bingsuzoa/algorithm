import java.util.*;
import java.io.*;

class Main {
    static int[][] graph;
    static int[][][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        visited = new int[N][M][2];

        for(int i = 0; i < graph.length; i++) {
            String input = br.readLine();
            for(int j =0; j < input.length(); j++) {
                graph[i][j] = input.charAt(j) - '0';
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1, 0});
        visited[0][0][0] = 1;

        int min = Integer.MAX_VALUE;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int count = cur[2];
            int broken = cur[3];

            if(x == N-1 && y == M-1) {
                min = Math.min(min, count);
                break;
            }

            for(int i = 0;i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= graph.length || ny < 0 || ny >= graph[0].length) continue;

                if(graph[nx][ny] == 0) {
                    if(visited[nx][ny][0] == 0) {
                        visited[nx][ny][0] = 1;
                        queue.add(new int[]{nx, ny, count +1, broken});
                    }
                } else {
                    if(broken == 0 && visited[nx][ny][1] == 0 ) {
                        visited[nx][ny][1] = 1;
                        queue.add(new int[]{nx, ny, count + 1, 1});
                    }
                }
            }
        }

        if(min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }

}