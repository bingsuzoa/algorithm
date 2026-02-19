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

        int size = input.length();
        for(int i = 0; i < graph.length - aCount; i++) {
            int start = i;
            int end = start + aCount;

            int bCount = 0;
            for(int j = start; j < end; j++) {
                if(graph[j] == 'b') {
                    bCount++;
                }
            }
            max = Math.min(max, bCount);
        }
        System.out.println(max);
    }

}