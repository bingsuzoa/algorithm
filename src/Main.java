import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int[] graph = new int[input.length()];

        int zero = 0;
        int one = 0;
        int zeroIdx = 0;
        int oneIdx = input.length() -1;
        for(int i = 0; i < input.length(); i++) {
            graph[i] = input.charAt(i)-'0';
            if(graph[i] == 0) {
                zero++;
                zeroIdx = i;
            }
            if(graph[i] == 1) {
                one++;
                oneIdx = Math.min(oneIdx, i);
            }
        }
        zero /= 2;
        one /= 2;

        for(int i = zeroIdx; i >= 0; i--) {
            if(graph[i] == 0) {
                if(zero <= 0) break;
                graph[i] = -1;
                zero--;
            }
        }

        for(int i = oneIdx; i < graph.length; i++) {
            if(graph[i] == 1) {
                if(one <= 0) break;
                graph[i] = -1;
                one--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < graph.length; i++) {
            if(graph[i] != -1) {
                sb.append(graph[i]);
            }
        }
        System.out.println(sb);
    }
}