import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int coupon = Integer.parseInt(st.nextToken());

        int[] graph = new int[N * 2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< N; i++) {
            graph[i] = Integer.parseInt(br.readLine());
            graph[i + N] = graph[i];
            map.put(graph[i], 0);
        }

        int start = 0;
        int end = 0;
        Set<Integer> set = new HashSet<>();
        int max = 0;
        int count = 0;
        while(start < N) {
            count = end - start + 1;
            if(count <= k) {
                map.put(graph[end], map.get(graph[end]) + 1);
                set.add(graph[end]);
                if(count == k) {
                    if(!set.contains(coupon)) {
                        max = Math.max(max, set.size() + 1);
                    } else {
                        max = Math.max(max, set.size());
                    }
                }
                end++;
            } else {
                map.put(graph[start], map.get(graph[start]) -1);
                if(map.get(graph[start]) == 0) {
                    set.remove(graph[start]);
                }
                start++;
            }
        }
        System.out.println(max);
    }
}