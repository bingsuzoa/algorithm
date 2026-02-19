import java.util.*;
import java.io.*;

class Main {
    static int n, k, t, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        ///// pq.add(new int[]{i, teams[i], times[i], sum});
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> {
            if(o1[3] == o2[3]) {
                if(o1[1] == o2[1]) {
                    return o1[2] - o2[2];
                }
                return o1[1] - o2[1];
            }
            return o2[3] - o1[3];
        });

        while (T-- > 0) {
            pq.clear();
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            int[] teams = new int[n + 1];
            int[] times = new int[n + 1];
            Info[] infos = new Info[k + 1];
            for (int i = 0; i < infos.length; i++) {
                infos[i] = new Info(n);
            }

            int counter = 1;
            for (int i = 0; i < m; i++) {
                StringTokenizer st1 = new StringTokenizer(br.readLine());
                int team = Integer.parseInt(st1.nextToken());
                int problem = Integer.parseInt(st1.nextToken());
                int score = Integer.parseInt(st1.nextToken());

                infos[problem].addScore(team, score);
                teams[team]++;
                times[team] = counter++;
            }

            for (int i = 1; i <= n; i++) {
                int sum = 0;
                for (Info info : infos) {
                    sum += info.getScore(i);
                }
                pq.add(new int[]{i, teams[i], times[i], sum});
            }

            int rank = 1;
            while(!pq.isEmpty()) {
                int team = pq.poll()[0];
                if(team == t) {
                    sb.append(rank).append("\n");
                    break;
                }
                rank++;
            }
        }
        System.out.println(sb);
    }

    private static boolean isAllGetted(boolean[] getted){
        for (boolean result : getted) {
            if (!result) {
                return false;
            }
        }
        return true;
    }
}

class Info {
    Map<Integer, Integer> map = new HashMap<>();

    public Info(int n) {
        for(int i = 1; i <= n; i++) {
            map.put(i, 0);
        }
    }

    public void addScore(int team, int score) {
        int befo = map.get(team);
        if(befo < score) {
            map.put(team, score);
        }
    }
    public int getScore(int team) {
        return map.get(team);
    }
}