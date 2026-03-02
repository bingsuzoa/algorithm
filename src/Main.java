import java.util.*;
import java.io.*;

class Main {
    static Stack<int[]> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            int value = Integer.parseInt(st.nextToken());

            if(stack.isEmpty()) {
                sb.append(0 + " ");
                stack.push(new int[]{value, i});
                continue;
            }

            while(true) {
                if(stack.isEmpty()) {
                    sb.append(0 + " ");
                    stack.push(new int[]{value, i});
                    break;
                }
                int[] cur = stack.peek();
                int pair = cur[0];
                int pos = cur[1];
                if(pair >= value) {
                    sb.append(pos + " ");
                    stack.push(new int[]{value, i});
                    break;
                }
                stack.pop();
            }

        }
        System.out.println(sb);


    }
}