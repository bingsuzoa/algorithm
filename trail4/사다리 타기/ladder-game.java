import java.util.Scanner;
import java.util.*;

public class Main {
    static List<int[]> initList;
    static int N,M;
    static int[] initAnswer;
    static int answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        N = n; M = m;

        initList = new ArrayList<>();
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            initList.add(new int[]{a,b});
        }
        boolean[] initChecked = new boolean[m];
        Arrays.fill(initChecked, true);
        initAnswer = getResult(initChecked);
        answer = M;
        dfs(0,0, new boolean[M]);
        System.out.println(answer);
    }
    private static void dfs(int cur, int count, boolean[] checked) {
        if(isTrue(getResult(checked))) {
                answer = Math.min(answer, count);
            }
            
        for(int i = cur; i < M; i++) {
            checked[i] = true;
            dfs(i + 1, count + 1, checked);
            checked[i] = false;
        }
    }
    private static boolean isTrue(int[] result) {
        for(int i =0 ;i < result.length; i++) {
            if(result[i] != initAnswer[i]) {
                return false;
            }
        }
        return true;
    }
    private static int[] makeResult(boolean[][] graph) {
        int[] result = new int[N+1];
        for(int per = 1; per <= N; per++) {
            int pos = per;
            for(int ch = 1; ch < 16; ch++) {
                if(graph[ch][pos]) {
                    pos++;
                }
                else if(pos > 1 && graph[ch][pos - 1]) {
                    pos --;
                }
            }
            result[pos] = per;
        }
        return result;
    }
    
    private static int[] getResult(boolean[] checked) {
        boolean[][] graph = new boolean[16][N+1];
        for(int i = 0;i < checked.length; i++) {
            if(checked[i]) {
                int[] tmp = initList.get(i);
                int a = tmp[0];
                int b = tmp[1];
                graph[b][a] = true;
            }
        }
        return makeResult(graph);
    }
}