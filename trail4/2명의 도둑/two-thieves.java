import java.util.Scanner;
public class Main {
    static int[][] grid;
    static int N,M,C;
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int c = sc.nextInt();
        grid = new int[n][n];
        N = n; M = m; C = c;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                int sy = j;
                int ey = j + M - 1;

                if(ey >= grid[0].length) continue;
                int left = dfs(i, sy, ey, sy, 0);

                for(int k = 0; k < grid.length; k++) {
                    for(int r = 0; r < grid[0].length; r++) {
                        int rsy = r;
                        int rey = r + M - 1;

                        if(i == k && !(ey < rsy || rey < sy)) continue;
                        if(rey >= grid[0].length) continue;

                        int right = dfs(k, rsy, rey, rsy, 0);
                        answer = Math.max(answer, left + right);

                    }
                }
            }
        }
        System.out.println(answer);
    }
    
    private static int dfs(int row, int sy, int ey, int cy, int currentWeight) {
        if(cy >= grid[0].length || cy > ey) {
            return 0;
        }

        int value = grid[row][cy];
        int having = 0;

        if(currentWeight + value <= C) {
            having = dfs(row, sy, ey, cy + 1, currentWeight + value) + (int)Math.pow(value, 2);
        }

        int skip = dfs(row, sy, ey, cy + 1, currentWeight);
        return Math.max(having, skip);
    }
}