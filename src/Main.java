import java.util.*;
import java.io.*;

class Main {
    static char[][] graph;
    static int[] answer = new int[5];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        graph = new char[N][N];

        for(int i = 0; i < graph.length; i++) {
            String input = br.readLine();
            for(int j = 0; j < graph[i].length; j++) {
                graph[i][j] = input.charAt(j);
            }
        }


        boolean endArm = false;
        int heartX = -1;
        int heartY = -1;
        for(int i = 0; i < graph.length; i++) {
            for(int j = 0; j < graph[i].length; j++) {
                if(graph[i][j] == '*') {
                    heartX = i + 1;
                    heartY = j;
                    sb.append((heartX + 1) + " " + (heartY + 1)).append("\n");
                    countLine(heartX + 1, heartY);
                    countArms(heartX, heartY);
                    countLegs(heartX, heartY);
                    endArm = true;
                    break;
                }
            }
            if(endArm) {
                break;
            }
        }

        for(int value : answer) {
            sb.append(value + " ");
        }
        System.out.println(sb);
    }
    private static void countLegs(int x, int heartPos) {
        int left = 0;
        int right = 0;
        for(int i = x+1; i < graph.length; i++) {
            if(graph[i][heartPos -1] == '*') {
                left++;
            }
            if(graph[i][heartPos + 1] == '*') {
                right++;
            }
        }
        answer[3] = left;
        answer[4] = right;
    }
    private static void countArms(int x, int y) {
        int left = 0;
        int right = 0;
        for(int j = y - 1; j >= 0; j--) {
            if(graph[x][j] == '*') {
                left++;
            }
        }
        for(int j = y + 1; j < graph[0].length; j++) {
            if(graph[x][j] == '*') {
                right ++;
            }
        }
        answer[0] = left;
        answer[1] = right;
    }
    private static void countLine(int x, int y) {
        int count = 0;
        for(int i = x; i < graph.length; i++) {
            if(graph[i][y] == '*') {
                count++;
            }
        }
        answer[2] = count;
    }
}