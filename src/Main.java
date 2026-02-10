import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        long cur = 1;
        int start = 0;

        while(start < input.length()) {
            String pair = String.valueOf(cur);

            int idx = 0;
            while(start < input.length()) {
                boolean isContain = false;
                for(int i = idx; i < pair.length(); i++) {
                    if(input.charAt(start) == pair.charAt(i)) {
                        isContain = true;
                        start++;
                        idx = i + 1;
                        break;
                    }
                }
                if(!isContain) break;
            }
            cur++;
        }
        System.out.println(cur - 1);
    }
}