import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        int answer = solution(10, 10, 4, 5);
        System.out.println(answer);
    }

    private static int solution(int S, int T, int X, int Y) {
        int min = Integer.MAX_VALUE;

        for(int att = X; att <= 1000; att ++) {
            int req = att - X;
            int monsterCount = ((T + att - 1) / att) -1;

            int minSeo = Y * monsterCount + 1;

            req += S >= minSeo ? 0 : minSeo - S;
            min = Math.min(min, req);
        }
        return min;
    }
}