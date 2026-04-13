import java.util.*;
import java.io.*;

class Main {
    static int[] graph;
    static boolean[] coins;
    static List<int[]> list;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = 3;
        while(N --> 0) {
            int n = Integer.parseInt(br.readLine());
            list = new ArrayList<>();

            int goal = 0;
            while(n --> 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int coin = Integer.parseInt(st.nextToken());
                int count = Integer.parseInt(st.nextToken());
                list.add(new int[]{coin, count});
                goal += (coin * count);
            }
            graph = new int[goal / 2 + 1];
            coins = new boolean[goal / 2 + 1];
            coins[0] = true;

            for(int[] cur : list) {
                int coin = cur[0];
                int count = cur[1];

                Arrays.fill(graph, 0);

                for(int i = coin; i < graph.length; i++) {
                    if(coins[i]) continue;
                    if(!coins[i - coin] || graph[i-coin] + 1 > count) continue;
                    graph[i] = graph[i - coin] + 1;
                    coins[i] = true;
                }
            }

            if(coins[graph.length -1]) {
                sb.append("1").append("\n");
            } else {
                sb.append("0").append("\n");
            }
        }
        System.out.println(sb);
    }
}