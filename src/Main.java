import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        int[] coins = new int[N];

        for(int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        long answer = 0;

        while(K > 0) {
            long cur = 0;
            for(long coin : coins) {
                if(K < coin) {
                    break;
                }
                cur = coin;
            }
            int count = (int)(K / cur);
            K -= (count * cur);
            answer += count;
        }

        System.out.println(answer);
    }
}