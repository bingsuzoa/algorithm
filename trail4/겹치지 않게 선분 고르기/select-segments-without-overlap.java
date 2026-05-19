import java.util.Scanner;
import java.util.*;

public class Main {
    static int[][] segments;
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        segments = new int[n][2];

        for (int i = 0; i < n; i++) {
            segments[i][0] = sc.nextInt();
            segments[i][1] = sc.nextInt();
        }
        ///오름차순으로 정렬하기
        Arrays.sort(segments, (o1, o2) -> {
            return o1[0] - o2[0];
        });
        
        boolean[] array = new boolean[segments.length];
        dfs(0, array);
        System.out.println(answer);

    }
    private static void check(boolean[] array) {
        List<int[]> list = new ArrayList<>();

        for(int i = 0; i < array.length; i++) {
            if(array[i]) {
                list.add(new int[]{segments[i][0], segments[i][1]});
            }
        }

        boolean isPass = true;
        for(int i = 1; i < list.size(); i++) {
            int[] befo = list.get(i-1);
            int[] cur = list.get(i);

            int bs = befo[0];
            int be = befo[1];
            int cs = cur[0];
            int ce = cur[1];

            if(bs <= cs && cs <= be) {
                isPass = false;
                break;
            }
        }
        if(isPass) {
            answer = Math.max(answer, list.size());
        }
    }


    private static void dfs(int cur, boolean[] array) {
        if(cur == array.length) {
            check(array);
            return;
        }

        for(int i = 0; i <= 1; i++) {
            array[cur] = i == 0 ? true : false;
            dfs(cur + 1, array);
        }
    }
}