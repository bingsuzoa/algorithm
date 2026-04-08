import java.util.*;
import java.io.*;

class Main {
    static int N,M;
    static int[][] graph;
    static List<int[]> list = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];

        for(int i =0 ; i < N; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for(int j = 0;j < M; j++) {
                graph[i][j] = Integer.parseInt(st1.nextToken());
                if(graph[i][j] != 0) {
                    if(graph[i][j] == 6)continue;
                    list.add(new int[]{i,j});
                }
            }
        }

        dfs(0);
        System.out.println(answer);
    }
    private static void dfs(int cur) {
        if(cur == list.size()) {
            check();
            return;
        }

        int[] tmp = list.get(cur);
        int x = tmp[0];
        int y = tmp[1];
        int n = graph[x][y];

        if(n == 1) {
            right(x, y);
            dfs(cur + 1);
            rollRight(x, y);

            left(x, y);
            dfs(cur + 1);
            rollLeft(x, y);

            up(x,y);
            dfs(cur + 1);
            rollUp(x, y);

            down(x,y);
            dfs(cur + 1);
            rollDown(x, y);
        }
        else if(n == 2) {
            right(x,y);
            left(x,y);
            dfs(cur + 1);
            rollLeft(x,y);
            rollRight(x,y);


            up(x,y);
            down(x,y);
            dfs(cur + 1);
            rollDown(x, y);
            rollUp(x, y);
        }
        else if(n == 3) {
            up(x, y);
            right(x,y);
            dfs(cur + 1);
            rollUp(x, y);

            down(x, y);
            dfs(cur + 1);
            rollRight(x, y);

            left(x, y);
            dfs(cur + 1);
            rollDown(x, y);

            up(x, y);
            dfs(cur + 1);
            rollUp(x, y);
            rollLeft(x, y);
        }
        else if(n == 4) {
            left(x, y);
            up(x, y);
            right(x, y);
            dfs(cur + 1);
            rollLeft(x, y);

            down(x, y);
            dfs(cur + 1);
            rollUp(x, y);

            left(x, y);
            dfs(cur + 1);
            rollRight(x, y);

            up(x, y);
            dfs(cur + 1);
            rollUp(x, y);
            rollLeft(x,y);
        }
        else {
            up(x, y);
            down(x, y);
            right(x, y);
            left(x, y);
            dfs(cur + 1);
            rollLeft(x, y);
            rollRight(x,y);
            rollDown(x, y);
            rollUp(x, y);
        }
    }

    private static void check() {
        int count = 0;
        for(int i = 0; i < graph.length; i++) {
            for(int j = 0; j < graph[0].length; j++) {
                if(graph[i][j] == 0) {
                    count++;
                }
            }
        }
        answer = Math.min(answer, count);
    }


    private static void down(int x, int y) {
        for(int i = x+1; i < graph.length; i++) {
            if(graph[i][y] == 6) break;
            if(graph[i][y] <= 0) graph[i][y] -= 1;
        }
    }

    private static void rollDown(int x, int y) {
        for(int i = x+1; i < graph.length; i++) {
            if(graph[i][y] == 6) break;
            if(graph[i][y] < 0) graph[i][y] += 1;
        }
    }

    private static void up(int x, int y) {
        for(int i = x-1; i >= 0; i--) {
            if(graph[i][y] == 6) break;
            if(graph[i][y] <= 0) graph[i][y] -= 1;
        }
    }

    private static void rollUp(int x, int y) {
        for(int i = x-1; i >= 0; i--) {
            if(graph[i][y] == 6) break;
            if(graph[i][y] < 0) graph[i][y] += 1;
        }
    }

    private static void left(int x, int y) {
        for(int i = y-1; i >= 0; i--) {
            if(graph[x][i] == 6) break;
            if(graph[x][i] <= 0) graph[x][i] -= 1;
        }
    }
    private static void rollLeft(int x, int y) {
        for (int i = y - 1; i >= 0; i--) {
            if (graph[x][i] == 6) break;
            if (graph[x][i] < 0) graph[x][i] += 1;
        }
    }

    private static void right(int x, int y) {
        for(int i = y + 1; i < graph[0].length; i++) {
            if(graph[x][i] == 6) break;
            if(graph[x][i] <= 0) graph[x][i] -= 1;
        }
    }
    private static void rollRight(int x, int y) {
        for(int i = y + 1; i < graph[0].length; i++) {
            if(graph[x][i] == 6) break;
            if(graph[x][i] < 0) graph[x][i] += 1;
        }
    }
}