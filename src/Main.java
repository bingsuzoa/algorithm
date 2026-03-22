import java.util.*;
import java.io.*;

class Main {
    static char[][] graph;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        graph = new char[3][3];
        sb = new StringBuilder();

        while(true) {
            String input = br.readLine();
            if(input.equals("end")) break;

            //절대 불가
            //O의 개수가 더 많다.
            //X의 개수가 2개 이상 많다.
            int ocount = 0;
            int xcount = 0;
            for(char c : input.toCharArray()) {
                if(c == 'O') ocount ++;
                if(c == 'X') xcount ++;
            }
            if(ocount > xcount || xcount >= ocount + 2) {
                sb.append("invalid").append("\n");
                continue;
            }

            for(int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                int n = i/3;
                int m = i%3;
                graph[n][m] = c;
            }

            //X가 이겼을 때
            //X의 갯수가 하나 더 많고
            //가로/세로/대각선 방향으로 이었을 때
            if(xcount == ocount + 1) {
                if(isPass('X') && !isPass('O')) {
                    sb.append("valid").append("\n");
                    continue;
                }
                //비겼을 때
                //게임판이 가득 찼을 때
                if(xcount == 5 && ocount == 4 && !isPass('X') && !isPass('O')) {
                    sb.append("valid").append("\n");
                    continue;
                }
            }

            //O이 이겼을 때
            //갯수 동일
            if(xcount == ocount) {
                if(isPass('O') && !isPass('X')) {
                    sb.append("valid").append("\n");
                    continue;
                }
            }
            sb.append("invalid").append("\n");
        }
        System.out.println(sb);
    }
    private static boolean isPass(char c) {
        if(graph[0][0] == graph[1][0] && graph[1][0] == graph[2][0] && graph[2][0] == c) {
            return true;
        }
        if(graph[0][1] == graph[1][1] && graph[1][1] == graph[2][1] && graph[2][1] == c) {
            return true;
        }
        if(graph[0][2] == graph[1][2] && graph[1][2] == graph[2][2] && graph[2][2] == c) {
            return true;
        }
        if(graph[0][0] == graph[1][1] && graph[1][1] == graph[2][2] && graph[2][2] == c) {
            return true;
        }
        if(graph[0][2] == graph[1][1] && graph[1][1] == graph[2][0] && graph[2][0] == c) {
            return true;
        }
        if(graph[0][0] == graph[0][1] && graph[0][1] == graph[0][2] && graph[0][2] == c) {
            return true;
        }
        if(graph[1][0] == graph[1][1] && graph[1][1] == graph[1][2] && graph[1][2] == c) {
            return true;
        }
        if(graph[2][0] == graph[2][1] && graph[2][1] == graph[2][2] && graph[2][2] == c) {
            return true;
        }
        return false;
    }
}