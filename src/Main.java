import java.util.*;
import java.io.*;

class Main {
    static int H,W,N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        long x = (H / (N + 1));
        long y = (W / (M + 1));
        if((H % (N + 1)) != 0) {
            x ++;
        }

        if(W % (M + 1) != 0) {
            y++;
        }

        System.out.println(x * y);

    }
}