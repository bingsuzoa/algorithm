import java.util.*;
import java.io.*;

class Main {
    static int max = Integer.MAX_VALUE;
    static char[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        graph = new char[input.length() * 2];

        int aCount = 0;
        for(int i =0 ; i < input.length(); i++) {
            char c = input.charAt(i);
            graph[i] = c;
            graph[i + input.length()] = c;
            if(c == 'a') aCount++;
        }

        int start = 0;
        int end = start + aCount - 1;
        int bCount = 0;
        for(int i = start; i <= end; i++) {
            if(graph[i] == 'b') bCount++;
        }
        max = Math.min(max, bCount);

        while(true) {
            if(graph[start] == 'b') {
                bCount--;
            }
            start++;
            end ++;
            if(start >= graph.length || end >= graph.length) break;
            if(graph[end] == 'b') {
                bCount++;
            }
            max = Math.min(max, bCount);
        }
        System.out.println (max);
    }

}