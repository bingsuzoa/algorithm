import java.util.*;
import java.io.*;

public class Main {
    static Set<String> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dfs(0, 0, 0, new int[N]);
        System.out.println(set.size());
    }


    private static void dfs(int cur, int num, int count, int[] tmp) {
        if(cur == tmp.length) {
            addSet(tmp);
            return;
        }

        if(count > 0) {
            tmp[cur] = num;
            dfs(cur + 1, num, count - 1, tmp);
        }
        else if(count == 0) {
            for(int i = 1; i <= 4; i++) {
                if(isPossible(cur, tmp, i)) {
                    dfs(cur, i, i, tmp);
                }
            }
        }
    }
    private static boolean isPossible(int cur, int[] tmp, int num) {
        int remain = tmp.length - cur;
        if(remain >= num) {
            return true;
        }
        return false;
    }

    private static void addSet(int[] tmp) {
        StringBuilder sb = new StringBuilder();
        for(int v : tmp) {
            sb.append(v);
        }
        set.add(sb.toString());
    }
}