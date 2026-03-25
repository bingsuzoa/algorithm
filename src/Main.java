import java.util.*;
import java.io.*;

class Main {
    static int N;
    static Map<String, Integer> map;
    static String[] graph;
    static String[] result;
    static int max = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        graph = new String[N];
        result = new String[2];



        for(int i =0 ;i < N; i++) {
            graph[i] = br.readLine();
        }

        for (int i = 0; i < N; i++) {
            map.putIfAbsent(graph[i], i);
        }
        Arrays.sort(graph);
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N - 1; i++) {
            for(int j = i + 1; j < N; j++) {
                String left;
                String right;

                left = map.get(graph[i]) < map.get(graph[j]) ? graph[i] : graph[j];
                right = map.get(graph[i]) < map.get(graph[j]) ? graph[j] : graph[i];

                if(left.equals(right)) continue;
                if(left.charAt(0) != right.charAt(0)) break;
                int min = Math.min(left.length(), right.length());
                sb.setLength(0);

                int count = 0;
                for (int k = 0; k < min; k++) {
                    if (left.charAt(k) == right.charAt(k)) {
                        sb.append(left.charAt(k));
                        count++;
                    } else {
                        break;
                    }
                }

                if (max < count) {
                    max = count;
                    result[0] = left;
                    result[1] = right;

                } else if (max == count) {
                    int resultLeftIdx = map.get(result[0]);
                    int resultRightIdx = map.get(result[1]);
                    int leftIdx = map.get(left);
                    int rightIdx = map.get(right);

                    if (leftIdx < resultLeftIdx) {
                        result[0] = left;
                        result[1] = right;
                    } else if (leftIdx == resultLeftIdx && rightIdx < resultRightIdx) {
                        if (leftIdx < rightIdx) {
                            result[0] = left;
                            result[1] = right;
                        } else {
                            result[0] = right;
                            result[1] = left;
                        }
                    }
                }

            }
        }

        System.out.println(result[0] + "\n" + result[1]);
    }
}