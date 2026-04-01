import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static Map<Integer, String> map;
    static int[] graph;
    static int[] sorted;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenzier(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Info[] infos = new Inf[N];
        map = new HashMap<>();

        for(int i =0 ; i < infos.length; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            String s = st1.nextToken();
            int v = Integer.parseInt(st1.nextToken());
            infos[i] = new Info(s, v);
        }

        graph = new int[M];
        sorted = new int[M];
        for(int i = 0; i < graph.length; i++) {
            graph[i] = Integer.parseInt(br.readLine());
            sorted[i] = graph[i];
        }

        Arrays.sort(sorted);

        int start = 0;
        for(Info info : infos) {
            if(start < sorted.length) {
                int end = binary(info, start);
                for(int i = start; i <= end; i++) {
                    map.putIfAbsent(sorted[i], info.info);
                }
                start = end + 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < graph.length; i++) {
            sb.append(map.get(graph[i])).append("\n");
        }
        System.out.println(sb);
    }

    private static int binary(Info info, int start) {
        String info = info.info;
        int goal = info.value;

        int end = sorted.length - 1;
        while(start <= end) {
            int mid = (start + end) / 2;

            if(sorted[mid] <= goal) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }
}

class Info {
    String info;
    int value;

    Info(String info, int value) {
        this.info = info;
        this.value = value;
    }
}