import java.util.*;
import java.io.*;

class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();

        char[] graph = new char[N];

        boolean isBlue = false;
        boolean isRed = false;

        for(int i = 0; i < graph.length; i++) {
            char c = input.charAt(i);
            graph[i] = c;
            if(c == 'R') {
                isRed = true;
            }
            if(c == 'B') {
                isBlue = true;
            }
        }

        if(!isBlue || !isRed) {
            System.out.println(0);
            return;
        }

        long min = Integer.MAX_VALUE;
        long first = 0;
        boolean isFirst = false;
        int start = 0;
        int end = 0;
        long redSum = 0;
        long blueSum = 0;
        while(end < graph.length) {
            if(graph[start] == graph[end]) {
                end ++;
                if(end == graph.length) {
                    min = Math.min(min, Math.min(redSum, blueSum));
                    if(graph[start] == 'R') {
                        redSum += end - start;
                    } else {
                        blueSum += end - start;
                    }
                }
            } else {
                int count = end - start;
                if(graph[start] == 'R') {
                    redSum += count;
                } else {
                    blueSum += count;
                }
                if(!isFirst) {
                    isFirst = true;
                    first = count;
                }
                start = end;
            }
        }


        if(graph[0] == 'R') {
            redSum -= first;
        } else {
            blueSum -= first;
        }
        min = Math.min(min, Math.min(redSum, blueSum));
        System.out.println(min);
    }
}