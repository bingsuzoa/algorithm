import java.util.*;
import java.io.*;


class Main {
    static String input, goal;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input = br.readLine();
        goal = br.readLine();

        if(dfs(goal)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static boolean dfs(String tmp) {
        boolean isPossible = false;

        if(tmp.length() == input.length()) {
            if(tmp.equals(input)) {
                return true;
            }
            return false;
        }

        char c = tmp.charAt(tmp.length() -1);
        char s = tmp.charAt(0);
        if(c == 'A') {
            isPossible |= dfs(tmp.substring(0, tmp.length() -1));
        }
        if(s == 'B') {
            StringBuilder sb = new StringBuilder();
            sb.append(tmp).reverse();
            isPossible |= dfs(sb.toString().substring(0, tmp.length() -1));
        }
        return isPossible;
    }
}