import java.util.*;

class Solution {
    static int[] dx = new int[]{1,-1,0,0};
    static int[] dy = new int[]{0,0,1,-1};
    static int[] opposite = new int[]{1, 0, 3, 2};

    static boolean[][][] visited;
    static int[][] graph;
    static int[][] dp;

    static int[][] infos;
    static int answer = 0;

    public int solution(int[][] grid) {
        graph = grid;
        visited = new boolean[graph.length][graph[0].length][2];

        infos = new int[][]{{}, {2,3},{0,1},{0,1,2,3},{3,1},{1,2},{2,0},{3,0}};

        dp = new int[graph.length][graph[0].length];
        for(int i = 0;i < graph.length; i++) {
            for(int j = 0;j < graph[0].length; j++) {
                dp[i][j] = graph[i][j];
            }
        }
        dfs(0,0, 2);
        return answer;
    }


    private static void dfs(int x, int y, int out) {
        if(x == graph.length - 1 && y == graph[0].length -1) {
            if(crossCheck()) {
                answer++;
            }
            return;
        }

        int nx = x + dx[out];
        int ny = y + dy[out];
        int oppo = opposite[out];

        if(isOut(nx, ny) || graph[nx][ny] == -1) return;

        int axis = (out == 0 || out == 1) ? 0 : 1; //0이면 가로, 1이면 세로
        if(visited[nx][ny][axis]) return;

        int nextType = graph[nx][ny];
        if(nextType > 0) {
            if(canConnect(nx, ny, oppo)) {
                visited[nx][ny][axis] = true;
                for(int dir : infos[nextType]) {
                    if(dir == oppo) continue;
                    dfs(nx, ny, dir);
                }
                visited[nx][ny][axis] = false;
            }
        }
        else if(nextType == 0) {
            for(int t = 1; t <= 7; t++) {
                if(canConnect(nx, ny, t)) {
                    visited[nx][ny][axis] = true;
                    dp[nx][ny] = t;
                    for(int dir : infos[nextType]) {
                        if(oppo == dir) continue;
                        dfs(nx, ny, dir);
                    }
                    dp[nx][ny] = 0;
                    visited[nx][ny][axis] = false;
                }
            }
        }

    }
    private static boolean crossCheck() {
        for(int i = 0; i< dp.length; i++) {
            for(int j =0; j < dp[i].length; j++) {
                if(dp[i][j] != 3) continue;

                int nx;
                int ny;
                for(int k = 0; k< 4; k++) {
                    nx = i + dx[k];
                    ny = j + dy[k];

                    if(isOut(nx, ny)) return false;
                    if(dp[nx][ny] <= 0 || !canConnect(nx, ny, opposite[k])) return false;
                }
            }
        }
        return true;
    }
    private static boolean canConnect(int nx, int ny, int dir) {
        int num = graph[nx][ny];

        int[] info = infos[num];
        for(int in : info) {
            if(in == dir) {
                return true;
            }
        }
        return false;
    }

    private static boolean isOut(int x, int y) {
        if(x >= graph.length || x < 0 || y >= graph[0].length || y < 0) return true;
        return false;
    }
}