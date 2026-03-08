import java.util.*;
import java.io.*;

class Main {
    static StringBuilder sb = new StringBuilder();
    static List<Integer> list = new ArrayList<>();
    static List<Info> answer = new ArrayList<>();

    static int[] buhos = new int[]{11, 12, 10};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        while(N --> 0) {
            answer.clear();
            int n = Integer.parseInt(br.readLine());

            int[] graph = new int[n + (n - 1)];

            int m = 1;
            for(int i = 0; i < graph.length; i++) {
                if(i % 2 == 0) {
                    graph[i] = m ++;
                }
            }

            dfs(1, graph);
            Collections.sort(answer);
            isAnswer();
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void isAnswer() {
        for(Info info : answer) {
            int[] graph = info.graph;
            for(int i = 0; i < graph.length; i++) {
                int value = graph[i];
                if(value == 10) {
                    sb.append(' ');
                }
                else if(value == 11) {
                    sb.append('+');
                }
                else if(value == 12) {
                    sb.append('-');
                } else {
                    sb.append(value);
                }
            }
            sb.append("\n");
        }
    }

    private static void dfs(int cur, int[] graph) {
        if(cur >= graph.length) {
            isCheck(graph);
            return;
        }

        for(int i = 0; i < buhos.length; i++) {
            graph[cur] = buhos[i];
            dfs(cur + 2, graph);
        }
    }

    private static void isCheck(int[] graph) {
        list.clear();

        int num = 0;
        for(int i = 0; i < graph.length; i++) {
            int value = graph[i];
            if(value >= 11) {
                list.add(num);
                list.add(value);
                num = 0;
            }
            else if(value < 10) {
                num *= 10;
                num += value;
            }
        }
        list.add(num);

        int sum = list.get(0);
        for(int i = 1; i < list.size() -1; i++) {
            int left = list.get(i);
            int right = list.get(i+1);
            if(left == 11) {
                sum += right;
            } else if(left == 12) {
                sum -= right;
            }
            i = i + 1;
        }

        if(sum == 0) {
            answer.add(new Info(Arrays.copyOf(graph, graph.length)));
        }
    }
}

class Info implements Comparable<Info> {
    int[] graph;

    public Info(int[] graph) {
        this.graph = graph;
    }

    @Override
    public int compareTo(Info o) {
        for(int i = 0; i < graph.length; i++) {
            if(i % 2 == 0) continue;
            if(this.graph[i] == o.graph[i]) continue;
            return this.graph[i] - o.graph[i];
        }
        return 0;
    }
}