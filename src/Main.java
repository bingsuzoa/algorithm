import java.util.*;
import java.io.*;

class Main {
    static Map<Character, List<Integer>> map;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(T --> 0) {
            map = new HashMap<>();
            String input = br.readLine();
            K = Integer.parseInt(br.readLine());

            for(int i =0 ; i < input.length(); i++) {
                char c = input.charAt(i);
                map.computeIfAbsent(c, k -> new ArrayList<>()).add(i);
            }

            int min = Integer.MAX_VALUE;
            int max = 0;
            boolean flag = false;
            for(char key : map.keySet()) {
                List<Integer> list = map.get(key);
                if(list.size() < K) continue;
                flag = true;
                int[] result = getResult(list);
                min = Math.min(min, result[0]);
                max = Math.max(max, result[1]);
            }

            if(!flag) {
                sb.append("-1").append("\n");
            } else {
                sb.append( min + " " + max).append("\n");
            }
        }
        System.out.println(sb.toString().trim());
    }

    private static int[] getResult(List<Integer> list) {
        int start = 0;
        int end = start + K - 1;

        int min = list.get(end) - list.get(start) + 1;
        int max = list.get(end) - list.get(start) + 1;
        while(true) {
            min = Math.min(min, list.get(end) - list.get(start) + 1);
            max = Math.max(max, list.get(end) - list.get(start) + 1);

            end++;
            start++;
            if(end >= list.size()) break;
        }
        return new int[]{min, max};
    }
}