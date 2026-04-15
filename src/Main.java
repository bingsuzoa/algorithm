import java.util.*;
import java.io.*;

class Main {
    static long[] minDp;
    static StringBuilder sb = new StringBuilder();
    static long min, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        minDp = new long[101];
        Arrays.fill(minDp, Long.MAX_VALUE);
        minDp[2]=1; minDp[3]=7; minDp[4]=4; minDp[5]=2; minDp[6]=6; minDp[7]=8;

        for(int i = 8; i < minDp.length; i++) {
            for(int j = 2; j <= 7; j++) {
                if(minDp[i - j] == Long.MAX_VALUE) continue;
                String result = minDp[i - j] + (j == 6 ? "0" : String.valueOf(minDp[j]));
                minDp[i] = Math.min(minDp[i], Long.parseLong(result));
            }
        }

        while(N --> 0) {
            int count = Integer.parseInt(br.readLine());
            min = minDp[count];

            StringBuilder tmp = new StringBuilder();
            int cur = count;
            if(count % 2 == 0) {
                while(cur > 0) {
                    tmp.append(1);
                    cur -= 2;
                }
            } else {
                tmp.append(7);
                cur -= 3;
                while(cur > 0) {
                    tmp.append(1);
                    cur -=2;
                }
            }

            sb.append(min + " " + tmp.toString()).append("\n");
        }
        System.out.println(sb);
    }
}