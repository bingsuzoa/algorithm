import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] graph = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < graph.length; i++) {
            graph[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(graph);
        int count = 0;
        for(int i = 0; i < graph.length; i++) {
            long target = graph[i];

            int left = 0;
            int right = graph.length - 1;

            while(left < right) {
                if(left == i) {
                    left++;
                    continue;
                }
                if(right == i) {
                    right--;
                    continue;
                }

                long sum = graph[left] + graph[right];

                if(sum == target) {
                    count++;
                    break;
                }
                if(sum < target) {
                    left++;
                }
                else {
                    right--;
                }
            }

        }
        System.out.println(count);
    }
}