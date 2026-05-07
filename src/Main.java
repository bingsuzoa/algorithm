import java.util.*;

class Solution {
    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        int[][] times = new int[m][n];

        for(int i = 0; i < times.length; i++) {
            Arrays.fill(times[i], Integer.MAX_VALUE);
        }

        for(int i = 0; i < drops.length; i++) {
            int r = drops[i][0];
            int c = drops[i][1];
            times[r][c] = i + 1;
        }

        int[][] rowMins = new int[m][n - w + 1];
        int bestTime = -1;
        int bestX = -1;
        int bestY = -1;

        //row sliding
        for(int i = 0; i < m; i++) {
            Deque<Integer> dq = new ArrayDeque<>();

            for(int j = 0; j < n; j++) {

                while(!dq.isEmpty() && times[i][j] <= times[i][dq.peekLast()]) {
                    dq.pollLast();
                }
                dq.addLast(j);

                if(j - dq.peekFirst() + 1 > w) {
                    dq.pollFirst();
                }

                if(j - w + 1 >= 0) {
                    rowMins[i][j-w+1] = times[i][dq.peekFirst()];
                }
            }
        }

        //col sliding
        for(int j = 0; j < n - w + 1; j++) {
            Deque<Integer> dq = new ArrayDeque<>();

            for(int i = 0; i < m; i++) {

                while(!dq.isEmpty() && rowMins[i][j] <= rowMins[dq.peekLast()][j]) {
                    dq.pollLast();
                }
                dq.addLast(i);

                if(i - dq.peekFirst() + 1 > h) {
                    dq.pollFirst();
                }

                if(i - h + 1 >= 0) {
                    int currentTime = rowMins[dq.peekFirst()][j];

                    int startX = i - h + 1;
                    int startY = j;
                    if(currentTime > bestTime) {
                        bestTime = currentTime;
                        bestX = startX;
                        bestY = startY;
                    }
                    else if(currentTime == bestTime) {
                        if(startX < bestX) {
                            bestX = startX;
                            bestY = startY;
                        }
                        else if(startX == bestX && startY < bestY) {
                            bestY = startY;
                        }
                    }
                }
            }
        }
        return new int[]{bestX, bestY};
    }
}