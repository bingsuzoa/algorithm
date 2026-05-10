import java.util.*;

class Solution {
    static int[][] graph;

    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        graph = new int[m][n];

        for(int i = 0; i < graph.length; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE);
        }

        for(int i = 0; i < drops.length; i++) {
            int r = drops[i][0];
            int c = drops[i][1];
            graph[r][c] = i+1;
        }

        int[][] rowMins = new int[m][n - w + 1];

        for(int i = 0; i < m; i ++) {
            Deque<Integer> dq = new LinkedList<>();
            for(int j = 0; j < n; j++) {

                while(!dq.isEmpty() && graph[i][dq.peekLast()] >= graph[i][j]) {
                    dq.pollLast();
                }
                dq.addLast(j);

                if(!dq.isEmpty() && dq.peekFirst() < j - w + 1) {
                    dq.pollFirst();
                }

                if(j - w + 1 >= 0) {
                    rowMins[i][j- w + 1] = graph[i][dq.peekFirst()];
                }
            }
        }

        int min = Integer.MIN_VALUE;
        int ax = -1;
        int ay = - 1;
        for(int j = 0; j < n - w + 1; j++) {
            Deque<Integer> dq = new LinkedList<>();
            for(int i = 0 ; i < m; i++) {

                while(!dq.isEmpty() && rowMins[i][j] <= rowMins[dq.peekLast()][j]) {
                    dq.pollLast();
                }
                dq.addLast(i);

                if(!dq.isEmpty() && i - h + 1 > dq.peekFirst()) {
                    dq.pollFirst();
                }

                if(i - h + 1 >= 0) {
                    if(min < rowMins[dq.peekFirst()][j]) {
                        min = rowMins[dq.peekFirst()][j];
                        ax = i - h + 1;
                        ay = j;
                    } else if(min == rowMins[dq.peekFirst()][j]) {
                        if(ax > i -h + 1) {
                            ax = i - h + 1;
                            ay = j;
                        }
                        else if(ax == i - h + 1 && ay > j) {
                            ax = i - h + 1;
                            ay = j;
                        }
                    }
                }
            }
        }
        return new int[]{ax, ay};
    }
}