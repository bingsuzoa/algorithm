import java.util.*;
import java.io.*;

class Main {
    static char[][] graph;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0,0, 1, -1};
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new char[N][M];

        for(int i = 0; i < graph.length; i++) {
            String input = br.readLine();
            for(int j = 0; j < graph[i].length; j++) {
                graph[i][j] = input.charAt(j);
            }
        }
        dfs(0, 0, "", 1);
        System.out.println(max);

    }

    private static void dfs(int sx, int sy, String sb, int count) {
        sb += String.valueOf(graph[sx][sy]);

        for(int i = 0; i < 4; i++) {
            int nx = sx + dx[i];
            int ny = sy + dy[i];
            if(nx >= graph.length || nx < 0 || ny >= graph[0].length || ny < 0) continue;
            char next = graph[nx][ny];

            if(sb.contains(String.valueOf(next))) continue;
            dfs(nx, ny, sb + String.valueOf(next), count + 1);
        }

        max = Math.max(max, count);
    }
}