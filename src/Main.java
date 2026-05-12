import java.util.*;

class Solution {
    static int[] dx = new int[]{1,-1,0,0};
    static int[] dy = new int[]{0,0,1,-1};
    static int[] converse = new int[]{1,0,3,2};
    static int[][] rails = new int[][]{{}, {2,3},{0,1},{0,1,2,3},{1,3},{1,2},{0,2},{0,3}};
    static int M,N;
    static int[][] graph;
    static int answer = 0;
    static int[][] visited;

    public int solution(int[][] grid) {
        M = grid.length;
        N = grid[0].length;

        graph = new int[M][N];
        visited = new int[M][N];

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                graph[i][j] = grid[i][j];
            }
        }
        visited[0][0] = 1;
        dfs(0,0,2);
        return answer;
    }
    private void dfs(int x, int y, int in) {
        if(x == M - 1 && y == N - 1) {
            if(check()) {
                answer++;
            }
            return;
        }
        int pair = converse[in];
        int rail = graph[x][y];

        if(rail == 3) {
            processNext(x, y, in);
        } else {
            for(int to : rails[rail]) {
                if(to == pair) continue;
                processNext(x, y, to);
            }
        }
    }
    private void processNext(int x, int y, int to) {
        int nx = x + dx[to];
        int ny = y + dy[to];

        if(nx < 0 || nx >= M || ny < 0 || ny >= N) return;
        if(graph[nx][ny] == -1) return;

        if(graph[nx][ny] > 0) {
            if(isExist(to, graph[nx][ny])) {
                int rail = graph[nx][ny];
                int limit = rail == 3 ? 2 : 1;
                if(visited[nx][ny] >= limit) return;
                visited[nx][ny] += 1;
                dfs(nx, ny, to);
                visited[nx][ny] -= 1;
            }
        } else {
            for(int rail : getLines(to)) {
                if(isExist(to, rail)) {
                    int limit = rail == 3 ? 2 : 1;
                    if(visited[nx][ny] >= limit) continue;
                    graph[nx][ny] = rail;
                    visited[nx][ny] += 1;
                    dfs(nx, ny, to);
                    graph[nx][ny] = 0;
                    visited[nx][ny] -= 1;
                }
            }
        }
    }

    private boolean isExist(int in, int rail) {
        int pair = converse[in];
        for(int ra : rails[rail]) {
            if(ra == pair) return true;
        }
        return false;
    }

    private boolean check() {
        for(int i = 0; i < M; i++) {
            for(int j =0 ; j < N; j++) {
                if(graph[i][j] <= 0) continue;
                if((i == 0 && j == 0) || (i == M-1 && j == N-1)) continue;

                for(int dir : rails[graph[i][j]]) {
                    int nx = i + dx[dir];
                    int ny = j + dy[dir];

                    if(nx < 0 || nx >= M || ny < 0 || ny >= N) return false;
                    if(graph[nx][ny] <= 0) return false;
                    if(!isExist(dir, graph[nx][ny])) return false;
                }
            }
        }
        return true;
    }

    private int[] getLines(int dir) {
        if(dir == 0) {
            return new int[]{2, 3, 4, 5};
        }
        if(dir == 1) {
            return new int[]{2, 3, 6, 7};
        }
        if(dir == 2) {
            return new int[]{1,3,4,7};
        }
        return new int[]{1, 3, 5, 6};
    }
}