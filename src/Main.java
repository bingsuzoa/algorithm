import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        System.out.println(check(B) - check(A - 1));
    }

    private static long check(long num) {
        long count = 0;
        long totalNumbers = num + 1;

        for(int i = 0; (1L << i) <= num; i++) {
            long cycle = 1L << (i+1);
            long halfCycle = 1L << (i);

            count += (totalNumbers / cycle) * halfCycle;

            long remainder = totalNumbers % cycle;
            if(remainder > halfCycle) {
                count += (remainder - halfCycle);
            }
        }
        return count;
    }


}