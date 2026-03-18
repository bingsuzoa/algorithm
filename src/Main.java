import java.util.*;
import java.io.*;

class Main {
    static int[][] graph;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0,0, 1, -1};
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];

        for(int i = 0; i < graph.length; i++) {
            String input = br.readLine();
            for(int j = 0; j < graph[i].length; j++) {
                graph[i][j] = input.charAt(j) - 'A';
            }
        }

        int startbit = 1 << graph[0][0];
        dfs(startbit, 0, 0, 1);
        System.out.println(max);

    }

    private static void dfs(int bit, int sx, int sy, int count) {
        for(int i = 0; i < 4; i++) {
            int nx = sx + dx[i];
            int ny = sy + dy[i];
            if(nx >= graph.length || nx < 0 || ny >= graph[0].length || ny < 0) continue;

            int next = 1 << graph[nx][ny];
            if((bit & next) != 0) {
                continue;
            }
            dfs(bit | next, nx, ny, count + 1);
        }

        max = Math.max(max, count);
    }

}