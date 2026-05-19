import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] segments = new int[n][2];
        for (int i = 0; i < n; i++) {
            segments[i][0] = sc.nextInt();
            segments[i][1] = sc.nextInt();
        }
        

        Arrays.sort(segments, (o1,o2) -> {
            return o1[1] - o2[1];
        });

        int answer = 1;
        int lastIdx = 0;
        for(int i = 1; i < segments.length; i++) {
            int bs = segments[lastIdx][0];
            int be = segments[lastIdx][1];

            int cs = segments[i][0];
            int ce = segments[i][1];

            if(be >= cs) continue;
            answer++;
            lastIdx = i;
        }
        System.out.println(answer);
    }
}