import java.util.*;

class Solution {
    static int[][] graph;
    static int[][] types;
    static int[] opps;
    static int[][] results;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int N,M;
    static boolean[][][] visited;
    static int answer;

    public static void main(String[] args) {
        int[][] temp = new int[][]{{1, 0, 0, 0, 0, -1, -1}, {-1, 0, 0, 1, 0, 0, 1}};
        Solution s = new Solution();
        System.out.println(s.solution(temp));
    }

    public int solution(int[][] grid) {
        answer = 0;
        graph = grid;
        types = new int[][] {{}, {2, 3}, {0, 1}, {0,1,2,3}, {1,3}, {1,2},{0,2},{0,3}};
        opps = new int[]{1, 0,3,2};
        M = graph.length;
        N = graph[0].length;
        visited = new boolean[M][N][2];
        results = new int[M][N];
        visited[0][0][0] = true;

        for(int i = 0;i < graph.length; i++) {
            for(int j = 0;j < graph[0].length; j++) {
                results[i][j] = graph[i][j];
            }
        }
        dfs(0,0,2);
        return answer;
    }

    private static void dfs(int x, int y, int outDir) {
        if(x == M-1 && y == N-1) {
            if(check()) {
                answer++;
            }
            return;
        }
        int nx = x + dx[outDir];
        int ny = y + dy[outDir];
        int oppo = opps[outDir];

        if(isOut(nx, ny) || graph[nx][ny] == -1) return;
        int newType = results[nx][ny];
        int original = results[nx][ny];

        if(newType > 0) {
            if(canConnect(oppo, newType)) {
                for(int dir : types[newType]) {
                    int axis = (dir == 2 || dir == 3) ? 0 : 1;
                    if(oppo == dir || visited[nx][ny][axis]) continue;

                    results[nx][ny] = newType;
                    visited[nx][ny][axis] = true;

                    if(newType != 3) {
                        dfs(nx, ny, dir);
                    }
                    else if(newType == 3 && dir == opps[oppo]) {
                        dfs(nx, ny, dir);
                    }

                    results[nx][ny] = original;
                    visited[nx][ny][axis] = false;
                }
            }
        } else {
            for(int i = 1; i <= 7; i++) {
                if(canConnect(oppo, i)) {
                    results[nx][ny] = i;

                    for(int dir : types[i]) {
                        int axis = (dir == 2 || dir == 3) ? 0 : 1;
                        if(oppo == dir || visited[nx][ny][axis]) continue;

                        visited[nx][ny][axis] = true;
                        if(i != 3) {
                            dfs(nx, ny, dir);
                        }
                        else if(i == 3 && dir == opps[oppo]) {
                            dfs(nx, ny, dir);
                        }
                        visited[nx][ny][axis] = false;
                    }
                    results[nx][ny] = 0;
                }
            }
        }
    }
    private static boolean check() {
        for(int i =0; i< results.length; i++) {
            for(int j =0 ;j < results[0].length; j++) {
                if(i == 0 && j == 0) continue;
                if(i == M - 1 && j == N - 1) continue;
                int type = results[i][j];
                if(type <= 0) continue;

                for(int t : types[type]) {
                    int nx = i + dx[t];
                    int ny = j + dy[t];
                    int opp = opps[t];

                    if(isOut(nx, ny) || results[nx][ny] <= 0) return false;
                    if(!canConnect(opp, results[nx][ny])) return false;
                }
            }
        }
        return true;
    }
    private static boolean canConnect(int dir, int type) {
        for(int connect : types[type]) {
            if(dir == connect) {
                return true;
            }
        }
        return false;
    }

    private static boolean isOut(int x, int y) {
        if(x >= M || x < 0 || y >= N || y < 0) return true;
        return false;
    }
}