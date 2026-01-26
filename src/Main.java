import java.util.*;
import java.io.*;


class Main {
    static boolean[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        dp = new boolean[N+1][K+1];

        dp[1][1] = true;

        for(int i = 2; i < dp.length; i++){
            for(int j = 2; j < dp[i].length; j++) {
                if(dp[i-1][j-1]) {
                    dp[i][j] = true;
                } else {
                    isPossible(i, j);
                }
            }
        }

        if(dp[N][K]) {
            System.out.println("minigimbob");
        } else {
            System.out.println("water");
        }
    }
    private static void isPossible(int floor, int opp) {
        for(int i = 1; i < opp; i++) {
            if(floor % 2 == 0) {
                int temp = floor;
                while(temp > 0) {
                    temp /= 3;
                    if(dp[temp][i]) {
                        dp[floor][opp] = true;
                        return;
                    }
                }
            } else {
                int temp = floor;
                while(temp > 0) {
                    temp = (temp + 3) / 4;
                    if(dp[temp][i]) {
                        dp[floor][opp] = true;
                        return;
                    }
                }
            }

        }

    }
}