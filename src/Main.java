import java.util.*;
import java.io.*;

class Main {
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String start = br.readLine();
        String end = br.readLine();

        System.out.println(dfs(start, end) ? 1 : 0);
    }


    private static boolean dfs(String start, String end) {
        boolean flag = false;
        if(start.length() == end.length()) {
            if(start.equals(end)) {
                return true;
            }
            return false;
        }

        if(end.charAt(end.length() -1) == 'A') {
            flag |= dfs(start, end.substring(0, end.length() -1));
        }
        if(end.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder();
            sb.append(end).reverse();
            String result = sb.toString();
            flag |= dfs(start, result.substring(0, result.length()-1));
        }
        return flag;
    }

}