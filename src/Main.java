import java.util.*;
import java.io.*;


class Main {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[][] graph;
    static int[][] answer;
    static Queue<int[]> queue;
    static int N,M;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[M][N];
        answer = new int[M][N];
        visited = new boolean[M][N];
        queue = new LinkedList<>();

        int[] goal = new int[2];
        for(int i =0 ; i < graph.length; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for(int j = 0; j < graph[i].length; j++) {
                graph[i][j] = Integer.parseInt(st1.nextToken());

                if(graph[i][j] == 2) {
                    goal[0] = i;
                    goal[1] = j;
                }
            }
        }
        for(int i= 0; i < answer.length; i++) {
            Arrays.fill(answer[i], -1);
        }

        for(int i =0; i < graph.length; i++) {
            for(int j =0 ; j < graph[i].length; j++) {
                if(graph[i][j] == 0) {
                    answer[i][j] = 0;
                }
            }
        }
        bfs(goal[0], goal[1]);

        StringBuilder sb = new StringBuilder();
        for(int i =0 ; i < answer.length; i++) {
            for(int j =0 ; j < answer[i].length; j++) {
                sb.append(answer[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int sx, int sy) {
        queue.add(new int[]{sx, sy, 0});
        visited[sx][sy] = true;
        answer[sx][sy] = 0;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int count = cur[2];

            answer[x][y] = count;

            for(int i =0 ; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= N || nx < 0 || ny >= M || ny < 0) continue;
                if(visited[nx][ny] || graph[nx][ny] == 0) continue;

                visited[nx][ny] = true;
                queue.add(new int[]{nx,ny, count + 1});
            }
        }
    }
}