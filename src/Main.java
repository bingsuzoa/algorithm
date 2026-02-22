import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2) -> {
            return o1 - o2;
        });
        StringBuilder sb = new StringBuilder();

        while(N --> 0) {
            int n = Integer.parseInt(br.readLine());

            if(n == 0) {
                if(pq.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(pq.poll()).append("\n");
                }
                continue;
            }
            pq.add(n);
        }
        System.out.println(sb);
    }
}