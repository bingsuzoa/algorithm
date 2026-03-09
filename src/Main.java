import java.util.*;
import java.io.*;

class Main {
    static int[][] graph;
    static boolean[][] visited;
    static int[][] flaged;
    static Queue<int[]> queue;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int N,L,H;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        graph = new int[N][N];
        visited = new boolean[N][N];
        flaged = new int[N][N];
        queue = new LinkedList<>();

        for(int i= 0; i < graph.length; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for(int j =0 ; j < graph[i].length; j++) {
                graph[i][j] = Integer.parseInt(st1.nextToken());
            }
        }

        int answer = 0;
        int num = 1000;
        while(true) {
            boolean isPossible = false;
            answer++;

            for(int i =0 ; i < visited.length; i++) {
                Arrays.fill(visited[i], false);
            }

            for(int i = 0; i < graph.length; i++) {
                for(int j = 0; j < graph[i].length; j++) {
                    if(visited[i][j]) continue;
                    visited[i][j] = true;
                    flaged[i][j] = num;
                    if(bfs(i,j,num)) {
                        isPossible = true;
                    }
                    num++;
                }
            }
            if(!isPossible) {
                answer -= 1;
                break;
            }
        }
        System.out.println(answer);
    }

    private static boolean bfs(int sx, int sy, int snum) {
        queue.clear();

        queue.add(new int[]{sx, sy});

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for(int i =0 ; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= graph.length || nx < 0 || ny >= graph[0].length || ny < 0) {
                    continue;
                }
                if(visited[nx][ny]) continue;

                int diff = Math.abs(graph[x][y] - graph[nx][ny]);
                if(diff < L || diff > H) {
                    continue;
                }
                visited[nx][ny] = true;
                flaged[nx][ny] = snum;
                queue.add(new int[]{nx, ny});
            }
        }

        int totalSum = 0;
        int totalCount = 0;
        for(int i = 0; i < flaged.length; i++) {
            for(int j =0 ; j  < flaged[0].length; j++) {
                if(flaged[i][j] == snum) {
                    totalCount++;
                    totalSum += graph[i][j];
                }
            }
        }
        if(totalCount <= 1) {
            return false;
        }
        int nextSum = totalSum / totalCount;
        for(int i = 0; i < flaged.length; i++) {
            for(int j =0 ; j < flaged[0].length; j++) {
                if(flaged[i][j] == snum) {
                    graph[i][j] = nextSum;
                }
            }
        }
        return true;
    }
}