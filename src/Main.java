import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        while(N --> 0) {
            int count = 0;
            queue.clear();
            list.clear();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()) {
                queue.add(Integer.parseInt(st.nextToken()));
            }

            while(!queue.isEmpty()) {
                int num = queue.poll();
                if(list.isEmpty()) {
                    list.add(num);
                    continue;
                }

                int height = list.get(list.size() -1);
                if(height <= num) {
                    list.add(num);
                    continue;
                }
                for(int i = 0; i < list.size(); i++) {
                    int pair = list.get(i);
                    if(pair >= num) {
                        count += (list.size() - i);
                        list.add(i, num);
                        break;
                    }
                }
            }
            sb.append(order + " " + count).append("\n");
        }
        System.out.println(sb);
    }
}