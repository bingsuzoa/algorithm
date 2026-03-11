import java.util.*;
import java.io.*;

class Main {
    static int N;
    static String input;
    static String goal;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        input = br.readLine();
        goal = br.readLine();

        if(input.equals(goal)) {
            System.out.println(0);
            return;
        }

        int[] graph = new int[N];
        for(int i=0 ;i < graph.length; i++) {
            graph[i] = input.charAt(i) - '0';
        }

        int[] original = Arrays.copyOf(graph, graph.length);
        int res1 = check(original);

        int[] pair = Arrays.copyOf(graph, graph.length);
        pair[0] = graph[0] == 0 ? 1 : 0;
        pair[1] = graph[1] == 0 ? 1 : 0;
        int res2 = check(pair) + 1;

        int answer = Integer.MAX_VALUE;
        if(original[N-1] == goal.charAt(N-1) - '0') {
            answer = Math.min(answer, res1);
        }
        if(pair[N-1] == goal.charAt(N-1) - '0') {
            answer = Math.min(answer, res2);
        }
        if(answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }
    private static int check(int[] graph) {
        int count = 0;
        for(int i = 1 ; i < input.length(); i++) {
            int bi = graph[i-1];
            int bg = goal.charAt(i-1) - '0';

            if(bi != bg) {
                count++;
                int v = bi == 0 ? 1 : 0;

                graph[i-1] = v;
                graph[i] = graph[i] == 0 ? 1 : 0;
                if(i + 1 < input.length()) {
                    graph[i+1] = graph[i+1] == 0 ? 1 : 0;
                }
            }
        }
        return count;
    }
}