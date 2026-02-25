import java.util.*;
import java.io.*;

class Main {
    static int[] belts;
    static boolean[] boxs;
    static int N,K;
    static int MOD = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        belts = new int[N * 2];
        boxs = new boolean[N * 2];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for(int i = 0; i < belts.length; i++) {
            belts[i] = Integer.parseInt(st1.nextToken());
        }

        int count = 1;
        while(true) {
            rotateBelt();
            rotateRobot();
            upRobot();
            if(isEnd()) {
                break;
            }
            count++;
        }

        System.out.println(count);
    }
    private static boolean isEnd() {
        int count = 0;
        for(int remain : belts) {
            if(remain == 0) count++;
        }
        if(count >= K) {
            return true;
        }
        return false;
    }
    private static void upRobot() {
        if(boxs[0]) return;
        if(belts[0] < 1) return;
        belts[0] --;
        boxs[0] = true;
    }
    private static void rotateRobot() {
        for(int i = N - 2; i >= 0; i--) {
            if(!boxs[i]) continue;
            if(boxs[i+1]) continue;
            if(belts[i+1] < 1) continue;

            boxs[i+1] = true;
            belts[i+1] --;
            boxs[i] = false;

            if(i+1 == N-1 && boxs[i+1]) {
                boxs[i+1] = false;
            }
        }
    }


    private static void rotateBelt() {
        int lastRemain = belts[belts.length - 1];
        boolean lastBox = boxs[boxs.length -1];
        for(int i = belts.length -1; i >= 1; i--) {
            belts[i] = belts[i-1];
            boxs[i] = boxs[i-1];

            if(i == N-1) {
                boxs[i] = false;
            }
        }
        belts[0] = lastRemain;
        boxs[0] = lastBox;
    }

}