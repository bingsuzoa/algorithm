import java.util.*;
import java.io.*;

class Main {
    static Stack<Character> stack;
    static String goal;
    static StringBuilder bomb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        goal = br.readLine();
        char last = goal.charAt(goal.length() -1);

        stack = new Stack<>();

        bomb = new StringBuilder();
        for(char c : input.toCharArray()) {
            if(c == last) {
                stack.push(c);
                check();
            } else {
                stack.push(c);
            }
        }

        if(stack.isEmpty()) {
            System.out.println("FRULA");
        } else {
            StringBuilder sb = new StringBuilder();
            while(!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            System.out.println(sb.reverse());
        }
    }

    private static void check() {
        bomb.setLength(0);

        if(stack.size() < goal.length()) {
            return;
        }

        boolean isMatch = true;
        for(int i = 0; i < goal.length(); i++) {
            if(stack.get(stack.size() - goal.length() + i) != goal.charAt(i)) {
                isMatch = false;
                break;
            }
        }
        if(isMatch) {
            for(int i = 0; i < goal.length(); i++) {
                stack.pop();
            }
        }
    }
}