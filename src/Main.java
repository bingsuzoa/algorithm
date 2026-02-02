import java.util.*;
import java.io.*;


class Main {
    static Set<Integer> set;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        set = new HashSet<>();
        sb = new StringBuilder();

        while(N --> 0) {
            String command = br.readLine();
            if(command.equals("all")) {
                for(int i = 1; i <= 20; i++) {
                    set.add(i);
                }
                continue;
            }
            if(command.equals("empty")) {
                set.clear();
                continue;
            }

            String[] split = command.split(" ");
            int num = Integer.parseInt(split[1]);

            if(command.contains("add")) {
                set.add(num);
            }
            else if(command.contains("remove")) {
                if(set.contains(num)) {
                    set.remove(num);
                }
            }
            else if(command.contains("toggle")) {
                if(set.contains(num)) {
                    set.remove(num);
                } else {
                    set.add(num);
                }
            }
            else if(command.contains("check")) {
                if(set.contains(num)) {
                    sb.append("1").append("\n");
                } else {
                    sb.append("0").append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}