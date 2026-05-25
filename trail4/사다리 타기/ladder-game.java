import java.util.Scanner;
import java.util.*;


public class Main {
    static int N,M;
    static List<int[]> initList;
    static int[] initResult;
    static int answer;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        N = n; M = m;

        //List<int[]> 를 구한다.
        initList = new ArrayList<>();
        for(int i = 0;i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            initList.add(new int[]{a, b});
        }
        
        //초기화 정답 구하기
        boolean[] initChecked = new boolean[m];
        Arrays.fill(initChecked, true);
        initResult = getResult(makeList(initChecked));
        answer = M;
    
        //dfs(list.size()만큼 true, false 전수조사)
        dfs(0, new boolean[M]);
        System.out.println(answer);
    }
    private static void dfs(int cur, boolean[] tmp) {
        if(cur == tmp.length) {
            int[] tmpAnswer = getResult(makeList(tmp));
            if(isTrue(tmpAnswer)) {
                answer = Math.min(answer, getCount(tmp));
            }
            return;
        }

        for(int i = 0; i <= 1; i++) {
            tmp[cur] = i == 0 ? true : false;
            dfs(cur + 1, tmp);
        }
    }
    private static boolean isTrue(int[] tmp) {
        for(int i = 0;i < tmp.length; i++) {
            if(tmp[i] != initResult[i]) return false;
        }
        return true;
    }
    private static int getCount(boolean[] tmp) {
        int count = 0;
        for(int i = 0;i < tmp.length; i++) {
            if(tmp[i]) count++;
        }
        return count;
    }
    private static List<int[]>[] makeList(boolean[] checked) {
        List<int[]>[] list = new ArrayList[N+1];
        for(int i =0;i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++){
            if(!checked[i]) continue;
            int[] tmp = initList.get(i);
            int a = tmp[0];
            int b = tmp[1];
            list[a].add(new int[]{b, a+1});
            if(a+1 < list.length) {
                list[a+1].add(new int[]{b, a});
            }
        }
        for(int i = 0;i < list.length; i++) {
            Collections.sort(list[i], (o1,o2) -> {
                return o1[0] - o2[0];
            });
        };
        return list;
    }
     //true에 해당하는 List<int[]>[] 구하기
    private static int[] getResult(List<int[]>[] list) {
        int[] result = new int[list.length];

        for(int person = 1; person <= N; person++) {
            int ch = 1;
            int pos = person;
            while(ch <= 15) {
                for(int[] next : list[pos]) {
                    int nextCh = next[0];
                    int to = next[1];
                    if(nextCh == ch) {
                        pos = to;
                        break;
                    }
                }
                ch++;
            }
            result[pos] = person;
        }
        return result;    
    }
}