import java.util.*;
import java.io.*;

class Main {
    static char[][] graph;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0,0, 1, -1};
    static int max = 0;
    static Map<Character, Integer> map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new char[N][M];
        visited = new boolean[26];

        map = new HashMap<>();
        int idx = 0;
        for(char i = 'A'; i <= 'Z'; i++) {
            map.put(i, idx++);
        }

        for(int i = 0; i < graph.length; i++) {
            String input = br.readLine();
            for(int j = 0; j < graph[i].length; j++) {
                graph[i][j] = input.charAt(j);
            }
        }
        visited[map.get(graph[0][0])] = true;
        dfs(0, 0, 1);
        System.out.println(max);

    }

    private static void dfs(int sx, int sy, int count) {

        for(int i =0 ; i < 4; i++) {
            int nx = sx + dx[i];
            int ny = sy + dy[i];
            if(nx >= graph.length || nx < 0 || ny >= graph[0].length || ny < 0) continue;
            if(visited[map.get(graph[nx][ny])]) continue;
            visited[map.get(graph[nx][ny])] = true;
            dfs(nx, ny, count + 1);
            visited[map.get(graph[nx][ny])] = false;
        }
        max = Math.max(max, count);
    }
}