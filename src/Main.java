import java.util.*;
import java.io.*;

class Main {
    static String[] nums = new String[10];
    static int[][] graph;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        graph = new int[10][10];

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        init();

        int[] goalArr = new int[K];
        int[] nowArr = new int[K];

        int nt = N;
        int nx = X;
        for(int i = goalArr.length - 1; i >= 0; i--) {
            goalArr[i] = nt % 10;
            nt /= 10;
        }
        for(int i = nowArr.length -1; i >= 0; i--) {
            nowArr[i] = nx % 10;
            nx /= 10;
        }
        dfs(0, P, goalArr, nowArr, new int[K], N, X);
        System.out.println(answer);
    }
    private static void dfs(int idx, int P, int[] goal, int[] now, int[] temp, int N, int X) {
        if(idx == goal.length) {
            if(isPass(N, X, temp)) {
                answer++;
            }
            return;
        }
        int cur = now[idx];
        for(int j = 0; j < graph[0].length; j++) {
            if(P - graph[cur][j] < 0) continue;
            temp[idx] = j;
            dfs(idx + 1, P - graph[cur][j], goal, now, temp, N, X);
        }
    }

    private static boolean isPass(int N, int X, int[] now) {
        int size = now.length - 1;

        int nowNum = 0;

        int idx = 0;
        while(size >= 0) {
            nowNum += (now[idx] * (int)Math.pow(10, size));
            size--;
            idx++;
        }
        if(nowNum == 0 || N < nowNum || X == nowNum) {
            return false;
        }
        return true;
    }

    private static void init() {
        nums[0] = "1110111";
        nums[1] = "0010010";
        nums[2] = "1011101";
        nums[3] = "1011011";
        nums[4] = "0111010";
        nums[5] = "1101011";
        nums[6] = "1101111";
        nums[7] = "1010010";
        nums[8] = "1111111";
        nums[9] = "1111011";

        for(int i =0 ; i < graph.length; i++) {
            for(int j = 0; j < graph[i].length; j++) {
                String start = nums[i];
                String end = nums[j];

                int count = 0;
                for(int k = 0; k < start.length(); k++) {
                    if(start.charAt(k) != end.charAt(k)) {
                        count++;
                    }
                }
                graph[i][j] = count;
                graph[j][i] = count;
            }
        }
    }
}