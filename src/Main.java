import java.util.*;
import java.io.*;

class Main {
    static int N;
    static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        stack = new Stack<>();

        int count = 0;
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(y == 0) {
                stack.clear();
                continue;
            }

            if(stack.isEmpty()) {
                stack.push(y);
                count++;
                continue;
            }

            while(!stack.isEmpty()) {
                int befo = stack.peek();
                if(befo < y) {
                    count++;
                    stack.push(y);
                    break;
                }
                else if(befo > y) {
                    stack.pop();
                }
                else {
                    break;
                }
            }
            if(stack.isEmpty()) {
                count++;
                stack.push(y);
            }

        }

        System.out.println(count);
    }
}