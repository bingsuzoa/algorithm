import java.util.*;
import java.io.*;


class Main {
    static Map<Integer, Info> map;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        sb = new StringBuilder();
        while(N --> 0) {
            map.clear();
            int M = Integer.parseInt(br.readLine());
            int[] graph = new int[M];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < graph.length; i++) {
                graph[i] = Integer.parseInt(st.nextToken());
                if(!map.containsKey(graph[i])) {
                    map.put(graph[i], new Info());
                }
                map.get(graph[i]).addCount();
            }

            for(int key : map.keySet()) {
                Info info = map.get(key);
                if(info.count < 6) {
                    info.isContain = false;
                }
            }
            int rank = 1;
            for(int i = 0; i < graph.length; i++) {
                Info info = map.get(graph[i]);
                if(!info.isContain) continue;
                info.addScore(rank);
                rank++;
            }

            List<Integer> list = new ArrayList<>();
            int prize = Integer.MAX_VALUE;
            for(int key : map.keySet()) {
                Info info = map.get(key);
                if(!info.isContain) continue;
                if(prize > info.getSum()) {
                    prize = info.getSum();
                }
            }
            for(int key : map.keySet()) {
                Info info = map.get(key);
                if(!info.isContain) continue;
                if(info.getSum() == prize) {
                    list.add(key);
                }
            }

            if(list.size() == 1) {
                sb.append(list.get(0)).append("\n");
            }

            else if(list.size() > 1) {
                for(int i = 5; i <= 6; i++) {
                    if(getPrize(i, list)) {
                        break;
                    }
                }
            }
        }

        System.out.println(sb);
    }

    private static boolean getPrize(int rank, List<Integer> yebi) {
        int prize = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();

        for(int key : yebi) {
            Info info = map.get(key);
            if(!info.isContain) continue;
            if(prize > info.getRemain(rank)) {
                prize = info.getRemain(rank);
            }
        }
        for(int key : yebi) {
            Info info = map.get(key);
            if(!info.isContain) continue;
            if(prize == info.getRemain(rank)) {
                list.add(key);
            }
        }
        if(list.size() == 1) {
            sb.append(list.get(0)).append("\n");
            return true;
        }
        return false;
    }

}

class Info {
    int count;
    boolean isContain;
    int[] score;
    int idx;

    public Info() {
        this.count = 0;
        this.isContain = true;
        this.score = new int[6];
        this.idx = 0;
    }

    public void addCount() {
        count ++;
    }

    public void addScore(int num) {
        score[idx] = num;
        idx++;
    }

    public int getSum() {
        int sum = 0;
        for(int i = 0; i < 4; i++) {
            sum += score[i];
        }
        return sum;
    }
    public int getRemain(int rank) {
        return score[rank -1];
    }
}