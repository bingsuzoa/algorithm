import java.util.*;
import java.io.*;

class Main {
    static char[] graph;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        graph = new char[input.length() * 2];

        int aCount = 0;
        for(int i = 0; i < input.length(); i++) {
            graph[i] = input.charAt(i);
            if(graph[i] == 'a') {
                aCount++;
            }
            graph[i + input.length()] = input.charAt(i);
        }

        int left = 0;
        int right = aCount - 1;
        int aMin = 0;
        for(int i = 0; i <= right; i++) {
            if(graph[i] == 'b') {
                aMin++;
            }
        }
        int answer = aMin;
        while(true) {
            char lc = graph[left];
            left++;
            right++;
            if(right >= graph.length || left >= input.length()) break;
            char rc = graph[right];
            if(lc == 'b') {
                aMin --;
            }

            if(rc == 'b') {
                aMin++;
            }

            answer = Math.min(answer, aMin);
        }
        System.out.println(answer);
    }
}