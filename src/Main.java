import java.util.*;
import java.io.*;

class Main {
    static char[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        graph = new char[3][3];
        StringBuilder sb = new StringBuilder();
        while(true) {
            String n = br.readLine();
            if(n.equals("end")) break;

            for(int i = 0; i < graph.length; i++) {
                for(int j = 0; j < graph[i].length; j++) {
                    graph[i][j] = n.charAt((i * 3) + j);
                }
            }

            int[] counts = isCount(n);
            int oCount = counts[0];
            int xCount = counts[1];
            if(oCount != xCount && xCount != oCount + 1) {
                sb.append("invalid").append("\n");
                continue;
            }
            int lineO = countLine('O');
            int lineX = countLine('X');
            int daeO = countDae('O');
            int daeX = countDae('X');

            boolean totalO = lineO == 0 && daeO == 0;
            boolean totalX = lineX == 0 && daeX == 0;

            if(xCount > oCount) {
                /// oCount == 0 && 일직선 1개, 대각 1개 또는 2개
                if(totalO && (0 < lineX) || totalO && (0 < daeX)) {
                    sb.append("valid").append("\n");
                    continue;
                }
                if(totalO && totalX && oCount == 4 && xCount == 5) {
                    sb.append("valid").append("\n");
                    continue;
                }
                sb.append("invalid").append("\n");
            } else {
                /// xCount == 0 && (oCount == 0 , 1) 가능
                if(totalX && (lineO == 1 || daeO == 1)) {
                    sb.append("valid").append("\n");
                    continue;
                }
                sb.append("invalid").append("\n");
            }
        }
        System.out.println(sb);
    }

    private static int[] isCount(String n) {
        int Xcount = 0;
        int Ocount = 0;
        for(char c : n.toCharArray()) {
            if(c == 'X') Xcount++;
            if(c == 'O') Ocount++;
        }
        return new int[]{Ocount, Xcount};
    }

    private static int countLine(char c) {
        int count = 0;
        //가로
        for(int i = 0; i < graph.length; i++) {
            char cur = graph[i][0];
            char cur1 = graph[i][1];
            char cur2 = graph[i][2];

            if(cur == cur1 && cur1 == cur2 && cur2 == c) {
                count++;
            }
        }
        //세로
        for(int j = 0; j < graph[0].length; j++) {
            char cur = graph[0][j];
            char cur1 = graph[1][j];
            char cur2 = graph[2][j];

            if(cur == cur1 && cur1 == cur2 && cur2 == c) {
                count++;
            }
        }

        return count;
    }

    private static int countDae(char c) {
        int count = 0;

        //대각
        if(graph[0][0] == graph[1][1] && graph[1][1] == graph[2][2] && graph[2][2] == c) {
            count++;
        }
        if(graph[0][2] == graph[1][1] && graph[1][1] == graph[2][0] && graph[2][0] == c) {
            count++;
        }
        return count;
    }
}