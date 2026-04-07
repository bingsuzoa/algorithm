import java.util.*;
import java.io.*;


class Main {
    static int[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        graph = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            graph[i] = Integer.parseInt(st.nextToken());
        }

        int[] counts = new int[N+1];
        int[] nums = new int[N+1];

        Stack<Integer> stack = new Stack<>();
        for(int i = 1; i <= N; i++) {
            int cur = graph[i];

            while(!stack.isEmpty() && graph[stack.peek()] <= cur) {
                stack.pop();
            }
            counts[i] += stack.size();
            if(!stack.isEmpty()) {
                nums[i] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear();

        for(int i = N; i >= 1; i--) {
            int cur = graph[i];

            while(!stack.isEmpty() && cur >= graph[stack.peek()]) {
                stack.pop();
            }

            counts[i] += stack.size();

            if(!stack.isEmpty()) {
                if(nums[i] == 0 || Math.abs(i - nums[i]) > Math.abs(i - stack.peek())) {
                    nums[i] = stack.peek();
                }
                else if(Math.abs(i - nums[i]) == Math.abs(i - stack.peek())) {
                    if(nums[i] > stack.peek()) {
                        nums[i] = stack.peek();
                    }
                }
            }
            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= N; i++) {
            if(counts[i] == 0) {
                sb.append("0").append('\n');
            } else {
                sb.append(counts[i] + " " + nums[i]).append('\n');
            }
        }
        System.out.println(sb);
    }
}