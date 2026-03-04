import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String goal = br.readLine();


        if(dfs(goal, input)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    private static boolean dfs(String goal, String input) {
        boolean match = false;
        if(goal.length() == input.length()) {
            if(goal.equals(input)) {
                return true;
            }
            return false;
        }

        char c = goal.charAt(goal.length() -1);
        if(c == 'A') {
            match |= dfs(goal.substring(0, goal.length() -1), input);
        }
        char c1 = goal.charAt(0);
        if(c1 == 'B') {
            StringBuilder sb = new StringBuilder();
            sb.append(goal).reverse();
            String next = sb.toString().substring(0, goal.length() -1);
            match |= dfs(next, input);
        }
        return match;
    }
}