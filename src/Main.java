import java.util.*;
import java.io.*;

class Main {
    static int[] graph;
    static Info[] infos;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        graph = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i < graph.length; i++) {
            graph[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        infos = new Info[M];
        for(int i = 0; i < infos.length; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st1.nextToken());
            int num = Integer.parseInt(st1.nextToken());
            infos[i] = new Info(sex, num);
        }

        for(Info info : infos) {
            if(info.sex == 1) {
                checkMan(info.num);
            } else {
                checkWoman(info.num);
            }
        }

        StringBuilder sb = new StringBuilder();
        int size = 0;
        for(int i = 1; i < graph.length; i++) {
            if(size == 20) {
                sb.append("\n");
                size = 0;
            }
            size ++;
            sb.append(graph[i] + " ");
        }
        System.out.println(sb.toString().trim());

    }
    private static void checkWoman(int num) {
        int dist = 0;
        int start = 0;
        int end = 0;
        while(true) {
            int leftIdx = num - dist;
            int rightIdx = num + dist;

            if(leftIdx >= 1 && rightIdx < graph.length) {
                if(graph[leftIdx] == graph[rightIdx]) {
                    start = leftIdx;
                    end = rightIdx;
                    dist++;
                } else {
                    break;
                }
            } else {
                break;
            }
        }

        for(int i = start; i <= end; i++) {
            graph[i] = graph[i] == 1 ? 0 : 1;
        }
    }
    private static void checkMan(int num) {
        for(int i = num; i < graph.length; i+=num) {
            graph[i] = graph[i] == 1 ? 0 : 1;
        }
    }
}

class Info {
    int sex;
    int num;

    public Info(int sex, int num) {
        this.sex = sex;
        this.num = num;
    }
}