import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] graph = new int[N];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for(int i =0 ; i < graph.length; i++) {
            graph[i] = Integer.parseInt(st1.nextToken());
        }

        int left = 0;
        int right = 0;
        long answer = 0;
        long sum = 0;
        int duration = 0;
        while(right < graph.length) {
            int count = right - left + 1;
            if(count <= K) {
                sum += graph[right];
                if(count == K) {
                    if(answer < sum) {
                        answer = sum;
                        duration = 1;
                    } else if(answer == sum) {
                        duration ++;
                    }
                }
                right++;
            } else {
                sum -= graph[left];
                left++;
            }
        }

        if(answer == 0) {
            System.out.println("SAD");
            return;
        }
        System.out.println(answer + "\n" + duration);
    }
}